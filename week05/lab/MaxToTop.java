package week05.lab;

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class MaxToTop {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(27);
        stack.push(5);
        stack.push(42);
        stack.push(-11);
        stack.push(0);
        stack.push(19);
        maxToTop(stack);
        System.out.println(stack);
    }

    public static void maxToTop(Stack<Integer> s) {
        Queue<Integer> q = new LinkedList<>();

        int max = s.peek(); // initialize max
        while (!s.isEmpty()) {
            int n = s.pop();
            q.add(n);
            if (n > max) {
                max = n; // update max
            }
        }

        while (!q.isEmpty()) { // add all elements back to stack, now in reverse
            s.push(q.remove());
        }

        while (!s.isEmpty()) { // add all elements to queue, now in original order
            q.add(s.pop());
        }

        // add all elements back to stack except max
        while (!q.isEmpty()) {
            int n = q.remove();
            if (n != max) {
                s.push(n);
            }
        }

        s.push(max); // add max to top of stack
    }
}
