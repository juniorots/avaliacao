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
 * Phone Clients
 * @author Jose
 *
 */
@Entity
@Table(name="telefone")
public class Telefone {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	/*
	 * 1 - residencial
	 * 2 - comercial
	 * 3 - celular
	 */
	@Column(name="tipo")
	private String tipo;
	
	@Column(name="numero")
	private String numero;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}	

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero.replace("(", "").replace(")", "").replace("-", "");
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
}
