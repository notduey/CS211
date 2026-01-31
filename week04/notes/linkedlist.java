/* ============================================================
 * CSE 143 — LinkedIntList (Linked Structure Fundamentals)
 * Topic: Building and Traversing Linked Lists
 *
 * Core idea:
 * - Instead of an array, a linked list is a chain of nodes
 * - Each node stores:
 *      1) data
 *      2) a reference to the next node
 *
 * Visual model:
 *   front -> [data | next] -> [data | next] -> null
 * ============================================================
 */


/* ============================================================
 * LINKED DATA STRUCTURES VS ARRAY-BASED STRUCTURES
 * ============================================================
 *
 * Array-based:
 * - ArrayList, Stack, HashSet, HashMap
 * - Uses a single array to store elements
 *
 * Linked-based:
 * - LinkedList, TreeSet, TreeMap
 * - Each element is stored in a separate object (node)
 * - Nodes are connected by references
 */


/* ============================================================
 * NODE (BASIC BUILDING BLOCK)
 * ============================================================
 *
 * A node stores:
 * - one data value
 * - one reference to the next node
 */

class ListNode {
    int data;
    ListNode next;
}


/* ============================================================
 * CREATING A SINGLE NODE
 * ============================================================
 */

ListNode node = new ListNode();
node.data = 18;
node.next = null;


/* ============================================================
 * CONSTRUCTING A LINKED LIST STEP BY STEP
 * ============================================================
 *
 * Goal: build the list [3, 7, 12]
 */

ListNode list;                 // reference (arrow only)
list = new ListNode();         // create first node

list.data = 3;
list.next = new ListNode();    // second node

list.next.data = 7;
list.next.next = new ListNode();  // third node

list.next.next.data = 12;
list.next.next.next = null;    // end of list


/* ============================================================
 * IMPORTANT: REFERENCES AT EACH LEVEL
 * ============================================================
 *
 * list              -> first node (3)
 * list.next         -> second node (7)
 * list.next.next    -> third node (12)
 *
 * Losing `list` means losing the entire list.
 */


/* ============================================================
 * PRINTING VALUES (ONLY USING FRONT REFERENCE)
 * ============================================================
 */

System.out.println(
        list.data + " " +
        list.next.data + " " +
        list.next.next.data
);
// Output: 3 7 12


/* ============================================================
 * LISTNODE WITH CONSTRUCTORS (CLEANER VERSION)
 * ============================================================
 */

class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }

    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }
}


/* ============================================================
 * REFERENCES VS OBJECTS (CRITICAL CONCEPT)
 * ============================================================
 *
 * variable = value;
 *
 * - variable (left side) is a reference (arrow)
 * - value (right side) is an object (box)
 *
 * Examples:
 *
 * a.next = value;    // changes where a.next points
 * variable = a.next; // makes variable point to same node
 */


/* ============================================================
 * REASSIGNING REFERENCES
 * ============================================================
 *
 * a.next = b.next;
 *
 * Meaning:
 * - a.next now points to the same node that b.next points to
 * - no objects are copied
 */


/* ============================================================
 * LIST TRAVERSAL (WALKING THROUGH THE LIST)
 * ============================================================
 *
 * Pseudocode:
 * while (there are more nodes)
 *     process current node
 *     move to next node
 */


/* ============================================================
 * BAD TRAVERSAL (DESTROYS THE LIST)
 * ============================================================
 *
 * This is dangerous:
 */

while (list != null) {
    System.out.println(list.data);
    list = list.next;
}

/*
 * Problem:
 * - `list` is the only reference to the front
 * - advancing it destroys access to the list
 */


/* ============================================================
 * CORRECT TRAVERSAL USING A CURRENT REFERENCE
 * ============================================================
 */

ListNode current = list;    // copy the reference

while (current != null) {
    System.out.println(current.data);
    current = current.next;
}

/*
 * Key idea:
 * - A ListNode variable is NOT a ListNode object
 * - Copying references does NOT copy nodes
 */


/* ============================================================
 * LINKED LIST VS ARRAY TRAVERSAL
 * ============================================================
 */

// Linked list
ListNode current = list;
while (current != null) {
    System.out.println(current.data);
    current = current.next;
}

// Array
int index = 0;
while (index < array.length) {
    System.out.println(array[index]);
    index++;
}


/* ============================================================
 * INNER CLASSES
 * ============================================================
 *
 * - A class defined inside another class
 * - Can be static or non-static
 * - We focus on non-static inner classes
 *
 * Benefits:
 * - Hidden from other classes (encapsulation)
 * - Can directly access outer class fields
 */


/* ============================================================
 * STATIC VS NON-STATIC INNER CLASSES
 * ============================================================
 */

class A {

    class B {           // non-static inner class
        // static int x;  // NOT allowed
    }

    static class C {    // static inner class
        static int x;   // allowed
    }
}

class Test {
    public static void main(String[] args) {

        A a = new A();

        // requires enclosing instance
        A.B obj1 = a.new B();

        // no enclosing instance required
        A.C obj2 = new A.C();
    }
}


/* ============================================================
 * LINKEDINTLIST WITH INNER LISTNODE CLASS
 * ============================================================
 */

public class LinkedIntList {

    private ListNode front;   // reference to first node

    public class ListNode {
        int data;
        ListNode next;
    }
}