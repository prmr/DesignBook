/*******************************************************************************
 * Companion code for the book "Introduction to Software Design with Java",
 * 2nd edition by Martin P. Robillard.
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
 * Stub of an object that represents the state of a card game. This
 * class is used to illustrate the use of the Prototype design pattern.
 */
public class GameModel {
	
	private final CardSource aCardSourcePrototype;
	
	// In a complete code base this field would be used.
	@SuppressWarnings("unused") 
	private CardSource aCardSource;
	
	public GameModel(CardSource pCardSourcePrototype) {
		aCardSourcePrototype = pCardSourcePrototype;
		newGame();
	}
	
	public void newGame() {
		aCardSource = aCardSourcePrototype.copy();
	}
}
