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
package e2.chapter9;

import java.util.function.Supplier;

/**
 * Demonstrates how to use the Supplier interface to obtain
 * card in the context of a card source that can supply an infinity
 * of card.
 * 
 * See Section 9.4
 */
public class InfiniteCardSource implements CardSource {
	
	/**
	 * Code that illustrates how to use this class
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		InfiniteCardSource randomCards = new InfiniteCardSource(Card::random);
		InfiniteCardSource acesOfHeart = new InfiniteCardSource(() -> Card.get(Rank.ACE, Suit.HEARTS));
	}
	
	private final Supplier<Card> aCardSupplier;

	public InfiniteCardSource(Supplier<Card> pCardSupplier) {
		aCardSupplier = pCardSupplier;
	}

	public Card draw() {
		return aCardSupplier.get();
	}

	public boolean isEmpty() {
		return false;
	}
}
