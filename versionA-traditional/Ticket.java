public class Ticket {
    private int ticketId;
    private String ticketNo;
    private double ticketPrice;

    public Ticket(int ticketId, String ticketNo, double ticketPrice) {
        this.ticketId = ticketId;
        this.ticketNo = ticketNo;
        this.ticketPrice = ticketPrice;
    }

    public int getTicketId() {
        return ticketId;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

}
