package miniProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirlineReservationApp {

	private List<Flight> flights;
    private List<User> users;
    private List<Reservation> reservations;
    private int reservationIdCounter;
    
    
    public AirlineReservationApp() {
        flights = new ArrayList<>();
        users = new ArrayList<>();
        reservations = new ArrayList<>();
        reservationIdCounter = 1;
    }
    
   

    public void addFlight(int flightNumber, String destination, int capacity) {
        Flight flight = new Flight(flightNumber, destination, capacity);
        flights.add(flight);
    }

    public void displayFlights() {
        System.out.println("Available Flights:");
        for (Flight flight : flights) {
            System.out.println("Flight Number: " + flight.getFlightNumber());
            System.out.println("Destination: " + flight.getDestination());
            System.out.println("Available Seats: " + flight.getAvailableSeats());
            System.out.println("------------------------------");
            
            
        }
        
    }
    
    
    public void UserRegistration() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        User newUser = new User(username, password);
        users.add(newUser);

        System.out.println("Registration successful!");
    }

    public void login() 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        User user = findUser(username);

        if (user != null && user.authenticate(password)) 
        {
            System.out.println("Login successful.");
        } 
        else
        {
            System.out.println("Login failed.Invalid username or password.");
        }
    }

    public User findUser(String username) 
    {
        for (User user : users) 
        {
            if (user.getUsername().equals(username))
            {
                return user;
            }
        }
        return null;
    }

    public void makeReservation() {
    
    	    Scanner sc = new Scanner(System.in);
    	    System.out.print("Enter your username: ");
    	    String username = sc.nextLine();

    	    User user = findUser(username);

    	    if (user == null) {
    	        System.out.println("User not found. Please register first to make reservations.");
    	        return;
    	    }

    	    System.out.print("Enter the flight number: ");
    	    int flightNumber = sc.nextInt();

    	    System.out.print("Enter the number of seats to reserve: ");
    	    int numSeats = sc.nextInt();

    	    boolean success = reserveSeat(flightNumber, numSeats);

    	    if (success) {
    	        Reservation reservation = new Reservation(reservationIdCounter++, username, flightNumber, numSeats);
    	        reservations.add(reservation);
    	        System.out.println("Reservation successful!");
    	        System.out.println("You have reserved " + numSeats + " seat(s) on flight " + flightNumber + ".");
    	        System.out.println("Your reservation ID is: " + reservation.getReservationId());
    	    } else {
    	        System.out.println("Reservation failed. Not enough seats available.");
    	    }
    	

    }
    public boolean reserveSeat(int flightNumber, int numSeats) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber() == flightNumber) {
            	return flight.reserveSeats(numSeats);
            }
        }
        return false;
    }



    public void cancelReservation() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your reservation ID: ");
        int reservationId = sc.nextInt();

        Reservation reservation = findReservation(reservationId);

        if (reservation == null) {
            System.out.println("No Reservation is found on the provided Username.");
            return;
        }

        reservations.remove(reservation);
        System.out.println("Reservation canceled successfully.");
    }

    public Reservation findReservation(int reservationId) {
        for (Reservation reservation : reservations) {
            if (reservation.getReservationId() == reservationId) {
                return reservation;
            }
        }
        return null;
    }
}
   
