package com.example.demo.custom.exception;

import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class ControllerException extends RuntimeException {
	/**
	 * NOTE: [ ] Find out about serialVerisonUID.
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	private String message;
		
	public ControllerException() {
		super();
	}
	
	public ControllerException(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "BusinessException [code=" + code + ", message=" + message + ", getCode()=" + getCode()
				+ ", getMessage()=" + getMessage() + ", getLocalizedMessage()=" + getLocalizedMessage()
				+ ", getCause()=" + getCause() + ", toString()=" + super.toString() + ", fillInStackTrace()="
				+ fillInStackTrace() + ", getStackTrace()=" + Arrays.toString(getStackTrace()) + ", getSuppressed()="
				+ Arrays.toString(getSuppressed()) + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
}
