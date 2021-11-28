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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Model core business
 * @author Jose
 *
 */
@Entity
@Table(name="cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="cpf")
	private String cpf;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="cliente")	
	@JsonManagedReference
	private Endereco endereco;	
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="cliente")	
	@JsonManagedReference
	private Auditoria auditoria;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Telefone> telefones;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Email> emails;
	
	public Cliente() {
	}
	
	public Cliente(String nome, String cpf, Endereco endereco, 
			Auditoria auditoria, List<Telefone> telefones, List<Email> emails) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.auditoria = auditoria;
		this.telefones = telefones;
		this.emails = emails;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf.replace(".", "").replace("-", "");
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Auditoria getAuditoria() {
		return auditoria;
	}

	public void setAuditoria(Auditoria auditoria) {
		this.auditoria = auditoria;
	}

	public List<Telefone> getTelefones() {
		if (telefones == null) return telefones = new ArrayList<>();
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public List<Email> getEmails() {
		if (emails == null) return emails = new ArrayList<>();
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}
}
