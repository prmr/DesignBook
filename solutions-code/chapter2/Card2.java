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
public class Card2
{
	private boolean aIsRed = false;
	private boolean aIsHighSuit = false;
	private boolean aRank1 = false;
	private boolean aRank2 = false;
	private boolean aRank3 = false;
	private boolean aRank4 = false;
	
	/**
	 * How to properly write automated tests such as this one 
	 * is the topic of Chapter 5.
	 */
	public static void main(String[] args)
	{
		for( Rank rank : Rank.values() )
		{
			for( Suit suit : Suit.values() )
			{
				Card2 card = new Card2(rank, suit);
				assert card.getRank() == rank;
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
	public Card2(Rank pRank, Suit pSuit)
	{
		assert pRank != null && pSuit != null;
		fromSuit(pSuit);
		fromRank(pRank);
	}
	
	private void fromSuit(Suit pSuit)
	{
		if( pSuit == Suit.HEARTS || pSuit == Suit.DIAMONDS )
		{
			aIsRed = true;
		}
		if( pSuit == Suit.HEARTS || pSuit == Suit.SPADES )
		{
			aIsHighSuit = true;
		}
	}
	
	private void fromRank(Rank pRank)
	{
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
	public Rank getRank()
	{
		int value = 0;
		if( aRank4 == true )
		{
			value += 8;
		}
		if( aRank3 == true )
		{
			value += 4;
		}
		if( aRank2 == true )
		{
			value += 2;
		}
		if( aRank1 == true )
		{
			value += 1;
		}
		return Rank.values()[value];
	}
	
	/**
	 * @return The suit of the card.
	 */
	public Suit getSuit()
	{
		if( aIsRed )
		{
			if( aIsHighSuit )
			{
				return Suit.HEARTS;
			}
			else
			{
				return Suit.DIAMONDS;
			}
		}
		else
		{
			if( aIsHighSuit )
			{
				return Suit.SPADES;
			}
			else
			{
				return Suit.CLUBS;
			}
		}
	}
	
	@Override
	public String toString()
	{
		return String.format("%s of %s", getRank(), getSuit());
	}
}
