package airport;

//import java.io.BufferedReader;
//import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirportSystemManager {
	
	
	private static List<Flight> flight = new ArrayList<>();

	public static void main(String[] args) {
		
		//array lists of passengers and flights
		List<Passengers> passengers = new ArrayList<>();
		
		
		Scanner m = new Scanner(System.in);
		
		System.out.println("***************************** AIRPORT SYSTEM MANAGER *****************************");
		System.out.println();
		
		
		int option = 0;
		do {
			
			System.out.print("Menu: \n\t1. View Passenger Info\n\t2. Add a Passenger"
				+ "\n\t3. Add luggage to passenger\n\t4. Save and exit \nSelect your option: ");
			option = m.nextInt();
			
		
		switch(option) {
		
		case 1:
			
			System.out.print("Enter passenger's passport number: ");
			String passportnumber = m.next();
			System.out.println();
			
			boolean found = false;
			
			for (Passengers p : passengers) {
				if (p.getPassportNumber().equals(passportnumber)) {
					System.out.println(p.getName());
					System.out.println(p.getFlight());
					System.out.println(p.getLuggageList());
					
					found = true;
					break;
				}
				if (!found)
					System.out.println("There is no passenger by that passport number. ");
			}
			
			break;
			
		case 2:
			
			
			System.out.println("Enter the passport number for the passenger you wish to add: ");
			String passportNumber = m.next();
			
			boolean flag = false;
			for (Passengers p : passengers) {
				if (p.getPassportNumber().equals(passportNumber)) {
					System.out.println("This passenger already exists in out system.");
					flag = true;
					break;
				}
					
			}
			if (flag == false){
				List<Luggage> personalLuggageList = new ArrayList<>();
				System.out.println("Enter the passenger's name: ");
					String newName = m.next();
					
					System.out.println("Enter the information about the flight: \n");
					System.out.println("Flight Number:\n");
					String flightNumber = m.next();
					System.out.println("Destination:\n");
					String destination = m.next();
					System.out.println("gate:\n");
					String gate = m.next();
					System.out.println("Departure time (YYYY-MM-DDTHH:MM):\n");
					
					CharSequence departureTimeStr = m.next();
					LocalDateTime departureTime1 = LocalDateTime.parse(departureTimeStr); 
					
					
					Flight newFlight = new Flight(flightNumber, destination, gate, departureTime1);
					Passengers newPassenger = new Passengers(newName, passportNumber, newFlight);
					
					
					System.out.println("Does the passenger have any luggage? Yes/No: ");
					String answer = m.next();
					
					while (answer.equalsIgnoreCase("Yes") ) {
						System.out.println("Enter the information about the luggage.");
						System.out.print("Luggage ID: ");
						String newLuggageID = m.next();
						System.out.print("Weight: ");
						double newWeight = m.nextDouble();
						System.out.print("Is the luggage checked in? true/false: ");
						boolean newIsCheckedIn = m.nextBoolean();
						
						Luggage newPersonalLuggage = new Luggage(newLuggageID, newWeight, newIsCheckedIn, newPassenger);
						personalLuggageList.add(newPersonalLuggage);
						
						System.out.print("Do you want to add another luggage? Yes/No: ");
						answer = m.next();
						
					}
				
					newPassenger.setLuggageList(personalLuggageList);
					passengers.add(newPassenger);
					
					System.out.println("Passenger added!!");
					
					
			}
			
			break;
				
		case 3:
			
			System.out.print("Enter the passenger's passport number: ");	
			String passportNumber1 = m.next();
			
			for (Passengers p : passengers) {
				if (p.getPassportNumber().equals(passportNumber1)) {
					
					System.out.println("Enter the information about the luggage.");
					System.out.print("Luggage ID: ");
					String newLuggageID = m.next();
					System.out.print("Weight: ");
					double newWeight = m.nextDouble();
					System.out.print("Is the luggage checked in? true/false: ");
					boolean newIsCheckedIn = m.nextBoolean();
					
					Luggage newLuggage = new Luggage(newLuggageID, newWeight, newIsCheckedIn, p);
					p.addLuggage(newLuggage);
					
					System.out.print("Do you wish to add another luggage? Yes/No: ");
					String answer = m.next();
					
					while (answer.equals("Yes") ) {
						System.out.println("Enter the information about the luggage.");
						System.out.print("Luggage ID: ");
						String newLuggageID1 = m.next();
						System.out.print("Weight: ");
						double newWeight1 = m.nextDouble();
						System.out.print("Is the luggage checked in? true/false: ");
						boolean newIsCheckedIn1 = m.nextBoolean();
						
						Luggage newLuggage1 = new Luggage(newLuggageID1, newWeight1, newIsCheckedIn1, p);
						p.addLuggage(newLuggage1);
						
						System.out.print("Do you want to add another luggage? Yes/No: ");
						answer = m.next();
						
					}
					
					
				}
				else {
					System.out.println("The passenger with this passport number isn't checked in. Check in passenger first.");
				}
			}
				
			break;
		}
		} while (option <= 3);
		
		if (option == 4) {
			System.out.println("Thank tou for usine the airport management system. See you next time! ");
			System.exit(0);
		}
		
		else {
			System.out.println("Please choose a valid option. ");
			System.out.print("Menu: \n\t1. View Passenger Info\n\t2. Add a Passenger"
					+ "\n\t3. Add luggage to passenger\n\t4. Save and exit \nSelect your option: ");
				option = m.nextInt();
		}
		
		
	}
	
	private static Flight findFlightNumber(String flightNumber1) {
		for (Flight f : flight) {
			if (f.getFlightNumber().equals(flightNumber1)) {
				return f;
			}
		}
		return null;
	}
	

}
