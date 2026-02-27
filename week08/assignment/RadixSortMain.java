package week08.assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * The main class of the program
 * @author Varik Hoang <varikmp@uw.edu>
 */
public class RadixSortMain
{
	/**
	 * The main method of the program
	 * @param theArguments the arguments of the program
	 * @throws FileNotFoundException
	 */
	public static void main(String[] theArguments) throws FileNotFoundException
	{
		Deque<Integer> master = new LinkedDeque<Integer>();
		readFileIntoDeque("week08/assignment/input100.txt", master);
		RadixSort.sort(master);
		writeDequeToFile("week08/assignment/output100.txt", master);
	}
	
	/**
	 * The method reads all elements from the input file into queue
	 * @param filename the input file
	 * @param queue the queue
	 * @throws FileNotFoundException
	 */
	public static void readFileIntoDeque(String filename, Deque<Integer> queue) throws FileNotFoundException
	{
		Scanner input = new Scanner(new File(filename));
		while (input.hasNext())
		{
			queue.addRear(input.nextInt());
		}
		input.close();
	}
	
	/**
	 * The method removes all elements in queue and writes them to output file
	 * @param filename the output file name
	 * @param queue the queue
	 * @throws FileNotFoundException
	 */
	public static void writeDequeToFile(String filename, Deque<Integer> queue) throws FileNotFoundException
	{
		PrintStream output = new PrintStream(new FileOutputStream(filename));
		while (!queue.isEmpty()) {
			output.println(queue.removeFront());
		}
		output.close();
	}
}