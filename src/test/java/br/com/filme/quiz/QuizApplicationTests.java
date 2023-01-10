package br.com.filme.quiz;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import br.com.filme.quiz.dto.QuizResponseDto;
import br.com.filme.quiz.model.Filme;
import br.com.filme.quiz.model.Partida;
import br.com.filme.quiz.model.Quiz;
import br.com.filme.quiz.model.Usuario;
import br.com.filme.quiz.repository.QuizRepository;
import br.com.filme.quiz.service.PartidaService;
import br.com.filme.quiz.service.QuizService;
import br.com.filme.quiz.service.UsuarioService;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class QuizApplicationTests {

	@InjectMocks
	private QuizService quizService;
	
	@Mock(answer = Answers.RETURNS_SMART_NULLS)
	QuizRepository quizRepository;
	
	@Mock(answer = Answers.RETURNS_SMART_NULLS)
	PartidaService partidaService;
	
	@Mock(answer = Answers.RETURNS_SMART_NULLS)
	UsuarioService usuarioService;
	
	@Test
	public void testStartQuiz() throws Exception {
		Usuario usuario = new Usuario(1, "gabriel", "");
		doReturn(new Quiz()).when(quizRepository).save(any());
		doReturn(usuario).when(usuarioService).findById(any());
		Partida partidaMock = new Partida();
		partidaMock.setFilme1(new Filme());
		partidaMock.setFilme2(new Filme());
		doReturn(partidaMock).when(partidaService).findById(any());
		QuizResponseDto iniciarQuiz = quizService.iniciarQuiz(usuario);
		Assert.notNull(iniciarQuiz);
		Assert.hasText(iniciarQuiz.getMensagem(),"Novo Jogo!");
	}

}
