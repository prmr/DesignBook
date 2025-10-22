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
package e3.chapter6;

/**
 * A CardSource decorator that logs cards drawn from the source.
 */
public class LoggingDecorator implements CardSource {

	private CardSource aSource;

	public LoggingDecorator(CardSource pSource) {
		aSource = pSource;
	}

	@Override
	public Card draw() {
		Card card = aSource.draw();
		System.out.println(card);
		return card;
	}

	@Override
	public boolean isEmpty() {
		return aSource.isEmpty();
	}

	@Override
	public CardSource copy() {
		return new LoggingDecorator(aSource.copy());
	}
}
