package com.avaliacao.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Keep eyes in operations :-)
 * @author Jose
 *
 */
//@Embeddable
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="auditoria")
public class Auditoria {	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="operador")
	private String operador;
	
	@Column(name="data")
	private Date data;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cliente_id")
	@JsonBackReference
	private Cliente cliente;
	
}
