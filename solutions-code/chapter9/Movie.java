package chapter9;

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
	
	public int year()
	{
		return aYear;
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
		return String.format("[%s (%d): %d minutes]", aTitle, aYear, aRunningTime);
	}
	
	public String title()
	{
		return aTitle;
	}

	@Override
	public int time()
	{
		return aRunningTime;
	}
	
	public String toString()
	{
		return description();
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + aRunningTime;
		result = prime * result + ((aTitle == null) ? 0 : aTitle.hashCode());
		result = prime * result + aYear;
		return result;
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
		if (aRunningTime != other.aRunningTime)
			return false;
		if (aTitle == null)
		{
			if (other.aTitle != null)
				return false;
		}
		else if (!aTitle.equals(other.aTitle))
			return false;
		if (aYear != other.aYear)
			return false;
		return true;
	}
}
