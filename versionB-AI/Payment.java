public class Payment {
    private double amount;

    public Payment(double amount) {
        setAmount(amount);
    }

    public void makePayment() {
        System.out.println("Payment of amount " + amount + " made successfully");
    }

    private void setAmount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Payment amount cannot be negative or zero.");
        }
        this.amount = amount;
    }
}
