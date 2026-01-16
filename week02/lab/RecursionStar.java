package week02.lab;

public class RecursionStar {
    public static void main(String[] args) {
        System.out.println(starString(3));
    }

    public static String starString(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n == 0) {
            return "*";
        }
        else {
            return starString(n - 1) + starString(n - 1);
            //2^n = 2 * 2^(n-1), so double the starString
        }
    }
}
