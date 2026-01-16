package week01.lab.payment;

public class CreditCardPayment implements PaymentMethod {
    private String cardNumber;
    private String cardHolderName;

    public CreditCardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    public boolean processPayment(double amount) {
        System.out.println("Processing credit card payment...");
        return true;
    }

    public void printReceipt() {
        System.out.println("Receipt: **** **** **** " + 
            cardNumber.substring(cardNumber.length() - 4)); 
            // substring(start) means give me the characters of the string from index "start" to the end
            // (cardNumber.length() - 4) means the index before the last 4 characters
            System.out.println("Name: " + cardHolderName);
    }
}
