package week08.assignment;

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
		assertEquals(0, myQueue.size());
    	assertTrue(myQueue.isEmpty());
	}

	@Test
	void testAddRear1()
	{
    	myQueue.addRear(5);
    	assertEquals(1, myQueue.size());
    	assertEquals("head -> 5", myQueue.toString());
	}

	@Test
	void testAddRear2()
	{
		myQueue.addRear(5);
    	myQueue.addRear(7);
    	assertEquals(2, myQueue.size());
    	assertEquals("head -> 5, 7", myQueue.toString());
	}

	@Test
	void testAddFront1()
	{
		myQueue.addFront(5);
    	assertEquals(1, myQueue.size());
    	assertEquals("head -> 5", myQueue.toString());
	}

	@Test
	void testAddFront2()
	{
    	myQueue.addFront(5);
    	myQueue.addFront(7);  // should become new head
    	assertEquals(2, myQueue.size());
    	assertEquals("head -> 7, 5", myQueue.toString());	
	}

	@Test
	void testAddFrontRear1()
	{
		myQueue.addFront(2);  // [2]
		myQueue.addRear(3);   // [2,3]
    	myQueue.addFront(1);  // [1,2,3]
    	assertEquals(3, myQueue.size());
    	assertEquals("head -> 1, 2, 3", myQueue.toString());	
	}
	
	@Test
	void testAddFrontRear2()
	{
	    myQueue.addRear(2);   // [2]
    	myQueue.addFront(1);  // [1,2]
    	myQueue.addRear(3);   // [1,2,3]
    	assertEquals(3, myQueue.size());
    	assertEquals("head -> 1, 2, 3", myQueue.toString());
	}

	@Test
	void testRemoveRear1()
	{
	    myQueue.addRear(1);
    	myQueue.addRear(2);
    	myQueue.addRear(3); // [1,2,3]

	    assertEquals(3, (int) myQueue.removeRear()); // removed value
    	assertEquals(2, myQueue.size());
    	assertEquals("head -> 1, 2", myQueue.toString());
	}
	
	@Test
	void testRemoveRear2()
	{
		myQueue.addRear(1);
    	myQueue.addRear(2);
    	myQueue.addRear(3); // [1,2,3]

    	assertEquals(3, (int) myQueue.removeRear());
    	assertEquals(2, (int) myQueue.removeRear());
    	assertEquals(1, myQueue.size());
    	assertEquals("head -> 1", myQueue.toString());
	}
	
	@Test
	void testRemoveFront1()
	{
		myQueue.addRear(1);
    	myQueue.addRear(2);
    	myQueue.addRear(3); // [1,2,3]

	    assertEquals(1, (int) myQueue.removeFront());
	    assertEquals(2, myQueue.size());
	    assertEquals("head -> 2, 3", myQueue.toString());
	}
	
	@Test
	void testRemoveFront2()
	{
    	myQueue.addRear(1);
    	myQueue.addRear(2);
    	myQueue.addRear(3); // [1,2,3]

    	assertEquals(1, (int) myQueue.removeFront());
    	assertEquals(2, (int) myQueue.removeFront());
    	assertEquals(1, myQueue.size());
    	assertEquals("head -> 3", myQueue.toString());
	}
	
	@Test
	void testPeekRear()
	{
		myQueue.addRear(1);
    	myQueue.addRear(2);
    	myQueue.addRear(3); // [1,2,3]

    	assertEquals(3, (int) myQueue.peekRear());
    	assertEquals(3, myQueue.size()); // peek should not remove
    	assertEquals("head -> 1, 2, 3", myQueue.toString());
	}
	
	@Test
	void testPeekFront()
	{
		myQueue.addRear(1);
    	myQueue.addRear(2);
    	myQueue.addRear(3); // [1,2,3]

    	assertEquals(1, (int) myQueue.peekFront());
    	assertEquals(3, myQueue.size()); // peek should not remove
    	assertEquals("head -> 1, 2, 3", myQueue.toString());
	}
}