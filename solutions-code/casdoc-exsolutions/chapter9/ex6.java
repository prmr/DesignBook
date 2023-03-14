package chapter9;

import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing; //import the comparing method from the Comparator interface to compare movies by time.


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
         * Keyword: movies
         * movies is a list of movies returned by the movies method.
         */
        List<Movie> movies = Movies.movies();
        /*?
         * Keyword: sort
         * The sort method sorts the list of movies using the comparing method from the Comparator interface.
         * 
         * Keyword: comparing
         * The comparing method takes a function that returns a value to compare. In this case, the function returns the time of the movie.
         * 
         * Keyword: thenComparing
         * The thenComparing method takes a function that returns a value to compare. In this case, the function returns the title of the movie. This creates a comparator that compares movies by time and then by title.
         */
        movies.sort(comparing(Movie::time).thenComparing(Movie::title));
    }

}

