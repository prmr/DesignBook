package chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;


public class CompositeShow implements Show
{
	private List<Show> aShows = new ArrayList<>();
	
	//constructor that takes a variable number of shows as arguments
	public CompositeShow(Show...pShows)
	{
		if( pShows.length < 2 || pShows.length > 5)
		{
			/*?
			 * Keyword: IllegalArgumentException
			 * Thrown to indicate that a method has been passed an illegal or inappropriate argument.
			 */
			throw new IllegalArgumentException("Arguments should be between two and five shows inclusively");
		}
		/*?
		 * Keyword: addAll
		 * Adds all of the elements in the specified collection to this list. addAll() is a method in the List interface that takes a collection as a parameter and adds all of the elements in the collection to the list. Here, we use it to add all of the elements in the array pShows to the list aShows.
		 * 
		 */
		aShows.addAll(Arrays.asList(pShows));
	}
	
	@Override
	/*?
	 * Keyword: description
	 * Returns a string representation of the composite show. description() is a method in the Show interface that returns a string representation of the show. Here, we use it to return a string representation of the composite show by using StringJoiner to join the descriptions of the shows in the composite show.
	 */
	public String description()
	{
		/*?
		 * Keyword: StringJoiner
		 * StringJoiner is a class that takes a delimiter, prefix, and suffix as parameters and joins strings with the delimiter and prefix and suffix. Here, we use it to join the descriptions of the shows in the composite show with a semicolon and space as the delimiter, a left square bracket as the prefix, and a right square bracket as the suffix.
		 */
		StringJoiner description = new StringJoiner("; ", "[", "]");
		for( Show show : aShows )
		{
			description.add(show.description());
		}
		return description.toString();
	}

	@Override
    /*?
     * Keyword: runningTime
     * Returns the running time of the composite show. runningTime() is a method in the Show interface that returns the running time of the show. Here, we use it to return the running time of the composite show by adding the running times of the shows in the composite show.
     */
	public int runningTime()
	{
		int time = 0;
		for( Show show : aShows )
		{
			time += show.runningTime();
		}
		return time;
	}

	@Override
	/*?
	 * Keyword: copy
	 * Returns a copy of the composite show. copy() is a method in the Show interface that returns a copy of the show. Here, we use it to return a copy of the composite show by creating a list of copies of the shows in the composite show and then creating a new composite show with the copies of the shows in the list.
	 */
	public Show copy()
	{
		List<Show> copies = new ArrayList<>();
		for( Show show : aShows )
		{
			copies.add(show.copy());
		}
		/*?
		 * Keyword: toArray
		 * Returns an array containing all of the elements in this list in proper sequence (from first to last element). toArray() is a method in the List interface that returns an array containing all of the elements in the list. Here, we use it to return an array containing all of the copies of the shows in the composite show.
		 */
		return new CompositeShow(copies.toArray(new Show[copies.size()]));
	}

	@Override
	/*?
	 * Keyword: hashCode
	 * Returns a hash code value for the object. This method is supported for the benefit of hash tables such as those provided by HashMap. hashCode() is a method in the Object class that returns a hash code value for the object. Here, we use it to return a hash code value for the composite show by using Objects.hash() to hash the list of shows in the composite show.
	 *
	 */
	public int hashCode()
	{
		/*?
		 * Keyword: Objects.hash
		 * Returns a hash code value for the arguments. hash() is a static method in the Objects class that returns a hash code value for the arguments. Here, we use it to return a hash code value for the list of shows in the composite show. The hash code of a list is computed by calling hash() on each of the elements in the list.
		 */
		return Objects.hash(aShows);
	}

	@Override
	/*?
	 * Keyword: equals
	 * Indicates whether some other object is "equal to" this one. equals() is a method in the Object class that indicates whether some other object is "equal to" this one. Here, we are trying to define equality for the composite show. We define two composite shows to be equal if they contain the same shows. We use Objects.equals() to compare the lists of shows in the two composite shows to determine if they are equal.
	 */
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompositeShow other = (CompositeShow) obj;
		return Objects.equals(aShows, other.aShows);
	}
}

public class Client
{
	// Create some shows for testing: a concert, and two movies
	private static final Concert CONCERT = new Concert("Concert 1", "Artist X", 100);
	private static final Movie MOVIE1 = new Movie("Movie 1", 2017, 120);
	private static final Movie MOVIE2 = new Movie("Movie 2", 2018, 130);
	
	public static void main(String[] args)
	{
        /*?
         * Keyword: exercise1
         * A composite show that contains a concert and a composite show that contains a concert and two movies. The two movies are contained in a composite show so this composite show contains a concert and a composite show that contains two movies.
         */
		CompositeShow exercise1 = new CompositeShow(
				CONCERT,
				new CompositeShow(
						MOVIE1,
						MOVIE2
						));
		System.out.println(exercise1.description()); // prints [Concert 1; [Movie 1; Movie 2]]
    }
}

