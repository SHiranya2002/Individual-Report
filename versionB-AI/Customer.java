public class Customer extends User {
    private String customerPhoneNo;

    public Customer(int customerId, String customerName, String customerEmail,String userPassword, String customerPhoneNo) {
        super(customerId, customerName, customerEmail, userPassword);
        this.customerPhoneNo = customerPhoneNo;
    }


    public String getCustomerPhoneNo() {
        return customerPhoneNo;
    }

    public void searchEvent(){
        System.out.println("Searching for an event");
    }

    public void bookTicket(){
        System.out.println("Ticket booked successfully");
    }

    public void cancelTicket(){
        System.out.println("Ticket cancelled successfully");
    }
    
}
