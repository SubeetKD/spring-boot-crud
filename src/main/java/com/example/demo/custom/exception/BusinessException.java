package com.example.demo.custom.exception;

import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class BusinessException extends RuntimeException {
	/**
	 * NOTE: [ ] Find out about serialVerisonUID.
	 */
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMessage;
		
	public BusinessException() {
		super();
	}

	public BusinessException(String errorCode, String errrorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errrorMessage;
	}
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BusinessException [errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
	}

}
