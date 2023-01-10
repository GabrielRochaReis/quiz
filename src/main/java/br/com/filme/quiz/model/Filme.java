package br.com.filme.quiz.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Filme {
	
	@Id
	@JsonProperty("imdbID")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 100)
	private String id;
	
	@JsonProperty("Year")
	private Integer ano;
	
	@JsonProperty("Title")
	private String titulo;
	
	@JsonProperty("imdbRating")
	private Double nota;
	
	@JsonProperty("imdbVotes")
	private String votos;
	
	private Double pontuacao;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public String getVotos() {
		return votos;
	}

	public void setVotos(String votos) {
		this.votos = votos;
	}

	public Double getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(Double pontuacao) {
		this.pontuacao = pontuacao;
	}
	
}
