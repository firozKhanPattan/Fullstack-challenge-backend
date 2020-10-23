package com.dev.flightfinder.model;

import java.util.ArrayList;
import java.util.List;

public class FlightResults {
    
    private List<Itineraries> itineraries;
   
    private List<Legs> legs;
    
    public FlightResults() {
    	
    }

    public FlightResults(ArrayList<Itineraries> Itinerariess, ArrayList<Legs> flightInfos) {
        this.itineraries = Itinerariess;
        this.legs = flightInfos;
    }

    public List<Itineraries> getItineraries() {
        return itineraries;
    }

    public void setItineraries(List<Itineraries> itineraries) {
        this.itineraries = itineraries;
    }

    public List<Legs> getLegs() {
        return legs;
    }

    public void setLegs(List<Legs> legs) {
        this.legs = legs;
    }
}