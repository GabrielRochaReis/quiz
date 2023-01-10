package br.com.filme.quiz.dto;

public class QuizRequestDto {
	
	private Integer resposta;
	private Integer idUsuario;
	public Integer getResposta() {
		return resposta;
	}
	public void setResposta(Integer resposta) {
		this.resposta = resposta;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	
}
