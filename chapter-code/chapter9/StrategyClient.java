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
package chapter9;

/**
 * See Section 9.5
 */
public final class StrategyClient
{
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		AutoPlayer player1 = new AutoPlayer(cards -> cards.get(0));
		AutoPlayer player2 = new AutoPlayer(CardSelection::lowestBlackCard);
	}
}
