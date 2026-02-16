package week06.assignment;

import java.util.Iterator;

/**
 * Represents List interface.
 * 
 * @author Varik Hoang
 * @version Sep 26, 2016
 * @param <Type> is of any object type.
 */
public interface List<Type>
{
	/**
	 * The method returns the current number of elements in the list.
	 * 
	 * @return the current number of elements in the list greater than or equal 0
	 */
	public int getSize();

	/**
	 * The method returns whether the list is empty.
	 * 
	 * @return true if list is empty, false otherwise.
	 */
	public boolean isEmpty();

	/**
	 * The method returns whether value is in the list.
	 * 
	 * @param value the value is assigned
	 * @return true if value in the list, false otherwise.
	 */
	public boolean contains(Type value);

	/**
	 * The method inserts an element into the list.
	 * 
	 * @param value the value is assigned
	 */
	public void insert(Type value);

	/**
	 * The method clears the list.
	 */
	public void clear();

	/**
	 * The method returns a string representation of list contents.
	 * 
	 * @return a string representation of list contents.
	 * @see Object#toString()
	 */
	@Override
	public String toString();

	/**
	 * /**
	 * The method removes first element occurrence from the list.
	 * 
	 * @param value the value is assigned
	 * @return the removed value
	 */
	public Type remove(Type value);

	/**
	 * The method returns the index of value.
	 * 
	 * @param value the value is assigned.
	 * @return the index of value if in the list, -1 otherwise.
	 */
	public int getIndex(Type value);

	/**
	 * The method removes value at the given index.
	 * 
	 * @param index the index must be in range of 0 and size
	 * @return the removed value
	 * @throws IndexOutOfBoundsException if index less than 0 or index greater than
	 *                                   or equal size
	 */
	public Type removeAtIndex(int index);

	/**
	 * The method replaces the value at the given index with the given value.
	 * 
	 * @param index the index must be in range of 0 and size
	 * @param value the value is assigned
	 * @throws IndexOutOfBoundsException if index less 0 or index greater than size
	 */
	public void set(int index, Type value);

	/**
	 * Returns the value at the given index in the list.
	 * 
	 * @param index the index must be in range of 0 and size
	 * @throws IndexOutOfBoundsException if index less than 0 or greater size
	 * @return the value at the given index in the list.
	 */
	public Type get(int index);

	/**
	 * The method returns an iterator for this list.
	 * 
	 * @return an iterator for the list.
	 */
	public Iterator<Type> iterator();
}