package week05.lab;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class IsPalindrome {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(3);
        queue.add(8);
        queue.add(17);
        queue.add(9);
        queue.add(17);
        queue.add(8);
        queue.add(3);
        System.out.println(isPalindrome(queue));
        System.out.println(queue);

        queue.add(0);
        System.out.println(isPalindrome(queue));
        System.out.println(queue);
    }

    public static boolean isPalindrome(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();

        int size = q.size();
        for (int i = 0; i < size; i++) { // add all elements to stack
            int n = q.remove();
            s.push(n); // push to stack, reverses order
            q.add(n); // add back to queue
        }

        boolean isPalindrome = true;
        for (int i = 0; i < size; i++) {
            int a = q.remove();
            int b = s.pop();
            if (a != b) { // compare front of queue and top (back) of stack
                isPalindrome = false; // loop doesn't end because we need to restore the queue
            }
            q.add(a); // add back to queue
        }

        return isPalindrome;
    }
}

// isPalindrome essentially adds elements from queue to stack and compares theme since the order is reversed, and returns true if the elements are the same