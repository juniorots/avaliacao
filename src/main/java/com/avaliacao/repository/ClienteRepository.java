package com.avaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avaliacao.model.Cliente;

/**
 * Interface JPA
 * @author Jose
 *
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
}
