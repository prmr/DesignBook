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
package e3.chapter7;

/**
 * Decorator that prints the card drawn on the console.
 */
public class LoggingDecorator extends AbstractDecorator {

	public LoggingDecorator(CardSource pElement) {
		super(pElement);
	}

	@Override
	public Card draw() {
		Card card = super.draw();
		System.out.println(String.format("Draws %s", card));
		return card;
	}
}
