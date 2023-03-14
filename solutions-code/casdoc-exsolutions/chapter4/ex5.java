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

import java.util.Optional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Implementation of a playing card. This class yields immutable objects.
 * This version of the class also implements the Comparable interface and
 * compares cards by rank, with an undefined order for cards of the same rank.
 * The class also includes a static factory method to create Comparator
 * objects that can compare cards according to their rank.
 */
public class Card implements Comparable<Card>
{
	// Use as a tester for the comparisons with jokers
	public static void main(String[] args)
	{
		Card whiteJoker = new Card(true);
		Card blackJoker = new Card(false);
		assert whiteJoker.compareTo(blackJoker) < 0;
		assert whiteJoker.compareTo(whiteJoker) == 0;
		Deck deck = new Deck();
		while( !deck.isEmpty() )
		{
			Card card = deck.draw();
			if( !card.isJoker() )
			{
				assert card.compareTo(whiteJoker) < 0;
				assert card.compareTo(blackJoker) < 0;
			}
		}
		System.out.println("Done");
	}
	
	/*?
	 * Keyword: Joker
	 * A joker is a special card that can be used as any other card. We use enums to represent the two jokers because they are immutable and have a finite number of values.
	 */
	private enum Joker { WHITE, BLACK }
	
	/*?
     * Keyword: Optional<Rank>
     * The Optional generic class is a container object that may or may not contain a non-null value. If a value is present, isPresent() returns true and get() returns the value. If a value is not present, isPresent() returns false and get() throws an exception. We can use the Optional class to represent the rank and suit of a card, because a joker does not have a rank or suit.
     * 
     * Internal: generic class
     * Optional<Rank>
     * A generic class is a class that can be used with any type. In this case, we use the Optional class with the Rank enum. If a card is a joker, then it does not have a rank or suit, so we use the Optional class to represent the rank and suit of a card.
     * 
     * Internal: isPresent()
     * Optional<Rank>
     * isPresent() returns true if the Optional object contains a value, and false if it does not.
     */
	private final Optional<Rank> aRank;

    /*?
     * Keyword: Optional<Suit>
     * The Optional generic class is a container object that may or may not contain a non-null value. If a value is present, isPresent() returns true and get() returns the value. If a value is not present, isPresent() returns false and get() throws an exception. We can use the Optional class to represent the rank and suit of a card, because a joker does not have a rank or suit.
     * 
     * Internal: generic class
     * Optional<Suit>
     * A generic class is a class that can be used with any type. In this case, we use the Optional class with the Suit enum. If a card is a joker, then it does not have a rank or suit, so we use the Optional class to represent the rank and suit of a card.
     * 
     * Internal: isPresent()
     * Optional<Suit>
     * isPresent() returns true if the Optional object contains a value, and false if it does not.
     * 
     */
	private final Optional<Suit> aSuit;

    /*?
     * Keyword: Optional<Joker>
     * The Optional generic class is a container object that may or may not contain a non-null value. We use the Optional class to represent the joker, because a joker does not have a rank or suit.
     * 
     * Internal: generic class
     * Optional<Joker>
     * A generic class is a class that can be used with any type. In this case, we use the Optional class with the Joker enum. If a card is a joker, then it does not have a rank or suit, so we use the Optional class to represent the rank and suit of a card.
     */
	private final Optional<Joker> aJoker;
	
	/**
	 * Creates a new card object that is not a joker
	 * 
	 * @param pRank The rank of the card.
	 * @param pSuit The suit of the card.
	 * @pre pRank != null
	 * @pre pSuit != null
	 */

    /*?
    * Keyword: Card(Rank pRank, Suit pSuit)
    * This is a constructor that creates a new card object that is not a joker. The constructor takes in a rank and a suit, and creates a new card object with the given rank and suit. To create a new card object, we use the Optional class to represent the rank and suit of a card, because a joker does not have a rank or suit.
    */ 
	public Card(Rank pRank, Suit pSuit)
	{
		assert pRank != null && pSuit != null;
        /*?
         * Keyword: Optional.of(pRank)
         * Optional.of() returns an Optional object that contains the given value. If the given value is null, then Optional.of() throws a NullPointerException. We use Optional.of() to create a new Optional object that contains the given rank. Then, we can get the rank of the card by calling the get() method on the Optional object.
         * 
         * Internal: get()
         * Optional.of(pRank)
         * get() returns the value of the Optional object. If the Optional object does not contain a value, then get() throws a NoSuchElementException.
         */
		aRank = Optional.of(pRank);
        /*?
         * Keyword: Optional.of(pSuit)
         * Optional.of() returns an Optional object that contains the given value. If the given value is null, then Optional.of() throws a NullPointerException. We use Optional.of() to create a new Optional object that contains the given suit. Then, we can get the suit of the card by calling the get() method on the Optional object.
         * 
         * Internal: get()
         * Optional.of(pSuit)
         * get() returns the value of the Optional object. If the Optional object does not contain a value, then get() throws a NoSuchElementException.
         */
		aSuit = Optional.of(pSuit);
        /*?
         * Keyword:empty();
         * Optional.empty() returns an empty Optional object. We use Optional.empty() to create a new Optional object that does not contain a value. Then, we can check if the card is a joker by calling the isPresent() method on the Optional object. If isPresent() is called on an empty Optional object, then it returns false, so aJoker.isPresent() returns false.
         * 
         * Internal: isPresent()
         * empty();
         * isPresent() returns true if the Optional object contains a value, and false if it does not. If aJoker.isPresent() returns false, then we know that the card is not a joker.
         */
		aJoker = Optional.empty();
	}
	
