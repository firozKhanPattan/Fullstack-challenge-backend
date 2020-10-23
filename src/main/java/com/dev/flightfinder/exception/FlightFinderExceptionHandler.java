package com.dev.flightfinder.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dev.flightfinder.controller.FlightsController;

@ControllerAdvice
public class FlightFinderExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(FlightFinderExceptionHandler.class);
	 @ExceptionHandler(value = { Exception.class })
	 	     public ResponseEntity<Object> handleException(FlightFinderException ex) {
		 		logger.error("Handling FlightFinderException");
		 		logger.error("Exception: "+ex.getMessage());
		 		ErrorResponse error = new ErrorResponse(ex.getExceptionMessage(),ex.getExceptionDetails());
	         return new ResponseEntity<Object>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	 
	     }
}
