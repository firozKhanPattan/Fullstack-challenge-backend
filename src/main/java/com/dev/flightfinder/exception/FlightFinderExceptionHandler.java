package com.dev.flightfinder.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Firoz
 *
 */
@Slf4j
@ControllerAdvice
public class FlightFinderExceptionHandler {
	
	
	/**
	 * Method handles all the custom Exceptions thrown in FlightFinder
	 * @return ResponseEntity<ErrorResponse>
	 */
	@ExceptionHandler(value = { FlightFinderException.class })
	public ResponseEntity<Object> handleFlightException(FlightFinderException ex) {
		log.error("Handling FlightFinderException");
		log.error("Exception: " + ex.getMessage());
		ErrorResponse error = new ErrorResponse(ex.getExceptionMessage(), ex.getExceptionDetails());
		return new ResponseEntity<Object>(error, HttpStatus.EXPECTATION_FAILED);

	}
	
	/**
	 * Method handles all the RuntimeExceptions Exceptions thrown in FlightFinder
	 * @return ResponseEntity<ErrorResponse>
	 */
	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleException(Exception ex) {
		log.error("Handling FlightFinderException");
		log.error("Exception: " + ex.getMessage());
		ErrorResponse error = new ErrorResponse(ex.getMessage(), ex.getLocalizedMessage());
		return new ResponseEntity<Object>(error, HttpStatus.INTERNAL_SERVER_ERROR);

	}
}
