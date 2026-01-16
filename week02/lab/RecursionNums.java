package week02.lab;

public class RecursionNums {
    public static void main(String[] args) {
        writeNums(5);
    }

    public static void writeNums(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        if (n == 1) {
            System.out.print(1);
        }
        else {
            writeNums(n - 1); // recursive call first so numbers print in ascending order
            System.out.print(", " + n); // if you want descending order, this line goes first
        }
    }
}
