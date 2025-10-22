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
package e1.chapter7;

import java.util.Iterator;

/**
 * A specialized Deck that stored a reference to 
 * all the cards drawn since the last shuffle.
 */
public class MemorizingDeck extends Deck
{
	public static void main(String[] args)
	{
		new MemorizingDeck();
	}
	
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
		if( aDrawnCards != null )
		{
			// Without the null check, attempting to create a new MemorizingDeck()
			// will throw a NullPointerException because of the order of field
			// initialization. When the constructor is called, the first 
			// instruction is to call the super-constructor. At this point, 
			// aDrawnCards is not yet initialized, and thus refers to null.
			// Then the constructor of Deck executes, which calls method shuffle(). 
			// However, because this method is now overridden it is this 
			// implementation that gets selected and executes without aDrawnCards
			// having been initialized
			aDrawnCards.clear();
		}
	}

	@Override
	public Card draw()
	{
		Card card = super.draw();
		aDrawnCards.push(card);
		return card;
	}
}
