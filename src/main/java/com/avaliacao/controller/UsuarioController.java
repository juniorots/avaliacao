package com.avaliacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avaliacao.model.Perfil;
import com.avaliacao.model.Usuario;
import com.avaliacao.repository.UsuarioRepository;

/**
 * Basic control user
 * @author Jose
 *
 */
@CrossOrigin(origins="http://localhost:8080")
@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@PostMapping("/usuario")
	public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
		try {			
			Perfil perfil = usuario.getPerfil();
			perfil.getUsuarioList().add(usuario);
			usuario.setPerfil(perfil);
			Usuario user = usuarioRepository.save(usuario);
			return new ResponseEntity<>(user, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); // :..-(
		}
	}	
	
}
