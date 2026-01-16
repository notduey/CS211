package week01.lab.payment;

public class MainPayment {
    public static void main(String[] args) {
        // array "methods" with 3 payment methods -> polymorphism
        PaymentMethod[] methods = {
            new CreditCardPayment("1234123412341234", "John Doe"),
            new DebitCardPayment("5678567856785678", "XYZ Bank"),
            new PayPalPayment("john@example.com")
        };

        double[] amounts = {50.0, 100.0, 200.0}; // array of amounts corresponding to each payment method

        for (int i = 0; i < methods.length; i++) {
            boolean success = methods[i].processPayment(amounts[i]);
            // if i = 0, CreditCardPayment is processed, with amount[0], which is 50
            if (success) { // handles failure
                methods[i].printReceipt();
            }
            else {
                System.out.println("Payment failed.");
            }

            System.out.println();
        }
    }
}
