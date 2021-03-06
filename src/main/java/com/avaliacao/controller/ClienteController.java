package com.avaliacao.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avaliacao.model.Cliente;
import com.avaliacao.repository.ClienteRepository;

/**
 * Controller operations.
 * @author Jose
 *
 */
@CrossOrigin(origins="http://localhost:8080")
@RestController
@RequestMapping("/api")
public class ClienteController {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@GetMapping("/clientes/{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable("id") long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (cliente.isPresent()) return new ResponseEntity<>(cliente.get(), HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND); // :..-( 
	}

	@PostMapping("/clientes")
	public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
		try {			
			Cliente client = clienteRepository.save(new Cliente(
					cliente.getNome(),
					cliente.getCpf(),
					cliente.getEndereco(),
					cliente.getAuditoria(),
					cliente.getTelefones(),
					cliente.getEmails()
					));
			return new ResponseEntity<>(client, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); // :..-(
		}
	}

	@PutMapping("/clientes/{id}")
	public ResponseEntity<Cliente> updateCliente(@PathVariable("id") long id, @RequestBody Cliente cliente) {
		Optional<Cliente> tmpCliente = clienteRepository.findById(id);
		if (!tmpCliente.isPresent()) return new ResponseEntity<>(HttpStatus.NOT_FOUND); // :..-(
		
		Cliente client = tmpCliente.get();
		client.setNome(cliente.getNome());
		client.setCpf(cliente.getCpf());
		client.setAuditoria(cliente.getAuditoria());
		client.setEndereco(cliente.getEndereco());
		client.setTelefones(cliente.getTelefones());
		client.setEmails(cliente.getEmails());
		return new ResponseEntity<>(clienteRepository.save(client), HttpStatus.OK);
	}

	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<HttpStatus> deleteCliente(@PathVariable("id") long id) {
		try {
			clienteRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // :..-(
		}
	}
}
