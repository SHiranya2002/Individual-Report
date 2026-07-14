import java.util.Scanner;

public class TicketBooking {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("TICKET BOOKING MANAGEMENT SYSTEM");

        try {
            Customer customer = createCustomer(input);
            initializeCustomer(customer);

            Event event = createEvent();
            displayEvent(event);

            if (confirm(input, "\nDo you want to book a ticket for this event? (yes/no): ")) {
                processBooking(input, customer, event);
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

    private static Customer createCustomer(Scanner input) {
        int customerId = readPositiveInt(input, "Enter Customer ID: ");
        String customerName = readCustomerName(input, "Enter Customer Name: ");
        String customerEmail = readEmail(input, "Enter Email: ");
        String password = readPassword(input, "Enter Password: ");
        String phone = readPhoneNumber(input, "Enter Phone Number: ");
        return new Customer(customerId, customerName, customerEmail, password, phone);
    }

    private static Event createEvent() {
        return new Event(
                101,
                "Naadanu Concert",
                "20/08/2026",
                "Nelum Pokuna Theatre",
                100,
                3500.00);
    }

    private static void initializeCustomer(Customer customer) {
        customer.register();
        customer.login();
        System.out.println();
        customer.searchEvent();
    }

    private static void displayEvent(Event event) {
        System.out.println("\n----Event Details----");
        event.displayEventDetails();
    }

    private static boolean confirm(Scanner input, String prompt) {
        return readYesNo(input, prompt).equalsIgnoreCase("yes");
    }

    private static void processBooking(Scanner input, Customer customer, Event event) {
        String seat = readSeatNumber(input, "Enter Seat Number: ");
        int ticketAmount = readPositiveInt(input, "Enter Number of Tickets: ");

        Ticket ticket = new Ticket(1001, seat, event);
        System.out.println("\nTicket Details");
        ticket.displayTicketDetails();

        double totalAmount = event.calculateTotalCost(ticketAmount);
        Payment payment = new Payment(totalAmount);
        payment.makePayment();
        customer.bookTicket();

        if (confirm(input, "\nDo you want to cancel the ticket? (yes/no): ")) {
            customer.cancelTicket();
        }
    }

    private static int readPositiveInt(Scanner input, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (!input.hasNextLine()) {
                throw new IllegalArgumentException("Input ended unexpectedly.");
            }
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
            if (!input.hasNextLine()) {
                throw new IllegalArgumentException("Input ended unexpectedly.");
            }
            String value = input.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("This field cannot be empty.");
        }
    }

    private static String readCustomerName(Scanner input, String prompt) {
        while (true) {
            String name = readRequiredText(input, prompt);
            if (name.matches("[A-Za-z\\s]+")) {
                return name;
            }
            System.out.println("User name should contain only letters and spaces.");
        }
    }

    private static String readSeatNumber(Scanner input, String prompt) {
        while (true) {
            String seat = readRequiredText(input, prompt);
            if (seat.matches("[A-Za-z0-9-]+")) {
                return seat;
            }
            System.out.println("Seat number should be letters, numbers, or dashes only.");
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