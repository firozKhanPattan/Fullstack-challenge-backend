package com.dev.flightfinder.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;


public class FlightFinderException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String exceptionMessage;
	private String exceptionDetails;
	public FlightFinderException() {
		
	}
	public FlightFinderException(String exceptionMessage, String exceptionDetails) {
		super(exceptionMessage);
		
		this.exceptionMessage = exceptionMessage;
		this.exceptionDetails = exceptionDetails;
		
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public String getExceptionDetails() {
		return exceptionDetails;
	}

	public void setExceptionDetails(String exceptionDetails) {
		this.exceptionDetails = exceptionDetails;
	}


	
}
