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

public abstract class AbstractDecorator implements CardSource {
	
	private final CardSource aElement;
	
	protected AbstractDecorator( CardSource pElement ) {
		aElement = pElement;
	}
	
	@Override
	public Card draw() {
		return aElement.draw();
	}

	@Override
	public boolean isEmpty() {
		return aElement.isEmpty();
	}
}
