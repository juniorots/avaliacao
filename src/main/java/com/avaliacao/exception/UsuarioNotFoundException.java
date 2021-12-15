package com.avaliacao.exception;

/**
 * Exceptions case
 * @author Jose
 *
 */
public class UsuarioNotFoundException extends Exception {

	private static final long serialVersionUID = 1254459184041361512L;

	public UsuarioNotFoundException(){
		super();
	}
	
	public UsuarioNotFoundException(String msg){
		super(msg);
	}
	
	public UsuarioNotFoundException(String msg, Throwable cause){
		super(msg, cause);
	}
}
