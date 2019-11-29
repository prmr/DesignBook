package chapter9;

import static chapter9.Movies.movies;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Exercise10
{
	public static void main(String[] args)
	{
		System.out.println(
		movies().stream()
			.map(Movie::title)
			.map(String::toLowerCase)
			.flatMap(s->Arrays.stream(s.split("[\\s,]+")))
			.filter(Predicate.isEqual("the"))
			.count()
		);	
	}
}
