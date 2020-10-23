package com.dev.flightfinder.dao;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.dev.flightfinder.exception.FlightFinderException;
import com.dev.flightfinder.model.FlightResults;
import com.google.gson.Gson;
import com.google.gson.JsonParser;

/**
 * @author Firoz
 *
 */
@Component
public class FlightFinderDaoImpl implements FlightFinderDAO {

	private static final Logger logger = LoggerFactory.getLogger(FlightFinderDaoImpl.class);

	@Value("${dataFile.path}")
	private String jsonFilePath;

	
	
	@Override
	public FlightResults getItineraries() throws FlightFinderException {
		
		FlightResults flightResults = null;
		try {

			logger.info("Get Itineraries for the travel");
			logger.info(
					String.format("Fetc Itineries from the file", ClassLoader.getSystemResource(jsonFilePath)));

			URL url = ClassLoader.getSystemResource(jsonFilePath);
			if (url == null) {
				throw new FlightFinderException("Error while reading the file", "File not found in the path");
			}

			Reader reader = Files.newBufferedReader(Paths.get(url.toURI()));

			String parser = JsonParser.parseReader(reader).toString();
			
			logger.info("Json file parsed into a json String");

			Gson gson = new Gson();

			flightResults = gson.fromJson(parser, FlightResults.class);
			

		} catch (IOException e) {
			
			e.printStackTrace();
			logger.error(String.format("Error occured while reading the file", e.getMessage()));
			throw new FlightFinderException("Error while reading the file", e.getLocalizedMessage());
		} catch (URISyntaxException e) {
			
			logger.error(String.format("Error in URI syntax", e.getMessage()));
			e.printStackTrace();
			throw new FlightFinderException("Error while reading the file", e.getLocalizedMessage());
		}

		
		return flightResults;
	}
	
}
