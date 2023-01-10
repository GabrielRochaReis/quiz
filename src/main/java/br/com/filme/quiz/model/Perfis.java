//package br.com.filme.quiz.model;
//
//import org.springframework.security.core.GrantedAuthority;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//
//@Entity
//public class Perfis implements GrantedAuthority{
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 7370473626370339480L;
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer id;
//	private String nome;
//	
//	public Perfis() {
//		super();
//	}
//	public Perfis(Integer id, String nome) {
//		super();
//		this.id = id;
//		this.nome = nome;
//	}
//	@Override
//	public String getAuthority() {
//		return nome;
//	}
//	public Integer getId() {
//		return id;
//	}
//	public void setId(Integer id) {
//		this.id = id;
//	}
//	public String getNome() {
//		return nome;
//	}
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
//}
