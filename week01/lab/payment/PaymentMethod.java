package week01.lab.payment;

public interface PaymentMethod {
    boolean processPayment(double amount);
    void printReceipt();
}
