package chapter7;

/**
 * Represents a show that consists of the screening of a single movie.
 */
public class Movie implements Show
{
	private String aTitle;
	private int aTime;
	private int aYear;
	
	public Movie(String pTitle, int pYear, int pTime)
	{
		aTitle = pTitle;
		aTime = pTime;
		aYear = pYear;
	}

	@Override
	public String title()
	{
		return aTitle;
	}

	@Override
	public String description()
	{
		return String.format("%s (%d)", aTitle, aYear);
	}

	@Override
	public int time()
	{
		return aTime;
	}
}
