package miniProject;

public class Flight {
    public int flightNumber;
    public String destination;
    public int capacity;
    private int reservedSeats;

    public Flight(int flightNumber, String destination, int capacity) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.capacity = capacity;
        this.reservedSeats = 0; // Initialize reserved seats to 0.
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public int getAvailableSeats() {
        return capacity - reservedSeats;
    }

    public boolean reserveSeats(int numSeats) {
        if (numSeats <= getAvailableSeats()) {
            reservedSeats += numSeats;
            return true;
        }
        return false;
    }

    public void cancelReservedSeats(int numSeats) {
        if (numSeats > 0 && reservedSeats >= numSeats) {
            reservedSeats -= numSeats;
        }
    }
}

		

	

