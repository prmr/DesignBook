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
         * This method returns a stream of movies from the movies() method.
         * 
         * Keyword: result
         * result is a Map that contains the title of the movie as the key and the runtime of the movie as the value.
         */
        Map<String, Integer> result = Movies.movies().stream()
                /*?
                 * Keyword: collect
                 * The collect method is a method that collects the elements of a stream into a collection. In this case, the collect method collects the stream of movies into a Map. The collect method takes a Collector as a parameter. The collector in this case is the toMap method from the Collectors interface.
                 * 
                 * Keyword: toMap
                 * The toMap method takes two parameters. The first parameter is a Function that takes a Movie object as a parameter and returns the title of the movie. The second parameter is a Function that takes a Movie object as a parameter and returns the runtime of the movie. The toMap method returns a Collector that collects the stream of movies into a Map.
                 */
                .collect(toMap(Movie::title, Movie::time));

    }

}

