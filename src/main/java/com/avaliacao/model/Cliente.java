package com.avaliacao.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	
	@OneToOne
	@JoinColumn(name="endereco_id")
	@JsonBackReference
	private Endereco endereco;	
	
	@OneToOne
	@JoinColumn(name="auditoria_id")
	@JsonBackReference
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
		return cpf;
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
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}
}
