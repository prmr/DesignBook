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

import java.util.HashSet;

/**
 * Implementation of a playing card. This class yields immutable objects.
 * This version of the class is checkable for quality.
 */
public class Card5
{
	/* Code that relies on the equals and hashCode methods */
	public static void main(String[] args)
	{
		Card5 card1 = new Card5(Rank.ACE, Suit.CLUBS);
		Card5 card2 = new Card5(Rank.ACE, Suit.DIAMONDS);
		Card5 card3 = new Card5(Rank.ACE, Suit.CLUBS);
		HashSet<Card5> set = new HashSet<>();
		set.add(card1);
		set.add(card2);
		assert card1.equals(card3);
		assert set.size() == 2;
		assert !set.add(card3);
		System.out.println("No errors");
	}
		
	private Rank aRank;
	private Suit aSuit;
	
	/**
	 * Creates a new card object.
	 * 
	 * @param pRank The rank of the card.
	 * @param pSuit The suit of the card.
	 * @pre pRank != null
	 * @pre pSuit != null
	 */
	public Card5(Rank pRank, Suit pSuit)
	{
		assert pRank != null && pSuit != null;
		aRank = pRank;
		aSuit = pSuit;
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
	public int hashCode()
	{
		return aSuit.ordinal() * Rank.values().length + aRank.ordinal();
	}

	@Override
	public boolean equals(Object pObject)
	{
		if(this == pObject)
		{
			return true;
		}
		if(pObject == null || getClass() != pObject.getClass())
		{
			return false;
		}
		Card5 other = (Card5) pObject;
		return aSuit == other.aSuit && aRank == other.aRank;
	}

}
