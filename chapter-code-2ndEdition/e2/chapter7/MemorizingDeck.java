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

import java.util.Iterator;

/**
 * A specialized Deck that stored a reference to 
 * all the cards drawn since the last shuffle.
 */
public class MemorizingDeck extends Deck {
	
	public static void main(String[] args) {
		new MemorizingDeck();
		System.out.println();
	}
	
	private CardStack aDrawnCards = new CardStack();
	
	/**
	 * @return The cards drawn.
	 */
	public Iterator<Card> getDrawnCards() {
		return aDrawnCards.iterator();
	}
	
	@Override
	public void shuffle() {
	
		super.shuffle();
		// The null check is necessary because of field initialization order.
		// Because the constructor of the superclass calls `shuffle()`, the call
		// will also get dispatched down to this method when the constructor of `Deck` is
		// executing. At that point, field `aDrawnCards` is not yet initialized. If you
		// remove the null check, creating a new `MemorizingDeck` will raise a `NullPointerException`.
//		if( aDrawnCards != null ) {
			aDrawnCards = new CardStack();
//		}
	}

	@Override
	public Card draw() {
		Card card = super.draw();
		aDrawnCards.push(card);
		return card;
	}
	
	@Override
	public MemorizingDeck clone()
	{
		MemorizingDeck clone = (MemorizingDeck) super.clone();
		clone.aDrawnCards = new CardStack(aDrawnCards);
		return clone;
	}
}
