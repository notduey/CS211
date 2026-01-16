package week01.lab.payment;

public class PayPalPayment implements PaymentMethod {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    public boolean processPayment(double amount) {
        System.out.println("Processing PayPal payment for " + email + "...");
        return true;
    }

    public void printReceipt() {
        System.out.println("Receipt for Paypal user: " + email);
    }
}
