package com.avaliacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avaliacao.model.Usuario;
import com.avaliacao.service.impl.UsuarioServiceImpl;

/**
 * Basic control user
 * @author Jose
 *
 */
@CrossOrigin(origins="http://localhost:8081")
@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	@Autowired
	UsuarioServiceImpl usuarioService;
	
	@PostMapping("/usuario")
	public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
		try {
			return new ResponseEntity<>(usuarioService.createUsuario(usuario), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); // :..-(
		}
	}	
	
	@PostMapping("/validarAcesso")
	public ResponseEntity<Usuario> getUsuario(@RequestBody Usuario usuario) {
		try {
//			Optional<Usuario> user = usuarioRepository.findByLoginAndSenha(usuario.getLogin(), usuario.getSenha());
//			if (!user.isPresent()) return new ResponseEntity<>(HttpStatus.NOT_FOUND); // :..-(	
//			
			return new ResponseEntity<>(usuarioService.getUsuario(usuario).get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); // :..-(		
		}		
	}
	
}
