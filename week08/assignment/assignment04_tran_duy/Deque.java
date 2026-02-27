
public interface Deque<Type>
extends Queue<Type>
{
	/**
	 * The method adds element to the back
	 * @param data the element is added to the back
	 */
	void addRear(Type data);
	
	/**
	 * The method adds element to the front
	 * @param data the element is added to the front
	 */
	void addFront(Type data);
	
	/**
	 * The method removes element from the back
	 */
	Type removeRear();
	
	/**
	 * The method removes element from the front
	 */
	Type removeFront();
	
	/**
	 * The method examines element from the back
	 */
	Type peekRear();
	
	/**
	 * The method examines the element from the front
	 */
	Type peekFront();
}