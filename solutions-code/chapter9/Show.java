package chapter9;

/**
 * Represents a performance that can take place in a theater.
 */
public interface Show
{
	/**
	 * @return A description of the show.
	 */
	String description();
	
	/**
	 * @return The running time in minutes of the show.
	 */
	int time();
}
