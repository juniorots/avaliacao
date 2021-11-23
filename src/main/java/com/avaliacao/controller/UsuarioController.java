package com.avaliacao.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
			Usuario user = usuarioRepository.save(usuario);
			return new ResponseEntity<>(user, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); // :..-(
		}
	}	
	
	@GetMapping("/usuario")
	public ResponseEntity<Usuario> getUsuario(@RequestBody Usuario usuario) {
		try {
			Optional<Usuario> user = usuarioRepository.findByLoginAndSenha(usuario.getLogin(), usuario.getSenha());
			if (!user.isPresent()) return new ResponseEntity<>(HttpStatus.NOT_FOUND); // :..-(	
			
			return new ResponseEntity<>(user.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); // :..-(		
		}		
	}
	
}
