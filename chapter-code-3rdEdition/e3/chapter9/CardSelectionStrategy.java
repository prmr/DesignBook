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
 *******************************************************************************/
package e3.chapter9;

import java.util.List;
import java.util.Optional;

/**
 * See section 9.5.
 *
 */
public interface CardSelectionStrategy {
	
	/**
	 * Select an instance of Card from pCards.
	 * 
	 * @param A
	 *            list of cards to choose from.
	 * @pre pCards != null && !pCards.isEmpty()
	 * @post If RETURN.isPresent(), pCards.contains(RETURN.get())
	 */
	Optional<Card> select(List<Card> pCards);

	static Optional<Card> first(List<Card> pCards) {
		return Optional.of(pCards.get(0));
	}

	static Optional<Card> lowestBlackCard(List<Card> pCards) { 
		return null; // This is a stub
	}

	 static Optional<Card> highestFaceCard(List<Card> pCards) { 
		return null; // This is a stub
	}
}
