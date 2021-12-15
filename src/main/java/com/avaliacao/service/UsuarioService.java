package com.avaliacao.service;

import java.util.Optional;

import com.avaliacao.exception.UsuarioNotFoundException;
import com.avaliacao.model.Usuario;

/**
 * Refactory Architecture case
 * @author Jose
 *
 */
public interface UsuarioService {

	public Usuario createUsuario(Usuario usuario);
	
	public Optional<Usuario> getUsuario(Usuario usuario) throws UsuarioNotFoundException;
}
