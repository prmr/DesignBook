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
     * Keyword: createByTimeComparator
     * This method returns a comparator that compares movies by time using a lambda expression.
     * 
     * Internal: comparator
     * createByTimeComparator
     * A comparator is an object that compares two objects. The compare method of the Comparator interface is used to compare two objects. It returns a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second. It is used to sort a list of objects.
     */
    private static Comparator<Show> createByTimeComparator() {
        /*?
         * Keyword: (show1, show2)
         * The lambda expression takes two parameters: show1 and show2, and then compares the time of the two shows and returns the difference.
         */
        return (show1, show2) -> show1.time() - show2.time();
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
         * The sort method sorts the list of movies using the comparator returned by a lambda expression.
         */
        movies.sort((movie1, movie2) -> movie1.time() - movie2.time());

        //We can also use the createByTimeComparator method directly in the sort method.
        movies.sort(createByTimeComparator());

    }

}

