package chapter7.copy;

/**
 * Represents a show that consists of the screening of a single movie.
 */
public class Movie extends AbstractShow
{
	private int aTime;
	
	public Movie(String pTitle, int pYear, int pTime)
	{
		super(pTitle, pTime);
		
	}

	@Override
	protected String extra()
	{
		return String.format("(%d minutes", aTime);
	}
}
