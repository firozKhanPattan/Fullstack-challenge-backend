package com.dev.flightfinder.controller;


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
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("flight-finder")
@Api(value="Flights Controller")
@CrossOrigin("*")
public class FlightsController {
	
	@Autowired
	private FlightFinderService flightFinderService;
	
	/**
     * This method is for retrieving all flights results
     * @param request
     * @param response
     * @return ResponseEntity<FlightResults>
     */
	
	@GetMapping(value="/flights",produces="application/json")
	@ApiOperation(value = "Gets flight results.", notes = "Provides the itineraries with the flight details")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message="Success|OK")
	})
	public ResponseEntity<FlightResults> getFlights() throws FlightFinderException{
		
		log.debug("Fetching Flight details - FlightsController");
		
		
		FlightResults results = flightFinderService.getFlightResults();
		
		return new ResponseEntity<FlightResults>(results,HttpStatus.OK);
	}
	
}
