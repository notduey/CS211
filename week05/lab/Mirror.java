package week05.lab;

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class Mirror {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(50);
        stack.push(19);
        stack.push(54);
        stack.push(30);
        stack.push(67);
        mirror(stack);
        System.out.println(stack);
    }

    public static void mirror(Stack<Integer> s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        
        Queue<Integer> q = new LinkedList<>();

        while (!s.isEmpty()) { // add all elements to queue
            q.add(s.pop());
        }

        while (!q.isEmpty()) { // add all elements back to stack, now in reverse
            s.push(q.remove());
        }

        while (!s.isEmpty()) { // add all elements to queue, now in original order
            q.add(s.pop());
        }

        int size = q.size();
        // iterate over queue and add elements to stack
        for (int i = 0; i < size; i++) {
            int n = q.remove();
            s.push(n);
            q.add(n);
        }

        while (!s.isEmpty()) { // add remaining elements to queue
            q.add(s.pop());
        }
        
        while (!q.isEmpty()) { // add all elements back to stack
            s.push(q.remove());
        }
    } 
}