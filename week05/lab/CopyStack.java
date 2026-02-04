package week05.lab;

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class CopyStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        Stack<Integer> copy = copyStack(stack);
        System.out.println(stack);
        System.out.println(copy);
    }

    public static Stack<Integer> copyStack(Stack<Integer> s) {
        Stack<Integer> copy = new Stack<>();
        Queue<Integer> q = new LinkedList<>();

        // move elements from s to q
        while (!s.isEmpty()) {
            q.add(s.pop());
        }

        // move elements back to s, restores original order
        while (!q.isEmpty()) {
            s.push(q.remove());
        }

        // move elements back to copy whilst building copy
        while (!s.isEmpty()) {
            int n = s.pop();
            q.add(n);
            copy.push(n);
        }

        // restore original stack
        while (!q.isEmpty()) {
            s.push(q.remove());
        }

        return copy;
    }
}

// example run for stack: [1, 2, 3, 4, 5]

// 1. move elemetns from s: [1, 2, 3, 4, 5] -> q: [5, 4, 3, 2, 1]
// 2. move elements back to s, q: [5, 4, 3, 2, 1] -> s: [5, 4, 3, 2, 1]
// 3. move elements whilst building copy, s: [5, 4, 3, 2, 1] -> copy: [1, 2, 3, 4, 5], q: [1, 2, 3, 4, 5]
// 4. restore original stack, q: [1, 2, 3, 4, 5] -> s: [1, 2, 3, 4, 5]