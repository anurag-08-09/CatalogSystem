package com.globomart.cams.exceptions;

public class CustomException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8232969670560375143L;

	public CustomException(String code) {
		super(code);
		this.code = code;
	}

	public CustomException(String code, String message) {
		super(code);
		this.code = code;
		this.message = message;
	}

	private String code;
	private String message;

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "CustomException [code=" + code + ", message=" + message + "]";
	}

}
