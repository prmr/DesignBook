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
package chapter7;

import java.util.Iterator;

/**
 * A specialized Deck that stored a reference to 
 * all the cards drawn since the last shuffle.
 */
public class MemorizingDeck extends Deck
{
	private final CardStack aDrawnCards = new CardStack();
	
	/**
	 * @return The cards drawn.
	 */
	public Iterator<Card> getDrawnCards()
	{
		return aDrawnCards.iterator();
	}
	
	@Override
	public void shuffle()
	{
		super.shuffle();
		aDrawnCards.clear();
	}

	@Override
	public Card draw()
	{
		Card card = super.draw();
		aDrawnCards.push(card);
		return card;
	}
}
