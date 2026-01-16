package week02.lab;
/*
*Use helper method if:
-recursion is easiest when it can assume a simpler input
-public method handles the setup, validation, and edge cases
-helper focuses only on the recursive logic itself
=============================================================
* for this program's case, evenDigits():
-accepts negative number
-decides when to return 0
-applies negative sign at end of method if necessary

* evenDigitsHelper() assumes:
-parameter (n) is positive
-it's only focused on working with digits
*/
public class RecursiveDigits {
    public static void main(String[] args) {
        System.out.println(evenDigits(-123456789));
    }

    public static int evenDigits(int n) {
        boolean isNegative = n < 0;
        n = Math.abs(n);

        int result = evenDigitsHelper(n); // call evenDigitHelper (recursive method)

        // if statement makes sure -0 is not returned as -0 but as 0
        // e.g. evenDigits(-7), isNegative = true, evenDigitsHelper(7) returns 0
        // return isNegative ? -result : result would return -0
        if (result == 0) {
            return 0;
        }

        return isNegative ? -result : result; // if isNegative true, return -result, else return result
    }

    private static int evenDigitsHelper(int n) {
        if (n == 0) {
            return 0;
        }

        int digit = n % 10; // get last digit, e.g. 1234 % 10 = 4
        int remainingDigits = evenDigitsHelper(n / 10);
        // get remaining digits, e.g. 1234 / 10 = 123
        // resursively call evenDigitHelper(n / 10)

        if (digit % 2 == 0) { // if digit is even
            return remainingDigits * 10 + digit; // keeps digit & appends to right of remainingDigits
            // remainingDigits = 123, digit = 4
            //  123 * 10 + 4 = 1234
            // if we did 123 + 4, would we get 127, 4 wouldn't be appended
        }
        else { // if digit is odd, return but don't append
            return remainingDigits;
        }
    }
}

// mental model & trace for evenDigitHelper(1234):

// trace for evenDigitsHelper(1234):
// evenDigitsHelper(1234) - calls evenDigitsHelper(123)
// -> evenDigitsHelper(123) - calls evenDigitsHelper(12)
// --> evenDigitsHelper(12) - calls evenDigitsHelper(1)
// ---> evenDigitsHelper(1) - calls evenDigitsHelper(0)
// ----> evenDigitsHelper(0) - base case, return 0

// 0. evenDigits(-1234) isNegative checks if n is negative & saves true if negative, false if not
// then n = Math.abs(n) makes sure n is positive -> n = 1234
// result variable calls evenDigitsHelper(n)

// 1. digit = 1234 % 10 = 4
// remainingDigits = evenDigitsHelper(1234 / 10) - calls evenDigitsHelper(123)

// 2. digit = 123 % 10 = 3
// remainingDigits = evenDigitsHelper(123 / 10) - calls evenDigitsHelper(12)

// 3. digit = 12 % 10 = 2
// remainingDigits = evenDigitsHelper(12 / 10) - calls evenDigitsHelper(1)

// 4. digit = 1 % 10 = 1
// remainingDigits = evenDigitsHelper(1 / 10) - calls evenDigitsHelper(0)

// 5. n == 0, base case reached
// evenDigitsHelper(0) is done, now back up the stack
// return 0 to remainingDigits in evenDigitsHelper(1)

// 6. evenDigitsHelper(1) resumes
// digit = 1 is odd, don't append to the right
// return remainingDigits -> 0

// 7. evenDigitsHelper(12) resumes
// digit = 2 is even
// return remainingDigits * 10 + digit -> 0 * 10 + 2 = 2

// 8. evenDigitsHelper(123) resumes
// digit = 3 is odd
// return remainingDigits -> 2

// 9. evenDigitsHelper(1234) resumes
// digit = 4 is even
// return remainingDigits * 10 + digit -> 2 * 10 + 4 = 24

// 10. evenDigitsHelper(1234) is done, return 24 to result variable in evenDigits(1234)

// 11. return isNegative ? -result : result;
// pseudo code: if isNegative is true, return result as negative int, else return result unmodified
