package com.dev.flightfinder.dao;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dev.flightfinder.exception.FlightFinderException;
import com.dev.flightfinder.model.FlightResults;

@Service
public interface FlightFinderDAO {
	
	public Optional<FlightResults> getItineraries() throws FlightFinderException;
	
	
}
