/* ============================================================
 * CSE 143 — Stack & Queue (Basic)
 * Topic: Ordered Data Structures with Restricted Access
 *
 * Key idea:
 * - Stack and Queue both store an ordered sequence of values
 * - Access is restricted in different ways
 * ============================================================
 */


/* ============================================================
 * STACK / QUEUE BASICS
 * ============================================================
 *
 * Common features:
 * - add: put values into the structure
 * - remove: take values out
 * - isEmpty: check if structure has elements
 * - size: number of elements
 * - peek: examine next value WITHOUT removing it
 *
 * Difference:
 * - Stack → LIFO (Last-In, First-Out)
 * - Queue → FIFO (First-In, First-Out)
 */


/* ============================================================
 * STACK — CONCEPTS
 * ============================================================
 *
 * - All action occurs at the TOP
 * - Add = push
 * - Remove = pop
 *
 * Stack operations:
 * - push(value): add to top
 * - pop(): remove and return top
 * - peek(): examine top (does NOT remove)
 */


/* ============================================================
 * STACK — COMMON OPERATIONS (java.util.Stack)
 * ============================================================
 */

Stack<Integer> stack = new Stack<>();

stack.push(10);
stack.push(20);
stack.push(30);

int top = stack.peek();   // 30
int removed = stack.pop(); // removes 30

int size = stack.size();
boolean empty = stack.isEmpty();

stack.clear();


/* ============================================================
 * STACK — EXCEPTION BEHAVIOR
 * ============================================================
 *
 * pop() and peek():
 * - throw EmptyStackException if stack is empty
 */

Stack<Integer> s = new Stack<>();

// s.pop();   // EmptyStackException
// s.peek();  // EmptyStackException


/* ============================================================
 * STACK — FULL EXAMPLE (BEHAVIOR)
 * ============================================================
 */

Stack<Integer> myStack = new Stack<>();

System.out.println(myStack.isEmpty()); // true
System.out.println(myStack.size());    // 0

myStack.push(10);
myStack.push(20);
myStack.push(30);
myStack.push(40);

System.out.println(myStack.isEmpty()); // false
System.out.println(myStack.size());    // 4
System.out.println(myStack);           // [10, 20, 30, 40]

System.out.println(myStack.peek());    // 40
System.out.println(myStack.pop());     // 40
System.out.println(myStack);           // [10, 20, 30]

myStack.clear();
System.out.println(myStack.isEmpty()); // true

// myStack.peek(); // EmptyStackException


/* ============================================================
 * STACK — CASE STUDY: FIND MAX VALUE
 * ============================================================
 *
 * Problem:
 * - Algorithm works
 * - But popping DESTROYS the stack
 *
 * Solution:
 * - Save values in a backup stack
 * - Restore original stack before returning
 */

// Precondition: myStack.size() > 0
public static int max(Stack<Integer> myStack) {

    Stack<Integer> backupStack = new Stack<>();

    int maxValue = myStack.pop();
    backupStack.push(maxValue);

    while (!myStack.isEmpty()) {
        int nextValue = myStack.pop();
        backupStack.push(nextValue);

        if (maxValue < nextValue) {
            maxValue = nextValue;
        }
    }

    // restore original stack
    while (!backupStack.isEmpty()) {
        myStack.push(backupStack.pop());
    }

    return maxValue;
}


/* ============================================================
 * QUEUE — CONCEPTS
 * ============================================================
 *
 * - Manipulates BOTH ends
 * - Add at BACK
 * - Remove from FRONT
 *
 * Queue operations:
 * - add (enqueue): add to back
 * - remove (dequeue): remove from front
 * - peek(): examine front (does NOT remove)
 *
 * Behavior:
 * - FIFO (First-In, First-Out)
 */


/* ============================================================
 * QUEUE — COMMON OPERATIONS (java.util.Queue + LinkedList)
 * ============================================================
 */

Queue<Integer> queue = new LinkedList<>();

queue.add(10);
queue.add(20);
queue.add(30);

int front = queue.peek();    // 10
int removed = queue.remove(); // removes 10

int size = queue.size();
boolean empty = queue.isEmpty();

queue.clear();


/* ============================================================
 * QUEUE — EXCEPTION & NULL BEHAVIOR
 * ============================================================
 *
 * remove():
 * - throws NoSuchElementException if empty
 *
 * peek():
 * - returns null if empty
 */

Queue<Integer> q = new LinkedList<>();

// q.remove();  // NoSuchElementException
q.peek();       // null


/* ============================================================
 * QUEUE — FULL EXAMPLE (BEHAVIOR)
 * ============================================================
 */

Queue<Integer> myQueue = new LinkedList<>();

System.out.println(myQueue.isEmpty()); // true
System.out.println(myQueue.size());    // 0

myQueue.add(10);
myQueue.add(20);
myQueue.add(30);
myQueue.add(40);

System.out.println(myQueue.isEmpty()); // false
System.out.println(myQueue.size());    // 4
System.out.println(myQueue);           // [10, 20, 30, 40]

System.out.println(myQueue.peek());    // 10
System.out.println(myQueue.remove());  // 10
System.out.println(myQueue);           // [20, 30, 40]

myQueue.clear();
System.out.println(myQueue.isEmpty()); // true
System.out.println(myQueue.peek());    // null

// myQueue.remove(); // NoSuchElementException


/* ============================================================
 * QUEUE — CASE STUDY: SUM VALUES
 * ============================================================
 *
 * Problem:
 * - Removing elements empties the queue
 *
 * Solution:
 * - Capture initial size
 * - Remove each element
 * - Add it back to preserve order
 */

public static int sum(Queue<Integer> myQueue) {

    int sumValue = 0;
    int size = myQueue.size();

    while (size > 0) {
        int nextValue = myQueue.remove();
        sumValue += nextValue;
        myQueue.add(nextValue);
        size--;
    }

    return sumValue;
}


/* ============================================================
 * STACK & QUEUE IN GRAPH TRAVERSAL
 * ============================================================
 *
 * Depth-First Search (DFS):
 * - Uses Stack
 * - Go as far as possible down one path before backtracking
 *
 * Breadth-First Search (BFS):
 * - Uses Queue
 * - Explore all neighbors level by level
 *
 * Both continue until entire graph is explored
 */


/* ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * DFS:
 * - Maze solving
 * - Backtracking problems
 *
 * BFS:
 * - Shortest path (Google Maps, MapQuest)
 * - Level-order traversal
 */
