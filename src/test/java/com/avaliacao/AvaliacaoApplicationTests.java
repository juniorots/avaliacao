package com.avaliacao;

import java.util.Calendar;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.avaliacao.model.Auditoria;
import com.avaliacao.model.Cliente;
import com.avaliacao.model.Email;
import com.avaliacao.model.Endereco;
import com.avaliacao.model.Perfil;
import com.avaliacao.model.Telefone;
import com.avaliacao.model.Usuario;
import com.avaliacao.repository.AuditoriaRepository;
import com.avaliacao.repository.ClienteRepository;
import com.avaliacao.repository.EnderecoRepository;
import com.avaliacao.repository.UsuarioRepository;

@SpringBootTest
class AvaliacaoApplicationTests {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	AuditoriaRepository auditoriaRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Test
	void contextLoads() {
		Optional<Usuario> usr = usuarioRepository.findByLoginAndSenha("admin", "123456");
		if (!usr.isPresent()) {
			Usuario user = new Usuario();
			user.setLogin("admin");
			user.setSenha("123456");
			Perfil p = new Perfil();
			p.setNomePerfil("admin");
			user.getPerfilList().add(p);
			usuarioRepository.save(user);
		}
		usr = usuarioRepository.findByLoginAndSenha("comum", "123456");
		if (!usr.isPresent()) {
			Usuario user = new Usuario();
			user.setLogin("comum");
			user.setSenha("123456");
			Perfil p = new Perfil();
			p.setNomePerfil("comum");
			user.getPerfilList().add(p);
			usuarioRepository.save(user);
		}
	}
	
	@Test
	void createUser() {
			
	}
	
//	@Test
	void testSaveClient() {
		try {
			Cliente cliente = new Cliente();
			cliente.setNome("Yuri Francisco de Paula");
			cliente.setCpf("35682260066");
			
			Telefone tel = new Telefone();
			tel.setTipo("celular");
			tel.setNumero("6199999999");
			cliente.getTelefones().add(tel);
			
			Email e = new Email();
			e.setEmail("user@gmail.com");
			cliente.getEmails().add(e);				
			
			Endereco end = new Endereco();
			end.setCep("58309820");
			end.setLogradouro("Rua José Fernandes de Lima");
			end.setBairro("Comercial Norte");
			end.setCidade("Bayeux");
			end.setUf("PB");
			end.setComplemento("Complemento 01");
			cliente.setEndereco(end);
			
			Auditoria au = new Auditoria();
			au.setOperador("Operador 01");
			au.setData(Calendar.getInstance().getTime());
			cliente.setAuditoria(au);
			clienteRepository.save(cliente);
			
			System.out.println("SUCESSO... :-)");
		} catch (Exception e) {
			System.err.println(e); // :..-(
		}
	}
	
//	@Test
	public void testeDeleteCliente() {
		try {
			clienteRepository.deleteById(1l);
			System.out.println("SUCESSO...");
		} catch (Exception e) {
			System.err.println(e); // :..-(
		}
	}
	
//	@Test
	public void getCliente() {
		try {
			Optional<Cliente> client = clienteRepository.findByNome("Yuri Francisco de Paula");
			System.out.println("CLIENTE RETORNADO: " + client.get().getCpf());
		} catch (Exception e) {
			System.err.println(e); // :..-(
		}
	}

}
