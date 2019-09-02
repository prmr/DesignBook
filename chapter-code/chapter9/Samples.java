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
package chapter9;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Code samples for Sections 9.1-9.3
 *
 */
public class Samples
{	
	public static void main(String[] args)
	{
		samples1();
	}
	
	/**
	 * For Section 9.1
	 */
	private static void samples1()
	{
		List<Card> cards = new Deck().getCards();
		
		// Calling 'sort' with an object of an anonymous class
		Collections.sort(cards, new Comparator<Card>()
		{
			public int compare(Card pCard1, Card pCard2)
			{ 
				return pCard1.getRank().compareTo(pCard2.getRank()); 
			}
		});
		printAll(cards);
		
		// Calling 'sort' with a method reference
		Collections.sort(cards, Card::compareByRank);
		printAll(cards);
	}
	
	private static void printAll(List<Card> pCards)
	{
		for( Card card : pCards)
		{
			System.out.println(card);
		}
	}
}
