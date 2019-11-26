package chapter9;

import java.util.Arrays;
import java.util.List;

public class Movies
{
	public static final Movie CARVE_UP = new Movie("What a Carve Up!", 1961, 87);
	public static final Movie GIANT_CLAW = new Movie("The Giant Claw", 1957, 75);
	public static final Movie ALLIGATOR = new Movie("The Alligator People", 1959, 75);
	public static final Movie CREEPING = new Movie("The Creeping Terror", 1964, 77);
	public static final Movie LEECHES = new Movie("Attack of the Giant Leeches", 1959, 62);
	
	public static final List<Movie> movies()
	{
		return Arrays.asList(CARVE_UP, GIANT_CLAW, ALLIGATOR, CREEPING, LEECHES);
	}
}
