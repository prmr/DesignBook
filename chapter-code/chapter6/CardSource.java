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
package chapter6;

/**
 * Represents an entity from which it is possible to obtain cards.
 * This version is cloneable
 */
public interface CardSource extends Cloneable
{
	/**
	 * Returns a card from the source.
	 *
	 * @return The next available card.
	 * @pre !isEmpty()
	 */
	Card draw();
	
	/**
	 * @return True if there is no card in the source.
	 */
	boolean isEmpty();
	
	CardSource clone();
}
