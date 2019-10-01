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
package chapter4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a deck of playing cards. Simple version that 
 * includes the jokers.
 */
public class Deck4
{
	private List<Card4> aCards = new ArrayList<>();
	
	/**
	 * Creates a new deck of 54 cards, shuffled.
	 */
	public Deck4()
	{
		shuffle();
	}
	
	/**
	 * Reinitializes the deck with all 54 cards, and shuffles them.
	 */
	public void shuffle()
	{
		aCards.clear();
		for( Suit suit : Suit.values() )
		{
            for( Rank rank : Rank.values() )
            {
                aCards.add( new Card4( rank, suit ));
            }
		}
		aCards.add(new Card4(true));
		aCards.add(new Card4(false));
		Collections.shuffle(aCards);
	}
	
	/**
	 * Draws a card from the deck: removes the card from the top
	 * of the deck and returns it.
	 * @return The card drawn.
	 * @pre !isEmpty()
	 */
	public Card4 draw()
	{
		assert !isEmpty();
		return aCards.remove(aCards.size() - 1);
	}
	
	/**
	 * @return True if and only if there are no cards in the deck.
	 */
	public boolean isEmpty()
	{
		return aCards.isEmpty();
	}
}

