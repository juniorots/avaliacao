package com.avaliacao.controller;

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

import com.avaliacao.exception.ClienteNotFoundException;
import com.avaliacao.model.Cliente;
import com.avaliacao.service.impl.ClienteServiceImpl;

/**
 * Controller operations.
 * @author Jose
 *
 */
@CrossOrigin(origins="http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ClienteController {
	
	@Autowired
	ClienteServiceImpl clienteService;
	
	
	@GetMapping("/clientes/{nome}")
	public ResponseEntity<Cliente> getClienteByNome(@PathVariable("nome") String nome) {
		try {			
			return new ResponseEntity<>(clienteService.getClienteByNome(nome), HttpStatus.OK);
		} catch (ClienteNotFoundException ce) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // :..-(
		}
	}

	@PostMapping("/clientes")
	public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
		try {
			// formatting
//			cliente.setCpf(cliente.getCpf());
//			cliente.getEndereco().setCep(cliente.getEndereco().getCep());
//			cliente.getAuditoria().setData(Calendar.getInstance().getTime());
//			for(Telefone t : cliente.getTelefones()) {
//				t.setNumero(t.getNumero());
//			}			
//			Cliente client = clienteRepository.save(ClienteMappingImpl.toCliente(cliente));
			return new ResponseEntity<>(clienteService.createCliente(cliente), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); // :..-(
		}
	}

	@PutMapping("/clientes/{id}")
	public ResponseEntity<Cliente> updateCliente(@PathVariable("id") long id, @RequestBody Cliente cliente) {
//		Optional<Cliente> tmpCliente = clienteRepository.findById(id);
//		if (!tmpCliente.isPresent()) return new ResponseEntity<>(HttpStatus.NOT_FOUND); // :..-(
//		
//		Cliente client = tmpCliente.get();
//		client.setId(id);
//		client.setNome(cliente.getNome());
//		client.setCpf(cliente.getCpf());
//		cliente.getEndereco().setCliente(client);
//		client.setEndereco(cliente.getEndereco());
//		cliente.getAuditoria().setCliente(client);
//		cliente.getAuditoria().setData(Calendar.getInstance().getTime());
//		client.setAuditoria(cliente.getAuditoria());
//		client.setEmails(cliente.getEmails());
//		client.setTelefones(null);
//		// formatting
//		for(Telefone t : cliente.getTelefones()) {
//			t.setNumero(t.getNumero());
//			client.getTelefones().add(t);
//		}
		try {
			return new ResponseEntity<>(clienteService.updateCliente(id, cliente), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); // :..-(			
		}
	}

	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<HttpStatus> deleteCliente(@PathVariable("id") long id) {
		try {
			clienteService.deleteCliente(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // :..-(
		}
	}
}
