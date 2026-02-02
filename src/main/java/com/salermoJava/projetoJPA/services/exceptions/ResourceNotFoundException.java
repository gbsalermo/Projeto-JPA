package com.salermoJava.projetoJPA.services.exceptions;

//Classe de excessão
public class ResourceNotFoundException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object id) {
		super("Resource not found. Id " + id); //Mensagem padrão da excessão
	}
}
