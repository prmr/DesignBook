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
     * decade is a helper fuction that returns the decade of a movie. For example, if the year of the movie is 2003, the decade of the movie is 00s.
     */
    private static String decade(Movie pMovie) {
        return String.format("%02ds", ((pMovie.year() - 1900) % 100) / 10 * 10);
}

    public static void main(String[] args) 
    {
        /*?
         * Keyword: stream
         * This method returns a stream of movies from the movies() method.
         */
        Movies.movies().stream()
                /*?
                 * Keyword: collect
                 * The collect method is a method that collects the elements of a stream into a collection. In this case, the collect method collects the stream of movies into a Map. The collect method takes a Collector as a parameter. The collector in this case is the groupingBy method from the Collectors interface that groups the movies by decade and returns a Map that contains the decade as the key and a list of movies as the value for each key.
                 */
                .collect(groupingBy(Movies::decade))
                /*?
                 * Keyword: entrySet
                 * The entrySet method returns a Set of Map.Entry objects. Each Map.Entry object contains a key and a value for that key in the Map. In this case, the key is the decade and the value is a list of movies for that decade.
                 *
                 * Keyword: stream
                 * The stream method returns a stream of Map.Entry objects which is a stream of key-value pairs used in the filter method
                 */
                .entrySet().stream()
                /*?
                 * Keyword: filter
                 * The filter method filters the stream of Map.Entry objects by the decade. In this case, the filter method filters the stream of Map.Entry objects by the decade 50s and 60s using a lambda expression that returns true if the key is 50s or 60s.
                 *
                 * Keyword: entry
                 * The entry parameter is a Map.Entry object that contains a key and a value for that key in the Map. In this case, the key is the decade and the value is a list of movies for that decade.
                 */
                .filter(entry -> entry.getKey().equals("50s") || entry.getKey().equals("60s"))
                /*?
                 * Keyword: flatMap
                 * The flatMap method is a method that takes a function and returns a stream of the function's result. In this case, the flatMap method takes a function that returns a stream of movies from the list of movies for that decade. The function is a lambda expression that returns a stream of movies from the list of movies for that decade.
                 *
                 * Keyword: entry
                 * The entry parameter is a Map.Entry object that contains a key and a value for that key in the Map. In this case, the key is the decade and the value is a list of movies for that decade.
                 *
                 * Keyword: getValue
                 * The entry.getValue() method returns the value of the Map.Entry object. In this case, the value is a list of movies for that decade.
                 *
                 * Keyword: stream
                 * The stream method returns a stream of movies from the list of movies for that decade.
                 */
                .flatMap(entry -> entry.getValue().stream());

    }

}

