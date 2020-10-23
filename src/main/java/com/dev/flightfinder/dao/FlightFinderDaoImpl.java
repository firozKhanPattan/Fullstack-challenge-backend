package com.dev.flightfinder.dao;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.dev.flightfinder.exception.FlightFinderException;
import com.dev.flightfinder.model.FlightResults;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Firoz
 *
 */
@Slf4j
@Component
public class FlightFinderDaoImpl implements FlightFinderDAO {

	@Value("${dataFile.path}")
	private String jsonFilePath;

	/**
     * Reads JSON data from file and provides flight results
     * @return FlightResults
     */
	
	@Override
	public Optional<FlightResults> getItineraries() throws FlightFinderException {
		
		FlightResults flightResults = null;
		try {
				ObjectMapper mapper = new ObjectMapper();
				
				flightResults = mapper.readValue(new File(ClassLoader.getSystemResource(jsonFilePath).getFile()),new TypeReference<FlightResults>() {});
				log.info("JSon file is read and mapped to FlightResults");
		} catch (IOException e) {
			
			e.printStackTrace();
			log.error(String.format("Error occured while reading the file", e.getMessage()));
			throw new FlightFinderException("Error while reading the file", e.getLocalizedMessage());
		}

		return Optional.of(flightResults);
	}
	
}
