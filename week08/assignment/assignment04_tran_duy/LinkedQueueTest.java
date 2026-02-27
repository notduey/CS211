import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The class is a unit testing for the {@link LinkedQueue}
 * 
 * @author Varik Hoang <varikmp@uw.edu>
 */
public class LinkedQueueTest
{
	/**
	 * A generic simple LinkedQueue to test.
	 */
	private LinkedQueue<Integer> myQueue;

	/**
	 * The method initializes the queue before the test.
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception
	{
		myQueue = new LinkedQueue<>();
	}

	/**
	 * Test method for{@link LinkedQueue#LinkedQueue()}.
	 */
	@Test
	void testLinkedQueue()
	{
		assertNotNull("myQueue was not instantiated!", myQueue);
		assertEquals("myQueue should be size zero!", 0, myQueue.size());
		assertTrue("myQueue should be empty!", myQueue.isEmpty());
	}

	@Test
	void testLinkedQueueAdd1()
	{
		myQueue.add(6);
		assertEquals("add failed: queue size expected 1 instead of " + myQueue.size(), 1, myQueue.size());
		assertEquals("to string failed: expected head -> 6 instead of " + myQueue.toString(), myQueue.toString(),
				"head -> 6");
	}

	@Test
	void testLinkedQueueAdd2()
	{
		myQueue.add(6);
		myQueue.add(-12);
		assertEquals("add failed: queue size expected 2 instead of " + myQueue.size(), 2, myQueue.size());
		assertEquals("to string failed: expected head -> 6, -12 instead of " + myQueue.toString(), myQueue.toString(),
				"head -> 6, -12");
	}

	@Test
	void testLinkedQueueAdd3()
	{
		myQueue.add(6);
		myQueue.add(-12);
		myQueue.add(5025);
		assertEquals("add failed: queue size expected 3 instead of " + myQueue.size(), 3, myQueue.size());
		assertEquals("to string failed: expected head -> 6, -12, 5025 instead of " + myQueue.toString(),
				myQueue.toString(), "head -> 6, -12, 5025");
	}

	@Test
	void testLinkedQueueAddNull()
	{
		myQueue.add(6);
		myQueue.add(null);
		myQueue.add(-12);
		assertEquals("add failed: queue size expected 3 instead of " + myQueue.size(), 3, myQueue.size());
		assertEquals("to string failed: expected head -> 6, null, -12 instead of " + myQueue.toString(),
				myQueue.toString(), "head -> 6, null, -12");
	}

	@Test
	void testLinkedQueueRemove1()
	{
		myQueue.add(6);
		myQueue.remove();
		assertEquals("add failed: queue size expected 0 instead of " + myQueue.size(), 0, myQueue.size());
		assertEquals("to string failed: expected head -> instead of " + myQueue.toString(), myQueue.toString(),
				"head ->");
	}

	@Test
	void testLinkedQueueRemove2()
	{
		myQueue.add(6);
		myQueue.add(-12);
		myQueue.remove();
		assertEquals("add failed: queue size expected 1 instead of " + myQueue.size(), 1, myQueue.size());
		assertEquals("to string failed: expected head -> -12 instead of " + myQueue.toString(), myQueue.toString(),
				"head -> -12");
	}

	@Test
	void testLinkedQueueRemove3()
	{
		myQueue.add(6);
		myQueue.add(-12);
		myQueue.add(5025);
		myQueue.remove();
		assertEquals("add failed: queue size expected 2 instead of " + myQueue.size(), 2, myQueue.size());
		assertEquals("to string failed: expected head -> -12, 5025 instead of " + myQueue.toString(),
				myQueue.toString(), "head -> -12, 5025");
	}

	@Test
	void testLinkedQueueRemove4()
	{
		myQueue.add(6);
		myQueue.add(-12);
		myQueue.add(5025);
		myQueue.add(0);
		myQueue.remove();
		myQueue.remove();
		assertEquals("add failed: queue size expected 2 instead of " + myQueue.size(), 2, myQueue.size());
		assertEquals("to string failed: expected head -> 5025, 0 instead of " + myQueue.toString(), myQueue.toString(),
				"head -> 5025, 0");
	}

	@Test
	void testLinkedQueuePeek1()
	{
		myQueue.add(6);
		assertEquals("add failed: queue size expected 1 instead of " + myQueue.size(), 1, myQueue.size());
		assertTrue("peek failed: expected 6", myQueue.peek() == 6);
	}

	@Test
	void testLinkedQueuePeek2()
	{
		myQueue.add(6);
		myQueue.add(-12);
		assertEquals("add failed: queue size expected 2 instead of " + myQueue.size(), 2, myQueue.size());
		assertTrue("peek failed: expected 6", myQueue.peek() == 6);
	}

	@Test
	void testLinkedQueueIsEmpty()
	{
		assertEquals("add failed: queue size expected 0 instead of " + myQueue.size(), 0, myQueue.size());
		assertEquals("toString failed: expected head -> instead of " + myQueue.toString(), "head ->",
				myQueue.toString());
		assertTrue("isEmpty() failed: expected True", myQueue.isEmpty());
	}

	@Test
	public final void testLinkedQueueRemoveException()
	{
		try
		{
			myQueue.remove();
			assertTrue("exception: expected to throw EmptyCollectionException", false);
		}
		catch (EmptyCollectionException e)
		{
			assertTrue(true);
		}
	}

	@Test
	public final void testLinkedQueuePeekException()
	{
		try
		{
			myQueue.peek();
			assertTrue("exception: expected to throw EmptyCollectionException", false);
		}
		catch (EmptyCollectionException e)
		{
			assertTrue(true);
		}
	}
}