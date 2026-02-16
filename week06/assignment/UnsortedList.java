package week06.assignment;

/**
 * The class represents for the circular unsorted linked list
 * @author Varik Hoang <varikmp@uw.edu>
 * @author FIRST_NAME LAST_NAME
 * @param <Type> the generic data type
 */
public class UnsortedList<Type>
extends AbstractList<Type>
implements List<Type>
{
	/**
	 * The constructor for the circular unsorted linked list.
	 */
	public UnsortedList()
	{
		super();
	}

	@Override
	public boolean contains(Type value)
	{
		return getIndex(value) >= 0;
	}

	// append value to end of list
	@Override
	public void insert(Type value) {
		if (value == null) {
			throw new NullPointerException("The value could not be null");
		}

		ListNode<Type> newNode = new ListNode<Type>(value);

		if (tail == null) { // if list is empty
			tail = newNode; // set tail to newNode
			tail.next = tail; // set next of tail to itself
		}
		else { // if list not empty
			newNode.next = tail.next; // set next of newNode to next of tail (which is the head)
			tail.next = newNode; // point the old tail to newNode (so newNode is now the tail)
			tail = newNode; // update tail to newNode
		}

		size++; // increment size
	}

	// clear list, make it empty
	@Override
	public void clear() {
		tail = null;
		size = 0;
	}

	// finds item in the list and removes it, then returns removed item
	@Override
	public Type remove(Type value) {
		if (value == null) {
			throw new NullPointerException("The value could not be null");
		}

		if (tail == null) { // if list is empty
			return null;
		}

		ListNode<Type> curr = tail.next; // node to traverse, start at head
		ListNode<Type> prev = tail; // previous node, start at tail

		for (int i = 0; i < size; i++) { // iterate through list once, exactly size times
			if (curr.data.equals(value)) { // if curr node's data is equal to value
				Type removed = curr.data; // store removed value

				if (size == 1) { // if list has only one node
					tail = null;
					size = 0;
					return removed;
				}

				prev.next = curr.next; // set next of previous node to next of curr node
				// this disconnects curr node as previous node's next points to node after curr

				if (curr == tail) { // if curr node is tail
					tail = prev; // update tail to previous node (previous node is now tail)
				}

				size--; // decrement size
				return removed;
			}

			prev = curr; // update previous node to current node
			curr = curr.next; // update current node to next node
		}

		return null;
	}

	// remove node at given index
	@Override
	public Type removeAtIndex(int index) {
		if (index < 0 || index >= size) { // if index is out of bounds
			throw new IndexOutOfBoundsException("Index out of bounds: " + index);
		}

		if (size == 1) { // if list has only one node
			Type removed = tail.data;
			tail = null;
			size = 0;
			return removed;
		}

		ListNode<Type> curr = tail.next; // node to traverse, start at head
		ListNode<Type> prev = tail; // previous node, start at tail

		for (int i = 0; i < index; i++) { // iterate through list until index is reached
			prev = curr; // update previous node to current node
			curr = curr.next; // update current node to next node
		}

		Type removed = curr.data; // store removed value

		prev.next = curr.next; // set next of previous node to next of curr node
		// this disconnects curr node as previous node's next points to node after curr

		if (curr == tail) { // if curr node is tail
			tail = prev; // update tail to previous node (previous node is now tail)
		}

		size--; // decrement size
		return removed;
	}

	// set value at given index
	@Override
	public void set(int index, Type value) {
		if (index < 0 || index >= size) { // if index is out of bounds
			throw new IndexOutOfBoundsException("Index out of bounds: " + index);
		}

		if (value == null) { // if value is null
			throw new NullPointerException("The value could not be null");
		}

		ListNode<Type> curr = tail.next; // node to traverse, start at head
		ListNode<Type> prev = tail; // previous node, start at tail

		for (int i = 0; i < index; i++) { // iterate through list until index is reached
			prev = curr; // update previous node to current node
			curr = curr.next; // update current node to next node
		}

		ListNode<Type> newNode = new ListNode<Type>(value, curr.next); // since ListNode.data is final, we can't change the current data, but we can disconnect the node and replace it with a new one
		// the second parameter is the where the new node will point to

		prev.next = newNode; // set next of previous node to newNode
		// this disconnects curr node as previous node's next points to node after curr

		if (curr == tail) { // if curr node is tail
			tail = newNode; // update tail to newNode
		}
	}

	// return value at given index
	@Override
	public Type get(int index) {
		if (index < 0 || index >= size) { // if index is out of bounds
			throw new IndexOutOfBoundsException("Index out of bounds: " + index);
		}

		ListNode<Type> curr = tail.next; // node to traverse, start at head
		for (int i = 0; i < index; i++) { // iterate through list until index is reached
			curr = curr.next; // update current node to next node
		}

		return curr.data;
	}
}