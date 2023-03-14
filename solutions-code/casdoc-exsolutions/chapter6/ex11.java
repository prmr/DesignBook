/*******************************************************************************
 * Companion code for the book "Introduction to Software Design with Java" 
 * by Martin P. Robillard.
 *
 * Copyright (C) 2019 by Martin P. Robillard
 *
 * This code is licensed under a Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * 
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 *******************************************************************************/
package chapter6;

import java.util.Objects;

/**
 * Represents a show that consists of the screening of a single movie.
 */
public class Movie implements Show
{
	private String aTitle;
	private int aYear;
	private int aRunningTime;
	
	/**
	 * @param pTitle The title of the movie
	 * @param pYear The release year of the movie
	 * @param pTime The running time of the movie.
	 */
	public Movie(String pTitle, int pYear, int pTime)
	{
		aTitle = pTitle;
		aYear = pYear;
		aRunningTime = pTime;
	}
	
	public Movie(Movie pMovie)
	{
		aTitle = pMovie.aTitle;
		aYear = pMovie.aYear;
		aRunningTime = pMovie.aRunningTime;
	}
	
	@Override
	public String description()
	{
		return String.format("%s (%d)", aTitle, aYear);
	}

	@Override
	public int runningTime()
	{
		return aRunningTime;
	}

	@Override
    /*?
     * Keyword: copy()
     * Returns a copy of the Movie object. The copy() method returns a new Movie object that is a copy of the current Movie object using the copy constructor. Covariant return type is used to ensure that the copy() method returns a Movie object.
     * 
     * Internal: Covariant return type
     * copy()
     * Covariant return type is a feature of Java that allows a method to return a subclass of the type specified in the method's return type. In this case, the copy() method in the Movie class returns a Movie object, which is a subclass of the Show interface. This is possible because the Movie class implements the Show interface.
     */
	public Show copy()
	{
		return new Movie(this);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(aRunningTime, aTitle, aYear);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return aRunningTime == other.aRunningTime && Objects.equals(aTitle, other.aTitle) && aYear == other.aYear;
	}

    /*?
     * Keyword: Movie(Movie pMovie)
     * Copy constructor for the Movie class. The constructor takes a Movie object as a parameter and initializes the aTitle, aYear, and aRunningTime instance variables.
     */
    public Movie(Movie pMovie)
    {
        aTitle = pMovie.aTitle;
        aYear = pMovie.aYear;
        aRunningTime = pMovie.aRunningTime;
    }

}

public class Concert implements Show
{
	private String aTitle;
	private String aPerformer;
	private int aRunningTime;
	
	/**
	 * @param pTitle The title of the concert
	 * @param pPerformer The name of the artist or orchestra performing
	 * @param pTime The running time of the concert.
	 */
	public Concert(String pTitle, String pPerformer, int pTime)
	{
		aTitle = pTitle;
		aPerformer = pPerformer;
		aRunningTime = pTime;
	}
	
	public Concert(Concert pConcert)
	{
		this(pConcert.aTitle, pConcert.aPerformer, pConcert.aRunningTime);
	}
	
	@Override
	public String description()
	{
		return String.format("%s by %s", aTitle, aPerformer);
	}

	@Override
	public int runningTime()
	{
		return aRunningTime;
	}

	@Override
    /*?
     * Keyword: copy()
     * Returns a copy of the Concert object. The copy() method returns a new Concert object that is a copy of the current Concert object using the copy constructor.
     */
	public Show copy()
	{
		return new Concert(this);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(aPerformer, aRunningTime, aTitle);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Concert other = (Concert) obj;
		return Objects.equals(aPerformer, other.aPerformer) && aRunningTime == other.aRunningTime
				&& Objects.equals(aTitle, other.aTitle);
	}

    /*?
     * Keyword: Concert(Concert pConcert)
     * Copy constructor for the Concert class. The constructor takes a Concert object as a parameter and initializes the aTitle, aPerformer, and aRunningTime instance variables.
     */
    public Concert(Concert pConcert)
    {
        /*?
         * Keyword: this
         * The `this` keyword is used to call another constructor in the same class. In this case, the constructor takes three parameters and initializes the aTitle, aPerformer, and aRunningTime instance variables.
         */
        this(pConcert.aTitle, pConcert.aPerformer, pConcert.aRunningTime);
    }
}

public class DoubleBill implements Show
{
   private Movie aMovie1;
   private Movie aMovie2;
	
   /**
    * @param pMovie1 The first movie.
    * @param pMovie2 The second movie.
    */
    /*?
     * Keyword: DoubleBill(Movie pMovie1, Movie pMovie2)
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

    /*?
     * Keyword: DoubleBill(DoubleBill pDoubleBill)
     * Copy constructor for the DoubleBill class that makes a deep copy of the DoubleBill object passed as a parameter. The constructor takes a DoubleBill object as a parameter and initializes the aMovie1 and aMovie2 instance variables by creating new Movie objects using the copy constructor of the Movie class and passing the corresponding Movie objects from the DoubleBill object passed as a parameter.
     */
    public DoubleBill(DoubleBill pDoubleBill)
    {
        aMovie1 = new Movie(DoubleBill.aMovie1);
        aMovie2 = new Movie(DoubleBill.aMovie2);
    }

    @Override
    /*?
     * Keyword: copy()
     * Returns a copy of the DoubleBill object. The copy() method returns a new DoubleBill object that is a copy of the current DoubleBill object using the copy constructor.
     */
    public Show copy()
    {
        return new DoubleBill(this);
    }
}

public class IntroducedShow implements Show
{
	private final Show aShow;
	private final String aSpeaker;
	private final int aSpeechTime;
	
