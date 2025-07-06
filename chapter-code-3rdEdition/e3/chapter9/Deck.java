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
package e3.chapter9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * Models a deck of 52 cards.
 */
public class Deck implements CardSource
{
	private CardStack aCards;
	
	/**
	 * @return A new List that contains all the cards in this deck.
	 */
	public List<Card> getCards()
	{
		ArrayList<Card> result = new ArrayList<>();
		for(Card card : aCards )
		{
			result.add(card);
		}
		return result;
	}
	
	public Stream<Card> stream() 
	{ 
		return aCards.stream(); 
	}
	
	/**
	 * @return The card at the top of the deck.
	 */
	public Card peek()
	{
		return aCards.peek();
	}
	
	/**
	 * Creates a new deck of 52 cards, shuffled.
	 */
	public Deck()
	{
		shuffle();
	}
	
	/**
	 * Reinitializes the deck with all 52 cards, and shuffles them.
	 */
	public void shuffle()
	{
		List<Card> cards = new ArrayList<>();
		for( Suit suit : Suit.values() )
		{
            for( Rank rank : Rank.values() )
            {
                cards.add( Card.get( rank, suit ));
            }
		}
		Collections.shuffle(cards);
		aCards = new CardStack(cards);
	}
	
	/**
	 * Draws a card from the deck and removes the card from the deck.
	 * @return The card drawn.
	 * @pre !isEmpty()
	 */
	public Card draw()
	{
		assert !isEmpty();
		return aCards.pop();
	}
	
	/**
	 * @return True iff there are no cards in the deck.
	 */
	public boolean isEmpty()
	{
		return aCards.isEmpty();
	}
	
	/**
	 * @param pCard A card to test
	 * @return True iff the suit color of pCard is the same as the one
	 * of the card on the top of the deck.
	 * @pre !isEmpty()
	 * @pre pCard != null
	 */
	public boolean topSameColorAs(Card pCard)
	{
		assert !isEmpty() && pCard != null;
		return peek().getSuit().getColor() == pCard.getSuit().getColor();
	}
}
