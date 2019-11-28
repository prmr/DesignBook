package chapter6;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

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
	public DoubleBill(Movie pMovie1, Movie pMovie2)
	{
		aMovie1 = pMovie1;
		aMovie2 = pMovie2;
	}
	
	public DoubleBill(DoubleBill pDoubleBill)
	{
		aMovie1 = new Movie(pDoubleBill.aMovie1);
		aMovie2 = new Movie(pDoubleBill.aMovie2);
	}
	
	@Override
	public String description() { return String.format("%s and %s", aMovie1.description(), aMovie2.description()); }

	@Override
	public int runningTime() { return aMovie1.runningTime() + aMovie2.runningTime(); }

	@Override
	public Show copy()
	{
		return new DoubleBill(this);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(aMovie1, aMovie2);
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
		DoubleBill other = (DoubleBill) obj;
		return Objects.equals(aMovie1, other.aMovie1) && Objects.equals(aMovie2, other.aMovie2);
	}
}
