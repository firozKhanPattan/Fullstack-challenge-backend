package com.dev.flightfinder.model;

import java.util.List;

public class Itineraries {
	
	private String id;
	
	private List<String> legs;
	
	private String price;
	
	private String agent;
	
	private double agent_rating;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getLegs() {
		return legs;
	}

	public void setLegs(List<String> legs) {
		this.legs = legs;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public double getagent_rating() {
		return agent_rating;
	}

	public void setagent_rating(double agent_rating) {
		this.agent_rating = agent_rating;
	}
	
	
	
	
}
