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

    public static void main(String[] args) 
    {

    // ANONYMOUS CLASS IMPLEMENTATION


    /*?
     * Keyword: movies
     * movies is a list of movies that is returned by the movies() method. We create a new list of movies by passing the movies() method to the constructor of the ArrayList class.
     */
    ArrayList<Movie> movies = new ArrayList<>(Movies.movies());

    /*?
     * Keyword: removeIf
     * The removeIf method removes all elements from the list that satisfy the predicate. The predicate is an anonymous class that implements the Predicate interface. The test method of the Predicate interface returns true if the movie is older than 1960.
     * 
     * Keyword: Predicate
     * The Predicate interface is a functional interface that represents a predicate (boolean-valued function) of one argument. This is a functional interface whose functional method is test(Object).
     * 
     * Internal: functional interface
     * Predicate
     * A functional interface is an interface that has only one method. The Predicate interface is a functional interface because test method is the only method.
     */
    movies.removeIf( new Predicate <Movie>()
    {
        @Override
        /*?
         * Keyword: test
         * The test method is a method of the Predicate interface that returns true if the condition is satisfied. The condition is that the movie is older than 1960.
         */
        public boolean test(Movie pMovie)
        {
            return pMovie.year() < 1960;
        }
    });

    // LAMBDA EXPRESSION IMPLEMENTATION
    
    /*?
     * Keyword: removeIf
     * The removeIf method removes all elements from the list that satisfy the predicate. The removeIf method takes a lambda expression as an argument, which is a predicate that returns true if the movie is older than 1960.
     * 
     * Internal: predicate
     * removeIf
     * A predicate is a boolean-valued function of one argument. The test method of the Predicate interface is a predicate, which returns true if the movie is older than 1960.
     * 
     * Keyword: ->
     * The symbol `->` is called a lambda operator. It separates the lambda's parameter list from its body.
     *
     * 
     * Keyword: movie:2
     * The parameter of the lambda expression is a movie.
     * 
     * Keyword: 1960
     * The body of the lambda expression `movie.year() < 1960` is a predicate that returns true if the movie is older than 1960.
     * 
     */
    movies.removeIf( movie -> movie.year() < 1960 );

    }
    
}