    /*?
     * Keyword: Card(boolean pIsWhite)
     * This is a constructor that creates a new card object that is a joker. The constructor takes in a boolean value pIsWhite, and creates a new card object that is a joker. To create a new card object, we use the Optional class to represent the joker, because a joker does not have a rank or suit. If pIsWhite is true, then the joker is white. If pIsWhite is false, then the joker is black.
     */
	public Card(boolean pIsWhite)
	{
        /*?
         * Keyword: empty();
         * empty() returns an empty Optional object. We use Optional.empty() to create a new Optional object that does not contain a value. Then, we can check if the card has a rank by calling the isPresent() method on the Optional object aRank. If isPresent() is called on an empty Optional object, then it returns false, so aRank.isPresent() returns false if the card is a joker.
         */
		aRank = Optional.empty();
        /*?
         * Keyword: empty();
         * empty() returns an empty Optional object. We use Optional.empty() to create a new Optional object that does not contain a value. Then, we can check if the card has a suit by calling the isPresent() method on the Optional object aSuit. If isPresent() is called on an empty Optional object, then it returns false, so aSuit.isPresent() returns false if the card is a joker.
         */
		aSuit = Optional.empty();
		if( pIsWhite )
		{
            /*?
             * Keyword: of(Joker.WHITE)
             * Optional.of() returns an Optional object that contains the given value. If the given value is null, then Optional.of() throws a NullPointerException. We use Optional.of() to create a new Optional object that contains the given joker. Then, we can check if the card is a joker by calling the isPresent() method on the Optional object aJoker. If isPresent() is called on an Optional object that contains a value, then it returns true, so aJoker.isPresent() returns true if the card is a joker. We pass Joker.WHITE to Optional.of() because the joker is white.
             */
			aJoker = Optional.of(Joker.WHITE);
		}
		else
		{
            /*?
             * Keyword: of(Joker.BLACK)
             * Optional.of() returns an Optional object that contains the given value. If the given value is null, then Optional.of() throws a NullPointerException. We use Optional.of() to create a new Optional object that contains the given joker. Then, we can check if the card is a joker by calling the isPresent() method on the Optional object aJoker. If isPresent() is called on an Optional object that contains a value, then it returns true, so aJoker.isPresent() returns true if the card is a joker. We pass Joker.BLACK to Optional.of() because the joker is black.
             */
			aJoker = Optional.of(Joker.BLACK);
		}
	}
	
    /**
     * @return True if the card is a joker, false otherwise.
     */
	public boolean isJoker()
	{
		return aJoker.isPresent();
	}
	
    /**
     * @return True if the card is a white joker, false otherwise.
     * @pre isJoker()
     */
	public boolean isWhiteJoker()
	{
        assert isJoker();

        /*?
         * Keyword: aJoker.get()
         * aJoker.get() returns the value of the Optional object aJoker. If aJoker does not contain a value, then aJoker.get() throws a NoSuchElementException. We use aJoker.get() to get the value of the joker and confirm that the joker is white. If the joker is white, then aJoker.get() returns Joker.WHITE so the method returns true.
         */
		return aJoker.isPresent() && aJoker.get() == Joker.WHITE;
	}
	
    /**
     * @return True if the card is a black joker, false otherwise.
     * @pre isJoker()
     */
	public boolean isBlackJoker()
	{
        assert isJoker();

        /*?
         * Keyword: aJoker.get()
         * aJoker.get() returns the value of the Optional object aJoker. If aJoker does not contain a value, then aJoker.get() throws a NoSuchElementException. We use aJoker.get() to get the value of the joker and confirm that the joker is black. If the joker is black, then aJoker.get() returns Joker.BLACK so the method returns true.
         */
		return aJoker.isPresent() && aJoker.get() == Joker.BLACK;
	}
	
