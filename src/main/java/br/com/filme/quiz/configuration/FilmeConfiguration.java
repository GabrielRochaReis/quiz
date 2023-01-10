package br.com.filme.quiz.configuration;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.filme.quiz.model.Filme;
import br.com.filme.quiz.model.Partida;
import br.com.filme.quiz.model.ResponseFilmesShort;
import br.com.filme.quiz.model.Usuario;
import br.com.filme.quiz.service.FilmeService;
import br.com.filme.quiz.service.PartidaService;
import br.com.filme.quiz.service.UsuarioService;


@Component
public class FilmeConfiguration  implements ApplicationRunner {

	@Autowired
	private FilmeService filmeService;
	
	@Autowired
	private PartidaService partidaService;
	
	@Autowired
	private UsuarioService usuarioService;
	
//	@Autowired
//	private PerfisService perfisService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<Filme> filmes = carregarFilmes();
		
		carregarQuiz(filmes);
		
		Usuario usuario = usuarioService.findByUser("gabriel");
		if (usuario == null) {
			criarUsuarios();
		}
		
	}

	private void criarUsuarios() {
//		Perfis perfis = new Perfis(1, "User");
//		perfisService.save(perfis);
//		ArrayList<Perfis> list = new ArrayList<Perfis>();
//		list.add(perfis);
//		Usuario usuario = new Usuario(new Long(1), "gabriel", "1234", list);
		Usuario usuario1 = new Usuario(1, "gabriel", "1234");
		usuarioService.save(usuario1);
		Usuario usuario2 = new Usuario(1, "visitante", "4321");
		usuarioService.save(usuario2);
	}

	private void carregarQuiz(List<Filme> filmes) {
		List<Partida> partidas = partidaService.findAll();
		Integer rep = 0;
		if(partidas == null || partidas.isEmpty()) {			
			for (Filme filme : filmes) {
				for (int i = rep; i < filmes.size(); i++) {
					if(filme.getId() != filmes.get(i).getId()) {
						Partida partida = new Partida();
						partida.setFilme1(filme);
						partida.setFilme2(filmes.get(i));
						Integer vencedor = partida.getFilme1().getPontuacao() > partida.getFilme2().getPontuacao()?1:2;
						partida.setVencedor(vencedor);
						partidas.add(partida);
					}
				}
				rep++;
			}
			Collections.shuffle(partidas);
			partidaService.saveAll(partidas);
		}
	}

	private List<Filme> carregarFilmes() {
		RestTemplate restTemplate = new RestTemplate();
		
		List<Filme> filmes = filmeService.findAll();
		
		if(filmes == null || filmes.isEmpty()) {			
			IntStream.rangeClosed(1, 10).forEach(page -> {
				
				ResponseFilmesShort responseFilmesShort = restTemplate.getForObject(
						String.format("http://www.omdbapi.com/?apikey=dad01f0b&s=\"and\"&page=%d&type=movie", page), ResponseFilmesShort.class);
				
				Stream.of(responseFilmesShort.getFilmes()).forEach(filmeShort -> {
					Filme filme = restTemplate.getForObject(String.format("http://www.omdbapi.com/?apikey=dad01f0b&i=%s", filmeShort.getId()), Filme.class);
					Double VOTOS = null;
					try {
						VOTOS = new Double(filme.getVotos().replace(",",""));
					}
					catch(Exception e) {
						VOTOS = new Double(1);
					}
					filme.setPontuacao(VOTOS * filme.getNota());
					filmes.add(filme);
				});
				
				filmeService.saveAll(filmes);
			});
		}
		return filmes;
	}

}
