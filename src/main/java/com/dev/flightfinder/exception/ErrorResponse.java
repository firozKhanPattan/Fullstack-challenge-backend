package com.dev.flightfinder.exception;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ErrorResponse {
	
	private String message;
	
	private String details;
	

	public ErrorResponse(String message, String details) {
		
		super();
		this.message = message;
		this.details = details;
		
	}

	
	
	

}
