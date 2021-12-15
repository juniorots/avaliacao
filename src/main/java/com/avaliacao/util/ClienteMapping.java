package com.avaliacao.util;

import org.mapstruct.Mapper;

import com.avaliacao.model.Cliente;

/**
 * Mapping structure easier datas copying
 * @author Jose
 *
 */
@Mapper(componentModel="spring")
public interface ClienteMapping {
	Cliente toCliente(Cliente cliente);	
}
