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
package e3.chapter8;

/**
 * An object that observes a CardStack. Design with push data flow.
 */
public interface CardStackObserver {
	default void pushed(Card pCard) {}
	default void popped(Card pCard) {}
	default void cleared() {}
}
