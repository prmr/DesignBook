package chapter7;

public class Client
{
	public static void main(String[] args)
	{
		System.out.println(new Movie("Movie", 1921, 100).description());
		System.out.println(new Concert("Concert", "Bob Dylan", 100).description());
		System.out.println(new SponsoredConcert("Concert", "Bob Dylan", 100, "McGill", 10).description());
	}
}
