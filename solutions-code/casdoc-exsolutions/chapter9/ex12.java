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
         */
        Movie result = Movies.movies().stream()
                /*?
                 * Keyword: reduce
                 * The reduce method is a method of the Stream interface that takes a BinaryOperator as a parameter and returns an Optional object that contains the result of the reduction. A reduction is a process of combining a stream of elements into a single value. A BinaryOperator is a functional interface that takes two parameters of the same type and returns a value of the same type. The reduce method is a terminal operation. In this case, the lambda expression passed to the reduce method takes two parameters of type Movie and returns the movie with the longest runtime.
                 * 
                 * Keyword: ?
                 * The ? operator is a ternary operator that takes three operands. The first operand is a boolean expression. The second operand is the value to return if the boolean expression is true. The third operand is the value to return if the boolean expression is false. In this case, the first operand is a boolean expression that compares the runtime of the first movie to the runtime of the second movie. The second operand is the first movie if the first movie has a longer runtime than the second movie. The third operand is the second movie if the second movie has a longer runtime than the first movie.
                 */
                .reduce((movie1, movie2) -> movie1.time() > movie2.time() ? movie1 : movie2).get();

    }

}

