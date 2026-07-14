public class Event {
    private int eventId;
    private String eventName;
    private String eventDate;
    private String eventLocation;
    private int avaiableTickets;
    private double ticketPrice;

    public Event(int eventId, String eventName, String eventDate, String eventLocation, int avaiableTickets, double ticketPrice) {
        setEventId(eventId);
        setEventName(eventName);
        setEventDate(eventDate);
        setEventLocation(eventLocation);
        setAvaiableTickets(avaiableTickets);
        setTicketPrice(ticketPrice);
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

    public void displayEventDetails() {
        System.out.println("Event ID : " + eventId);
        System.out.println("Event Name : " + eventName);
        System.out.println("Date : " + eventDate);
        System.out.println("Location : " + eventLocation);
        System.out.println("Available Tickets : " + avaiableTickets);
        System.out.println("Ticket Price : Rs." + ticketPrice);
    }

    public double calculateTotalCost(int quantity) {
        return ticketPrice * quantity;
    }

    private void setEventId(int eventId) {
        if (eventId <= 0) {
            throw new IllegalArgumentException("Event ID must be greater than zero.");
        }
        this.eventId = eventId;
    }

    private void setEventName(String eventName) {
        if (eventName == null || eventName.trim().isEmpty()) {
            throw new IllegalArgumentException("Event name cannot be empty.");
        }
        this.eventName = eventName.trim();
    }

    private void setEventDate(String eventDate) {
        if (eventDate == null || eventDate.trim().isEmpty()) {
            throw new IllegalArgumentException("Event date cannot be empty.");
        }
        this.eventDate = eventDate.trim();
    }

    private void setEventLocation(String eventLocation) {
        if (eventLocation == null || eventLocation.trim().isEmpty()) {
            throw new IllegalArgumentException("Event location cannot be empty.");
        }
        this.eventLocation = eventLocation.trim();
    }

    private void setAvaiableTickets(int avaiableTickets) {
        if (avaiableTickets < 0) {
            throw new IllegalArgumentException("Available tickets cannot be negative.");
        }
        this.avaiableTickets = avaiableTickets;
    }

    private void setTicketPrice(double ticketPrice) {
        if (ticketPrice <= 0) {
            throw new IllegalArgumentException("Ticket price cannot be negative or zero.");
        }
        this.ticketPrice = ticketPrice;
    }
}
