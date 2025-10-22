/*******************************************************************************
 * Companion code for the book "Introduction to Software Design with Java",
 * 3rd edition by Martin P. Robillard.
 *
 * Copyright (C) 2025 by Martin P. Robillard
 *
 * This code is licensed under a Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * 
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 * 
 *******************************************************************************/
package e3.chapter5;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/*
 * Sample class under test. This class is a simplified
 * component of the Solitaire application responsible for
 * managing one of the top four piles of cards at the top
 * of a game of Solitaire.
 */
public class FoundationPile {
	
	private List<Card> aPile = new ArrayList<>();
	
	public boolean isEmpty() { 
		return aPile.isEmpty();
	}
	
	public Card peek() {
		if( isEmpty() ) { 
			throw new EmptyStackException(); 
		}
		return aPile.get(aPile.size() - 1);
	}
	
	public Card pop() { 
		if( isEmpty() ) { 
			throw new EmptyStackException(); 
		}
		return aPile.remove(aPile.size() - 1 );
	}
	
	public void push(Card pCard) {
		assert pCard != null;
		aPile.add(pCard);
	}
	
	public boolean canMoveTo(Card pCard) {
		assert pCard != null;
		if( isEmpty() ) {
			return pCard.rank() == Rank.ACE;
		}
		else {
			return pCard.suit() == peek().suit() &&
					pCard.rank().ordinal() ==
					peek().rank().ordinal()+1;
		}
	}
	
	@SuppressWarnings("unused")
	private Suit getSuit() {
		assert !isEmpty();
		return aPile.getFirst().suit();
	}
}
