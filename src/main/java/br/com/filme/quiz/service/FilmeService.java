package br.com.filme.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.filme.quiz.model.Filme;

@Service
public class FilmeService {
	
	@Autowired
	private JpaRepository<Filme, String> filmeRepository;
	
	public void saveAll(List<Filme> filmes) {
		this.filmeRepository.saveAll(filmes);
	}
	
	public List<Filme> findAll() {
		return this.filmeRepository.findAll();
	}

}
