public class Customer extends User {
    private String customerPhoneNo;

    public Customer(int customerId, String customerName, String customerEmail, String userPassword, String customerPhoneNo) {
        super(customerId, customerName, customerEmail, userPassword);
        setCustomerPhoneNo(customerPhoneNo);
    }

    public String getCustomerPhoneNo() {
        return customerPhoneNo;
    }

    private void setCustomerPhoneNo(String customerPhoneNo) {
        if (customerPhoneNo == null || customerPhoneNo.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be empty.");
        }
        String phone = customerPhoneNo.trim();
        if (!phone.matches("\\d{1,10}")) {
            throw new IllegalArgumentException("Phone number must contain only digits and not exceed 10 digits.");
        }
        this.customerPhoneNo = phone;
    }

    public void searchEvent() {
        System.out.println("Searching for an event");
    }

    public void bookTicket() {
        System.out.println("Ticket booked successfully");
    }

    public void cancelTicket() {
        System.out.println("Ticket cancelled successfully");
    }
}
