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

import java.util.ArrayList;
import java.util.List;

/**
 * See Section 9.5
 */
public final class CommandClient
{
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Deck deck = new Deck();
		Command draw = new Command(() -> deck.draw());
		Command shuffle = new Command(() -> deck.shuffle());
		
		Deck deck2 = new Deck();
		List<Card> drawnCards = new ArrayList<>();
		DeckCommand draw2 = new DeckCommand("draw", ()-> drawnCards.add(deck2.draw()));
	}
}
