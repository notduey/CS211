package week06.assignment;

/**
 * The class represents for the circular sorted linked list
 * @author Varik Hoang <varikmp@uw.edu>
 * @author FIRST_NAME LAST_NAME
 * @param <Type> the generic data type
 */
public class SortedList<Type extends Comparable<? super Type>>
extends AbstractList<Type>
implements List<Type>
{
	/**
	 * The constructor for the circular sorted linked list.
	 */
	public SortedList()
	{
		super();
	}
	
	@Override
	public boolean contains(Type value)
	{
		return getIndex(value) >= 0;
	}

	// add value to sorted list
	@Override
	public void insert(Type value)
	{
		if (value == null) {
			throw new NullPointerException("The value could not be null");
		}

		ListNode<Type> newNode = new ListNode<Type>(value);

		if (tail == null) { // if list is empty
			tail = newNode; // set tail to newNode
			tail.next = tail; // set next of tail to itself
			size++;
			return;
		}

		ListNode<Type> head = tail.next;

		if (value.compareTo(head.data) <= 0) { // if value less than or equal to head data
			// add to beginning of sorted list
			newNode.next = head;
			tail.next = newNode;
			size++;
			return;
		}

		if (value.compareTo(tail.data) >= 0) { // if value greater than or equal to tail data
			// add to end of sorted list
			newNode.next = head;
			tail.next = newNode;
			tail = newNode;
			size++;
			return;
		}

		// start at node after head because head case is already handled
		ListNode<Type> curr = head.next;
		ListNode<Type> prev = head;

		while (curr != head && value.compareTo(curr.data) <= 0) { // iterate through list until value is less than or equal to curr data, curr != head is to avoid infinite loop
			prev = curr;
			curr = curr.next;
		}

		newNode.next = curr;
		prev.next = newNode;
		size++;
	}

	@Override
	public void clear()
	{
		tail = null;
		size = 0;
		
	}

	// remove value from sorted list
	@Override
	public Type remove(Type value)
	{
		if (value == null) {
			throw new NullPointerException("The value could not be null");
		}

		if (tail == null) { // if list is empty
			return null;
		}

		ListNode<Type> curr = tail.next; // node to traverse, start at head
		ListNode<Type> prev = tail; // previous node, start at tail

		for (int i = 0; i < size; i++) {
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

				size--;
				return removed;
			}
			// if value is greater than curr node's data, value is not in list so we can end loop early
			else if (value.compareTo(curr.data) > 0) {
				return null;
			}

			prev = curr;
			curr = curr.next;
		}

		return null;
	}

	// remove node at given index, same code as in UnsortedList
	@Override
	public Type removeAtIndex(int index)
	{
		if (index < 0 || index >= size) { // if index is out of bounds
			throw new IndexOutOfBoundsException("Index out of bounds: " + index);
		}

		if (size == 1) { // if list has only one node
			Type removed = tail.data;
			tail = null;
			size = 0;
			return removed;
		}

		ListNode<Type> curr = tail.next;
		ListNode<Type> prev = tail;

		for (int i = 0; i < index; i++) { // iterate through list until index is reached
			prev = curr;
			curr = curr.next;
		}

		Type removed = curr.data;

		prev.next = curr.next; // set next of previous node to next of curr node
		// this disconnects curr node as previous node's next points to node after curr

		if (curr == tail) { // if curr node is tail
			tail = prev; // update tail to previous node (previous node is now tail)
		}

		size--; // decrement size
		return removed;
	}

	@Override
	public void set(int index, Type value)
	{
		throw new UnsupportedOperationException("The SortedList does not support set method");
	}

	// get value at given index, same code as in UnsortedList
	@Override
	public Type get(int index)
	{
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