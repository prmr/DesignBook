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

        //The problem for IntroducedShow is that it aggregates an instance of the interface type Show. As a consequence of the polymorphism, the actual type of the Show object aggregated may only be known at run-time, so it is not possible to use a copy constructor in the source code without introducing a battery of inelegant and unsafe checks.
    }
}
