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
 * This version of the class is checkable for equality.
 */
public class Card
{
	/* Code that relies on the equals and hashCode methods */
	public static void main(String[] args)
	{
        // Create three cards with the same rank and suit
		Card card1 = new Card(Rank.ACE, Suit.CLUBS);
		Card card2 = new Card(Rank.ACE, Suit.DIAMONDS);
		Card card3 = new Card(Rank.ACE, Suit.CLUBS);
        // Create a hash set and add the cards to it
		HashSet<Card> set = new HashSet<>();
		set.add(card1);
		set.add(card2);
        // Check that the cards are equal and that the set contains two cards
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
	public Card(Rank pRank, Suit pSuit)
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

	/*?
	 * Keyword: @Override
	 * @Override is an annotation that indicates that the method is intended to override a method in a superclass. Here, we are overriding the hashCode method because we want to set a unique hash code for each card. The default implementation of hashCode in the Object class returns a hash code based on the memory address of the object. This is not a good hash code for a card because we want two card objects with the same rank and suit to have the same hash code.
	 *
	 */
	@Override
	/*?
	 * Keyword: hashCode
	 * The hashCode method returns an integer that is used to identify the object. The hash code is used to determine where the object is stored in a hash table. The hash code is also used to determine whether two objects are equal. If two objects have the same hash code, then the equals method is called to determine whether the objects are equal. If the hash codes are different, then the objects are not equal. The hash code is also used to determine the order of objects in a hash set or hash map. The hash code is not intended to be a unique identifier for the object. It is possible for two objects to have the same hash code. However, it is very unlikely that two objects with different hash codes will be equal. We define the hashCode() function to be the ordinal of the suit times the number of ranks plus the ordinal of the rank. This is a unique number for each card.
	 * 
	 * Internal: hash table
	 * hashCode
	 * A Hash Table is a data structure that stores key-value pairs. The key is used to determine where the value is stored in the table. The key is also used to determine whether two values are equal. If two values have the same key, then the equals method is called to determine whether the values are equal. If the keys are different, then the values are not equal. The key is also used to determine the order of values in a hash set or hash map. The key is not intended to be a unique identifier for the value. It is possible for two values to have the same key. However, it is very unlikely that two values with different keys will be equal.
	 */
	public int hashCode()
	{
		return aSuit.ordinal() * Rank.values().length + aRank.ordinal();
	}

	/*?
	 * Keyword: @Override
	 * @Override is an annotation that indicates that the method is intended to override a method in a superclass. Here, we are overriding the equals method because we want to set a unique hash code for each card. The default implementation of equals in the Object class returns true if the two objects are the same object. This is not a good implementation for a card because we want two card objects with the same rank and suit to be equal.
	 */
	@Override
	/*?
	 * Keyword: equals
	 * The equals method is used to determine whether two objects are equal. The equals method is called when two objects are compared using the == operator. The equals method is also called when an object is added to a hash set or hash map. If the hash codes of the two objects are different, then the objects are not equal. If the hash codes are the same, then the equals method is called to determine whether the objects are equal. We define the equals method to be true if the two objects are the same object or if the two objects have the same rank and suit.
	 */
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
		Card other = (Card) pObject;
		return aSuit == other.aSuit && aRank == other.aRank;
	}

}
