public class Payment {
    private double amount;
    
    public Payment(double amount) {
        this.amount = amount;
    }

    public void makePayment() {
        System.out.println("Payment of amount " + amount + " made successfully");
    }
}
