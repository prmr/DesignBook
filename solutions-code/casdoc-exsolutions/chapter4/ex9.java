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
package e2.chapter4;

/**
 * Implementation of a playing card. This class yields immutable objects.
 * This version of the class shows an application of the Flyweight design
 * pattern where the flyweight store is pre-initialized using a bidimensional array.
 */
public class Card {
	
	/*
	 * Implements the flyweight store as a bidimensional array. The 
	 * first dimension indexes the suits by the ordinal value of their enumerated type, 
	 * and the second dimension, the ranks. For example, to retrieve the two of clubs,
	 * we access CARDS[Suit.CLUBS.ordinal()][Rank.TWO.ordinal()]. 
	 */
	private static final Card[][] CARDS = new Card[Suit.values().length][Rank.values().length];
	
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
				CARDS[suit.ordinal()][rank.ordinal()] = new Card(rank, suit);
			}
		}
	}
	
	// Private constructor
	private Card( Rank pRank, Suit pSuit) {
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
	public static Card get(Rank pRank, Suit pSuit) {
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
}

/**
 * Implementation of a playing card. This class yields immutable objects.
 * This version of the class shows an application of the Flyweight design
 * pattern where the flyweight store is pre-initialized using a Map to store the flyweights.
 */
public class Card2 {

	/*
	 * Implements the flyweight store as a Map. The key is a string
	 * that is the concatenation of the rank and suit of the card.
	 * For example, the key for the two of clubs is "TWO of CLUBS".
	 */
	/*?
	 * Keyword: Map<String, Card2>
	 * A Map is a data structure that maps keys to values. In this case, the keys are strings that are the concatenation of the rank and suit of the card. For example, the key for the two of clubs is "TWO of CLUBS". The values are Card instances.
	 * 
	 * Keyword: HashMap<>()
	 * A HashMap is a Map implementation that uses a hash table to store the key-value pairs. The hash table is an array of linked lists. The hash function is the hashCode() method of the key.
	 * 
	 * Internal: hash table
	 * HashMap<>()
	 * A hash table is a data structure that uses a hash function to map keys to values using an array of linked lists. The hash table is an array of linked lists. 
	 * 
	 * Internal: hashCode()
	 * HashMap<>()
	 * The hashCode() method is a method of the Object class that returns an integer that is used as the index in the hash table. The hashCode() method is overridden in the String class to return a hash code for the string. The hashCode() method is overridden in the enumerated types Rank and Suit to return the ordinal value of the enumerated type.
	 */
	private static final Map<String, Card2> CARDS = new HashMap<>();
	
	private final Rank aRank;
	private final Suit aSuit;
	
	// Initialization of the flyweight store as a Map.
	/*?
	 * Keyword: static
	 * A static block is a block of code that is guaranteed to be executed exactly once when the class is loaded before any other code in the class is executed. Here we use it to initialize the flyweight store CARDS by iterating over the enumerated types Suit and Rank and creating a new Card instance for each combination of rank and suit and storing it in the map CARDS. Any card can be retrieved by calling Card.get(Rank, Suit).
	 */
	static {
		for( Suit suit : Suit.values() ) {
			for( Rank rank : Rank.values() ) {
				CARDS.put(rank + " of " + suit, new Card2(rank, suit));
			}
		}
	}
	
	// Private constructor
	private Card2( Rank pRank, Suit pSuit) {
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
	 * 
	 * Internal: Map
	 * CARDS
	 * A Map is a data structure that maps keys to values. In this case, the keys are strings that are the concatenation of the rank and suit of the card. For example, the key for the two of clubs is "TWO of CLUBS". The values are the unique Card instances for each combination of rank and suit.
	 */
	public static Card2 get(Rank pRank, Suit pSuit) {
		assert pRank != null && pSuit != null;
		return CARDS.get(pRank + " of " + pSuit);
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

}

