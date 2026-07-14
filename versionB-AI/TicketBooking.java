import java.util.Scanner;

public class TicketBooking {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("TICKET BOOKING MANAGEMENT SYSTEM");

        try {
            int customerId = readPositiveInt(input, "Enter Customer ID: ");
            String customerName = readRequiredText(input, "Enter Customer Name: ");
            String customerEmail = readEmail(input, "Enter Email: ");
            String password = readPassword(input, "Enter Password: ");
            String phone = readPhoneNumber(input, "Enter Phone Number: ");

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

            String answer = readYesNo(input, "\nDo you want to book a ticket for this event? (yes/no): ");

            if (answer.equalsIgnoreCase("yes")) {
                String seat = readRequiredText(input, "Enter Seat Number: ");
                int ticketAmount = readPositiveInt(input, "Enter Number of Tickets: ");

                Ticket ticket = new Ticket(1001, seat, event);
                System.out.println("\nTicket Details");
                System.out.println("Ticket ID : " + ticket.getTicketId());
                System.out.println("Seat Number : " + ticket.getSeatNo());

                double totalAmount = event.getTicketPrice() * ticketAmount;
                Payment payment = new Payment(totalAmount);
                payment.makePayment();
                customer.bookTicket();

                String cancel = readYesNo(input, "\nDo you want to cancel the ticket? (yes/no): ");
                if (cancel.equalsIgnoreCase("yes")) {
                    customer.cancelTicket();
                }
            } else {
                System.out.println("Booking Cancelled.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
        } finally {
            input.close();
        }

        System.out.println("Thank you for booking with us.");
    }

    private static int readPositiveInt(Scanner input, String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = input.nextLine().trim();
            try {
                int number = Integer.parseInt(value);
                if (number > 0) {
                    return number;
                }
                System.out.println("Please enter a value greater than zero.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }

    private static String readRequiredText(Scanner input, String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = input.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("This field cannot be empty.");
        }
    }

    private static String readEmail(Scanner input, String prompt) {
        while (true) {
            String email = readRequiredText(input, prompt);
            if (email.contains("@") && email.contains(".")) {
                return email;
            }
            System.out.println("Please enter a valid email address.");
        }
    }

    private static String readPassword(Scanner input, String prompt) {
        while (true) {
            String password = readRequiredText(input, prompt);
            if (password.length() >= 6) {
                return password;
            }
            System.out.println("Password must be at least 6 characters long.");
        }
    }

    private static String readPhoneNumber(Scanner input, String prompt) {
        while (true) {
            String phone = readRequiredText(input, prompt);
            if (phone.matches("\\d{1,10}")) {
                return phone;
            }
            System.out.println("Phone number must contain only digits and not exceed 10 digits.");
        }
    }

    private static String readYesNo(Scanner input, String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = input.nextLine().trim();
            if (value.equalsIgnoreCase("yes") || value.equalsIgnoreCase("no")) {
                return value;
            }
            System.out.println("Please enter either 'yes' or 'no'.");
        }
    }
}