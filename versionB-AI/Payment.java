public class Payment {
    private final double amount;

    public Payment(double amount) {
        this.amount = validateAmount(amount);
    }

    public double getAmount() {
        return amount;
    }

    public void makePayment() {
        displayPaymentDetails();
    }

    public void displayPaymentDetails() {
        System.out.println("Payment of amount " + amount + " made successfully");
    }

    private static double validateAmount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Payment amount cannot be negative or zero.");
        }
        return amount;
    }
}
