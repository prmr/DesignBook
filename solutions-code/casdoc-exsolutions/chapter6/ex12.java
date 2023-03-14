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
    /*?
     * Keyword: hashCode
     * hashCode() is a method in the Object class that returns an integer value that is used to identify the object in a hash table or hash set or any other data structure that uses hashing to store and retrieve objects quickly and efficiently from memory. We override the hashCode() method in our Movie class to return a hash code value for the object. The hash code value is calculated using the Objects.hash() method that takes aRunningTime, aTitle, and aYear as parameters.
     */
	public int hashCode()
	{
        /*?
         * Keyword: hash
         * Objects.hash() is a static method in the Objects class that returns a hash code value for the object. The hash code value is calculated using the parameters passed to the method. The hash code value is calculated using the Objects.hash() method that takes aRunningTime, aTitle, and aYear as parameters.
         */
		return Objects.hash(aRunningTime, aTitle, aYear);
	}

	@Override
    /*?
     * Keyword: equals
     * equals() is a method in the Object class that returns true if the object passed as a parameter is equal to the object on which the method is called. We override the equals() method to define equality for the Movie class. Two Movie objects are equal if they have the same title, year, and running time.
     */
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
    /*?
     * Keyword: hashCode
     * hashCode() is a method in the Object class that returns an integer value that is used to identify the object in a hash table or hash set or any other data structure that uses hashing to store and retrieve objects quickly and efficiently from memory. We override the hashCode() method in our Concert class to return a hash code value for the object. The hash code value is calculated using the Objects.hash() method. The Objects.hash() method returns a hash code value for the given arguments.
     */
	public int hashCode()
	{
        /*?
         * Keyword: hash
         * The Objects.hash() method returns a hash code value for the given arguments. The hash code value is unique for each object. The hash code value is calculated by passing aPerformer, aRunningTime, and aTitle to the Objects.hash() method which returns a hash code value for the given arguments.
         * 
         * 
         */
		return Objects.hash(aPerformer, aRunningTime, aTitle);
	}

	@Override
    /*?
     * Keyword: equals
     * The equals() method is used to compare two objects. The equals() method in the Object class compares the memory location of two objects. If the memory location of two objects is the same, then the equals() method returns true. If the memory location of two objects is different, then the equals() method returns false. We override the equals() method in our Concert class to compare the values of the fields of two Concert objects. Two Concert objects are equal if they have the same title, performer, and running time.
     */
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

    public Concert(Concert pConcert)
    {
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
   public DoubleBill(Movie pMovie1, Movie pMovie2)
   {
      aMovie1 = pMovie1;
      aMovie2 = pMovie2;
   }
	
   @Override
   public String description() 
   { 
      return String.format("%s and %s", aMovie1.description(), aMovie2.description()); 
   }

   @Override
   public int runningTime() 
   { 
      return aMovie1.runningTime() + aMovie2.runningTime(); 
   }

    public DoubleBill(DoubleBill pDoubleBill)
    {
        aMovie1 = new Movie(DoubleBill.aMovie1);
        aMovie2 = new Movie(DoubleBill.aMovie2);
    }

    @Override
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
    /*?
     * Keyword: hashCode
     * hashCode() is a method in the Object class that returns an integer value that is used to identify the object in a hash table or hash set or any other data structure that uses hashing to store and retrieve objects quickly and efficiently from memory. We override the hashCode() method in our IntroducedShow class to return a hash code value for the object. The hash code value is calculated using the Objects.hash() method. The Objects.hash() method returns a hash code value for the given arguments.
     */
	public int hashCode()
	{
        /*?
         * Keyword: hash
         * The Objects.hash() method returns a hash code value for the given arguments. The hash code value is unique for each object. The hash code value is calculated by passing aShow, aSpeaker, and aSpeechTime to the Objects.hash() method which returns a hash code value for the given arguments.
         * 
         * 
         */
		return Objects.hash(aShow, aSpeaker, aSpeechTime);
	}

	@Override
    /*?
     * Keyword: equals
     * The equals() method is used to compare two objects. The equals() method in the Object class compares the memory location of two objects. If the memory location of two objects is the same, then the equals() method returns true. If the memory location of two objects is different, then the equals() method returns false. We override the equals() method in our IntroducedShow class to compare the values of the fields of two IntroducedShow objects. Two IntroducedShow objects are equal if they have the same show, speaker, and speech time.
     */
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

    public IntroducedShow(IntroducedShow pIntroducedShow)
    {
        this(pIntroducedShow.aSpeaker, pIntroducedShow.aSpeechTime, pIntroducedShow.aShow);
    }

    @Override
    public Show copy()
    {
        return new IntroducedShow(aSpeaker, aSpeechTime, aShow.copy());
    }
}

public class CompositeShow implements Show
{
	private List<Show> aShows = new ArrayList<>();
	
	public CompositeShow(Show...pShows)
	{
		if( pShows.length < 2 || pShows.length > 5)
		{
			throw new IllegalArgumentException("Arguments should be between two and five shows inclusively");
		}
		aShows.addAll(Arrays.asList(pShows));
	}
	
	@Override
	public String description()
	{
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
		 * Keyword: hash
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


