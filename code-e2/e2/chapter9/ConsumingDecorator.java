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

import java.util.function.Consumer;

/**
 * Demonstrates how to use the Consumer interface to process card in the context
 * of CardSource decorator
 * 
 * See Section 9.4
 */
public class ConsumingDecorator implements CardSource {

	private final CardSource aSource;
	private final Consumer<Card> aCardConsumer;
	
	/**
	 * Illustrates who to create a decorated card source
	 * that prints every card drawn to the console.
	 */
	public static void main(String[] args) {
		ConsumingDecorator source = new ConsumingDecorator(new Deck(), System.out::println);
		source.draw();
		source.draw();
		source.draw();
	}

	public ConsumingDecorator(CardSource pSource, Consumer<Card> pCardConsumer) {
		aSource = pSource;
		aCardConsumer = pCardConsumer;
	}

	public Card draw() {
		Card card = aSource.draw();
		aCardConsumer.accept(card);
		return card;
	}

	public boolean isEmpty() {
		return aSource.isEmpty();
	}
}
