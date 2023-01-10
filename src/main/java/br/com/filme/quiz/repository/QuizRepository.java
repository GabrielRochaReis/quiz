package br.com.filme.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.filme.quiz.model.Quiz;
import br.com.filme.quiz.model.Usuario;

public interface QuizRepository extends JpaRepository<Quiz, Long>{
	
	List<Quiz> findByUsuario(Usuario usuario);
	
}