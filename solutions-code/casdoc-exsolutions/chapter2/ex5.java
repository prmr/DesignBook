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

public enum Joker {
    HIGH_JOKER, LOW_JOKER, JOKER1, JOKER2, JOKER3, NOT_JOKER;
}

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

    /*?
     * Keyword: Joker
     * Joker is an enum type that represents the joker of a playing card.
     * 
     * Internal: enum type
     * Joker
     * An enum type is a type that represents a set of named constants, such as the jokers of a playing card.
     */
    private Joker aJoker;


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
     * Card is a constructor that creates a new card object using rank, suit, and PJoker.
     * 
     * Internal: pJoker
     * Card
     * pJoker is a Joker that represents the joker type of a playing card. It is an enum type that represents the joker of a playing card.
     * 
     * Internal: enum type
     * pJoker
     * An enum type is a type that represents a set of named constants, such as the jokers of a playing card.
     * 
     */
	public Card(Rank pRank, Suit pSuit, Joker pJoker) {

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
        aRank = pRank;
        aSuit = pSuit;
        /*?
         * Keyword: pJoker == null
         * pJoker == null is a condition that checks whether pJoker is null. If pJoker is null, aJoker is set to Joker.NOT_JOKER. If pJoker is not null, aJoker is set to pJoker.
         */
        if (pJoker == null) {
            aJoker = Joker.NOT_JOKER;
        } else {
            aJoker = pJoker;
        }
    }
	
	/**
	 * @return The rank of the card if it is not a joker, null otherwise.
     * 
	 */

    /*?
     * Keyword: getRank
     * getRank is a method that returns the rank of the card if it is not a joker, null otherwise.
     * 
     * Internal: null
     * getRank
     * null is a value that indicates that there is no reference to an object. In this case, it is null if the card is a joker.
     */
	public Rank getRank() {
		return aRank;
	}
	
	/**
	 * @return The suit of the card, null if the card is a joker.
	 */
    /*?
     * Keyword: getSuit
     * getSuit is a method that returns the suit of the card, null if the card is a joker.
     * 
     * Internal: null
     * getSuit
     * null is a value that indicates that there is no reference to an object. In this case, it is null if the card is a joker.
     */
	public Suit getSuit() {
		return aSuit;
	}

    /**
     * @return The joker of the card, null if the card is not a joker.
     */
    /*?
     * Keyword: getJoker
     * getJoker is a method that returns the joker of the card, null if the card is not a joker.
     * 
     */
    public Joker getJoker() {
        return aJoker;
    }

     /**
     * Returns whether the card is a Joker or not.
     * 
     * @return True if the card is a Joker, false otherwise.
     */
    /*?
        * Keyword: isJoker
        * isJoker is a method that returns true if the card is a Joker.
        *
        */
    public boolean isJoker() {
        return aJoker != JokerType.NO_JOKER;
    }
}
