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
package e2.chapter2;

/**
 * Implementation of a playing card. This class yields immutable objects.
 */
public class Card {

    /*?
     * Keyword: Rank
     * Rank is an enum type that represents the rank of a playing card.
     * 
     * Internal: enum type
     * Rank
     * An enum type is a type that represents a set of named constants, such as the ranks of a playing card.
     */
	private Rank aRank;
    /*?
     * Keyword: Suit
     * Suit is an enum type that represents the suit of a playing card.
     * 
     * Internal: enum type
     * Suit
     * An enum type is a type that represents a set of named constants, such as the suits of a playing card.
     */
	private Suit aSuit;
    /*?
     * Keyword: aIsJoker
     * aIsJoker is a boolean that indicates whether the card is a joker.
     * 
     * Internal: boolean
     * isJoker
     * A boolean is a type that represents a value that can be either true or false.
     */
    private boolean aIsJoker = false; 

	/**
	 * Creates a new card object.
	 * 
	 * @param pRank The rank of the card.
	 * @param pSuit The suit of the card.
	 * @pre pRank != null
	 * @pre pSuit != null
	 */
    /*?
     * Keyword: Card
     * Card is a constructor that creates a new card object using rank, suit, and aIsJoker.
     * 
     * Internal: pIsJoker
     * Card
     * pIsJoker is a boolean that indicates whether the card is a joker. 
     */
	public Card(Rank pRank, Suit pSuit, boolean pIsJoker) {

        /*?
         * Keyword: assert
         * assert is a keyword that checks whether the condition is true. If the condition is false, an AssertionError is thrown. In this case, the condition is that pRank and pSuit are not null.
         * 
         * Internal: AssertionError
         * assert
         * An AssertionError is an error that indicates that an assertion has failed, which means that the condition is false and the program should not continue.
         * 
         * Internal: null
         * assert
         * null is a value that indicates that there is no reference to an object. In this case, the condition is that pRank and pSuit are not null.
         */
		assert pRank != null && pSuit != null;

        aIsJoker = pIsJoker;

        if(aIsJoker) {
            aRank = null;
            aSuit = null;
        }
        else {
            aRank = pRank;
            aSuit = pSuit;      
        }
	}
	
	/**
	 * @return The rank of the card if it is not a joker, null otherwise.
     * 
	 */
	public Rank getRank() {
		return aRank;
	}
	
	/**
	 * @return The suit of the card, null if the card is a joker.
	 */
	public Suit getSuit() {
		return aSuit;
	}
}
