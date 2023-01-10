package br.com.filme.quiz.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.filme.quiz.model.Usuario;
import br.com.filme.quiz.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private JpaRepository<Usuario, Integer> usuarioRepository;
	
	public Usuario findById(Integer idUsuario) {
		return usuarioRepository.findById(idUsuario).get();
	}
	
	public Usuario findByUser(String username) {
		Optional<Usuario> usuario = ((UsuarioRepository) usuarioRepository).findByUsuario(username);
		if (usuario.isPresent()) {
			return usuario.get();
		}
		return null;
	}
	
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Optional<Usuario> usuario = ((UsuarioRepository) usuarioRepository).findByUsuario(username);
//		if (usuario.isPresent()) {
//			return usuario.get();
//		}
//		throw new UsernameNotFoundException("Usuario incorreto!");
//	}

}
