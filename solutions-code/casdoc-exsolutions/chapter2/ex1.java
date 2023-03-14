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

package chapter2;

/**
 * Implementation of a playing card. This class yields immutable objects.
 * This version is a facetious implementation with 6 Boolean values.
 */
public class Card {
	
	/*?
	 * Keyword: aIsRed
	 * `aIsRed` is a boolean that is true if the suit is hearts or diamonds.
	 */
	private boolean aIsRed = false;

	/*?
	 * Keyword: aIsHighSuit
	 * `aIsHighSuit` is a boolean that is true if the suit is hearts or spades.
	 */
	private boolean aIsHighSuit = false;

	/*?
	 * Keyword: aRank1
	 * `aRank1` is a boolean that is true if the rank is odd.
	 */
	private boolean aRank1 = false;
	
	/*?
	 * Keyword: aRank2
	 * `aRank2` is a boolean that is true if the rank is divisible by 2.
	 */
	private boolean aRank2 = false;

	/*?
	 * Keyword: aRank3
	 * `aRank3` is a boolean that is true if the rank is divisible by 4.
	 */
	private boolean aRank3 = false;

	/*?
	 * Keyword: aRank4
	 * `aRank4` is a boolean that is true if the rank is divisible by 8.
	 */
	private boolean aRank4 = false;

	/**
	 * How to properly write automated tests such as this one
	 * is the topic of Chapter 5.
	 */
	public static void main(String[] args) {
		for (Rank rank : Rank.values()) {
			for (Suit suit : Suit.values()) {
				Card card = new Card(rank, suit); // create a new card object with the rank and suit of the current
													// iteration
				assert card.getRank() == rank; // assert that the rank of the card is equal to the rank of the current
												// iteration
				assert card.getSuit() == suit;
				System.out.println(card);
			}
		}
	}

	/**
	 * Creates a new card object.
	 * 
	 * @param pRank The rank of the card.
	 * @param pSuit The suit of the card.
	 * @pre pRank != null
	 * @pre pSuit != null
	 */

	/*?
	 * Block: 6
	 * Constructor
	 * This is a constructor that takes in a rank and a suit and sets the value of
	 * aIsRed, aIsHighSuit, aRank1, aRank2, aRank3, and aRank4, so that the card
	 * object is created. 
	 * 
	 * Internal: constructor
	 * 6
	 * A constructor is a method that creates an object.
	 *
	 */
	public Card(Rank pRank, Suit pSuit) {

		assert pRank != null && pSuit != null;
		fromSuit(pSuit);
		fromRank(pRank);
	}

	/**
	 * @return The rank of the card.
	 */

	/*?
	 * Keyword: fromSuit
	 * fromSuit is a method that sets the value of aIsRed and aIsHighSuit using a mini-decision tree for the suit (red vs. black, high vs. low)
	 * 
	 * Internal: aIsRed
	 * fromSuit
	 * aIsRed is set to true if the suit is hearts or diamonds.
	 * 
	 * Internal: aIsHighSuit
	 * fromSuit
	 * aIsHighSuit is set to true if the suit is hearts or spades.
	 * 
	 */
	private void fromSuit(Suit pSuit) {
		if (pSuit == Suit.HEARTS || pSuit == Suit.DIAMONDS) {
			aIsRed = true;
		}
		if (pSuit == Suit.HEARTS || pSuit == Suit.SPADES) {
			aIsHighSuit = true;
		}
	}

	/**
	 * @return The suit of the card.
	 */


	 /*?
	 * Keyword: fromRank
	 * fromRank is a method that sets the value of aRank1, aRank2, aRank3, and aRank4 using standard integer to binary base conversion algorithm for the rank.
	 * 
	 * Internal: aRank1
	 * fromRank
	 * aRank1 is set to true if the rank is odd.
	 * 
	 * Internal: aRank2
	 * fromRank
	 * aRank2 is set to true if the rank is divisible by 2.
	 * 
	 * Internal: aRank3
	 * fromRank
	 * aRank3 is set to true if the rank is divisible by 4.
	 * 
	 * Internal: aRank4
	 * fromRank
	 * aRank4 is set to true if the rank is divisible by 8.
	 *
	 * 
	 * 
	 */
	private void fromRank(Rank pRank) {
		int value = pRank.ordinal();
		aRank1 = value % 2 == 1;
		value /= 2;
		aRank2 = value % 2 == 1;
		value /= 2;
		aRank3 = value % 2 == 1;
		value /= 2;
		aRank4 = value % 2 == 1;
		value /= 2;
	}

	/**
	 * @return The rank of the card.
	 */

	/*?
	 * Keyword: getRank
	 * getRank is a method that returns the rank of the card.
	 */
	public Rank getRank() {
		int value = 0;
		if (aRank4 == true) {
			value += 8;
		}
		if (aRank3 == true) {
			value += 4;
		}
		if (aRank2 == true) {
			value += 2;
		}
		if (aRank1 == true) {
			value += 1;
		}
		return Rank.values()[value];
	}

	/**
	 * @return The suit of the card.
	 */

	/*?
	 * Keyword: getSuit
	 * getSuit is a method that returns the suit of the card.
	 */
	public Suit getSuit() {
		if (aIsRed) {
			if (aIsHighSuit) {
				return Suit.HEARTS;
			} else {
				return Suit.DIAMONDS;
			}
		} else {
			if (aIsHighSuit) {
				return Suit.SPADES;
			} else {
				return Suit.CLUBS;
			}
		}
	}

	/**
	 * @return True if the card is red.
	 */

	/*?
	 * Keyword: toString
	 * toString is a method that returns the rank and suit of the card, for example,
	 * "Ace of Spades".
	 */
	@Override
	public String toString() {
		return String.format("%s of %s", getRank(), getSuit());
	}
}
