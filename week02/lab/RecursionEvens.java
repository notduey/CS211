package week02.lab;

public class RecursionEvens {
    public static void main(String[] args) {
        System.out.println(multiplyEvens(4));
    }

    public static int multiplyEvens(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        if (n == 1) {
            return 2;
        }
        else {
            return multiplyEvens(n - 1) * (2 * n);
            //product(n) = product(n-1) * 2n
        }
    }
}
