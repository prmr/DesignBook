//For DoubleBill to work with Movie instances specifically (as opposed to Show instances), and thereby not be a constructor, it is simply a matter of declaring the two aggregated objects to be of type Movie.

/**
 * Represents a show that consists of the screening of two movies
 * in sequence.
 */
public class DoubleBill implements Show
{
   private Movie aMovie1;
   private Movie aMovie2;
	
   /**
    * @param pMovie1 The first movie.
    * @param pMovie2 The second movie.
    */
    /*?
     * Keyword: DoubleBill
     * Constructor for the DoubleBill class. The constructor takes two movies as parameters and initializes the aMovie1 and aMovie2 instance variables.
     */
   public DoubleBill(Movie pMovie1, Movie pMovie2)
   {
      aMovie1 = pMovie1;
      aMovie2 = pMovie2;
   }
	
   @Override
   /*?
    * Keyword: description
    * Returns a description of the show. The description is the description of the first movie followed by the description of the second movie.
    */
   public String description() 
   { 
      return String.format("%s and %s", aMovie1.description(), aMovie2.description()); 
   }

   @Override
    /*?
     * Keyword: runningTime
     * Returns the running time of the show. The running time is the running time of the first movie plus the running time of the second movie.
     */
   public int runningTime() 
   { 
      return aMovie1.runningTime() + aMovie2.runningTime(); 
   }
}