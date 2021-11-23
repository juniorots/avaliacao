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
 * Email Clients
 * @author Jose
 *
 */
@Entity
@Table(name="email")
public class Email {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="email")
	private String email;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="cliente_email",
			joinColumns={@JoinColumn(name="email_id", referencedColumnName="id")},
			inverseJoinColumns={@JoinColumn(name="cliente_id",referencedColumnName="id")})
	private List<Cliente> clienteList;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Cliente> getClienteList() {
		return clienteList;
	}

	public void setClienteList(List<Cliente> clienteList) {
		this.clienteList = clienteList;
	}	
}
