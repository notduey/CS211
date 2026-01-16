package week02.assignment;
public class ExtraCredit
{
	public static void main(String[] args)
	{
        int nTerms = 9;
        for (int i = 0; i <= nTerms; i++) {
            System.out.printf("expoential(%d) = %.6f%n", i, exponential(i));
        }
	}

	public static int factorial(int n)
	{
        // 0! and 1! are = 1
        int result = 1;

        // loop from 2 to n because 0! & 1! are redundant/already calculated
        for (int i = 2; i <= n; i++) {
            result *= i;
        }

		return result;
	}

	public static double exponential(int n)
	{
        double result = 0.0;

        // loop from 0 to n
        // 1/0! + 1/1! + 1/2! + ... + 1/n!
        for (int i = 0; i <= n; i++) {
            Fraction term = new Fraction(1, factorial(i)); // 1 / i!
            result += term.getDecimalValue(); // result = result + term
            // java doesn't allow result += term because it can't add Fraction objects
        }

        // return decimal value instead of fraction
		return result;
	}
}