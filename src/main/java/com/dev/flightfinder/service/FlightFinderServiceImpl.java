package com.dev.flightfinder.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dev.flightfinder.dao.FlightFinderDAO;
import com.dev.flightfinder.exception.FlightFinderException;
import com.dev.flightfinder.model.FlightResults;

@Component
public class FlightFinderServiceImpl implements FlightFinderService {
	
	private static final Logger logger = LoggerFactory.getLogger(FlightFinderServiceImpl.class);
	
	@Autowired
	private FlightFinderDAO flightFinderDao;

	@Override
	public FlightResults getFlightResults() throws FlightFinderException {
		 logger.info("FlightFinderService- getFlightResults()");
		FlightResults results =  flightFinderDao.getItineraries();
		if(results == null) {
			throw new FlightFinderException("Error occured while converting json String to Object","json String is empty");
		}
		
		return results;
	}

}
