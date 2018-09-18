package net.ssh.shoppingbackend.dto;

import java.io.Serializable;

public class CustomException extends Exception implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public void CustomException() {
		
	}
	
	public void CustomException(String message) {
		this.message = System.currentTimeMillis() + ": " + message;
	}

	public String getMessage() {
		return message;
	}

	
	
	
}
