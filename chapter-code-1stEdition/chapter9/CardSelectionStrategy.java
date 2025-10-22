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
package chapter9;

import java.util.List;
import java.util.Optional;

public interface CardSelectionStrategy
{
	/**
	 * Select an instance of Card from pCards.
	 * 
	 * @param A
	 *            list of cards to choose from.
	 * @pre pCards != null && !pCards.isEmpty()
	 * @post If RETURN.isPresent(), pCards.contains(RETURN.get())
	 */
	Optional<Card> select(List<Card> pCards);

	public static Optional<Card> first(List<Card> pCards)
	{
		return Optional.of(pCards.get(0));
	}

	public static Optional<Card> lowestBlackCard(List<Card> pCards)
	{ 
		return null; // This is a stub
	}

	public static Optional<Card> highestFaceCard(List<Card> pCards)
	{ 
		return null; // This is a stub
	}
}