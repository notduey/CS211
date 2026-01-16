package week02.lab;

public class RecursionChars {
    public static void main(String[] args) {
    writeChars(8);
    }

    public static void writeChars(int n ) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        if (n == 1) {
            System.out.print('*');
        }
        else if (n == 2) {
            System.out.print("**");
        }
        else {
            System.out.print('<'); // '<' prints before recursion
            writeChars(n - 2); // n goes down by 2 instead of 1
            System.out.print('>'); // '>' prints after recursion returns
        }
    }
}

// mental model & trace for writeChars(8):

// trace:
// writeChars(8) - calls writeChars(8-2)
// -> writeChars(6) - calls writeChars(6-2)
// --> writeChars(4) - calls writeChars(4-2)
// ---> writeChars(2) - base case, print "**"

// 1. print '<'
// call writeChars(n - 2), where n = 8, so (n - 2) = 6
// doesn't print ">" yet because writeChars(6) is still running
// output: "<"

// 2. print '<'
// writeChars(n-2), where n = 6, so (n - 2) = 4
// doesn't print ">" yet because writeChars(4) is still running
// output: "<<"

// 3. print '<'
// writeChars(n-2), where n = 4, so (n - 2) = 2
// doesn't print ">" yet because writeChars(2) is still running
// output: "<<<"

// 4. reached base case (n = 2)
// print "**"
// writeChars(2) is done, now back up the stack
// output: "<<<**"

// 5. writeChars(4) resumes
// print '<' - writeChars(4) is done, back up the stack
// output: "<<<**>"

// 6. writeChars(6) resumes
// print '<' - writeChars(6) is done, back up the stack
// output: "<<<**>>"

// 7. writeChars(8) resumes
// print '<' - writeChars(8) is done, recursion is finished
// output: "<<<**>>>"

// ============================================================== //

// quick mental model & trace for writeChars(7):

// trace:
// writeChars(7)
// ->writeChars(5)
// --> writeChars(3)
// ---> writeChars(1) - base case, print '*'

// mental model:
// 1.writeChars(7) - "<"
// 2.writeChars(5) - "<<"
// 3.writeChars(3) - "<<<"
// 4.writeChars(1) - "<<<*" - base case, now back up the stack
// 5.writeChars(3) - "<<<*>"
// 6.writeChars(5) - "<<<*>>"
// 7.writeChars(7) - "<<<*>>>"