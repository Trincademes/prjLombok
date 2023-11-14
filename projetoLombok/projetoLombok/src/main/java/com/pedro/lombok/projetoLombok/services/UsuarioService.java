package com.pedro.lombok.projetoLombok.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.pedro.lombok.projetoLombok.Entities.Usuario;
import com.pedro.lombok.projetoLombok.Repositories.UsurarioRepository;

public class UsuarioService {

	private final UsurarioRepository usurarioRepository;

	@Autowired
	public UsuarioService (UsurarioRepository usurarioRepository) {
		this.usurarioRepository = usurarioRepository;
	}

	// preparando as buscas por id
	public Usuario findUsuarioById(Long id) {
		Optional<Usuario> Usuario = usurarioRepository.findById(id);
		return Usuario.orElse(null);
	}

	// preparando a busca geral
	public List<Usuario> findAllUsuario() {
		return usurarioRepository.findAll();
	}

	// salvando o Jogo
	public Usuario insertUsuario(Usuario usuario) {
		return usurarioRepository.save(usuario);
	}

	// fazendo o update do jogo com o optional
	public Usuario updateUsuario(Long id, Usuario novoUsuario) {
		Optional<Usuario> usuarioOptional = usurarioRepository.findById(id);
		if (usuarioOptional.isPresent()) {
			Usuario usuarioExistente = usuarioOptional.get();
			usuarioExistente.setNome(novoUsuario.getNome());
			usuarioExistente.setEmail(novoUsuario.getEmail());
			return usurarioRepository.save(usuarioExistente);
		} else {
			return null;
		}
	}

	// deletando o update do usuario com o optional
	public boolean deleteUsuario(Long id) {
		Optional<Usuario> usuarioExistente = usurarioRepository.findById(id);
		if (usuarioExistente.isPresent()) {
			usurarioRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
