package chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

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
		List<Show> copies = new ArrayList<>();
		for( Show show : aShows )
		{
			copies.add(show.copy());
		}
		return new CompositeShow(copies.toArray(new Show[copies.size()]));
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(aShows);
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
		CompositeShow other = (CompositeShow) obj;
		return Objects.equals(aShows, other.aShows);
	}
}
