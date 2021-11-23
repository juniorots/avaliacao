package com.avaliacao.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	
	@Embedded
	private Endereco endereco;	
	
	@Embedded
	private Auditoria auditoria;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinTable(name="cliente_telefone",
			joinColumns={@JoinColumn(name="cliente_id",referencedColumnName="id")},
			inverseJoinColumns={@JoinColumn(name="telefone_id", referencedColumnName="id")})
	private Telefone telefones;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinTable(name="cliente_email",
			joinColumns={@JoinColumn(name="cliente_id",referencedColumnName="id")},
			inverseJoinColumns={@JoinColumn(name="email_id", referencedColumnName="id")})
	private Email emails;
	
	public Cliente(String nome, String cpf, Endereco endereco, 
			Auditoria auditoria, Telefone telefones, Email emails) {
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

	public Telefone getTelefones() {
		return telefones;
	}

	public void setTelefones(Telefone telefones) {
		this.telefones = telefones;
	}

	public Email getEmails() {
		return emails;
	}

	public void setEmails(Email emails) {
		this.emails = emails;
	}		
}
