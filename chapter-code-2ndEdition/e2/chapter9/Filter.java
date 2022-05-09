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

/**
 * Functional interface used in Section 9.2.
 */
public interface Filter {
	
	/**
	 * @param pCard The card to test
	 * @return True if this filter accepts pCard
	 * @pre pCard != null
	 */
	boolean accept(Card pCard);
}
