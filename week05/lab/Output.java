package week05.lab;

import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class Output {
    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
        Queue<String> q = new LinkedList<>();
        s.push("how");
        s.push("are");
        s.push("you");
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
        System.out.println(q); // output: [you, are, how]

        Queue<Integer> q1 = new LinkedList<>();
        q1.add(10);
        q1.add(4);
        System.out.println(q1.size()); // output: 2
        System.out.println(q1.peek()); // output: 10
        q1.add(6);
        System.out.println(q1.remove()); // output: 10
        q1.add(3);
        System.out.println(q1.remove()); // output: 4
        System.out.println(q1.peek()); // output: 6
        System.out.println(q1.remove()); // output: 6
        q1.add(7);
        System.out.println(q1.peek()); // output: 3

        Stack<Integer> s1 = new Stack<>();
        s1.push(2);
        s1.push(6);
        s1.push(1);
        mystery1(s1); // output: [1, 1, 6, 6, 2, 2]

        Queue<Integer> q2 = new LinkedList<>();
        q2.add(1);
        q2.add(2);
        q2.add(3);
        q2.add(4);
        q2.add(5);
        q2.add(6);
        mystery2(q2); // output: [1, 3, 5] [2, 4, 6]

        Queue<Integer> q3 = new LinkedList<>();
        q3.add(1);
        q3.add(-2);
        q3.add(3);
        q3.add(-3);
        q3.add(5);
        q3.add(-6);
        mystery3(q3); // output: [-1, -3, -5]
    }

    public static void mystery1(Stack<Integer> s) {
        Queue<Integer> q = new LinkedList<>();
        while (!s.isEmpty()) {
            int n = s.pop();
            q.add(n);
            q.add(n);
        }
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        System.out.println(s);
    }

    public static void mystery2(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        int size = q.size();
        for (int i = 0; i < size; i++) {
            int n = q.remove();
            if (n % 2 == 0) {
                s.push(n);
            }
            else {
                q.add(n);
            }
        }
        System.out.println(q + " " + s);
    }

    public static void mystery3(Queue<Integer> q) {
        int size = q.size();
        for (int i = 0; i < size; i++) {
            int n = q.remove();
            if (n > 0 ) {
                q.add(-n);
            }
        }
        System.out.println(q);
    }
}