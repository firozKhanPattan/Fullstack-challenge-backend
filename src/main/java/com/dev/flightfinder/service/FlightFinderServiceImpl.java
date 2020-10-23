package com.dev.flightfinder.service;

import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dev.flightfinder.dao.FlightFinderDAO;
import com.dev.flightfinder.exception.FlightFinderException;
import com.dev.flightfinder.model.FlightResults;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Component
public class FlightFinderServiceImpl implements FlightFinderService {
	
	@Autowired
	private FlightFinderDAO flightFinderDao;
	
	/**
     * fetch the file details from dao.
     * @return FlightResults
     */
	@Override
	public FlightResults getFlightResults() throws FlightFinderException {
		 log.info("FlightFinderService- getFlightResults()");
		Optional<FlightResults> results= flightFinderDao.getItineraries();
		 FlightResults flightResults = results.orElseThrow( ()-> new FlightFinderException("Flight Results not found","Null values are returned from DAO"));
		return flightResults;
	}

}
