package week06.lab;

public class ApproxRuntime {
    public static void main(String[] args) {
        codeFragment1(10);
        codeFragment2(10);
        codeFragment3(10);
        codeFragment4(10);
        codeFragment5(10);
    }

    public static void codeFragment1(int n ) {
        int sum = 0;
        int j = 1;
        while (j <= n) {
            sum = sum++;
            j = j * 2;
        }

        System.out.println(sum);
        // runtime is O(log n) because j is double every iteration until j > n (loop ends)
    }

    public static void codeFragment2(int n ) {
        int sum = 0;
        for (int j = 1; j < n; j++) {
            sum++;
            if (j % 2 == 0) {
                sum++;
            }
        }

        System.out.println(sum);
        // runtime is O(n) because j iterates n times
        // even if the if statement runs every other iteration, runtime is still O(n)
        // conditionals do not change Big-O unless they change how many times the loop runs
    }

    public static void codeFragment3(int n ) {
        int sum = 0;
        for (int i = 1; i <= n * 2; i++) {
            for (int j = 1; j <= n; j++) {
                sum++;
            }
        }
        for (int j = 1; j < 100; j++) {
            sum++;
            sum++;
        }

        System.out.println(sum);
        // runtime is O(n^2) because i iterates n times and j iterates n times for each i iteration
        // outer loop -> n * 2, still O(n) as constants don't affect Big-O
        // inner loop -> n, O(n) 
        // the second loop runs constant 99 times, O(1)
        // when combined, the largest growth rate dominates
        // O(n^2) + O(1) -> O(n^2)
    }

    public static void codeFragment4(int n ) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j+= 2) {
                sum += 4;
            }
        }
        for (int k = -50; k <= -1; k++) {
            sum --;
        }

        System.out.println(sum);
        // runtime is O(n^2) because i iterates n times and j iterates n times
        // outer loop -> n, O(n)
        // inner loop -> n, even if j += 2, it still iterates n times, O(n)
        // the second loop runs constant 51 times, O(1)
        // when combined, the largest growth rate dominates
        // O(n^2) + O(1) -> O(n^2)
    }

    public static void codeFragment5(int n ) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 1000000; j++) {
                sum += 10;
            }
        }
        sum += 9999;

        System.out.println(sum);
        // runtime is O(n) because i iterates n times and j iterates constant 1000000 times
        // outer loop -> n, O(n)
        // inner loop -> iterates 1000000 times which is huge, but is still constant, O(1)
        // when combined, the largest growth rate dominates
        // O(n) + O(1) -> O(n)
    }
}
