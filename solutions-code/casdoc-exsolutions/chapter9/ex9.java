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
         * The stream method returns a stream of movies from the list of movies. A stream is a sequence of elements that supports various methods to perform computations upon the elements, such as filtering, sorting, and mapping.
         * 
         * Keyword: mySelection
         * This variable stores the result of the stream operations, which is a list of movies.
         */
        List<Movie> mySelection = Movies.movies().stream()
                /*?
                * Keyword: filter
                * The filter method takes a predicate that returns a boolean value to filter. In this case, the predicate returns true if the movie was released before 2000. The filter method returns a stream of the filtered movies (i.e. the movies released before 2000).
                */
                .filter(movie -> movie.year() < 2000)
                /*?
                * Keyword: sorted
                * The sorted method takes a comparator that returns a boolean value to sort. In this case, the comparator returns true if the first movie was released before the second movie. The sorted method returns a stream of the sorted movies (i.e. the movies sorted by year).
                * 
                * Keyword: comparing
                * The comparing method takes as argument a function that returns a value to compare. In this case, the function returns the year of the movie. The comparing method returns a comparator that compares the movies by year. The comparing method in this case returns a comparator that compares the movies by year.
                * 
                * Keyword: reversed
                * The reversed method returns a comparator that compares the movies in the opposite order. In this case, the comparator compares the movies by year in descending order because the movies are sorted by year in ascending order by default.
                */
                .sorted(comparing(Movie::time).reversed())
                /*?
                * Keyword: limit
                * The limit method takes a number to limit the number of elements in the stream. In this case, the number is 3. The limit method returns a stream of the first 3 movies (i.e. the first 3 movies sorted by year in descending order).
                */
                .limit(3)
                /*?
                * Keyword: comparing
                * The comparing method takes as argument a function that returns a value to compare. In this case, the function returns the title of the movie. The comparing method returns a comparator that compares the movies by title. The comparing method in this case returns a comparator that compares the movies by title.
                *
                * Keyword: reversed
                * The reversed method returns a comparator that compares the movies in the opposite order. In this case, the comparator compares the movies by title in descending order because the movies are sorted by title in ascending order by default.
                */
                .sorted(comparing(Movie::title).reversed())
                /*?
                * Keyword: collect
                * The collect method takes a collector that collects the stream into a list. In this case, the collector is the toList method. The collect method returns a list of the movies (i.e. the first 3 movies sorted by year in descending order and then sorted by title in descending order).

                * Internal: collector
                * collect
                * a collector is a method that collects the stream into a list (e.g. toList) or a map (e.g. toMap) or a set (e.g. toSet). The collect method returns a list of the movies (i.e. the first 3 movies sorted by year in descending order and then sorted by title in descending order).
                */
                .collect(toList());
    }

}

