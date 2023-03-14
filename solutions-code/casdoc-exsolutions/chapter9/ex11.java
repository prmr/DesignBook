package chapter9;

import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing; //import the comparing method from the Comparator interface to compare movies by time.

import static java.util.stream.Collectors.toList; //import the toList method from the Collectors interface to collect the stream of movies into a list.


public class Movies
{
	public static final Movie OLDBOY = new Movie("Oldboy", 2003, 121);
	public static final Movie METROPOLIS = new Movie("Metropolis", 1927, 153);
	public static final Movie WAGES = new Movie("The Wages of Fear", 1953, 131);
	public static final Movie INTOUCHABLES = new Movie("The Intouchables", 2011, 112);
	public static final Movie AMELIE = new Movie("Amelie", 2001, 121);
	public static final Movie GOODBAD = new Movie("The Good, the Bad, and the Ugly", 1966, 178);
	public static final Movie DIABOLIQUE = new Movie("Diabolique", 1955, 117);
	public static final Movie JOAN = new Movie("The Passion of Joan of Arc", 1928, 114);

	/*?
     * Keyword: movies
     * This method returns a list of movies.
     */
	public static final List<Movie> movies()
	{
	    return Arrays.asList(OLDBOY, METROPOLIS, WAGES, INTOUCHABLES, AMELIE, GOODBAD, DIABOLIQUE, JOAN);
    }

    public static void main(String[] args) 
    {
        /*?
         * Keyword: stream
         * This method returns a stream of movies.
         */
        long result = Movies.movies().stream()
                /*?
                 * Keyword: map
                 * The map method is used to map the stream of movies to a stream of titles using the title method.
                 */
                .map(Movie::title)
                /*?
                 * Keyword: map
                 * The map method is used to map the stream of titles to a stream of strings using the toLowerCase method.
                 * 
                 * Keyword: toLowerCase
                 * The toLowerCase method in the String class is used to convert the string to lowercase.
                 */
                .map(String::toLowerCase)
                /*?
                 * Keyword: flatMap
                 * The flatMap method is a special case of the map method where the stream of strings is mapped to a stream of strings using the split method.
                 * 
                 * Keyword: split
                 * The split method in the String class is used to split the string into an array of strings using the regular expression "[\\s,]+" which matches any whitespace or comma.
                 * 
                 * Keyword: stream
                 * The stream method in the Arrays class is used to return a sequential stream with the array as its source.
                 */
                .flatMap(string -> stream(string.split("[\\s,]+")))
                /*?
                 * Keyword: filter
                 * The filter method is used to filter the stream of strings to a stream of strings using the isEqual method. A filter is a predicate that returns true if the string is equal to "the".
                 * 
                 * Keyword: isEqual
                 * The isEqual method in the String class is used to compare the string to the string "the" and return true if they are equal.
                 */
                .filter(isEqual("the"))
                /*?
                 * Keyword: count
                 * The count method is used to count the number of elements in the stream. This is a terminal operation and returns a long value of the number of elements in the stream, which is the number of times the word "the" appears in the titles of the movies.
                 */
                .count();

        System.out.println(result);
    }

}

