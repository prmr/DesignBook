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

    public static void main(String[] args) 
    {
        /*?
         * Keyword: isOld
         * The :: operator is used to refer to a method. In this case, we refer to the isOld method of the Movie class. This is called a method reference.
         * 
         * Keyword: removeIf
         * The removeIf method removes all elements from the list that satisfy the predicate. The predicate is a method reference to the isOld method of the Movie class. The isOld method returns true if the movie is older than 1960 so movies.removeIf(Movie::isOld) removes all movies older than 1960.
         */
        movies.removeIf(Movie::isOld);
    }
    
}

