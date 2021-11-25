package com.avaliacao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avaliacao.model.Cliente;
import com.avaliacao.model.Usuario;

/**
 * Interface JPA
 * @author Jose
 *
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	Optional<Cliente> findByNome(String nome);
}
