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


}
}