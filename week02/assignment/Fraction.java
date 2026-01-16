package week02.assignment;
/**
 * The class is to define the fraction object that include properties
 * - Numerator
 * - Denominator
 * The class provided some methods such as:
 * - Addition
 * - Subtraction
 * - Multiplication
 * - Division
 *
 * @author DUY TRAN duy.pt.tran@bellevuecollege.edu
 * @version 
 */
public class Fraction
{
	/**
	 * The value of numerator of the fraction.
	 */
	private int numerator;
	
	/**
	 * The value of denominator of the fraction.
	 */
	private int denominator;

	/**
	 * The constructor accepts numerator and denominator
	 * @param numerator the numerator of fraction
	 * @param denominator the denominator of fraction
	 */
	public Fraction(int numerator, int denominator)
	{
		// the value to the numerator field
        this.numerator = numerator;

		// use setDenominator() setter to protect against divide by zero
        setDenominator(denominator);

		// make sure that we reduce the fraction at this point and adjust the sign
        reduce();
        adjustSign();
	}

	/**
	 * The setter method for numerator
	 * @param numerator the denominator
	 */
	public void setNumerator(int numerator)
	{
        this.numerator = numerator;
	}

	/**
	 * The setter method for denominator
	 * @param denominator the denominator
	 */
	public void setDenominator(int denominator)
	{
		// throw the exception if the denominator is zero
        if (denominator == 0) {
            throw new ArithmeticException("Denominator cannot be zero");
        }
		
		// set the value to the denominator
        this.denominator = denominator;
		adjustSign();
	}

	/**
	 * The method returns the numerator.
	 * @return the numerator
	 */
	public int getNumerator()
	{
		return numerator;
	}

	/**
	 * The method returns the denominator.
	 * @return the denominator
	 */
	public int getDenominator()
	{
		return denominator;
	}

	/**
	 * The method returns the decimal value.
	 * @return the decimal value of the fraction
	 */
	public double getDecimalValue()
	{
		return (double) numerator / denominator;
	}

	/**
	 * The method returns the sum of fractions
	 * @param other the other fraction
	 * @return the sum of fractions
	 */
	public Fraction add(Fraction other)
	{
        int newNumerator;
        int newDenominator;

		// if this fraction and the other fraction have the same denominator
		// otherwise make them same denominator before doing the addition
        if (this.denominator == other.denominator) {
            newNumerator = this.numerator + other.numerator;
            newDenominator = this.denominator;
        }
        else {
            newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
            newDenominator = this.denominator * other.denominator;
        }

		// create new fraction instance by calling (output fraction)
		// the constructor to instantiate the new fraction
		// return the output fraction
		return new Fraction(newNumerator, newDenominator);
	}

	/**
	 * The method returns the difference between fractions
	 * @param other the other fraction
	 * @return the difference between fractions
	 */
	public Fraction subtract(Fraction other)
	{
        int newNumerator;
        int newDenominator;

		// if this fraction and the other fraction have the same denominator
		// otherwise make them same denominator before doing the addition
        if (this.denominator == other.denominator) {
            newNumerator = this.numerator - other.numerator;
            newDenominator = this.denominator;
        }
        else {
            newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
            newDenominator = this.denominator * other.denominator;
        }

		// create new fraction instance by calling (output fraction)
		// the constructor to instantiate the new fraction
		// return the output fraction
        return new Fraction(newNumerator, newDenominator);
	}

	/**
	 * The method returns the product of two fractions
	 * @param other the other fraction
	 * @return the product of two fractions
	 */
	public Fraction multiply(Fraction other)
	{
		// declare local variables for the new numerator and denominator
        int newNumerator;
        int newDenominator;

		// get the new numerator by multiplying the two numerators
        newNumerator = this.numerator * other.numerator;

		// get the new numerator by multiplying the two denominators
        newDenominator = this.denominator * other.denominator;

		// create new fraction instance by calling (output fraction)
		// the constructor to instantiate the new fraction
		// return the output fraction
		return new Fraction(newNumerator, newDenominator);
	}

	public Fraction divide(Fraction other)
	{
		// throw ArithmeticException if the numerator of the divided fraction is zero
        if (other.numerator == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
		
		// declare local variables for the new numerator and denominator
        int newNumerator;
        int newDenominator;

		// get the new numerator by multiplying
		// this fraction's numerator and the other fraction's denominator
        newNumerator = this.numerator * other.denominator;

		// get the new denominator by multiplying
		// this fraction's denominator and the other fraction's numerator
        newDenominator = this.denominator * other.numerator;

		// create new fraction instance by calling (output fraction)
		// the constructor to instantiate the new fraction
		// return the output fraction
		return new Fraction(newNumerator, newDenominator);
	}

	/**
	 * The method returns the greatest common factor (GCF) of two integers
	 * @param a the first integer
	 * @param b the second integer
	 * @return the greatest common factor of a and b
	 */
	protected int getGCF(int a, int b)
	{
		// declare local variable for remainder
        int remainder;

		// use while loop to determine greatest common factor of a and b
        while (b != 0) {
            remainder = a % b;
            a = b;
            b = remainder;
        }

		// return the values stored in a
		return a;
	}

	/**
	 * The method simplify the current fraction.
	 */
	protected void reduce()
	{
		// declare a variable to hold the value of common greatest factor
        int gcf = getGCF(numerator, denominator);
		
		// reduce the fraction by dividing numerator and
		// denominator by the value of common greatest factor
        numerator /= gcf;
        denominator /= gcf;

	}

	/**
	 * The method makes sure the negative sign always goes with
	 * the numerator instead of the denominator.
	 */
	protected void adjustSign()
	{
        if (denominator < 0 ) {
            numerator = -numerator;
            denominator = -denominator;
        }
	}

	/**
	 * The method returns a string representing a fraction.
	 */
	public String toString()
	{
		// the fraction must have the string format without spaces 1/2 for example
		// if the denominator is one, the string format should be in integer type.
		// For example, if the fraction is 2/1, the string format should be 2 instead of 2/1
        if (denominator == 1) {
            return Integer.toString(numerator);
        }
        return Integer.toString(numerator) + "/" + Integer.toString(denominator);

	}
}
