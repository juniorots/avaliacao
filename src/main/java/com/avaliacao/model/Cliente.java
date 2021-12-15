package com.avaliacao.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Model core business
 * @author Jose
 *
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="cpf")
	private String cpf;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="cliente", orphanRemoval = true)	
	@JsonManagedReference
	private Endereco endereco;	
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="cliente", orphanRemoval = true)	
	@JsonManagedReference
	private Auditoria auditoria;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Telefone> telefones;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Email> emails;	
	
}
