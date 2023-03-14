package chapter6;

import java.util.Objects;

public class IntroducedShow implements Show
{
	private final Show aShow; // the show being introduced
	private final String aSpeaker; // the name of the speaker
	private final int aSpeechTime; // the time taken by the speaker
	

	public IntroducedShow(String pName, int pTime, Show pShow)
	{
		aShow = pShow;
		aSpeaker = pName;
		aSpeechTime = pTime;
	}
	
	@Override
    /*?
     * Keyword: description
     * Returns a string representation of the introduced show. description() is a method in the Show interface that returns a string representation of the show. Here, we use it to return a string representation of the introduced show by using String.format() to format the string representation of the show being introduced with the name of the speaker added to the beginning.
     */
	public String description() { return "[" + aSpeaker + " introduces " + aShow.description() + "]"; }

	@Override
    /*?
     * Keyword: runningTime
     * Returns the running time of the introduced show. runningTime() is a method in the Show interface that returns the running time of the show. Here, we use it to return the running time of the introduced show by adding the running time of the show being introduced and the time taken by the speaker.
     */
	public int runningTime() { return aSpeechTime + aShow.runningTime(); }

	@Override
    /*?
     * Keyword: copy
     * Returns a copy of the introduced show. copy() is a method in the Show interface that returns a copy of the show. We create a copy of an IntroducedShow object by creating a new IntroducedShow object with a copy of aShow, aSpeaker, and aSpeechTime as the parameters for the constructor.
     */
	public IntroducedShow copy()
	{
		return new IntroducedShow(aSpeaker, aSpeechTime, aShow.copy());
	}

	@Override
    /*?
     * Keyword: hashCode
     * Returns a hash code value for the object. This method is supported for the benefit of hash tables such as those provided by HashMap. hashCode() is a method in the Object class that returns a hash code value for the object. Here, we use it to return a hash code value for the introduced show by passing the values of aShow, aSpeaker, and aSpeechTime to the hash() method in the Objects class. If multiple parameters are passed to the hash() method, it returns a hash code value for the parameters by combining the hash code values of the parameters, in this case, the hash code values of aShow, aSpeaker, and aSpeechTime. The hash code value of aShow is calculated by calling the hashCode() method in the Show interface, which is implemented by the Show class. The hash code value of aSpeaker is calculated by calling the hashCode() method in the String class. The hash code value of aSpeechTime is calculated by calling the hashCode() method in the Integer class. This provides a unique hash code value for each introduced show.
     */
	public int hashCode()
	{
		return Objects.hash(aShow, aSpeaker, aSpeechTime);
	}

	@Override
    /*?
     * Keyword: equals
     * Indicates whether some other object is "equal to" this one. equals() is a method in the Object class that indicates whether some other object is "equal to" this one. Here, we use it to indicate whether some other object is "equal to" this introduced show by comparing the values of aShow, aSpeaker, and aSpeechTime with the values of the corresponding fields in the other object. If the other object is not an instance of the IntroducedShow class, the method returns false. If the other object is an instance of the IntroducedShow class, the method returns true if the values of aShow, aSpeaker, and aSpeechTime are equal to the values of the corresponding fields in the other object. If the values of aShow, aSpeaker, and aSpeechTime are not equal to the values of the corresponding fields in the other object, the method returns false.
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
}

public class Client
{
    // create some shows for testing
	private static final Concert CONCERT = new Concert("Concert 1", "Artist X", 100);
	private static final Movie MOVIE1 = new Movie("Movie 1", 2017, 120);
	private static final Movie MOVIE2 = new Movie("Movie 2", 2018, 130);
	
	public static void main(String[] args)
	{
		CompositeShow exercise1 = new CompositeShow(
				CONCERT,
				new CompositeShow(
						MOVIE1,
						MOVIE2
						));
		System.out.println(exercise1.description());
		
        /*?
         * Keyword: exercise2
         * exercise2 is an IntroducedShow object that is created by passing the values of "Speaker 1" and 10 (speech time) and a CompositeShow object which contains a Concert object and an inner CompositeShow object which contains a Movie and an Introduced show with a "Speaker 2" and a speech time of 5 with a Movie as the show being introduced for this inner IntroducedShow. The CompositeShow object is passed as the show being introduced to the IntroducedShow object exercise2.
         */
		IntroducedShow exercise2 = new IntroducedShow(
				"Speaker 1", 10, new CompositeShow(
						CONCERT,
						new CompositeShow(
								MOVIE1,
								new IntroducedShow("Speaker 2", 5, MOVIE2))));
		System.out.println(exercise2.description());
	}
    
}
