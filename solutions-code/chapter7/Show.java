package chapter7;

/**
 * Represents a performance that can take place in a theater.
 */
public interface Show
{
	/**
	 * @return The title of the show.
	 */
	String title();
	
	/**
	 * @return A description of the show.
	 */
	String description();
	
	/**
	 * @return The total time required for the show.
	 */
	int time();
}
