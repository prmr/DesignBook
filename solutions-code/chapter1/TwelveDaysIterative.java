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
package chapter1;

/**
 * Outputs the text of the poem "The Twelve Days of Christmas"
 * to the console. This version is iterative instead of recursive.
 */
public class TwelveDaysIterative
{
	public static void main(String[] args)
	{
		System.out.println(poem());
	}
	
	static String[] DAYS = {"first", "second", "third", "fourth",
							"fifth", "sixth", "seventh", "eighth",
							"ninth", "tenth", "eleventh", "twelfth"};
	
	static String[] GIFTS = {
			"a partridge in a pear tree",
			"two turtle doves",
			"three French Hens",
			"four Calling Birds",
			"five Golden Rings",
			"six Geese a Laying",
			"seven Swans a Swimming",
			"eight Maids a Milking",
			"nine Ladies Dancing",
			"ten Lords a Leaping",
			"eleven Pipers Piping",
			"twelve Drummers Drumming"
	};
	
	/*
     * Returns the first line in the verse for a given day.
	 */
	static String firstLine(int day)
	{
	  return "On the " + DAYS[day] +
	    " day of Christmas my true love sent to me:\n";
	}
	
	/*
     * Returns a string that lists all the gifts received on a given
     * day.
	 */
	static String allGifts(int day)
	{
		StringBuilder result = new StringBuilder();
		for( int i = day; i > 0; i-- )
		{
			result.append(GIFTS[i] + "\n");
		}
		result.append("and " + GIFTS[0]);
		return result.toString();
	}
	
	/*
	 * Returns the text of the entire poem. 
	 */
	static String poem()
	{
		String poem = firstLine(0) + GIFTS[0] + "\n\n";
		for( int day = 1; day < 12; day++ )
		{ 
			poem += firstLine(day) + allGifts(day) + "\n\n"; 
		}
		return poem;
	}
}
