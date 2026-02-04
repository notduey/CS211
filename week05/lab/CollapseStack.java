package week05.lab;

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class CollapseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        stack.push(-2);
        stack.push(-3);
        stack.push(0);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        
        collapse(stack);
        System.out.println(stack);
    }

    public static void collapse(Stack<Integer> s) {
        Queue<Integer> q = new LinkedList<>();
        
        while (!s.isEmpty()) {
            q.add(s.pop()); // add elements to queue
        }
        
        Integer top = null; // Integer allows null, used for odd stack size
        if (q.size() % 2 == 1) { // if there's one remaining element (odd number of elements)
            top = q.remove(); // remove and store in top
        }

        while (q.size() >= 2) { // while queue has at least two elements
            int a = q.remove();
            int b = q.remove();
            s.push(a + b); // push a + b to stack
        }

        while (!s.isEmpty()) { // reverse stack
            q.add(s.pop());
        }

        while (!q.isEmpty()) { // push elements back to stack in original order
            s.push(q.remove());
        }
        
        if (top != null) { // if top is not null
            s.push(top); // push top back to stack
        }
    }
}
