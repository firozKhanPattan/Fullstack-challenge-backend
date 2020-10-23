package com.dev.flightfinder.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class FlightResults {
	
    private List<Itineraries> itineraries;
   
    private List<Legs> legs;
    
 
    public FlightResults(ArrayList<Itineraries> Itinerariess, ArrayList<Legs> flightInfos) {
        this.itineraries = Itinerariess;
        this.legs = flightInfos;
    }

    
}