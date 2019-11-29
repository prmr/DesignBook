package chapter9;

import static chapter9.Movies.movies;

import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Exercise11
{
	public static void main(String[] args)
	{
		Random random = new Random();
//		System.out.println(IntStream
//				.generate(()-> random.nextInt(101))
//				.limit(1000000)
//				.summaryStatistics());
		
		System.out.println(DoubleStream
				.generate(()-> 100 * random.nextDouble())
				.limit(1000000)
				.summaryStatistics());
	}

}
