package br.com.filme.quiz.dto;

public class RankingDTO {

	private Integer posicao;
	private String usuario;
	private Integer pontuacao;
	
	public RankingDTO(Integer pontuacao, String usuario) {
		super();
		this.pontuacao = pontuacao;
		this.usuario = usuario;
	}
	
	public Integer getPosicao() {
		return posicao;
	}
	public void setPosicao(Integer posicao) {
		this.posicao = posicao;
	}
	public Integer getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(Integer pontuacao) {
		this.pontuacao = pontuacao;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
}
