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

import java.util.function.Supplier;

/**
 * See Section 9.4
 */
public class CardViewer
{
	public static void main(String[] args)
	{
		// Sample client code
		Deck deck = new Deck();
		CardViewer viewer = new CardViewer( () -> deck.peek() );
		viewer.show();
	}
	
	private Supplier<Card> aCardSupplier;

	public CardViewer(Supplier<Card> pCardSupplier)
	{
		aCardSupplier = pCardSupplier;
	}

	public void show()
	{
		Card card = aCardSupplier.get();
		// Show the card.
		System.out.println(card);
	}
}