	/**
	 * @return The rank of the card.
	 * @pre !isJoker();
	 */
	public Rank getRank()
	{
        assert !isJoker();
        /*?
         * Keyword: aRank.get()
         * aRank.get() returns the value of the Optional object aRank. If aRank does not contain a value, then aRank.get() throws a NoSuchElementException. We use aRank.get() to get the value of the rank of the card.
         */
		return aRank.get();
	}
	
	/**
	 * @return The suit of the card.
	 * @pre !isJoker()
	 */
	public Suit getSuit()
	{
        assert !isJoker();
        /*?
         * Keyword: aSuit.get()
         * aSuit.get() returns the value of the Optional object aSuit. If aSuit does not contain a value, then aSuit.get() throws a NoSuchElementException. We use aSuit.get() to get the value of the suit of the card.
         */
		return aSuit.get();
	}

    /*?
     * Keyword: @Override
     * @Override is an annotation that tells the compiler that the method is overriding a method in a superclass. If the method is not overriding a method in a superclass, then the compiler will throw an error. Here we are overriding the compareTo() method in the Comparable interface to be able to compare cards. We need to specify the comparison rules for cards because there are two jokers and we need to specify which joker is greater than the other joker.
     * 
     * Internal: compareTo()
     * @Override
     * compareTo() is a method in the Comparable interface. The compareTo() method takes an object as a parameter and returns an integer. The compareTo() method compares the object that the method is called on to the object that is passed as a parameter. If the object that the method is called on is less than the object that is passed as a parameter, then the compareTo() method returns a negative integer. If the object that the method is called on is greater than the object that is passed as a parameter, then the compareTo() method returns a positive integer. If the object that the method is called on is equal to the object that is passed as a parameter, then the compareTo() method returns 0.
     */
	@Override
	public int compareTo(Card pCard)
	{
		if( isJoker() && pCard.isJoker() ) // both cards are jokers
		{
			return aJoker.get().compareTo(pCard.aJoker.get()); // compare the jokers, which are enums so if the first joker is Joker.WHITE and the second joker is Joker.BLACK, then the compareTo() method will return -1. If the first joker is Joker.BLACK and the second joker is Joker.WHITE, then the compareTo() method will return 1. This is because Joker.WHITE comes before Joker.BLACK in the enum.
		}
		else if( isJoker() && !pCard.isJoker()) // this card is a joker and the other card is not
		{
			return 1; // jokers should come after normal cards so we specify that this card is greater than the other card.
		}
		else if( !isJoker() && pCard.isJoker() ) // this card is not a joker but the other card is.
		{
			return -1;  // a normal card should come before a joker so we specify that this card is less than the other card.
		}
		else
		{
			return aRank.get().compareTo(pCard.aRank.get()); // both cards are normal cards so we compare the ranks of the cards.
		}
	}
}


/**
 * Represents a deck of playing cards. Simple version that 
 * includes the jokers.
 */
public class Deck
{
	private List<Card> aCards = new ArrayList<>();
	
	/**
	 * Creates a new deck of 54 cards, shuffled.
	 */

    /*?
     * Keyword: Deck()
     * Deck() is a constructor for the Deck class. The constructor for the Deck class creates a new deck of 54 cards and shuffles them.
     */
	public Deck()
	{
		shuffle();
	}
	
	/**
	 * Reinitializes the deck with all 54 cards, and shuffles them.
	 */
	public void shuffle()
	{
        /*?
         * Keyword: aCards.clear()
         * aCards.clear() removes all of the elements from the list aCards. We use aCards.clear() to remove all of the cards from the deck before we add the new cards to the deck. The clear() method is a method in the List interface that is implemented by the ArrayList class, and basically removes all of the elements from the list, all the cards in this case.
         */
		aCards.clear();
        //add all 52 cards to the deck
		for( Suit suit : Suit.values() )
		{
            for( Rank rank : Rank.values() )
            {
                aCards.add( new Card( rank, suit ));
            }
		}
        //add the two jokers to the deck
		aCards.add(new Card(true));
		aCards.add(new Card(false));
        /*?
         * Keyword: shuffle(aCards);
         * Collections.shuffle() is a method in the Collections class that shuffles the elements in the list. We use Collections.shuffle() to shuffle the cards in the deck.
         */
		Collections.shuffle(aCards);
	}
	
	/**
	 * Draws a card from the deck: removes the card from the top
	 * of the deck and returns it.
	 * @return The card drawn.
	 * @pre !isEmpty()
	 */
	public Card draw()
	{
		assert !isEmpty();
		return aCards.remove(aCards.size() - 1);
	}
	
	/**
	 * @return True if and only if there are no cards in the deck.
	 */
	public boolean isEmpty()
	{
		return aCards.isEmpty();
	}
}
