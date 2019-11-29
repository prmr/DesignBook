package chapter9;

import static chapter9.Movies.movies;

public class Exercise08
{
	public static void main(String[] args)
	{
		movies().stream()
			.map(Movie::time)
			.map(Exercise08::toHHMM)
			.forEach(System.out::println);
	}
	
	private static String toHHMM(int pTime)
	{
		return String.format("%d:%02d", pTime/60, pTime%60);
	}
}
