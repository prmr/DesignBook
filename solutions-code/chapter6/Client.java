/*******************************************************************************
 * Companion code for the book "Introduction to Software Design with Java" 
 * by Martin P. Robillard.
 *
 * Copyright (C) 2019 by Martin P. Robillard
 *
 * This code is licensed under a Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * 
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 *******************************************************************************/
package chapter6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

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
	
	@Test
	public void testCopy()
	{
		IntroducedShow intro1 = new IntroducedShow("Speaker 2", 5, MOVIE2);
		CompositeShow combo1 = new CompositeShow(
				MOVIE1,
				intro1);
		CompositeShow combo2 = new CompositeShow(
				CONCERT,
				combo1);
		IntroducedShow exercise2 = new IntroducedShow(
				"Speaker 1", 10, combo2);
		
		IntroducedShow copy = exercise2.copy();
		assertNotSame(exercise2, copy);
		assertEquals(exercise2, copy);
		Show inner1 = getShow(copy);
		assertNotSame(combo2, inner1);
		assertEquals(combo2, inner1);
		assertEquals(CompositeShow.class, inner1.getClass());
	}
	
	
	
	private static Show getShow(IntroducedShow pShow)
	{
		try
		{
			Field showField = IntroducedShow.class.getDeclaredField("aShow");
			showField.setAccessible(true);
			return (Show) showField.get(pShow);
		}
		catch( ReflectiveOperationException e )
		{
			fail();
			return null;
		}
	}
}
