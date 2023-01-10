package br.com.filme.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.filme.quiz.model.Partida;

public interface PartidaRepository  extends JpaRepository<Partida, Long>{}