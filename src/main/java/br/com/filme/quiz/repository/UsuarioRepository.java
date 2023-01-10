package br.com.filme.quiz.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.filme.quiz.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	public Optional<Usuario> findByUsuario(String username);
	
}