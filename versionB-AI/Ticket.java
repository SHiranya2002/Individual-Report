public class Ticket {
    private final int ticketId;
    private final String seatNo;
    private final Event event;

    public Ticket(int ticketId, String seatNo, Event event) {
        this.ticketId = validateTicketId(ticketId);
        this.seatNo = validateSeatNo(seatNo);
        this.event = event;
    }

    public int getTicketId() {
        return ticketId;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public Event getEvent() {
        return event;
    }

    public void displayTicketDetails() {
        System.out.println("Ticket ID : " + ticketId);
        System.out.println("Seat Number : " + seatNo);
    }

    private static int validateTicketId(int ticketId) {
        if (ticketId <= 0) {
            throw new IllegalArgumentException("Ticket ID must be greater than zero.");
        }
        return ticketId;
    }

    private static String validateSeatNo(String seatNo) {
        if (seatNo == null || seatNo.trim().isEmpty()) {
            throw new IllegalArgumentException("Seat number cannot be empty.");
        }
        String trimmedSeat = seatNo.trim();
        if (!trimmedSeat.matches("[A-Za-z0-9-]+")) {
            throw new IllegalArgumentException("Seat number should be letters, numbers, or dashes only.");
        }
        return trimmedSeat;
    }
}
