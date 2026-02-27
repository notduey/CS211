/**
 * The class represents the exception when a collection is empty.
 * @author Varik Hoang <varikmp@uw.edu>
 */
public class EmptyCollectionException extends RuntimeException
{
	private static final long serialVersionUID = 8084488539524488189L;

	/**
	 * The constructor sets up this exception with an appropriate message.
	 * @param message the error message
	 */
	public EmptyCollectionException(final String message)
	{
		super(message);
	}
}