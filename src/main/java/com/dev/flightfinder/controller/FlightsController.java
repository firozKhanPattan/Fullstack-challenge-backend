package com.dev.flightfinder.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.flightfinder.exception.FlightFinderException;
import com.dev.flightfinder.model.FlightResults;
import com.dev.flightfinder.service.FlightFinderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("flight-finder")
@Api(tags="flights")
@CrossOrigin("*")
public class FlightsController {
	
	private static final Logger logger = LoggerFactory.getLogger(FlightsController.class);

	@Autowired
	private FlightFinderService flightFinderService;
	
	/**
     * This method is for retrieving all flights results
     * @param request
     * @param response
     * @return ResponseEntity<FlightResults>
     */
	
	@GetMapping("/flights")
	@ApiOperation(value = "Gets flight results.", notes = "Provides the itineraries with the flight details")
	public ResponseEntity<FlightResults> getFlights() throws FlightFinderException{
		
		logger.info("Fetching Flight details - FlightsController");
		
		FlightResults results = flightFinderService.getFlightResults();
		
		return new ResponseEntity<FlightResults>(results,HttpStatus.OK);
	}
	
}
