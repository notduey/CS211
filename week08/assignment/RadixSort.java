package week08.assignment;
/**
 * The class defines to sort the integer number in queue.
 * @author Varik Hoang <varikmp@uw.edu>
 */
public class RadixSort
{
	/**
	 * The number of digit queue.
	 */
	public static final int TEN_DIGITS = 10;
	
	/**
	 * The max digits in a number.
	 */
	public static final int MAX_DIGITS = 4;
	
	/**
	 * The method sort the queue using radix sort.
	 * @param master the queue
	 */
	public static void sort(Deque<Integer> master)
	{
		@SuppressWarnings("unchecked")
		Deque<Integer>[] buckets = new LinkedDeque[TEN_DIGITS];
		for (int index = 0; index < TEN_DIGITS; index++)
			buckets[index] = new LinkedDeque<Integer>();
		
		int divisor = 1;

		for (int pass = 0; pass < MAX_DIGITS; pass++) { // MAX_DIGITS = 4 passes
			while (!master.isEmpty()) { // move everything from master to buckets
				int value = master.removeFront(); // take number from front of master
				int digit = (value / divisor) % TEN_DIGITS; // extract digit
				buckets[digit].addRear(value); // add back to bucket
			}

			for (int digit = 0; digit < TEN_DIGITS; digit++) { // move everything back to master
				while (!buckets[digit].isEmpty()) { // remove from front of bucket entil empty
					master.addRear(buckets[digit].removeFront()); // add back to master in order
				}
			}

			divisor *= TEN_DIGITS; // move to next digit place
		}
	}
}