package week08.assignment;
/**
 * The class defines a node-based queue.
 * @author Varik Hoang <varikmp@uw.edu>
 * @param <Type> the generic data type
 */
public class LinkedQueue<Type>
implements Queue<Type>
{
	/**
	 * The number of elements contained in the queue.
	 */
	protected int size;

	/**
	 * A reference to the first node in the queue. (The 'head' of the queue.)
	 */
	protected Node head;

	/**
	 * A reference to the last node in the queue. (The 'tail' of the queue.)
	 */
	private Node tail;

	/**
	 * The constructor initializes an empty queue.
	 */
	public LinkedQueue()
	{
		size = 0;
		head = null;
		tail = null;
	}

	@Override
	public void add(final Type theElement)
	{
		if (size == 0)
		{
			// base case when the queue is empty
			head = new Node(theElement);
			tail = head;
		}
		else
		{
			// regular case when the queue is not empty
			tail.next = new Node(theElement);
			tail = tail.next;
		}
		size++;
	}

	@Override
	public Type remove()
	{
		if (size == 0)
			throw new EmptyCollectionException("queue");

		final Type returnValue = head.data;
		head = head.next;
		size--;
		return returnValue;
	}

	@Override
	public Type peek()
	{
		if (size == 0)
		{
			throw new EmptyCollectionException("queue");
		}
		return head.data;
	}

	@Override
	public int size()
	{
		return size;
	}

	@Override
	public boolean isEmpty()
	{
		return size == 0;
	}

	/**
	 * The method returns the linked queue in string format as below
	 * <p>
	 * The format of the returned String is: Head -> 8, 6, 7, 5, 3, 0, 9
	 */
	@Override
	public String toString()
	{
		if (size == 0)
			return "head ->";
		
		final StringBuilder buffer = new StringBuilder();
		buffer.append("head -> ");
		
		Node current = head;
		for (int i = 0; i < size - 1; i++)
		{
			buffer.append(current.data);
			buffer.append(", ");
			current = current.next;
		}
		buffer.append(current.data);
		
		return buffer.toString();
	}
	
	protected void setTail(Node last)
	{
		tail = last;
	}

	/**
	 * The class represents a node in a singly linked structure.
	 * 
	 * @author Varik Hoang <varikmp@uw.edu>
	 * @param <Type> generic data type
	 */
	protected class Node
	{
		/**
		 * A reference to the next node in the linked structure.
		 */
		protected Node next;

		/**
		 * A reference to the data element held in this node.
		 */
		protected final Type data;

		/**
		 * The constructor initializes the node using the specified data element.
		 * 
		 * @param data the data element held in this node
		 */
		Node(final Type data)
		{
			this(data, null);
		}

		/**
		 * The constructor initializes the node using the specified data element and the specified next
		 * node.
		 * 
		 * @param data the data element held in this node
		 * @param next the next node in the linked structure
		 */
		Node(final Type data, final Node next)
		{
			this.data = data;
			this.next = next;
		}
	}
}