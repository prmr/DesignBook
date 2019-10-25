package chapter6;

public class Client
{
	// Leaves
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
		
		IntroducedShow exercise2 = new IntroducedShow(
				"Speaker 1", 10, new CompositeShow(
						CONCERT,
						new CompositeShow(
								MOVIE1,
								new IntroducedShow("Speaker 2", 5, MOVIE2))));
		System.out.println(exercise2.description());
	}
}
