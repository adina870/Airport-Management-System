package airport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Passengers {
	
	private String name;
	private String passportNumber;
	private Flight flight;
	private List<Luggage> luggageList;
	
	public Passengers(String name, String passportNumber, Flight flight, List<Luggage> luggageList) {
		this.name = name;
		this.passportNumber = passportNumber;
		this.flight = flight;
		this.luggageList = new ArrayList<>();
	}
	
	public Passengers(String name, String passportNumber, Flight flight) {
		this.name = name;
		this.passportNumber = passportNumber;
		this.flight = flight;
	}
	
	public Passengers() {
		this.name = "No name enterd";
		this.passportNumber = "No passport bumber entered yet";
		this.flight = null;
		this.luggageList = null;
	}
	
	public Passengers(Passengers other) {   
		this.name = other.name;
		this.passportNumber = other.passportNumber;
		this.flight = other.flight;
		this.luggageList = other.luggageList;
	}
	
	public void addLuggage(Luggage luggage) {
	    if (luggageList == null) {
	        luggageList = new ArrayList<>();
	    }
	    luggageList.add(luggage);
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getPassportNumber() {
		return this.passportNumber;
	}
	
	public Flight getFlight() {
		return this.flight;
	}
	
	public List<Luggage> getLuggageList() {
		return Collections.unmodifiableList(this.luggageList); //makes my list unmodifiable. 
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	public void setLuggageList(List<Luggage> luggageList) {
		this.luggageList = luggageList;
	}
	
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
		
		if (getClass() != other.getClass()) {
			return false;
		}
		
		Passengers other2 = (Passengers) other;
		return this.name.equals(other2.name) && this.passportNumber.equals(other2.passportNumber) && 
				(this.flight == other2.flight) && (this.luggageList == other2.luggageList);
	}
	
	public String toString() {
		return "Name of passenger: " + this.name + "\n Passport Number: " + this.passportNumber + "\n Flight: " + (this.flight !=null ? flight.getFlightNumber() : "N/A") + "\n Luggages: " + (luggageList != null ? luggageList.size() : 0) + "\n";
	}
	

}
