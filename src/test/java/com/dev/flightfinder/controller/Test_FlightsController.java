package com.dev.flightfinder.controller;

import java.io.File;
import java.io.IOException;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.dev.flightfinder.model.FlightResults;
import com.dev.flightfinder.service.FlightFinderService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import junit.framework.TestCase;

@RunWith(MockitoJUnitRunner.class)
public class Test_FlightsController extends TestCase {
	
	@Mock
	private FlightFinderService flightFinderService;
	
	@Autowired
	@InjectMocks
	private FlightsController flightsController;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void test_getFlightsTest() throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		ClassLoader loader = this.getClass().getClassLoader();
		FlightResults flightResults = mapper.readValue(new File(loader.getSystemResource("data/flights.json").getFile()), new TypeReference<FlightResults>() {});
		Mockito.when(flightFinderService.getFlightResults()).thenReturn(flightResults);
		
		ResponseEntity<FlightResults> entity =	new ResponseEntity<FlightResults>(flightResults,HttpStatus.OK);
	
		entity= flightsController.getFlights();
		Assert.assertNotNull(entity);	
		
	}
	
	
}
