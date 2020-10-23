package com.dev.flightfinder.service;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.dev.flightfinder.dao.FlightFinderDAO;
import com.dev.flightfinder.exception.FlightFinderException;
import com.dev.flightfinder.model.FlightResults;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import junit.framework.TestCase;

@RunWith(MockitoJUnitRunner.class)
public class Test_FlightFinderService extends TestCase{
	
	@Mock
	private FlightFinderDAO flightFinderDao;
	
	
	@InjectMocks
	@Autowired
	FlightFinderServiceImpl flightFinderService;
	
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void test_getFlightResults() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		ClassLoader loader = this.getClass().getClassLoader();
		FlightResults flightResults = mapper.readValue(new File(loader.getSystemResource("data/flights.json").getFile()), new TypeReference<FlightResults>() {});
		Optional<FlightResults> result = Optional.of(flightResults);
		Mockito.when(flightFinderDao.getItineraries()).thenReturn(result);
		FlightResults results = flightFinderService.getFlightResults();
		Assert.assertNotNull(results);
	}
	
	@Test(expected = FlightFinderException.class)
	public void test_getFlightResults_withException() {
		Mockito.when(flightFinderDao.getItineraries()).thenReturn(null);
		FlightResults results = flightFinderService.getFlightResults();	
	}
	}
