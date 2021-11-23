package com.avaliacao.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
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
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinTable(name="usuario_perfil",
			joinColumns={@JoinColumn(name="usuario_id",referencedColumnName="id")},
			inverseJoinColumns={@JoinColumn(name="perfil_id", referencedColumnName="id")})
	private Perfil perfil;

	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
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

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}	
	
}
