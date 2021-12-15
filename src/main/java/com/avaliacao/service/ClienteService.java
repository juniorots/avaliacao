package com.avaliacao.service;

import com.avaliacao.exception.ClienteNotFoundException;
import com.avaliacao.model.Cliente;

/**
 * Refactory Architecture case
 * @author Jose
 *
 */
public interface ClienteService {
	
	public Cliente getClienteByNome(String nome) throws ClienteNotFoundException;
	
	public Cliente createCliente(Cliente cliente);
	
	public Cliente updateCliente(long id, Cliente cliente) throws ClienteNotFoundException;
	
	public void deleteCliente(Long id);
	
}
