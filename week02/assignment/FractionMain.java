package week02.assignment;
import java.util.Scanner;
/**
 * The class is to run the main workflow.
 *
 * @author DUY TRAN duy.pt.tran@bellevuecollege.edu
 */
public class FractionMain
{
	public static void main(String[] args)
	{
		System.out.println("Welcome to the Fraction program");
		System.out.println("===============================");
		Scanner console = new Scanner(System.in);
		char tryAgain = runWorkflow(console);
		while (tryAgain == 'y' || tryAgain == 'Y')
			tryAgain = runWorkflow(console);
		System.out.println("===============================");
		System.out.println("Thank you for using the program");
	}

	public static char runWorkflow(Scanner console)
	{
		// declare variables
        int n1, d1, n2, d2;

		// inputs for f1 numerator and denominator
        System.out.print("Enter the numerator for the 1st fraction: ");
        n1 = console.nextInt();

        System.out.print("Enter the denominator for the 1st fraction: ");
        d1 = console.nextInt();

		// get inputs for f2 numerator and denominator
        System.out.print("Enter the numerator for the 2nd fraction: ");
        n2 = console.nextInt();

        System.out.print("Enter the denominator for the 2nd fraction: ");
        d2 = console.nextInt();

		// create instances for two fractions
        Fraction f1 = new Fraction(n1, d1);
        Fraction f2 = new Fraction(n2, d2);

		// display the two fractions
        System.out.println("f1 == " + f1.toString());
        System.out.println("f2 == " + f2.toString());

		// display the two fractions as decimal values
        System.out.printf("%s == %.4f%n", f1, f1.getDecimalValue());
        System.out.printf("%s == %.4f%n", f2, f2.getDecimalValue());

		// multiply the two fractions and store product in f3
        Fraction f3 = f1.multiply(f2);

		// display f3 after multiplication
        System.out.println(f1 + " * " + f2 + " = " + f3.toString());

		// display f3 after division
        f3 = f1.divide(f2);
        System.out.println(f1 + " / " + f2 + " = " + f3.toString());

		// display f3 after addition
        f3 = f1.add(f2);
        System.out.println(f1 + " + " + f2 + " = " + f3.toString());

		// display f3 after subtraction
        f3 = f1.subtract(f2);
        System.out.println(f1 + " - " + f2 + " = " + f3.toString());

		
		// prompt the user if like to try again
        System.out.print("Would you like to try again? ['Y' or 'y']: ");
        char tryAgain = console.next().charAt(0);
		return tryAgain;
	}
}