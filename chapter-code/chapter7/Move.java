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
package chapter7;

/**
 * Represents a move in a game of Solitaire
 */
public interface Move
{
	/**
	 * Performs the move.
	 */
	void perform();
	
	/**
	 * Undoes (reverses) the move.
	 */
	void undo();
}
