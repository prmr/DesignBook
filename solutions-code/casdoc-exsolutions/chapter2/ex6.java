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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a deck of playing cards. In this version, the cards in the 
 * deck are stored in a list and the list of cards in the deck can 
 * be obtained by client code using an immutable wrapper object.
 */
public class Deck {
	private List<Card> aCards = new ArrayList<>();
	
	/**
	 * Creates a new deck of 52 cards, shuffled.
	 */
	public Deck() {
		shuffle();
	}
	
	/**
	 * Reinitializes the deck with all 52 cards, and shuffles them.
	 */

	/*?
	 * Keyword: shuffle
	 * shuffle creates a new deck of 52 cards and shuffles them.
	 * 
	 * Internal: new deck
	 * shuffle
	 * A new deck is created by adding all 52 cards to the list of cards in the deck. The cards are added in the order of their suits and ranks. The cards are added by using a nested for loop. The outer for loop iterates over the suits, and the inner for loop iterates over the ranks. The cards are added in the order of their suits and ranks and then shuffled by using the Collections.shuffle method.
	 * 
	 * Internal: Collections.shuffle
	 * new deck
	 * Collections.shuffle shuffles the items in a list. In this case, the list of cards in the deck is shuffled.
	 * 
	 */
	public void shuffle() {
		aCards.clear();
		for( Suit suit : Suit.values() ) {
            for( Rank rank : Rank.values() ) {
                aCards.add( new Card( rank, suit ));
            }
		}
		Collections.shuffle(aCards);
	}
	
	/**
	 * Places pCard on top of the deck.
	 * @param pCard The card to place on top
	 * of the deck.
	 * @pre pCard !=null
	 */
	public void push(Card pCard) {
		assert pCard != null;
		aCards.add(pCard);
	}
	
	/**
	 * Draws a card from the deck: removes the card from the top
	 * of the deck and returns it.
	 * @return The card drawn.
	 * @pre !isEmpty()
	 */
	public Card draw() {
		assert !isEmpty();
		return aCards.remove(aCards.size() - 1);
	}
	
	/**
	 * @return True if and only if there are no cards in the deck.
	 */

	public boolean isEmpty() {
		return aCards.isEmpty();
	}
	
	/**
	 * @return An unmodifiable list of all the cards in the deck.
	 */

    /*?
     * Keyword: getCards
     * getCards uses the copy constructor to return a copy of the list of cards in the deck. This list contains references to the cards referred to in the original list, but the list itself is a new object. Therefore, the list returned by getCards is immutable because the list itself cannot be modified, and the cards in the list cannot be modified because they are immutable. This way we do not break encapsulation.
     * 
     * Internal: copy constructor
     * getCards
     * A copy constructor is a constructor that takes an object of the same class as a parameter and creates a new object that is a copy of the parameter. In this case, the copy constructor takes a list of cards as a parameter and creates a new list that is a copy of the parameter. The copy constructor is used to create a new list that is a copy of the list of cards in the deck. This new list is returned by getCards. 
     * 
     * Internal: immutable
     * getCards
     * An immutable object is an object whose state cannot be modified after it is created.
     * 
     * Internal: encapsulation
     * getCards
     * Encapsulation is the principle that the internal representation of an object should be hidden from the outside world, and that only a controlled set of operations can be performed on an object. In this case, we do not break encapsulation because the list returned by getCards is immutable. This means that the list itself cannot be modified, and the cards in the list cannot be modified because they are immutable.
     */
	public List<Card> getCards() {
        return new ArrayList<>(aCards);
	}
}
