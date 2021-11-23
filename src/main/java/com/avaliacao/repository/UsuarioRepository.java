package com.avaliacao.repository;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.avaliacao.model.Usuario;

/**
 * Repository users.
 * @author Jose
 *
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
//	@Query("select u from Usuario u where u.login = :login and u.senha = :senha")
	Optional<Usuario> findByLoginAndSenha(String login, String senha);
}
