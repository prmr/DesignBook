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

    /**
     * @pre pMinutes >= 0
     * @param pMinutes
     * @return String
     */
    /*?
     * Keyword: toHHMM
     * This method converts minutes to hours and minutes in the format HH:MM (e.g. 2:15) and returns the result as a string.
     */
    private static String toHHMM(int pMinutes) {
        assert pMinutes >= 0;
        return String.format("%d:%02d", pMinutes / 60, pMinutes % 60);
    }

    public static void main(String[] args) 
    {

        /*?
         * Keyword: stream
         * The stream method returns a stream of movies from the list of movies. A stream is a sequence of elements that supports various methods to perform computations upon the elements.
         */
        Movies.movies().stream()
                /*?
                * Keyword: map
                * The map method takes a function that returns a value to map. In this case, the function returns the time of the movie. The map method returns a stream of the mapped values (i.e. the times of the movies).
                */
                .map(Movie::time)
                /*?
                * Keyword: map
                * The map method takes a function that returns a value to map. In this case, the function returns the time of the movie in hours and minutes. The map method returns a stream of the mapped values (i.e. the times of the movies in hours and minutes).
                */
                .map(Movies::toHHMM)
                /*?
                * Keyword: forEach
                * The forEach method takes a function that returns a value to perform. In this case, the function prints the time of the movie in hours and minutes. The forEach method returns a stream of the mapped values (i.e. the times of the movies in hours and minutes). The forEach method is a terminal operation, which means that it is the last operation in the stream pipeline.
                */
                .forEach(System.out::println);
       
    }

}

