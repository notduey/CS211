package week06.assignment;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The abstract class provides basic structure of the circular
 * linked list with the tail and size references
 * 
 * @author Varik Hoang <varikmp@uw.edu>
 *
 * @param <Type> is any object type
 */
public abstract class AbstractList<Type>
implements List<Type>
{
	/**
	 * The reference to the last element
	 */
	protected ListNode<Type> tail;

	/**
	 * The size of the list
	 */
	protected int size;

	/**
	 * The constructor that initiate the tail and size references
	 */
	public AbstractList()
	{
		tail = null;
		size = 0;
	}

	@Override
	public int getSize()
	{
		return size;
	}

	@Override
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	@Override
	public int getIndex(final Type value)
	{
		if (value == null)
			throw new NullPointerException("The value could not be null");
		
		if (tail == null)
			return -1;
		
		ListNode<Type> current = tail.next; // point to head
		for (int index = 0; index < size; index++)
		{
			if (current.data.equals(value))
				return index;
			current = current.next;
		}

		return -1;
	}
	
	@Override
	public String toString()
	{
		if (size == 0)
			return "[]";

		StringBuilder builder = new StringBuilder();
		builder.append("[");

		ListNode<Type> current = tail.next; // head node
		while (current != tail)
		{
			builder.append(current.data).append(",").append(" ");
			current = current.next;
		}
		builder.append(tail.data);

		builder.append("]");
		return builder.toString();
	}

	/**
	 * Returns an iterator for this list.
	 * 
	 * @return an iterator for the list.
	 */
	public Iterator<Type> iterator()
	{
		return new LinkedIterator();
	}

	/**
	 * Represents a list node.
	 * 
	 * @author Building Java Programs 3rd ed.
	 * @param <Type> is of any object type
	 */
	protected static class ListNode<Type>
	{
		/**
		 * Data stored in this node.
		 */
		public final Type data;

		/**
		 * Link to next node in the list.
		 */
		public ListNode<Type> next;

		/**
		 * Constructs a node with given data and a null link.
		 * 
		 * @param data assigned
		 */
		public ListNode(Type data)
		{
			this(data, null);
		}

		/**
		 * Constructs a node with given data and given link.
		 * 
		 * @param data assigned
		 * @param next assigned
		 */
		public ListNode(Type data, ListNode<Type> next)
		{
			this.data = data;
			this.next = next;
		}
		
		/**
		 * The method returns the generic data type as string
		 */
		public String toString()
		{
			return this.data.toString();
		}
	}

	/**
	 * The iterator class for the list.
	 * 
	 * @author modified from BuildingJavaPrograms 3rd Edition
	 */
	public class LinkedIterator implements Iterator<Type>
	{
		/**
		 * Location of current value to return.
		 */
		private ListNode<Type> current;

		/**
		 * The flag that tells if the first node has been visited.
		 */
		private boolean visited;

		/**
		 * Constructs an iterator for the given list.
		 */
		public LinkedIterator()
		{
			reset();
		}

		/**
		 * Returns whether there are more list elements.
		 * 
		 * @return true if there are more elements left, false otherwise
		 * @see java.util.Iterator#hasNext()
		 */
		public boolean hasNext()
		{
			if (tail != null)
				return !(current == tail.next && visited);
			else
				return false;
		}

		/**
		 * Returns the next element in the iteration.
		 * 
		 * @throws NoSuchElementException if no more elements.
		 * @return the next element in the iteration.
		 * @see java.util.Iterator#next()
		 */
		public Type next()
		{
			if (!hasNext())
			{
				throw new NoSuchElementException();
			}
			Type result = current.data;
			current = current.next;
			visited = true;
			return result;
		}

		/**
		 * This method is not supported
		 */
		public void remove()
		{
			throw new IllegalStateException("This iterator does not support remove operation");
		}

		/**
		 * The method resets back to the beginning.
		 */
		public final void reset()
		{
			if (tail != null)
				current = tail.next;
			visited = false;
		}
	}
	
}