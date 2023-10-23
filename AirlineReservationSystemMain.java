package miniProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirlineReservationSystemMain 
{
    
	public static void main(String[] args) 
	{
		    System.out.println("======================================================================");
		    System.out.println("================= Airline Reservation System =========================");
		    System.out.println("======================================================================");
		    Scanner sc = new Scanner(System.in);
		    String ch;
		    
		    AirlineReservationApp reservationSystem = new AirlineReservationApp();

		    reservationSystem.addFlight(101, "Delhi,India", 110);
	        reservationSystem.addFlight(102, "New York,USA", 100);
	        reservationSystem.addFlight(103, "Los Angeles,USA", 130);
	        reservationSystem.addFlight(104, "Sydney,Australia", 120);
	        reservationSystem.addFlight(105, "Paris,France",105 );
	        
	   
	        
	        AirlineReservationApp obj=new AirlineReservationApp();
	        do 
	        {
	            System.out.println("Welcome to the Airline Reservation System.");
	            System.out.println("\t1. New Registration");
	            System.out.println("\t2. Login");
	            System.out.println("\t3. Available Flights");      //n
	            System.out.println("\t4. Reservation");
	            System.out.println("\t5. Cancellation");
	            System.out.println("\t6. Exit");
	            System.out.println("======================================================================");
	            System.out.print("Enter your choice: ");
	            int choice = sc.nextInt();
	            sc.nextLine();

	            switch (choice)
	            {
	                case 1:
	                	reservationSystem.UserRegistration();
	                    break;
	                case 2:
	                	reservationSystem.login();
	                    break;
	                case 3:
	                	reservationSystem.displayFlights();
	                	break;
	                case 4:
	                	reservationSystem.makeReservation();
	                    break;
	                case 5:
	                	reservationSystem.cancelReservation();
	                    break;
	                case 6:
	                	System.out.println("Thank you");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please select a valid choice.");
	            }
	            System.out.println("Do you want to continue? (Y-Yes / N-No)");
	            ch=sc.next();
	        }
	        while(ch.equals("Y")||ch.equals("y"));
	        System.out.println("====================================================================");

	     	System.out.println("Thank you for using the Airline Reservation System.");
	    		
	    	System.out.println("====================================================================");
		}

}
