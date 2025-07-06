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
package e3.chapter9;

import java.util.function.Consumer;

/**
 * Sample observable object where the Observer design pattern is applied using
 * functional-style design.
 * 
 * See Section 9.5.
 */
public class ObservableDeck extends Deck {
	private Consumer<Card> aDrawHandler;

	public ObservableDeck(Consumer<Card> pDrawHandler) {
		aDrawHandler = pDrawHandler;
	}

	public Card draw() {
		Card card = super.draw();
		aDrawHandler.accept(card);
		return card;
	}
}
