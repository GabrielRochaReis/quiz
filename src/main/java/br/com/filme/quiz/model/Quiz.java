package br.com.filme.quiz.model;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Quiz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne
	private Usuario usuario;
	@OneToOne
	private Partida partida;
	@ColumnDefault("2")
	private Integer proximaPartida;
	@ColumnDefault("0")
	private Integer pontos;
	@ColumnDefault("1")
	private Integer tentativa;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Partida getPartida() {
		return partida;
	}
	public void setPartida(Partida partida) {
		this.partida = partida;
	}
	public Integer getProximaPartida() {
		return proximaPartida;
	}
	public void setProximaPartida(Integer proximaPartida) {
		this.proximaPartida = proximaPartida;
	}
	public Integer getPontos() {
		return pontos;
	}
	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}
	public Integer getTentativa() {
		return tentativa;
	}
	public void setTentativa(Integer tentativa) {
		this.tentativa = tentativa;
	}

}