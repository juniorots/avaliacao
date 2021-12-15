package com.avaliacao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacao.exception.ClienteNotFoundException;
import com.avaliacao.model.Cliente;
import com.avaliacao.repository.ClienteRepository;
import com.avaliacao.service.ClienteService;
import com.avaliacao.util.ClienteMapping;

/**
 * Refactory Architecture case
 * @author Jose
 *
 */
@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	ClienteMapping clienteMapping;
	
	public Cliente getClienteByNome(String nome) throws ClienteNotFoundException {
		return clienteRepository.findByNome(nome).orElseThrow(() -> 
			new ClienteNotFoundException("Cliente [ " + nome + " ] nao encontrado."));
	}
	
	public Cliente createCliente(Cliente cliente) {		
		return clienteRepository.save(cliente);
	}
	
	public Cliente updateCliente(long id, Cliente cliente) throws ClienteNotFoundException {
		Cliente client = clienteRepository.findById(id).orElseThrow(() -> 
				new ClienteNotFoundException("Cliente [ " + id + " ] nao encontrado."));
		client = clienteMapping.toCliente(cliente);
		return clienteRepository.save(client);	
	}
	
	public void deleteCliente(Long id) {
		clienteRepository.deleteById(id);
	}
}
