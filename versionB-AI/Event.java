public class Event {
    private final int eventId;
    private final String eventName;
    private final String eventDate;
    private final String eventLocation;
    private final int avaiableTickets;
    private final double ticketPrice;

    public Event(int eventId, String eventName, String eventDate, String eventLocation, int avaiableTickets, double ticketPrice) {
        this.eventId = validateEventId(eventId);
        this.eventName = validateEventName(eventName);
        this.eventDate = validateEventDate(eventDate);
        this.eventLocation = validateEventLocation(eventLocation);
        this.avaiableTickets = validateAvailableTickets(avaiableTickets);
        this.ticketPrice = validateTicketPrice(ticketPrice);
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

    private static int validateEventId(int eventId) {
        if (eventId <= 0) {
            throw new IllegalArgumentException("Event ID must be greater than zero.");
        }
        return eventId;
    }

    private static String validateEventName(String eventName) {
        if (eventName == null || eventName.trim().isEmpty()) {
            throw new IllegalArgumentException("Event name cannot be empty.");
        }
        return eventName.trim();
    }

    private static String validateEventDate(String eventDate) {
        if (eventDate == null || eventDate.trim().isEmpty()) {
            throw new IllegalArgumentException("Event date cannot be empty.");
        }
        return eventDate.trim();
    }

    private static String validateEventLocation(String eventLocation) {
        if (eventLocation == null || eventLocation.trim().isEmpty()) {
            throw new IllegalArgumentException("Event location cannot be empty.");
        }
        return eventLocation.trim();
    }

    private static int validateAvailableTickets(int avaiableTickets) {
        if (avaiableTickets < 0) {
            throw new IllegalArgumentException("Available tickets cannot be negative.");
        }
        return avaiableTickets;
    }

    private static double validateTicketPrice(double ticketPrice) {
        if (ticketPrice <= 0) {
            throw new IllegalArgumentException("Ticket price cannot be negative or zero.");
        }
        return ticketPrice;
    }
}
