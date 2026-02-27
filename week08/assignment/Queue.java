package week08.assignment;
/**
 * The class defines the Queue interface
 * 
 * @author Varik Hoang <varikmp@uw.edu>
 * @param <Type> generic data type
 */
public interface Queue<Type>
{
	/**
	 * The method adds the specified element to the tail/rear/last of the queue.
	 * @param data the element to add to the queue
	 */
	void add(Type data);

	/**
	 * The method removes and returns the front/head element from the queue.
	 * @throws EmptyCollectionException if the queue is empty.
	 * @return the front/head element from the queue
	 */
	Type remove();

	/**
	 * The method eturns the front/head element from the queue (without removing the element.
	 * 
	 * @throws EmptyCollectionException if the queue is empty.
	 * @return the front element from the queue
	 */
	Type peek();

	/**
	 * The method indicates the number of elements in the queue
	 * 
	 * @return the count of elements currently in the queue
	 */
	int size();

	/**
	 * The method checks if the queue is empty or not
	 * 
	 * @return true if the queue contains no elements otherwise false
	 */
	boolean isEmpty();

}