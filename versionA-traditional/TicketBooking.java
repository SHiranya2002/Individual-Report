import java.util.Scanner;

public class TicketBooking {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        
        System.out.println("TICKET BOOKING MANAGEMENT SYSTEM");
        
        
        System.out.print("Enter Customer ID: ");
        int customerId = input.nextInt();
        input.nextLine();

        System.out.print("Enter Customer Name: ");
        String customerName = input.nextLine();

        System.out.print("Enter Email: ");
        String customerEmail = input.nextLine();

        System.out.print("Enter Password: ");
        String password = input.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = input.nextLine();

        Customer customer = new Customer(customerId, customerName, customerEmail, password, phone);

        customer.register();
        customer.login();

        System.out.println();

      
        customer.searchEvent();


        Event event = new Event(

                101,
                "Naadanu Concert",
                "20/08/2026",
                "Nelum Pokuna Theatre",
                100,
                3500.00);

        System.out.println("\n----Event Details----");
        System.out.println("Event ID : " + event.getEventId());
        System.out.println("Event Name : " + event.getEventName());
        System.out.println("Date : " + event.getEventDate());
        System.out.println("Location : " + event.getEventLocation());
        System.out.println("Available Tickets : " + event.getAvaiableTickets());
        System.out.println("Ticket Price : Rs." + event.getTicketPrice());


        System.out.print("\nDo you want to book a ticket for this event? (yes/no): ");
        String answer = input.nextLine();



        if(answer.equalsIgnoreCase("yes")){
            
            System.out.print("Enter Seat Number: ");
            String seat = input.nextLine();

            Ticket ticket = new Ticket(1001, seat, event);
            System.out.println("\nTicket Details");
            System.out.println("Ticket ID : " + ticket.getTicketId());
            System.out.println("Seat Number : " + ticket.getSeatNo());
            Payment payment = new Payment(event.getTicketPrice());
            payment.makePayment();
            customer.bookTicket();



            System.out.print("\nDo you want to cancel the ticket? (yes/no): ");
            String cancel = input.nextLine();



            if(cancel.equalsIgnoreCase("yes")){
                customer.cancelTicket();
            }
            
        }
        else{
            System.out.println("Booking Cancelled.");
            
        }
       System.out.println("Thank you for booking with us.");

}
}