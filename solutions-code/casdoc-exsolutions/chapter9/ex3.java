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
     * Keyword: isOld
     * The isOld method returns true if the movie is older than 1960.
     */
    public boolean isOld() {
        return aYear < 1960;
    }

	/*?
     * Keyword: movies
     * This method returns a list of movies.
     */
	public static final List<Movie> movies()
	{
	    return Arrays.asList(OLDBOY, METROPOLIS, WAGES, INTOUCHABLES, AMELIE, GOODBAD, DIABOLIQUE, JOAN);
    }

    /*?
     * Keyword: print
     * The print method prints the movie passed as a parameter.
     */
    private static void print(Movie pMovie) {
        System.out.println(pMovie);
    }


    public static void main(String[] args) 
    {
        // ANONYMOUS CLASS

        /*?
         * Keyword: forEach
         * The forEach method iterates over the list of movies and prints each movie. The parameter of the forEach method is a Consumer anonymous class. The Consumer interface is a functional interface. The accept method is the single method of the Consumer interface.
         * 
         * Internal: functional interface
         * forEach
         * A functional interface is an interface that has a single method. The Consumer interface is a functional interface. The accept method is the single method of the Consumer interface.
         */
        Movies.movies().forEach(new Consumer<Movie>() {
            @Override
            /*?
             * Keyword: accept
             * The accept method prints the movie passed as a parameter. We override the accept method of the Consumer interface to print the movie.
             */
            public void accept(Movie pMovie) {
                System.out.println(pMovie);
            }
        });

        // LAMBDA EXPRESSION

        /*?
         * Keyword: forEach
         * The forEach method iterates over the list of movies and prints each movie. The parameter of the forEach method is a lambda expression.
         * 
         * Keyword: pMovie
         * The lambda expression has a parameter pMovie. The type of the parameter is inferred from the type of the list of movies.
         * 
         * Internal: lambda expression
         * forEach
         * The lambda expression is composed of a parameter list, an arrow, and a body. The body of the lambda expression is the expression that is executed when the lambda expression is called.
         * 
         * Keyword: ->
         * The arrow separates the parameter list from the body of the lambda expression.
         */
        Movies.movies().forEach(pMovie -> System.out.println(pMovie));

        // METHOD REFERENCE

        Movies.movies().forEach(Movies::print); // this is equivalent to the previous lambda expression


        /*?
         * Keyword: forEach
         * The forEach method iterates over the list of movies and prints each movie. The parameter of the forEach method is a method reference.
         * 
         * Internal: method reference
         * forEach
         * A method reference is a shorthand notation for a lambda expression. The method reference is composed of a class name, a double colon, and a method name. The method reference is equivalent to a lambda expression that calls the method.
         * 
         * Keyword: System.out
         * System.out in the class System is a static field that represents the standard output stream.
         * 
         * Keyword: println
         * The println method prints the movie passed as a parameter and adds a new line.
         */
        Movies.movies().forEach(System.out::println);

}


    
}

