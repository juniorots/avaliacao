package com.avaliacao.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * User's definitions
 * @author Jose
 *
 */
@Entity
@Table(name="usuario") 
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="login")
	private String login;
	
	@Column(name="senha")
	private String senha;

	//	@OneToMany(mappedBy="usuario", cascade=CascadeType.ALL)
	@OneToMany(cascade=CascadeType.ALL)
	private List<Perfil> perfilList;

	public Usuario() {
	}
	
	public Usuario(String login, String senha, List<Perfil> lista) {
		this.login = login;
		this.senha = senha;
		perfilList = lista;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Perfil> getPerfilList() {
		if (perfilList == null) return perfilList = new ArrayList<Perfil>();
		return perfilList;
	}

	public void setPerfilList(List<Perfil> perfilList) {
		this.perfilList = perfilList;
	}	
}
