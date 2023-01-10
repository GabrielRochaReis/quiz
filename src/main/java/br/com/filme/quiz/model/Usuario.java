package br.com.filme.quiz.model;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9109426284578838094L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	private String usuario;
	private String senha;
	@ColumnDefault("0")
	private Integer pontuacao;
//	@ManyToMany(fetch = FetchType.EAGER)
//	private List<Perfis> perfis;
	
	public Usuario() {
		super();
	}

	public Usuario(Integer id, String usuario, String senha) {
		super();
		this.usuario = usuario;
		this.senha = senha;
		this.pontuacao = 0;
//		this.perfis = perfis;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public Integer getPontuacao() {
		return pontuacao;
	}


	public void setPontuacao(Integer pontuacao) {
		this.pontuacao = pontuacao;
	}

//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		return this.perfis;
//	}
//
//	@Override
//	public String getPassword() {
//		return senha;
//	}
//
//	@Override
//	public String getUsername() {
//		return usuario;
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return true;
//	}
	
}
