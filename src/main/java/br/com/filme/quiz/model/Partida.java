package br.com.filme.quiz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Partida {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Filme filme1;
	
	@ManyToOne
	private Filme filme2;
	
	private Integer vencedor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Filme getFilme1() {
		return filme1;
	}

	public void setFilme1(Filme filme1) {
		this.filme1 = filme1;
	}

	public Filme getFilme2() {
		return filme2;
	}

	public void setFilme2(Filme filme2) {
		this.filme2 = filme2;
	}

	public Integer getVencedor() {
		return vencedor;
	}

	public void setVencedor(Integer vencedor) {
		this.vencedor = vencedor;
	}
	
	

}
