package com.avaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avaliacao.model.Endereco;

/**
 * Resource Repository
 * @author Jose
 *
 */
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
	
}
