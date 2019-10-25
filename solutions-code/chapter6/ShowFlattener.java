package chapter6;

import java.util.ArrayList;
import java.util.List;

public class ShowFlattener
{
	private static final Concert CONCERT = new Concert("Concert 1", "Artist X", 100);
	private static final Movie MOVIE1 = new Movie("Movie 1", 2017, 120);
	private static final Movie MOVIE2 = new Movie("Movie 2", 2018, 130);
	
	public static void main(String[] args)
	{
		IntroducedShow exercise2 = new IntroducedShow(
				"Speaker 1", 10, new CompositeShow(
						CONCERT,
						new CompositeShow(
								MOVIE1,
								new IntroducedShow("Speaker 2", 5, MOVIE2))));
		List<Show> atomicShows = flattenShow(exercise2);
		System.out.println(atomicShows);
	}
	
	private static final List<Show> flattenShow(Show pShow)
	{
		List<Show> result = new ArrayList<>();
		result.add(pShow);
		if( pShow instanceof Iterable )
		{
			for( Object child : (Iterable<?>)pShow)
			{
				result.addAll(flattenShow((Show)child));
			}
		}
		return result;
	}
}
