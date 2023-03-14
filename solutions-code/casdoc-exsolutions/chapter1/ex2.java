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
 * to the console. The code leverages the natural recursion in 
 * the structure of the poem. This version allows users to 
 * display days using digits by passing in the command-line 
 * argument "digits".
 */
public class TwelveDays2
{
	private static boolean asDigits = false;
	
	public static void main(String[] args)
	{
		detectDigits(args);
		System.out.println(poem());
	}
	
	static void detectDigits(String[] args)
	{
		asDigits = args != null && args.length > 0 && args[0].equals("digits");
	}
	
	static String[] DAYS = {"first", "second", "third", "fourth",
							"fifth", "sixth", "seventh", "eighth",
							"ninth", "tenth", "eleventh", "twelfth"};
	
	static String[] DAYS_DIGITS = {"1st", "2nd", "3rd", "4th",
			"5th", "6th", "7th", "8th",
			"9th", "10th", "11th", "12th"};
	
	/*?
	 * Block: 11
	 * Returns the day of the week as a string
	 * Instead of retrieving the string that describes the day directly from a data structure, a method day(int) now abstracts this concept, and hides the details of where the string comes from and the switching logic. The method returns the day of the week as a string, either in its textual or numerical representation depending on the value of the global variable "asDigits". Abstraction and information hiding are topics covered in Chapter 2.
	 * 
	 * Internal: asDigits
	 * 11
	 * "asDigits" is a global variable that determines whether the day of the week is displayed as a digit or a string. It is set to false by default, which means that the day is displayed as a string by default. In the case of the TwelveDays program, this variable is used to determine whether to display the day as a string or a digit.
	 * 
	 * Internal: global variable
	 * asDigits
	 * A global variable is a variable that is accessible to all methods in the class. However, overuse of global variables can lead to poor code comprehensibility and encapsulation (see Chapter 2). In general, it is better to use method arguments or class fields instead of global variables.
	 * 
	 */
	static String day(int day)
	{
		if(asDigits)
		{
			return DAYS_DIGITS[day];
		}
		else
		{
			return DAYS[day];
		}
	}
	
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
	  return "On the " + day(day) +
	    " day of Christmas my true love sent to me:\n";
	}
	
	/*
     * Returns a string that lists all the gifts received on a given
     * day.
	 */
	static String allGifts(int day)
	{
		if( day == 0 ) 
		{ 
			return "and " + GIFTS[0]; 
		}
		else 
		{ 
			return GIFTS[day] + "\n" + allGifts(day-1);	
		}
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
