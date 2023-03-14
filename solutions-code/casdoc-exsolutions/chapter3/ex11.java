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
package chapter3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/*?
 * Keyword:HandView
 * The `HandView` interface offers a subset of the methods of the Hand class for clients that only need to check the state of the hand. HandView extends `Iterable<Card>` and therefore provides an `iterator()` method. The Hand class implements the HandView interface, but also provides methods that modify the hand. The HandView interface is used by the Player class to check the state of the hand, but not to modify it. This respects the Interface Segregation Principle. The methods in HandView are `contains()`, `isEmpty()`, `isFull()`, and `iterator()`.
 * 
 * 
 * Internal:`extends`
 * HandView
 * The `extends` keyword is used here to indicate that an interface inherits from another interface. The `HandView` interface extends the `Iterable<Card>` interface, which means that HandView inherits all the methods of the `Iterable<Card>` interface. The HandView interface does not need to implement the `iterator()` method, because it is inherited from the `Iterable<Card>` interface. 
 * 
 * Internal: Interface Segregation Principle
 * HandView
 * The Interface Segregation Principle states that clients should not be forced to depend on methods they do not use. The `HandView` interface is a subset of the Hand class, and therefore clients that only need to check the state of the hand do not need to depend on methods that modify the hand. The `HandView` interface is used by the Player class to check the state of the hand, but not to modify it. Any client that implements the HandView interface will not be forced to implement methods that modify the hand.
 * 
 * 
 */
public interface HandView extends Iterable<Card> {

    // The following methods are part of the `HandView` interface and allow clients to check the state of the hand without modifying it.
    public boolean contains(Card pCard);
    public boolean isEmpty();
    public boolean isFull();
    public Iterator<Card> iterator();
}

/**
 * A collection of cards in a player's hand. Basic version for Exercise 1.
 */
public class Hand implements HandView
{
	private List<Card> aCards = new ArrayList<>();
	private int aMaxCards;
	
	/**
	 * Creates a new, empty hand, which can hold
	 * a maximum of pMaxCards.
	 * 
	 * @param pMaxCards The maximum number of cards allowed in this hand.
	 * @pre pMaxCards > 0;
	 */
	public Hand(int pMaxCards)
	{
		assert pMaxCards > 0;
		aMaxCards = pMaxCards;
	}
	
	/**
	 * Add pCards to the hand.
	 * @param pCard The card to add.
	 * @pre !isFull()
	 * @pre pCard != null;
	 */
	public void add(Card pCard)
	{
		assert pCard != null;
		assert !isFull();
		aCards.add(pCard);
	}

    /**
	 * Removes pCards if it is in the hand. If it is not in the
	 * hand, does nothing. 
	 * 
	 * @param pCard The card to remove.
	 * @pre pCards != null;
	 */
	public void remove(Card pCard)
	{
		assert pCard != null;
		aCards.remove(pCard);
	}

    	/**
	 * @param pCard A card to check for containment.
	 * @return True if pCard is a card in this hand.
	 * @pre pCard != null
	 */
    /*?
     * Keyword:contains
     * The contains() method is part of the `HandView` interface. Clients that only need to check the state of the hand do not need to depend on methods that modify the hand.
     * 
     * Internal: `HandView`
     * contains
     * The `HandView` interface specifies the methods `contains()`, `isEmpty()`, `isFull()`, and `iterator()`.
     */
	public boolean contains(Card pCard)
	{
		assert pCard != null;
		return aCards.contains(pCard);
	}

    /**
	 * @return True if there are no cards in this hand.
	 */
    /*?
     * Keyword:isEmpty
     * The isEmpty() method is part of the `HandView` interface. Clients that only need to check the state of the hand do not need to depend on methods that modify the hand.
     * 
     * Internal: `HandView`
     * isEmpty
     * The `HandView` interface specifies the methods `contains()`, `isEmpty()`, `isFull()`, and `iterator()`.
     */
	public boolean isEmpty()
	{
		return aCards.size() == 0;
	}

	/**
	 * @return True if the number of cards in the hand
	 * is the maximum number of cards allowable, as specified
	 * in the constructor.
	 */
    /*?
     * Keyword:isFull
     * The isFull() method is part of the `HandView` interface. Clients that only need to check the state of the hand do not need to depend on methods that modify the hand.
     * 
     * Internal: `HandView`
     * isFull
     * The `HandView` interface specifies the methods `contains()`, `isEmpty()`, `isFull()`, and `iterator()`.
     */
	public boolean isFull()
	{
		return aCards.size() == aMaxCards;
	}
	


	@Override
    /*?
     * Keyword:iterator
     * The iterator() method is part of the HandView interface. Clients that only need to check the state of the hand do not need to depend on methods that modify the hand.
     * 
     * Internal: `HandView`
     * iterator
     * The `HandView` interface specifies the methods `contains()`, `isEmpty()`, `isFull()`, and `iterator()`.
     */
	public Iterator<Card> iterator()
	{
		return aCards.iterator();
	}

	
	public static Comparator<Hand> createDescendingComparator()
	{
		return new Comparator<Hand>() {

			@Override
			public int compare(Hand pHand1, Hand pHand2)
			{
				return pHand2.aCards.size() - pHand1.aCards.size();
			}};
	}
	
	/**
	 * @return The number of cards currently in the hand.
	 */
	public int size()
	{
		return aCards.size();
	}

}
