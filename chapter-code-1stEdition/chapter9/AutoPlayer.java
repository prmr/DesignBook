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
import java.util.function.Function;

public class AutoPlayer
{
	private Function<List<Card>, Card> aSelectionStrategy;

	public AutoPlayer(Function<List<Card>, Card> pSelectionStrategy)
	{
		aSelectionStrategy = pSelectionStrategy;
	}

	@SuppressWarnings("unused")
	public void play()
	{
		Card selected = aSelectionStrategy.apply(getCards());
		/* ... */
	}

	// Gets the cards to supply to the strategy
	private List<Card> getCards()
	{ 
		return null; // this is a stuby
	}
}
