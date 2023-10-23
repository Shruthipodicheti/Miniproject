package miniProject;

public class Reservation {
	private int reservationId;
    private String username;
    private int flightNumber;
    private int numSeats;

    public Reservation(int reservationId, String username, int flightNumber, int numSeats) {
        this.reservationId = reservationId;
        this.username = username;
        this.flightNumber = flightNumber;
        this.numSeats = numSeats;
    }

    public int getReservationId() {
        return reservationId;
    }
    public String getUsername() {
        return username;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public int getNumSeats() {
        return numSeats;
    }
}
