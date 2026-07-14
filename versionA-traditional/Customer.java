public class Customer {
    private int customerId;
    private String customerName;
    private String customerEmail;
    private String customerPhoneNo;

    public Customer(int customerId, String customerName, String customerEmail, String customerPhoneNo) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhoneNo = customerPhoneNo;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getCustomerPhoneNo() {
        return customerPhoneNo;
    }
    
}
