package com.avaliacao.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Keep eyes in operations :-)
 * @author Jose
 *
 */
@Embeddable
public class Auditoria {	
	
	@Column(name="operador")
	private String operador;
	
	@Column(name="data")
	private Date data;

	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
}
