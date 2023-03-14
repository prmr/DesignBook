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
	
	@Test
	public void testCopy()
	{
        /*?
         * Keyword: intro1
         * create an IntroducedShow object with a "Speaker 2" and a speech time of 5 with a Movie as the show being introduced
         */
		IntroducedShow intro1 = new IntroducedShow("Speaker 2", 5, MOVIE2);
        /*?
         * Keyword: combo1
         * create a CompositeShow object which contains 2 shows: a Movie and an Introduced show with a "Speaker 2" and a speech time of 5 with a Movie as the show being introduced
         */
		CompositeShow combo1 = new CompositeShow(
				MOVIE1,
				intro1);
        /*?
         * Keyword: combo2
         * create a CompositeShow object which contains 2 shows: a Concert and a CompositeShow object which contains 2 shows: a Movie and an Introduced show with a "Speaker 2" and a speech time of 5 with a Movie as the show being introduced
         */
		CompositeShow combo2 = new CompositeShow(
				CONCERT,
				combo1);
        /*?
         * Keyword: exercise2
         * create an IntroducedShow object with a "Speaker 1" and a speech time of 10 and a CompositeShow object which contains 2 shows: a Concert and a CompositeShow object which contains 2 shows: a Movie and an Introduced show with a "Speaker 2" and a speech time of 5 with a Movie as the show being introduced
         */
		IntroducedShow exercise2 = new IntroducedShow(
				"Speaker 1", 10, combo2);
		
        /*?
         * Keyword: copy
         * create a copy of the IntroducedShow object exercise2
         */
		IntroducedShow copy = exercise2.copy();

        /*?
         * Keyword: assertNotSame
         * assertNotSame() is a method in the Assert class that checks that the two objects passed to it are not the same object. If the two objects are the same object, the method fails the test. If the two objects are not the same object, the method passes the test. Here, we are checking that the copy of the IntroducedShow object exercise2 is not the same object as the IntroducedShow object exercise2.
         */
		assertNotSame(exercise2, copy);

        /*?
         * Keyword: assertEquals
         * assertEquals() is a method in the Assert class that checks that the two objects passed to it are equal. If the two objects are not equal, the method fails the test. If the two objects are equal, the method passes the test. Here, we are checking that the copy of the IntroducedShow object exercise2 is equal to the IntroducedShow object exercise2, which means that the values of the fields in the copy are equal to the values of the fields in the original.
         */
		assertEquals(exercise2, copy);

        /*?
         * Keyword: inner1
         * get the show being introduced from the IntroducedShow object copy using the getShow() method.
         * 
         * Keyword: getShow
         * getShow() is a method in the Client class that returns the show being introduced from the IntroducedShow object passed to it. Here, we are using it to get the show being introduced from the IntroducedShow object copy.
         */
		Show inner1 = getShow(copy);

        /*?
         * Keyword: assertNotSame
         * assertNotSame() is a method in the Assert class that checks that the two objects passed to it are not the same object. If the two objects are the same object, the method fails the test. If the two objects are not the same object, the method passes the test. Here, we are checking that the show being introduced from the IntroducedShow object copy is not the same object as the CompositeShow object combo2.
         */
		assertNotSame(combo2, inner1);

        /*?
         * Keyword: assertEquals
         * assertEquals() is a method in the Assert class that checks that the two objects passed to it are equal. If the two objects are not equal, the method fails the test. If the two objects are equal, the method passes the test. Here, we are checking that the show being introduced from the IntroducedShow object copy is equal to the CompositeShow object combo2, which means that the values of the fields in the show being introduced from the IntroducedShow object copy are equal to the values of the fields in the CompositeShow object combo2.
         */
		assertEquals(combo2, inner1);

        /*?
         * Keyword: CompositeShow.class
         * CompositeShow.class is a static field in the CompositeShow class that contains the class object for the CompositeShow class. Here, we are checking that the show being introduced from the IntroducedShow object copy is an instance of the CompositeShow class.
         */
		assertEquals(CompositeShow.class, inner1.getClass());
	}
	
	
	
	private static Show getShow(IntroducedShow pShow)
	{
		try
		{
            /*?
             * Keyword: Field
             * Field is a class in the java.lang.reflect package that represents a field in a class. Here, we are using it to get the field named "aShow" from the IntroducedShow class.
             * 
             * Keyword: getDeclaredField
             * getDeclaredField() is a method in the Class class that returns the Field object for the field with the name passed to it. Here, we are using it to get the Field object for the field named "aShow" from the IntroducedShow class.
             *
             */
			Field showField = IntroducedShow.class.getDeclaredField("aShow");

            /*?
             * Keyword: setAccessible
             * setAccessible() is a method in the Field class that sets whether or not the field is accessible. Here, we are using it to set the field named "aShow" from the IntroducedShow class to be accessible.
             */
			showField.setAccessible(true);

            /*?
             * Keyword: get
             * get() is a method in the Field class that returns the value of the field for the object passed to it. Here, we are using it to get the value of the field named "aShow" from the IntroducedShow object pShow. We cast the value returned by get() to a Show object because the field named "aShow" in the IntroducedShow class is a Show object.
             */
			return (Show) showField.get(pShow);
		}
        /*?
         * Keyword: ReflectiveOperationException
         * ReflectiveOperationException is a class in the java.lang.reflect package that is the superclass of all exceptions that can be thrown during reflection. Here, we are catching the exception that is thrown if the field named "aShow" is not found in the IntroducedShow class or if the field named "aShow" is not accessible.
         */
		catch( ReflectiveOperationException e )
		{
            /*?
             * Keyword: fail
             * fail() is a method in the Assert class that fails the test. Here, we are using it to fail the test if the field named "aShow" is not found in the IntroducedShow class or if the field named "aShow" is not accessible.
             */
			fail();
			return null;
		}
	}
}
