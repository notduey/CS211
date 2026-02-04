package week05.lab;

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class SplitStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(-10);
        stack.push(15);
        stack.push(0);
        stack.push(-5);
        stack.push(100);
        
        splitStack(stack);
        System.out.println(stack);
    }

    public static void splitStack(Stack<Integer> s) {
        Queue<Integer> q = new LinkedList<>();

        while (!s.isEmpty()) { // while stack is not empty
            q.add(s.pop());
        }

        int size = q.size();
        for (int i = 0; i < size; i++) { // for loop to modify queue while iterating over it
            int n = q.remove(); // remove and store in n
            if (n < 0) { // if n is negative
                s.push(n); // push to stack
            }
            else { // if n is positive
                q.add(n); // add back to queue
            }
        }

        while (!q.isEmpty()) {
            s.push(q.remove()); // add remaining elements from queue to stack
        }
    }
}
