package br.com.filme.quiz.dto;

import br.com.filme.quiz.model.Quiz;

public class QuizResponseDto {
	
	private String tituloFilme1;
	private String tituloFilme2;
	private Boolean acerto;
	private String mensagem;
	private Integer idUsuario;
	
	public QuizResponseDto() {
		super();
	}

	public QuizResponseDto(Quiz quiz) {
		this.tituloFilme1 = quiz.getPartida().getFilme1().getTitulo();
		this.tituloFilme2 = quiz.getPartida().getFilme2().getTitulo();
		this.idUsuario = quiz.getUsuario().getId();
	}
	
	public String getTituloFilme1() {
		return tituloFilme1;
	}
	public void setTituloFilme1(String tituloFilme1) {
		this.tituloFilme1 = tituloFilme1;
	}
	public String getTituloFilme2() {
		return tituloFilme2;
	}
	public void setTituloFilme2(String tituloFilme2) {
		this.tituloFilme2 = tituloFilme2;
	}
	public Boolean getAcerto() {
		return acerto;
	}
	public void setAcerto(Boolean acerto) {
		this.acerto = acerto;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
