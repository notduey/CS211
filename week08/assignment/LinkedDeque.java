package week08.assignment;
/**
 * The class defines the node-based queue
 * @author Varik Hoang <varikmp@uw.edu>
 * @param <Type> the generic data type
 */
public class LinkedDeque<Type>
extends LinkedQueue<Type>
implements Deque<Type>
{
	/**
	 * The constructor initializes an empty queue.
	 */
	public LinkedDeque()
	{
		super(); // super calls the constructor of LinkedQueue
	}
	
	@Override
	public void addRear(Type data)
	{
		add(data); // inherited from LinkedQueue, adds to tail, increments size	
	}

	@Override
	public void addFront(Type theElement)
	{
		head = new Node(theElement, head); // create new node that points to current head

		if (size == 0) { // if queue is empty, head is also tail
			setTail(head); // tail is private variable, call setTail instead
		}

		size++;		
	}

	@Override
	public Type removeRear()
	{
		if (size == 0) { // if queue is empty
			throw new EmptyCollectionException("queue");
		}

		Type result; // initialize result

		if (size == 1) { // if queue has only one element
			result = head.data; // result is head data
			head = null; // set head to null
			setTail(null); // set tail to null
		}
		else {
			Node current = head; // current points to head

			while (current.next.next != null) { // walk to node before tail
				current = current.next; // move to next node
			}

			result = current.next.data; // result is tail data

			setTail(current); // set tail to current
			current.next = null; // set next of current (now the new tail) to null
		}

		size--;
		return result;
	}
 
	@Override
	public Type removeFront()
	{
		return remove(); // inherited from LinkedQueue, removes head, decrements size
	}

	@Override
	public Type peekRear()
	{
		if (size == 0) { // if queue is empty
			throw new EmptyCollectionException("queue");
		}

		Node current = head;

		while (current.next != null) { // walk to tail
			current = current.next; // move to next node
		}

		return current.data; // return tail data
	}

	@Override
	public Type peekFront()
	{
		return peek(); // inherited from LinkedQueue, returns head data
	}
}