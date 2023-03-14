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

    /*?
     * Keyword: aMovies
     * aMovies is a static flyweight store of movies that is implemented as a map. The key is the title of the movie and the value is the movie.
     */
    private static final Map<String, Movie> aMovies = new HashMap<>();

    /*?
     * Keyword: get
     * The `get` method returns a movie from the flyweight store. If the movie is not in the store, it is created and added to the store. The `get` method is a static accessor method that is used to access the flyweight store of movies. It takes the title, year, and time of the movie as parameters and returns the movie from the flyweight store of movies if it exists. If the movie is not in the store, it is created and added to the store. This is called lazy instantiation.
     */
    public static Movie get(String pTitle, int pYear, int pTime) {
        /*?
         * Keyword: computeIfAbsent
         * The computeIfAbsent method takes a key and a function that returns a value. If the key is not in the map, the function is used to create the value and add it to the map. In this case, the function creates a new movie and adds it to the map. We use a lambda expression to create the function that creates the movie and adds it to the map if it is not in the map already.
         */
        return aMovies.computeIfAbsent(pTitle, title -> new Movie(pTitle, pYear, pTime));
    }


    public static void main(String[] args) 
    {
       
    }

}

