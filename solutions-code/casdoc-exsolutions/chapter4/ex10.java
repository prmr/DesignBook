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
package chapter4;

import System.currentTimeMillis;

/**
 * Implementation of a playing card. This class yields immutable objects.
 * This version of the class shows an application of the Flyweight design
 * pattern where the flyweight store is lazily-initialized. Lazy initialization means that the flyweight store is not initialized until the first time the get() method is called. Each time get() is called, it checks if the requested card is already in the flyweight store. If it is, it returns it. If it is not, it creates a new card and stores it in the flyweight store before returning it.
 */
public class CardLazy
{
    /*?
     * Keyword: CARDS
     * CARDS is the flyweight store implemented as a bidimensional array. The first dimension indexes the suits by the ordinal value of their enumerated type, and the second dimension, the ranks. For example, to retrieve the two of clubs, we access CARDS[Suit.CLUBS.ordinal()][Rank.TWO.ordinal()].
     */
	private static final CardLazy[][] CARDS = new CardLazy[Suit.values().length][Rank.values().length];
	
	private final Rank aRank;
	private final Suit aSuit;
	
	// Private constructor
	private CardLazy(Rank pRank, Suit pSuit)
	{
		aRank = pRank;
		aSuit = pSuit;
	}
	
	/**
	 * @param pRank The rank of the requested card.
	 * @param pSuit The suit of the requested card.
	 * @return The unique Card instance with pRank and pSuit
	 * @pre pRank != null && pSuit != null
	 */

    /*?
     * Keyword: get
     * The get() method is the only way to obtain a Card instance. It is static because it is a factory method. It is final because it is a template method. It is public because it is an interface method. It is a Flyweight factory method because it returns a flyweight object by creating it if it does not exist yet and returning it if it does. Lazy initialization means that the flyweight store is not initialized until the first time the get() method is called. Each time get() is called, it checks if the requested card is already in the flyweight store. If it is, it returns it. If it is not, it creates a new card and stores it in the flyweight store before returning it.
     */
	public static CardLazy get(Rank pRank, Suit pSuit)
	{
		assert pRank != null && pSuit != null;
		CardLazy card = CARDS[pSuit.ordinal()][pRank.ordinal()]; //Check if card already exists in the flyweight store
		if( card == null ) //If it does not exist, create it and store it in the flyweight store
		{
			card = new CardLazy(pRank, pSuit);
			CARDS[pSuit.ordinal()][pRank.ordinal()] = card;
		}
		return card; //Return the card
	}


	
	/**
	 * @return The rank of the card.
	 */
	public Rank getRank()
	{
		return aRank;
	}
	
	/**
	 * @return The suit of the card.
	 */
	public Suit getSuit()
	{
		return aSuit;
	}
	
	@Override
	public String toString()
	{
		return String.format("%s of %s", aRank, aSuit);
	}
}

public class CardPreInstantiated {
	
	/*
	 * Implements the flyweight store as a bidimensional array. The 
	 * first dimension indexes the suits by the ordinal value of their enumerated type, 
	 * and the second dimension, the ranks. For example, to retrieve the two of clubs,
	 * we access CARDS[Suit.CLUBS.ordinal()][Rank.TWO.ordinal()]. 
	 */
	private static final CardPreInstantiated[][] CARDS = new CardPreInstantiated[Suit.values().length][Rank.values().length];
	
	private final Rank aRank;
	private final Suit aSuit;
	
	// Initialization of the flyweight store as a bidimensional array.
	/*?
	 * Keyword: static
	 * A static block is a block of code that is guaranteed to be executed exactly once when the class is loaded before any other code in the class is executed. Here we use it to initialize the flyweight store CARDS[][] by iterating over the enumerated types Suit and Rank and creating a new Card instance for each combination of rank and suit and storing it in the appropriate location in the array. Any card can be retrieved by calling Card.get(Rank, Suit).
	 */
	static {
		for( Suit suit : Suit.values() ) {
			for( Rank rank : Rank.values() ) {
				CARDS[suit.ordinal()][rank.ordinal()] = new CardPreInstantiated(rank, suit);
			}
		}
	}
	
	// Private constructor
	private CardPreInstantiated( Rank pRank, Suit pSuit) {
		aRank = pRank;
		aSuit = pSuit;
	}
	
	/**
	 * @param pRank The rank of the requested card.
	 * @param pSuit The suit of the requested card.
	 * @return The unique Card instance with pRank and pSuit
	 * @pre pRank != null && pSuit != null
	 */
	/*?
	 * Keyword: get
	 * This method is a factory method that returns a unique instance of Card for each combination of rank and suit. The method is static because it is not associated with a particular instance of Card. The method is public because it is part of the public interface of the class. The method is final because it is not intended to be overridden by subclasses. get() returns a card instance for the given rank and suit.
	 * 
	 * Internal: factory method
	 * get
	 * A factory method is a method that returns an instance of a class. In this case, the method returns a unique instance of Card for each combination of rank and suit.
	 */
	public static CardPreInstantiated get(Rank pRank, Suit pSuit) {
		assert pRank != null && pSuit != null;
		return CARDS[pSuit.ordinal()][pRank.ordinal()];
	}
	
	/**
	 * @return The rank of the card.
	 */
	public Rank getRank() {
		return aRank;
	}
	
	/**
	 * @return The suit of the card.
	 */
	public Suit getSuit() {
		return aSuit;
	}
	
	@Override
	public String toString() {
		return String.format("%s of %s", aRank, aSuit);
	}

    public static void main(String[] args) {
        //Using currentTimeMillis(), compare the time needed to obtain all 52 cards using pre-instantiation and lazy initialization
        
        /*?
         * Keyword: currentTimeMillis
         * The currentTimeMillis() method returns the current time in milliseconds in long format. It is used to measure the time it takes to execute a piece of code.
         * 
         * Internal: long format
         * currentTimeMillis
         * The long format is a 64-bit integer.
         */
        long start = currentTimeMillis();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                CardPreInstantiated.get(rank, suit);
            }
        }
        long end = currentTimeMillis();
        System.out.println("Pre-instantiation: " + (end - start) + " ms");


        start = currentTimeMillis();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                CardLazy.get(rank, suit);
            }
        }
        end = currentTimeMillis();
        System.out.println("Lazy initialization: " + (end - start) + " ms");

    }
}
