package com.avaliacao.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Definition access
 * @author Jose
 *
 */
@Entity
@Table(name="perfil")
public class Perfil {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="nome")
	private String nomePerfil;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="usuario_perfil",
			joinColumns={@JoinColumn(name="perfil_id", referencedColumnName="id")},
			inverseJoinColumns={@JoinColumn(name="usuario_id",referencedColumnName="id")})
	private List<Usuario> usuarioList;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}	

	public String getNomePerfil() {
		return nomePerfil;
	}

	public void setNomePerfil(String nomePerfil) {
		this.nomePerfil = nomePerfil;
	}

	public List<Usuario> getUsuarioList() {
		return usuarioList;
	}

	public void setUsuarioList(List<Usuario> usuarioList) {
		this.usuarioList = usuarioList;
	}
			
}
