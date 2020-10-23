package com.dev.flightfinder.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class Legs {
	
	private String id;
	
	@ApiModelProperty(notes="Airport where flight starts",name="departure_airport")
	private String departure_airport;
	
	@ApiModelProperty(notes="Name of the arrival airport",name="arrival_airport")
	private String arrival_airport;
	
	@ApiModelProperty(notes="Departure time",name="departure_time")
	private String departure_time;
	
	@ApiModelProperty(notes="Arrival time of flight",name="arrival_time")
	private String arrival_time;
	
	@ApiModelProperty(notes="Denotes if a direct flight or has stops",name="stops")
	private int stops;
	
	@ApiModelProperty(notes="Name of the airline",name="airline_name")
	private String airline_name;
	
	@ApiModelProperty(notes="Id of the Airlines",name="airline_id")
	private String airline_id;
	
	@ApiModelProperty(notes="Total duration of travel",name="duration_mins")
	private int duration_mins;


	
}
