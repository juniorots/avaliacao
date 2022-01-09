package com.avaliacao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Phone Clients
 * @author Jose
 *
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
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

}
