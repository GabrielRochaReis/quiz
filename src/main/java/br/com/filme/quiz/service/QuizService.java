package br.com.filme.quiz.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.filme.quiz.dto.QuizRequestDto;
import br.com.filme.quiz.dto.QuizResponseDto;
import br.com.filme.quiz.dto.RankingDTO;
import br.com.filme.quiz.model.Partida;
import br.com.filme.quiz.model.Quiz;
import br.com.filme.quiz.model.Usuario;
import br.com.filme.quiz.repository.QuizRepository;

@Service
public class QuizService {
	
	@Autowired
	private QuizRepository quizRepository;
	
	@Autowired
	private PartidaService partidaService;
	
	@Autowired
	private UsuarioService usuarioService;

	public QuizResponseDto iniciarQuiz(Usuario usuario) {
		usuario = usuarioService.findById(usuario.getId());
		List<Quiz> quizzes = quizRepository.findByUsuario(usuario);
		if (quizzes == null || quizzes.isEmpty()) {
			Quiz quiz = new Quiz();
			quiz.setUsuario(usuario);
			Partida partida = partidaService.findById(new Long("1"));
			quiz.setPartida(partida);
			quiz.setPontos(0);
			quiz.setTentativa(1);
			quiz.setProximaPartida(2);
			quizRepository.save(quiz);
			QuizResponseDto quizResponseDto = new QuizResponseDto(quiz);
			quizResponseDto.setMensagem("Novo Jogo!");
			return quizResponseDto;
		} else {
			return new QuizResponseDto(quizzes.get(0));
		}
	}
	
	public QuizResponseDto respostaQuiz(QuizRequestDto quizDto) {
		Usuario usuario = usuarioService.findById(quizDto.getIdUsuario());
		List<Quiz> quizzes = quizRepository.findByUsuario(usuario);
		if (quizzes == null || quizzes.isEmpty()) {
			return iniciarQuiz(usuario);
		}
		Quiz quiz = quizzes.get(0);
		if (quiz.getTentativa() <= 3) {
			if (quiz.getPartida().getVencedor() == quizDto.getResposta()) {
				quiz.setPontos(quiz.getPontos()+1);
				proximaPartida(quiz);
				quizRepository.save(quiz);
				QuizResponseDto quizResponseDto = new QuizResponseDto(quiz);
				quizResponseDto.setMensagem(String.format("Resposta certa! Sua pontuação é %d",quiz.getPontos()));
				quizResponseDto.setAcerto(true);
				return quizResponseDto;
			} else {
				if (quiz.getTentativa() == 3) {
					fimQuiz(quiz);
					QuizResponseDto quizResponseDto = new QuizResponseDto();
					quizResponseDto.setMensagem(String.format("Resposta errada! Você não possui mais tentativas. Sua pontuação foi %d",quiz.getPontos()));
					quizResponseDto.setAcerto(false);
					return quizResponseDto;
				} else {
					quiz.setTentativa(quiz.getTentativa()+1);
					quizRepository.save(quiz);
					QuizResponseDto quizResponseDto = new QuizResponseDto(quiz);
					quizResponseDto.setAcerto(false);
					quizResponseDto.setMensagem(String.format("Resposta errada! Você está na tentativa %d e possui %d tentativas.",quiz.getTentativa()-1, 4 - quiz.getTentativa()));
					return quizResponseDto;
				}
			}
		} else {
			fimQuiz(quiz);
			QuizResponseDto quizResponseDto = new QuizResponseDto();
			quizResponseDto.setMensagem(String.format("Você não possui mais tentativas. Sua pontuação foi %d",quiz.getPontos()));
			quizResponseDto.setAcerto(false);
			return quizResponseDto;
		}
	}
	
	private Quiz proximaPartida(Quiz quiz) {
		Partida proximaPartida = partidaService.findById(quiz.getProximaPartida().longValue());
		quiz.setPartida(proximaPartida);
		quiz.setProximaPartida(proximaPartida.getId().intValue()+1);
		return quiz;
	}
	
	private void fimQuiz(Quiz quiz) {
		Usuario usuario = quiz.getUsuario();
		Integer pontuacao = quiz.getPontos();
		if (usuario.getPontuacao() < pontuacao) {
			usuario.setPontuacao(pontuacao);
			usuarioService.save(usuario);
		}
		quizRepository.delete(quiz);
	}
	
	public QuizResponseDto pararQuiz(QuizRequestDto quizDto) {
		Usuario usuario = usuarioService.findById(quizDto.getIdUsuario());
		List<Quiz> quizzes = quizRepository.findByUsuario(usuario);
		QuizResponseDto quizResponseDto = new QuizResponseDto();
		if (quizzes != null && !quizzes.isEmpty()) {
			Quiz quiz = quizzes.get(0);
			fimQuiz(quiz);
			quizResponseDto.setMensagem(String.format("Jogo finalizado! Sua pontuação foi %d",quiz.getPontos()));
		} else {
			quizResponseDto.setMensagem(String.format("Jogo finalizado!"));
		}
		return quizResponseDto;
	}
	
	public List<RankingDTO> rankingQuiz() {
		List<Usuario> usuarios = usuarioService.findAll();
		List<RankingDTO> ranking = usuarios.stream().map( usuario -> new RankingDTO(usuario.getPontuacao(), usuario.getUsuario())).sorted( (r1, r2) -> 
		r1.getPontuacao().compareTo(r2.getPontuacao())).collect(Collectors.toList());
		IntStream.range(0, ranking.size()).forEach(idx ->
		  ranking.get(idx).setPosicao(idx+1) );
		return ranking;
	}
}
