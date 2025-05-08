package airport;

import java.time.LocalDateTime;
import java.util.List;

public class Flight {
	
	private String flightNumber;
	private String destination;
	private String gate;
	private LocalDateTime departureTime;
	private static int passengerNumber = 0; 
	
//	public Flight(String flightNumber, String destination, String gate, LocalDateTime departureTime, List<Passengers> passengerList ) {
//		this.flightNumber = flightNumber;
//		this.destination = destination;
//		this.gate = gate;
//		this.departureTime = departureTime;
//		this.passengerNumber = passengerNumber;
//	}
	
	public Flight(String flightNumber, String destination, String gate, LocalDateTime departureTime) {
		this.flightNumber = flightNumber;
		this.destination = destination;
		this.gate = gate;
		this.departureTime = departureTime;
		passengerNumber++;
		
	}
	
	public Flight() {
		this.flightNumber = "No flight number yet";
		this.destination = "No destination yet";
		this.gate = "No gate yet";
		this.departureTime = null;
	}
	
	public Flight(Flight other) {
		this.flightNumber = other.flightNumber;
		this.destination = other.destination;
		this.gate = other.gate;
		this.departureTime = other.departureTime;
		passengerNumber++;
	}
	
	public String getFlightNumber() {
		return this.flightNumber;
	}
	
	public String getDestination() {
		return this.destination;
	}
	
	public String getGate() {
		return this.gate;
	}
	
	public LocalDateTime getDepartureTime() {
		return this.departureTime;
	}
	
	public int getPassengerNumber() {
		return this.passengerNumber;
	}
	
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public void setGate(String gate) {
		this.gate = gate;
	}
	
	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}
	
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
		
		if (getClass() != other.getClass()) {
			return false;
		}
		
		Flight other2 = (Flight) other;
		return this.flightNumber.equals(other2.flightNumber) && this.destination.equals(other2.destination) && 
				this.gate.equals(other2.gate) && (this.departureTime == other2.departureTime) && 
				(this.passengerNumber == other2.passengerNumber);
	}
	
	public String toString() {
		return "Flight Number: " + this.flightNumber + "\n Destination: " + this.destination + "\n Gate: " + this.gate + "\n Departure Time: " + this.departureTime + "\n Passenger Number: " + this.passengerNumber + "\n";
	}

}
