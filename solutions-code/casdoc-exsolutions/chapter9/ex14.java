package chapter9;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.groupingBy; //import the groupingBy method from the Collectors interface to group the movies by decade.

import static java.util.Comparator.comparing;

import static java.util.stream.Collectors.toList; 

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
     * Keyword: decade
     * decade is a helper fuction that returns the decade of a movie. For example, if the year of the movie is 2003, the decade of the movie is 2000s.
     */
    private static String decade(Movie pMovie) {
        return String.format("%02ds", ((pMovie.year() - 1900) % 100) / 10 * 10);
}

    public static void main(String[] args) 
    {
        /*?
         * Keyword: stream
         * This method returns a stream of movies from the movies() method.
         * 
         * Keyword: result
         * result is a Map that contains the decade of the movie as the key and a list of movies as the value for each decade.
         */
        Map<String, List<Movie>> result = Movies.movies().stream()
                /*?
                 * Keyword: collect
                 * The collect method is a method that collects the elements of a stream into a collection. In this case, the collect method collects the stream of movies into a Map. The collect method takes a Collector as a parameter. The collector in this case is the groupingBy method from the Collectors interface.
                 * 
                 * Keyword: groupingBy
                 * The groupingBy method takes a Function as a parameter and groups the elements of the stream by the value returned by the Function. In this case, the Function is the decade method. The groupingBy method returns a Collector that collects the stream of movies into a Map of movies grouped by decade.
                 */
                .collect(groupingBy(Movies::decade));

    }

}

