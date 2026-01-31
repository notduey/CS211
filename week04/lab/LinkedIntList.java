package week04.lab;
import java.util.*;

// A LinkedIntList object can be used to store a list of integers.
public class LinkedIntList {
    private ListNode front;   // node holding first value in list (null if empty)
    private String name = "front";   // string to print for front of list
    
    // Constructs an empty list.
    public LinkedIntList() {
        front = null;
    }
    
    // Constructs a list containing the given elements.
    // For quick initialization via Practice-It test cases.
    public LinkedIntList(int... elements) {
        this("front", elements);
    }
    
    public LinkedIntList(String name, int... elements) {
        this.name = name;
        if (elements.length > 0) {
            front = new ListNode(elements[0]);
            ListNode current = front;
            for (int i = 1; i < elements.length; i++) {
                current.next = new ListNode(elements[i]);
                current = current.next;
            }
        }
    }
    
    // Constructs a list containing the given front node.
    // For quick initialization via Practice-It ListNode test cases.
    private LinkedIntList(String name, ListNode front) {
        this.name  = name;
        this.front = front;
    }
    
    // Appends the given value to the end of the list.
    public void add(int value) {
        if (front == null) {
            front = new ListNode(value, front);
        } else {
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
            } 
            current.next = new ListNode(value);
        }
    }
    
    // Inserts the given value at the given index in the list.
    // Precondition: 0 <= index <= size
    public void add(int index, int value) {
        if (index == 0) {
            front = new ListNode(value, front);
        } else {
            ListNode current = front;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            } 
            current.next = new ListNode(value, current.next);
        }
    }
    
    public boolean equals(Object o) {
        if (o instanceof LinkedIntList) {
            LinkedIntList other = (LinkedIntList) o;
            return toString().equals(other.toString());   // hackish
        } else {
            return false;
        }
    }
    
    // Returns the integer at the given index in the list.
    // Precondition: 0 <= index < size
    public int get(int index) {
        ListNode current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    
    // Removes the value at the given index from the list.
    // Precondition: 0 <= index < size
    public void remove(int index) {
        if (index == 0) {
            front = front.next;
        } else {
            ListNode current = front;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
    }
    
    // Returns the number of elements in the list.
    public int size() {
        int count = 0;
        ListNode current = front;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    
    // Returns a text representation of the list, giving
    // indications as to the nodes and link structure of the list.
    // Detects student bugs where the student has inserted a cycle
    // into the list.
    public String toFormattedString() {
        ListNode.clearCycleData();
        
        String result = this.name;
        
        ListNode current = front;
        boolean cycle = false;
        while (current != null) {
            result += " -> [" + current.data + "]";
            if (current.cycle) {
                result += " (cycle!)";
                cycle = true;
                break;
            }
            current = current.__gotoNext();
        }

        if (!cycle) {
            result += " /";
        }
        
        return result;
    }
    
    // Returns a text representation of the list.
    public String toString() {
        return toFormattedString();
    }
    
    // Returns a shorter, more "java.util.LinkedList"-like text representation of the list.
    public String toStringShort() {
        ListNode.clearCycleData();
        
        String result = "[";
        
        ListNode current = front;
        boolean cycle = false;
        while (current != null) {
            if (result.length() > 1) {
				result += ", ";
			}
            result += current.data;
            if (current.cycle) {
                result += " (cycle!)";
                cycle = true;
                break;
            }
            current = current.__gotoNext();
        }

        if (!cycle) {
            result += "]";
        }
        
        return result;
    }
    

    // ListNode is a class for storing a single node of a linked list.  This
    // node class is for a list of integer values.
    // Most of the icky code is related to the task of figuring out
    // if the student has accidentally created a cycle by pointing a later part of the list back to an earlier part.

    public static class ListNode {
        private static final List<ListNode> ALL_NODES = new ArrayList<ListNode>();
        
        public static void clearCycleData() {
            for (ListNode node : ALL_NODES) {
                node.visited = false;
                node.cycle = false;
            }
        }
        
        public int data;          // data stored in this node
        public ListNode next;     // link to next node in the list
        public boolean visited;   // has this node been seen yet?
        public boolean cycle;     // is there a cycle at this node?

        // post: constructs a node with data 0 and null link
        public ListNode() {
            this(0, null);
        }

        // post: constructs a node with given data and null link
        public ListNode(int data) {
            this(data, null);
        }

        // post: constructs a node with given data and given link
        public ListNode(int data, ListNode next) {
            ALL_NODES.add(this);
            this.data = data;
            this.next = next;
            this.visited = false;
            this.cycle = false;
        }
        
        public ListNode __gotoNext() {
            return __gotoNext(true);
        }
        
        public ListNode __gotoNext(boolean checkForCycle) {
            if (checkForCycle) {
                visited = true;
                
                if (next != null) {
                    if (next.visited) {
                        // throw new IllegalStateException("cycle detected in list");
                        next.cycle = true;
                    }
                    next.visited = true;
                }
            }
            return next;
        }
    }

// YOUR CODE GOES HERE
    // 1. sets the value of the node at the given index
    public void set(int index, int value) {
        ListNode current = front; // pointers to front of list/first node

        for (int i = 0; i < index; i++) { // traverse through list until index
            current = current.next; // move to next node
        }

        current.data = value; // set data of node to value
    }

    // 2. returns the index of the last occurrence of the given value
    public int lastIndexOf(int value) {
        ListNode current = front;
        int index = 0;
        int lastIndex = -1; // default value if value is not found

        // linked lists don't have built in indexes or known length, so a for loop can't be used
        // using a while loop instead allows us to naturally traverse through the list by following the next references (pointers) until current is null, which indicates the end of the list
        while (current != null) { // traverse through list
            if (current.data == value) {
                lastIndex = index;
            }

            current = current.next; // move to next node
            index++; // move to next index
        }

        return lastIndex;
    }

    // 3. returns true if the list has two adjacent integer values that are consecutive
    // 1, 2 are two adjacent consecutive integers, but 2, 1 are not
    public boolean hasTwoConsecutive() {
        ListNode current = front;

        while (current != null && current.next != null) { // traverse through list and check if next node exists
            if (current.next.data == current.data + 1) { // if next node is 1 greater than current node
                return true; // found a consecutive pair so loop ends
            }
            
            current = current.next;
        }

        return false;
    }

    // 4. switches the order of the pairs of notes in list, last node isn't switched if list is odd
    public void switchPairs() {
        if (front == null || front.next == null) {
            return;
        }

        ListNode previous = null; // node before pair of nodes getting swapped
        ListNode current = front;

        front = current.next; // set front to next node

        // swap if there are at last 2 nodes left
        while (current != null && current.next != null) {
            ListNode next = current.next; // second node in pair
            ListNode after = next.next; // node after pair (start of next pair)

            // swap pairs
            next.next = current;
            current.next = after;

            // connect previous part of list to swapped pair
            if (previous != null) {
                previous.next = next;
            }

            // move to next pair
            previous = current; // current is now the second node in swapped pair
            current = after; // move to start of next pair
        }
    }
    /* example: front -> 3 -> 7 -> 4 -> 9 -> 8 -> 12 -> null
    0. if statement checks if list is empty or has only one node

    1. 
        a. prev = null, current = front (front points to 3), current now points to 3
        b. front = current.next (front now points to 7), current still points to 3

    2.
        a. next = current.next (next points to 7), after = next.next (after points to what next.next is pointing, which is 4)
        b. next.next = current (make next point to current, 7 -> 3), current.next = after (make current point to after, 3 -> 4)
        c. previous = null, skip if statement
        d. previous = current (previous now points at what current is pointing, which is 3), current = after (current now points at what after is pointing, which is 4)

    3.
        a. next = current.next (points to 9), after = next.next (points to 8)
        b. next.next = current (now points to 4), current.next = after (now points to 8)
        c. previous != null, previous.next = next (now points to next, which is 9)
        d. previous = current (now points to 4), current = after (now points to 8)

    4. repeat steps a,b,c,d, next points to 12, after points to null, at the end of while loop, current points to null, loop ends
    */

    // 5. duplicates each node in the list
    public void stutter() {
        ListNode current = front;

        while (current != null) {
            // current.next points to new duplicate nodes
            current.next = new ListNode(current.data, current.next);

            current = current.next.next; // move forward 2 nodes (move over the duplicate)
        }
    }

    // 6. rearranges list so negative elements appear before all positive elements
    public void split() {
        ListNode negHead = null; // points to first negative node
        ListNode negTail = null; // points to last negative node
        ListNode posHead = null; // points to first positive node
        ListNode posTail = null; // points to last positive node

        ListNode current = front;

        while (current != null) {
            ListNode next = current.next; // points to next node
            current.next = null; // disconnect current pointer from list

            if (current.data < 0 ) {
                // add current node to negative list
                if (negHead == null) {
                    negHead = current; // set negHead to current node
                    negTail = current; // set negTail to current node
                }
                else { // since negHead isn't null, negTail points to last negative node
                    negTail.next = current; // negTail's next pointer now points to current, which is new last negative node
                    negTail = current; // update negTail point at what current is pointing at, which is new last negative node, current.next is null so negTail.next is also null because negTail inherits that from current
                }
            }
            else {
                // add current node to positive list
                if (posHead == null) {
                    posHead = current; // set posHead to current node
                    posTail = current; // set posTail to current node
                }
                else {
                    posTail.next = current; // posTail's next pointer now points to current, which is new last positive node
                    posTail = current; // update posTail point at what current is pointing at, which is new last positive node, current.next is null so posTail.next is also null because posTail inherits that from current
                }
            }

            current = next; // move to next node
        }

        // connect the two lists
        if (negHead == null) {
            front = posHead; // if no negative nodes, set front to first positive node
        }
        else {
            front = negHead; // set front to first negative node
            negTail.next = posHead; // connect last negative node pointer to first postive nodes
        }
    }

    // 7. rearranges list so that all even-indexed nodes appear before all odd-indexed nodes
    public void shift() {
        if (front == null || front.next == null) { // if list empty or has only one node
            return;
        }

        ListNode evenHead = front; // points to first node, first even index
        ListNode oddHead = front.next; // points to second node, first odd index

        ListNode even = evenHead; // tail of even list, points to last even node
        ListNode odd = oddHead; // tail of odd list, points to last odd node

        while (odd != null && odd.next != null) {
            even.next = odd.next; // connect even to next even (which is what odd is pointing at)
            even = even.next; // move even tail forward

            odd.next = even.next; // connect odd to next odd (which is what even is pointing at)
            odd = odd.next; // move odd tail forward
        }

        even.next = oddHead; // connect last even node to first odd node (even list goes before odd list)
    }

    // 8.
    public void reverse() {
        ListNode previous = null;
        ListNode current = front;

        while (current != null) {
            ListNode next = current.next; // points to next node
            current.next = previous; // connect current node to previous node
            previous = current; // set previous to current node
            current = next; // move to next node
        }

        front = previous; // new front points to old last node
    }
}