	public IntroducedShow(String pName, int pTime, Show pShow )
	{
		aShow = pShow;
		aSpeaker = pName;
		aSpeechTime = pTime;
	}
	
	@Override
	public String description() { return "[" + aSpeaker + " introduces " + aShow.description() + "]"; }

	@Override
	public int runningTime() { return aSpeechTime + aShow.runningTime(); }

	@Override
	public IntroducedShow copy()
	{
		return new IntroducedShow(aSpeaker, aSpeechTime, aShow.copy());
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(aShow, aSpeaker, aSpeechTime);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IntroducedShow other = (IntroducedShow) obj;
		return Objects.equals(aShow, other.aShow) && Objects.equals(aSpeaker, other.aSpeaker)
				&& aSpeechTime == other.aSpeechTime;
	}

    /*?
     * Keyword: IntroducedShow(IntroducedShow pIntroducedShow)
     * Copy constructor for the IntroducedShow class. The constructor takes an IntroducedShow object as a parameter and initializes the aSpeaker, aSpeechTime, and aShow instance variables.
     */
    public IntroducedShow(IntroducedShow pIntroducedShow)
    {
        /*?
         * Keyword: this
         * The `this` keyword is used to call another constructor in the same class. In this case, the constructor takes three parameters and initializes the aSpeaker, aSpeechTime, and aShow instance variables.
         */
        this(pIntroducedShow.aSpeaker, pIntroducedShow.aSpeechTime, pIntroducedShow.aShow);
    }

    @Override
    /*?
     * Keyword: copy()
     * Returns a copy of the IntroducedShow object. The copy() method returns a new IntroducedShow object that is a copy of the current IntroducedShow object using the copy constructor for the Show interface to copy the Show object aggregated by the IntroducedShow object. Then, the copied Show object, aSpeaker, and aSpeechTime instance variables are passed to the copy constructor of the IntroducedShow class to create a new IntroducedShow object that is a copy of the current IntroducedShow object.
     */
    public Show copy()
    {
        return new IntroducedShow(aSpeaker, aSpeechTime, aShow.copy());
    }
}

public class CompositeShow implements Show
{
	private List<Show> aShows = new ArrayList<>();
	
	//constructor that takes a variable number of shows as arguments
	public CompositeShow(Show...pShows)
	{
		if( pShows.length < 2 || pShows.length > 5)
		{
			/*?
			 * Keyword: IllegalArgumentException
			 * Thrown to indicate that a method has been passed an illegal or inappropriate argument.
			 */
			throw new IllegalArgumentException("Arguments should be between two and five shows inclusively");
		}
		/*?
		 * Keyword: addAll
		 * Adds all of the elements in the specified collection to this list. addAll() is a method in the List interface that takes a collection as a parameter and adds all of the elements in the collection to the list. Here, we use it to add all of the elements in the array pShows to the list aShows.
		 * 
		 */
		aShows.addAll(Arrays.asList(pShows));
	}
	
	@Override
	/*?
	 * Keyword: description
	 * Returns a string representation of the composite show. description() is a method in the Show interface that returns a string representation of the show. Here, we use it to return a string representation of the composite show by using StringJoiner to join the descriptions of the shows in the composite show.
	 */
	public String description()
	{
		/*?
		 * Keyword: StringJoiner
		 * StringJoiner is a class that takes a delimiter, prefix, and suffix as parameters and joins strings with the delimiter and prefix and suffix. Here, we use it to join the descriptions of the shows in the composite show with a semicolon and space as the delimiter, a left square bracket as the prefix, and a right square bracket as the suffix.
		 */
		StringJoiner description = new StringJoiner("; ", "[", "]");
		for( Show show : aShows )
		{
			description.add(show.description());
		}
		return description.toString();
	}

	@Override
	public int runningTime()
	{
		int time = 0;
		for( Show show : aShows )
		{
			time += show.runningTime();
		}
		return time;
	}

	@Override
	/*?
	 * Keyword: copy
     * Returns a copy of the CompositeShow object. The copy() method returns a new CompositeShow object that is a copy of the current CompositeShow object. It does this by creating a new CompositeShow object and adding copies of the shows in the current CompositeShow object to the new CompositeShow object.
	 */
	public Show copy()
	{
        CompositeShow copy = new CompositeShow();
        for( Show show : aShows )
        {
           copy.aShows.add(show.copy());
        }
        return copy;
	}

	@Override
	/*?
	 * Keyword: hashCode
	 * Returns a hash code value for the object. This method is supported for the benefit of hash tables such as those provided by HashMap. hashCode() is a method in the Object class that returns a hash code value for the object. Here, we use it to return a hash code value for the composite show by using Objects.hash() to hash the list of shows in the composite show.
	 *
	 */
	public int hashCode()
	{
		/*?
		 * Keyword: Objects.hash
		 * Returns a hash code value for the arguments. hash() is a static method in the Objects class that returns a hash code value for the arguments. Here, we use it to return a hash code value for the list of shows in the composite show. The hash code of a list is computed by calling hash() on each of the elements in the list.
		 */
		return Objects.hash(aShows);
	}

	@Override
	/*?
	 * Keyword: equals
	 * Indicates whether some other object is "equal to" this one. equals() is a method in the Object class that indicates whether some other object is "equal to" this one. Here, we are trying to define equality for the composite show. We define two composite shows to be equal if they contain the same shows. We use Objects.equals() to compare the lists of shows in the two composite shows to determine if they are equal.
	 */
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompositeShow other = (CompositeShow) obj;
		return Objects.equals(aShows, other.aShows);
	}

}


