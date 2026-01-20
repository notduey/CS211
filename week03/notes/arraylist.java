/* ============================================================
 * CSE 143 — ArrayIntList (Implementation + Design Notes)
 * Topic: Building an Array-backed List from Scratch
 *
 * Two perspectives:
 * 1) Client view: WHAT the class does (specs, behavior)
 * 2) Implementer view: HOW the class works internally
 * ============================================================
 */

/* ============================================================
 * CLASS FIELDS
 * ============================================================
 *
 * - elements: the underlying array storing data
 * - size: number of elements currently in the list
 * - DEFAULT_CAPACITY: starting array size
 */

public class ArrayIntList {

    public static final int DEFAULT_CAPACITY = 100;

    private int[] elements;
    private int size;


/* ============================================================
 * CONSTRUCTORS
 * ============================================================
 */

    // Default constructor
    // Allocates DEFAULT_CAPACITY space and starts empty
    public ArrayIntList() {
        this(DEFAULT_CAPACITY);   // avoid redundancy
    }

    // Parameterized constructor
    // Allows client to control starting capacity
    public ArrayIntList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity must not be negative");
        }
        this.elements = new int[capacity];
        this.size = 0;
    }


/* ============================================================
 * ADDING ELEMENTS
 * ============================================================
 */

    // Adds value to the end of the list
    public void add(int value) {
        elements[size] = value;
        size++;
    }

    // Adds value at a specific index
    // Shifts elements to the right to make space
    public void add(int index, int value) {
        for (int i = size; i >= index + 1; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = value;
        size++;
    }


/* ============================================================
 * STRING REPRESENTATION (toString)
 * ============================================================
 *
 * Uses the "fencepost technique":
 * - handle first element separately
 * - prepend ", " for the rest
 */

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        String result = "[" + elements[0];
        for (int i = 1; i < size; i++) {
            result += ", " + elements[i];
        }
        result += "]";
        return result;
    }


/* ============================================================
 * SIZE, GET, SET
 * ============================================================
 */

    // Returns number of elements stored
    public int size() {
        return size;
    }

    // pre: 0 <= index < size
    // post: returns value at index
    public int get(int index) {
        return elements[index];
    }

    // pre: 0 <= index < size
    // post: replaces value at index, returns new value
    public int set(int index, int value) {
        return elements[index] = value;
    }


/* ============================================================
 * REMOVE, INDEXOF, CLEAR
 * ============================================================
 */

    // Removes element at index
    // Shifts elements left to fill the gap
    public void remove(int index) {
        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
    }

    // Returns index of first occurrence of value
    // Returns -1 if not found
    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == value) {
                return i;
            }
        }
        return -1;
    }

    // Clears the list logically (does not resize array)
    public void clear() {
        size = 0;
    }
}


/* ============================================================
 * PRECONDITIONS & POSTCONDITIONS
 * ============================================================
 *
 * Preconditions:
 * - Assumptions the method makes about inputs
 *
 * Postconditions:
 * - What the method guarantees after execution
 *
 * Example:
 *
 * // pre: 0 <= index < size()
 * // post: returns the integer at the given index
 * public int get(int index)
 */


/* ============================================================
 * COMMON EXCEPTIONS (Know These)
 * ============================================================
 *
 * NullPointerException
 * ArrayIndexOutOfBoundsException
 * IndexOutOfBoundsException
 * IllegalStateException
 * IllegalArgumentException
 * NoSuchElementException
 */


/* ============================================================
 * GENERIC VERSION (ArrayList<Type>)
 * ============================================================
 *
 * Key ideas:
 * - Use Type instead of int
 * - Cannot directly create new Type[]
 * - Must use casting: (Type[]) new Object[capacity]
 * - Use .equals instead of ==
 */

public class ArrayList<Type> {

    private Type[] elements;
    private int size;

    public ArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity must not be negative");
        }
        elements = (Type[]) new Object[capacity];
        size = 0;
    }

    public int indexOf(Type value) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }
}


/* ============================================================
 * MEMORY ALLOCATION & GARBAGE COLLECTION
 * ============================================================
 *
 * Important rule:
 * - Garbage collector only frees objects with NO references
 * - If an array still holds references, objects are NOT freed
 *
 * Good practice:
 * - Set unused array slots to null
 */

public void removeWithGC(int index) {
    for (int i = index; i < size - 1; i++) {
        elements[i] = elements[i + 1];
    }
    elements[size - 1] = null;  // allow GC
    size--;
}

public void clearWithGC() {
    for (int i = 0; i < size; i++) {
        elements[i] = null;
    }
    size = 0;
}
