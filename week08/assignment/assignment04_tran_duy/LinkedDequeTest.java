import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The class is a unit testing for the {@link LinkedDeque}
 * 
 * @author Varik Hoang <varikmp@uw.edu>
 */
public class LinkedDequeTest
{

	/**
	 * A generic simple LinkedDeque to test.
	 */
	private LinkedDeque<Integer> myQueue;

	/**
	 * The method initializes the queue before the test.
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception
	{
		myQueue = new LinkedDeque<>();
	}

	/**
	 * Test method for{@link LinkedDeque#LinkedDeque()}.
	 */
	@Test
	void testLinkedDeque()
	{
		// TODO Do nothing but check the size and if the queue is empty.
		
	}

	@Test
	void testAddRear1()
	{
		// TODO Add one element to the back and check size and queue in string format.
		
	}

	@Test
	void testAddRear2()
	{
		// TODO Add two elements to the back and check size and queue in string format.
		
	}

	@Test
	void testAddFront1()
	{
		// TODO Add one element to the front and check size and queue in string format.
		
	}

	@Test
	void testAddFront2()
	{
		// TODO Add two elements to the front and check size and queue in string format.
		
	}

	@Test
	void testAddFrontRear1()
	{
		// TODO Add three elements to the front and/or back then check size and queue in string format.
		
	}
	
	@Test
	void testAddFrontRear2()
	{
		// TODO Add three elements to the front and/or back then check size and queue in string format.
		
	}

	@Test
	void testRemoveRear1()
	{
		// TODO Remove the element from the back once then check size and queue in string format.
		
	}
	
	@Test
	void testRemoveRear2()
	{
		// TODO Remove the element from the back twice then check size and queue in string format.
		
	}
	
	@Test
	void testRemoveFront1()
	{
		// Remove the element from the front once then check size and queue in string format.
		
	}
	
	@Test
	void testRemoveFront2()
	{
		// TODO Remove the element from the front twice then check size and queue in string format.
		
	}
	
	@Test
	void testPeekRear()
	{
		// TODO Examine the element from the back then check size and queue in string format.
		
	}
	
	@Test
	void testPeekFront()
	{
		// TODO Examine the element from the front then check size and queue in string format.
		
	}
}