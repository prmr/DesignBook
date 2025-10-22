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
 *******************************************************************************/
package e3.chapter9;

import e3.chapter9.Suit.Color;

/**
 * Used to demonstrate how to use references to static method.
 * See corresponding client code in class Samples.
 */
public class CardUtils {
	public static boolean hasBlackSuit(Card pCard) {
		return pCard.suit().color() != Color.BLACK;
	}
}
