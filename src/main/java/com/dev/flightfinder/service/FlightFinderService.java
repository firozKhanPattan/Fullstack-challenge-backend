package com.dev.flightfinder.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dev.flightfinder.exception.FlightFinderException;
import com.dev.flightfinder.model.FlightResults;

@Service
public interface FlightFinderService {
	
	public FlightResults getFlightResults() throws FlightFinderException;

}
