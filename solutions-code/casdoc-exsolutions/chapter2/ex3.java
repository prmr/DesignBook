/*******************************************************************************
 * Companion code for the book "Introduction to Software Design with Java",
 * 2nd edition by Martin P. Robillard.
 *
 * Copyright (C) 2022 by Martin P. Robillard
 *
 * This code is licensed under a Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * 
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 * 
 *******************************************************************************/
package e2.chapter2;

/**
 * Represents the suit of a playing card.
 */

/*?
 * Keyword: Suit
 * Suit is an enum type that represents the suit of a playing card.
 * 
 * Internal: enum type
 * Suit
 * An enum type is a type that represents a set of named constants, such as the suits of a playing card.
 */
public enum Suit
{
	CLUBS, DIAMONDS, SPADES, HEARTS;
		
	/*?
	 * Keyword: Color
	 * Color is an enum type that represents the color of a playing card. It is an inner type of Suit.
     * 
     * Internal: inner type
     * Color
     * An inner type is a type that is defined inside another type. Inner types are used to group related types together.
	 */
	enum Color
	{
		RED, BLACK; 
	}
		
	/*?
	 * Keyword: getColor
	 * getColor is a method that returns the color of a playing card.
	 */
	public Color getColor()
	{
		if( this == CLUBS || this == SPADES )
		{
			return Color.BLACK;
		}
		else
		{
			return Color.RED;
		}
	}
}