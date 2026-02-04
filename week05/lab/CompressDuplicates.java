package week05.lab;

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class CompressDuplicates {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(2);
        stack.push(2);
        stack.push(2);
        stack.push(2);
        stack.push(-5);
        stack.push(-5);
        stack.push(3);
        stack.push(3);
        stack.push(3);
        stack.push(3);
        stack.push(4);
        stack.push(4);
        stack.push(1);
        stack.push(0);
        stack.push(17);
        stack.push(17);

        compressDuplicates(stack);
        System.out.println(stack);
    }

    public static void compressDuplicates(Stack<Integer> s) {
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

        int current = q.remove(); // remove and store first element
        int count = 1; // count is 1 because first element is removed
        while (!q.isEmpty()) {
            int next = q.remove();
            if (current == next) { // if next element is same as current
                count++;
            }
            else {
                s.push(count); // push current count
                s.push(current); // push current element

                current = next; // update current to next element
                count = 1; // reset count
            }
        }
        
        // push last count and current pair (since while loop ends before pushing last pair)
        s.push(count);
        s.push(current);
    }
}
