package chapter6;

public class Client
{
	public static void main(String[] args)
	{
		CompositeShow complete = new CompositeShow(
				new Concert("Concert 1", "Artist X", 100),
				new CompositeShow(
						new Movie("Movie 1", 2017, 120),
						new Movie("Movie 2", 2018, 130)
						));
		System.out.println(complete.description());
	}
}
