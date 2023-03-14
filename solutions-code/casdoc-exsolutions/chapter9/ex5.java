package chapter9;

import java.util.Arrays;
import java.util.List;

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

    /*?
     * Keyword: compareByTime
     * The compareByTime method compares two movies by time. The method returns a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
     */
    private static int compareByTime(Show pShow1, Show pShow2)
    {
       return pShow1.time() - pShow2.time();
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
         * The sort method sorts the list of movies. We pass a method reference to the sort method to sort the list of movies by time.
         * 
         * Internal: method reference
         * sort
         * A method reference is a reference to a method. We can pass a method reference to a method that expects a functional interface. The method reference is a shortcut for a lambda expression. A method reference consists of a class name, a double colon (::), and a method name. The method reference is equivalent to a lambda expression that takes the same number of arguments as the method and passes the arguments to the method.
         */
        movies.sort(Movies::compareByTime);

    }

}

