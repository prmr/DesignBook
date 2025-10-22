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
package e2.chapter7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Represents a deck of playing cards that can be inherited and polymorphically copied.
 */
public class Deck implements CardSource, Iterable<Card>, Cloneable {
	
	private CardStack aCards = new CardStack();
	
	/**
	 * Creates a new deck of 52 cards, shuffled.
	 */
	public Deck() {
		shuffle();
	}
	
	/**
	 * Reinitializes the deck with all 52 cards, and shuffles them.
	 */
	public void shuffle() {
		List<Card> cards = new ArrayList<>();
		for( Suit suit : Suit.values() ) {
            for( Rank rank : Rank.values() ) {
                cards.add( Card.get( rank, suit ));
            }
		}
		Collections.shuffle(cards);
		aCards = new CardStack(cards);
	}
	
	/**
	 * Draws a card from the deck: removes the card from the top
	 * of the deck and returns it.
	 * @return The card drawn.
	 * @pre !isEmpty()
	 */
	public Card draw() {
		assert !isEmpty();
		return aCards.pop();
	}
	
	/**
	 * @return True if and only if there are no cards in the deck.
	 */
	public boolean isEmpty() {
		return aCards.isEmpty();
	}
	
	@Override
	public Iterator<Card> iterator() {
		return aCards.iterator();
	}
	
	@Override
	public Deck clone()
	{
		try
		{
			Deck clone = (Deck) super.clone();
			clone.aCards = new CardStack(aCards);
			return clone;
		}
		catch( CloneNotSupportedException e )
		{
			assert false;
			return null;
		}
	}
}
