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
		System.out.println("---");
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


	/*?
 	* Block: 10
 	* allGifts is now iterative
	* The only change required is limited to the body of method allGifts.
	* The change can be isolated to within a method, so the impact on the design is minimal. 
	* Perhaps it makes the code easier to understand for readers unfamiliar with recursion.
 	* This block defines a static method named allGifts that takes an integer
 	* parameter day and returns a String. The method iteratively concatenates
 	* a series of Strings from the GIFTS array to produce the returned result. 
 	* The loop iterates from the specified day parameter down to day 0, and for
 	* each day it retrieves the corresponding gift from the GIFTS array and
 	* appends it to the result String along with a newline character. The final
 	* gift, retrieved from index 0 of the GIFTS array, is appended to the result
 	* String with the string "and " preceding it.
	*
 	* Internal: result
 	* 10
 	* The result variable is a String that accumulates the Strings from the
 	* GIFTS array as the loop iterates. The final result includes all the gifts
 	* from the specified day down to day 0, with each gift on a separate line
 	* and the last gift preceded by "and ".
	*/
	static String allGifts(int day)
	{
		String result = "";
		for( int i = day; i > 0; i-- )
		{
			result += GIFTS[i] + "\n";
		}
		result += "and " + GIFTS[0];
		return result;
	}
	
	/*
	 * Returns the text of the entire poem. 
	 */
	static String poem()
	{
		String poem = firstLine(0) + GIFTS[0];
		for( int day = 1; day < 12; day++ )
		{ 
			poem += "\n\n" + firstLine(day) + allGifts(day); 
		}
		return poem;
	}
}
