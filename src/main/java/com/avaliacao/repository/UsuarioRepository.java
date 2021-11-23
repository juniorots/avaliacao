package com.avaliacao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avaliacao.model.Usuario;

/**
 * Repository users.
 * @author Jose
 *
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Optional<Usuario> findByLoginAndSenha(String login, String senha);
}
