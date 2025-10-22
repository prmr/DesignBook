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
package e3.chapter4;

import e3.chapter4.Deck.Shuffler;

public class Client {

	public static void main(String[] args) {
		// Illustration of the use of the Null object
		CardSource source = new Deck();
		System.out.println(source.isNull());
		source = CardSource.NULL;
		System.out.println(source.isNull());

		// Illustration of the use of the Shuffler nested class
		Deck deck = new Deck();
		Shuffler shuffler = deck.newShuffler();
		shuffler.shuffle();
		shuffler.shuffle();
		deck.shuffle();
		System.out.println(shuffler.shuffles());

		// Illustration of the use of the createByRankComparator static factory method
		// The result should always be zero because both decks are freshly initialized.
		System.out.println(Deck.createRankComparator(Rank.ACE).compare(new Deck(), new Deck()));
	}
}
