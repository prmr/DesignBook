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
package e2.chapter6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A deck that logs cards when they are drawn. 
 * Although an implementing class of CardSource,
 * this class is not decorator.
 */
public class LoggingDeck implements CardSource {
	
	private CardStack aCards = new CardStack();
	
	/**
	 * Creates a new deck of 52 cards, shuffled.
	 */
	public LoggingDeck() {
		shuffle();
	}
	
	/**
	 * Reinitializes the deck with all 52 cards, and shuffles them.
	 */
	public void shuffle() {
		List<Card> cards = new ArrayList<>();
		for( Suit suit : Suit.values() ) {
            for( Rank rank : Rank.values())  {
                cards.add( Card.get( rank, suit ));
            }
		}
		Collections.shuffle(cards);
		aCards = new CardStack(cards);
	}

	@Override
	public Card draw() {
		Card card = aCards.pop();
		System.out.println(card);
		return card;
	}

	@Override
	public boolean isEmpty() {
		return aCards.isEmpty();
	}

	@Override
	public CardSource copy() {
		LoggingDeck copy = new LoggingDeck();
		copy.aCards = new CardStack(aCards);
		return copy;
	}
}
