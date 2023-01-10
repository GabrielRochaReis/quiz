package br.com.filme.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.filme.quiz.model.Filme;

public interface FilmeRepository  extends JpaRepository<Filme, String>{}