package com.dev.flightfinder.model;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class Itineraries {
	
	private String id;
	
	private List<String> legs;
	
	@ApiModelProperty(notes="Price of the travel",name="price")
	private String price;
	
	@ApiModelProperty(notes="Agent providing the price",name="agent")
	private String agent;
	
	@ApiModelProperty(notes="Rating given by users to the agent",name="agent_rating")
	private double agent_rating;

	
	
}
