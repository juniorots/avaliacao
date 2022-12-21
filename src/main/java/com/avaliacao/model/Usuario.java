package com.avaliacao.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * User's definitions
 * @author Jose
 *
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
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
	
	public String getLogin() {
		return this.login;
	}
	public String getSenha() {
		return this.senha;
	}
}
