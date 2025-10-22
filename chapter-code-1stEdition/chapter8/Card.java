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
package chapter8;

/**
 * Implementation of a playing card. This class yields immutable objects.
 * This version of the class shows an application of the Flyweight design
 * pattern where the flyweight store is pre-initialized.
 */
public class Card 
{
	// Flyweight store
	private static final Card[][] CARDS = new Card[Suit.values().length][Rank.values().length];
	
	private final Rank aRank;
	private final Suit aSuit;
	
	// Initialization of the flyweight store
	static
	{
		for( Suit suit : Suit.values() )
		{
			for( Rank rank : Rank.values() )
			{
				CARDS[suit.ordinal()][rank.ordinal()] = new Card(rank, suit);
			}
		}
	}
	
	// Private constructor
	private Card( Rank pRank, Suit pSuit)
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
	public static Card get(Rank pRank, Suit pSuit)
	{
		assert pRank != null && pSuit != null;
		return CARDS[pSuit.ordinal()][pRank.ordinal()];
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
