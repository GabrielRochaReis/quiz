package br.com.filme.quiz.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.filme.quiz.model.Partida;

@Service
public class PartidaService {
	
	@Autowired
	private JpaRepository<Partida, Long> partidaRepository;
	
	public void saveAll(List<Partida> filmes) {
		this.partidaRepository.saveAll(filmes);
	}
	
	public List<Partida> findAll() {
		return this.partidaRepository.findAll();
	}
	
	public Partida findById(Long id) {
		Optional<Partida> partidas = this.partidaRepository.findById(id);
		if (partidas != null && !partidas.isEmpty()) {
			return partidas.get();
		}
		return null;
	}

}
