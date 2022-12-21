package com.avaliacao.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacao.exception.UsuarioNotFoundException;
import com.avaliacao.model.Usuario;
import com.avaliacao.repository.UsuarioRepository;
import com.avaliacao.service.UsuarioService;

/**
 * Refactory Architecture case
 * @author Jose
 *
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Usuario createUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Optional<Usuario> getUsuario(Usuario usuario) throws UsuarioNotFoundException {	
		Optional<Usuario> tmp = usuarioRepository.findByLoginAndSenha(usuario.getLogin(), usuario.getSenha());
		if (!tmp.isPresent()) throw new UsuarioNotFoundException("Usuario [ " + usuario.getLogin() + " ] nao encontrado."); // :..-(
		return tmp;
	}
}
