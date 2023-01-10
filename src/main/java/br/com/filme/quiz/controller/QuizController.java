package br.com.filme.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.filme.quiz.dto.QuizRequestDto;
import br.com.filme.quiz.dto.QuizResponseDto;
import br.com.filme.quiz.dto.RankingDTO;
import br.com.filme.quiz.model.Usuario;
import br.com.filme.quiz.service.QuizService;

@RestController
public class QuizController {
	
	@Autowired
	private QuizService quizService;

	@GetMapping("/iniciar")
	public QuizResponseDto novo(@RequestBody Usuario usuario){
		QuizResponseDto quizResponseDto = quizService.iniciarQuiz(usuario);
		return quizResponseDto;
	}
	
	@PostMapping("/resposta")
	public QuizResponseDto resposta(@RequestBody QuizRequestDto quizRequestDto){
		return quizService.respostaQuiz(quizRequestDto);
	}
	
	@GetMapping("/encerrar")
	public QuizResponseDto parar(@RequestBody QuizRequestDto quizRequestDto){
		return quizService.pararQuiz(quizRequestDto);
	}
	
	@GetMapping("/ranking")
	public List<RankingDTO> ranking(){
		return quizService.rankingQuiz();
	}
}
