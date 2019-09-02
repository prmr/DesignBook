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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * Code samples for Sections 9.1-9.3
 *
 */
public class Samples
{	
	public static void main(String[] args)
	{
		samples1();
		samples2();
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
	
	/**
	 * For Section 9.2
	 */
	@SuppressWarnings("unused")
	private static void samples2()
	{
		// Defining a function object of type Filter, which is an application-defined functional interface
		Filter blackCards1 = new Filter()
		{
			public boolean accept(Card pCard)
			{
				return pCard.getSuit().getColor() == Suit.Color.BLACK;
			}
		};
		
		// Defining a function object whose type is a library functional interface
		Predicate<Card> blackCards2 = new Predicate<Card>()
		{
			public boolean test(Card pCard)
			{
				return pCard.getSuit().getColor() == Suit.Color.BLACK;
			}
		};
		
		// Defining a predicate using a lambda expression (expression syntax with parameter type specified)
		Predicate<Card> blackCards3 = (Card card) -> card.getSuit().getColor() == Suit.Color.BLACK;
		
		// Defining a predicate using a lambda expression (block syntax with parameter type specified)
		Predicate<Card> blackCards4 =
				(Card card) -> { return card.getSuit().getColor() == Suit.Color.BLACK; };
				
		// Defining a predicate using a lambda expression (expression syntax with parameter type not specified)
		Predicate<Card> blackCards5 = (card) -> card.getSuit().getColor() == Suit.Color.BLACK;
		
		// Defining a predicate using a lambda expression (expression syntax with parameter type not specified
		// and no parentheses around the parameter
		Predicate<Card> blackCards6 = card -> card.getSuit().getColor() == Suit.Color.BLACK;
		
		// Sample use of the filter:
		int total = 0;
		for( Card card : new Deck().getCards() )
		{
			if( blackCards6.test(card) )
			{
				total++;
			}
		}
		System.out.println(total);
		
		// Example use of removeIf
		ArrayList<Card> cards = new ArrayList<>(new Deck().getCards());
		cards.removeIf(card -> card.getSuit().getColor() == Suit.Color.BLACK );
		printAll(cards);
		
		// Example of using a method reference with removeIf
		cards = new ArrayList<>(new Deck().getCards());
		cards.removeIf(Card::hasBlackSuit);
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
