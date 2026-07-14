public class Ticket {
    private int ticketId;
    private String seatNo;
    private double ticketPrice;
    private boolean isAvailable;

    public Ticket(int ticketId, String seatNo, double ticketPrice, boolean isAvailable) {
        this.ticketId = ticketId;
        this.seatNo = seatNo;
        this.ticketPrice = ticketPrice;
        this.isAvailable = isAvailable;
    }

    public int getTicketId() {
        return ticketId;
    }
    
    public String getSeatNo() {
        return seatNo;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void reserve() {
        isAvailable = false;
    }

    public void cancelReservation() {
        isAvailable = true;
    }

}
