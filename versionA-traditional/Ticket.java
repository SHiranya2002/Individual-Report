public class Ticket {
    private int ticketId;
    private String seatNo;
   

    public Ticket(int ticketId, String seatNo) {
        this.ticketId = ticketId;
        this.seatNo = seatNo;
    }

    public int getTicketId() {
        return ticketId;
    }
    
    public String getSeatNo() {
        return seatNo;
    }

}
