package week04.assignment;

/**
 * FILL UP YOUR JAVA DOCUMENT HERE
 * @author FIRST_NAME LAST_NAME <YOUR_EMAIL>
 */
class MathematicsRec
{
    /**
     * The method returns a value which:
     * - Increases each of even decimal digits of n by one
     * - Decreases each of  odd decimal digits of n by one
     * @param theDecimalNumber the input decimal number (n)
     * @return the new decimal number after digit adjustments
     */
	public static long eduodd(long n)
	{
        // edge case, deal with negative sign first
        if (n < 0) {
            long positive = eduodd(-n);
            if (positive == 0) {
                return 0;
            }
            return -positive;
        }

        // base case
        if (n < 10) { // if n is single digit
            int d = (int) n;
            int nd;
            if (d % 2 == 0) { // if digit is even
                nd = d + 1;
            }
            else { // if digit is odd
                nd = d - 1;
            }
            if (nd < 0) { // if original input e.g. -11 is passed, return 0 and not -0
                return 0;
            }
            return nd;
        }

        // recursive case
        long remainingDigits = eduodd(n / 10); // get remaining digits
        int d = (int) (n % 10); // get last digit

        int nd;
        if (d % 2 == 0) { // if digit is even
            nd = d + 1;
        }
        else { // if digit is odd
            nd = d - 1;
        }

        return remainingDigits * 10 + nd; // * 10 to move remainingDigits to the right and append nd
	}

    /**
     * The method accepts non-negative integer and returns a value as described below
     * @param theDecimalNumber is a non-negative decimal number (n)
     * @return the value in following way:
     * - return 1 when n = 0
     * - return sum of fibby(floor(n/4)) and fibby(floor(3n/4)) when n > 0
     */
	public static int fibby(int n)
	{
        // base case
        if (n == 0) { 
            return 1;
        }

        // recursive case
        // fibby(n) = fibby(n/4) + fibby(3n/4) where n > 0
        return fibby(n / 4) + fibby(3 * n / 4);
	}
	
    /**
     * The method prints all consecutive values of n and its fibby value
     * @param theLowerBound the lower bound (start)
     * @param theUpperBound the upper bound (end)
     */
	public static void stg(int start, int end)
	{
        // helper method is needed to keep track of previously printed fibby
        stgHelper(start, end, -1); // -1  placeholder
	}

    public static void stgHelper(int n, int m, int prevFib) {
        // base case
        if (n > m) {
            return;
        }

        int f = fibby(n);

        if (f != prevFib) {
            System.out.println(n + " " + f);
            // increase n by 1 to move upward
            stgHelper(n + 1, m, f); // update and print f as new prev only if f != prev
        }
        else {
            // increase n by 1 to move upward
            stgHelper(n + 1, m, prevFib); // keep prev the same if f == prev
        }
    }

    /**
     * The method returns the median that split the array into 3 parts
     * @param theList the list of integers (a)
     * @return the median
     */
	public static double median3(int[] a)
	{
        // helper method 
		return median3Range(a, 0, a.length);
	}

    public static double median3Range(int[] n, int start, int length) {
        // base case,if the array has one element, that element itself is the median
        if (length == 1) {
            return n[start];
        }
        // base case, if the array has two elements, return the average
        if (length == 2) {
            return (n[start] + n[start + 1]) / 2.0;
        }

        // if the array has three or more elements
        int piece = length / 3; // length of each piece / 3
        int remainder = length % 3; // remainder of length

        // declare pieces
        int first;
        int middle;
        int last;

        if (remainder == 0) { // remainder of 0
            first = piece;
            middle = piece;
            last = piece;
        }
        else if (remainder == 1) { // remainder of 1
            first = piece;
            middle = piece + 1;
            last = piece;
        }
        else { // remainder of 2
            first = piece;
            middle = piece + 2;
            last = piece;
        }

        // recursively compute median of each piece
        double median1 = median3Range(n, start, first); // starts at start, length = first
        double median2 = median3Range(n, start + first, middle); // starts at start + first, length = middle
        double median3 = median3Range(n, start + first + middle, last); // starts at start + first + middle, length = last

        // return median of the 3 medians
        return medianOf3(median1, median2, median3);
    }
    /*
    The method recursively splits the array into 3 pieces 
    and returns the median of the 3 medians.

    It essentially continues to split the array into 3 pieces 
    until there is only one element, which itself is the median,
    or there are two elements, which the median is the average of the two.
     */

    public static double medianOf3(double x, double y, double z) {
        if (x <= y) {
            if (y <= z) {
                return y;
            }
            else if (x <= z) {
                return z;
            }
            else {
                return x;
            }
        }
        else {
            if (x <= z) {
                return x;
            }
            else if (y <= z) {
                return z;
            }
            else {
                return y;
            }
        }
    }
}