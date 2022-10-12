package com.estados.service.exceptions;

public class ParamInvalidException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ParamInvalidException(String msg) {
		super(msg);
	}
}
