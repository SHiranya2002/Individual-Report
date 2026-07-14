public class Event {
    private int eventId;
    private String eventName;
    private String eventDate;
    private String eventLocation;
    private int avaiableTickets;
    private double ticketPrice;

    public Event(int eventId, String eventName, String eventDate, String eventLocation, int avaiableTickets, double ticketPrice) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventLocation = eventLocation;
        this.avaiableTickets = avaiableTickets;
        this.ticketPrice = ticketPrice;
    }

    public int getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public int getAvaiableTickets() {
        return avaiableTickets;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
}
