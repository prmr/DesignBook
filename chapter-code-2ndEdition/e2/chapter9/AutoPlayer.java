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

import java.util.List;
import java.util.function.Function;

/**
 * Demonstration code for the Strategy pattern applied
 * using functional-style design. See Section 9.5.
 */
public class AutoPlayer
{
	private Function<List<Card>, Card> aSelectionStrategy;

	public AutoPlayer(Function<List<Card>, Card> pSelectionStrategy) {
		aSelectionStrategy = pSelectionStrategy;
	}

	@SuppressWarnings("unused")
	public void play() {
		Card selected = aSelectionStrategy.apply(getCards());
		/* ... */
	}

	// Gets the cards to supply to the strategy
	private List<Card> getCards() { 
		return null; // this is a stub
	}
}
