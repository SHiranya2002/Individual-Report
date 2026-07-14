public class Ticket {
    private int ticketId;
    private String seatNo;
   private Event event;

    public Ticket(int ticketId, String seatNo, Event event) {
        this.ticketId = ticketId;
        this.seatNo = seatNo;
        this.event = event;
    }

    public int getTicketId() {
        return ticketId;
    }
    
    public String getSeatNo() {
        return seatNo;
    }

}
