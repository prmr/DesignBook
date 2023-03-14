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


/**
 * A collection of cards in a player's hand.
 */

/*?
 * Keyword:Iterable<Card>
 * The `Iterable<Card>` interface is a generic interface that represents an object that can be iterated over. In this case, the type is Card. The interface has one method, `iterator()`, which returns an iterator over the elements in this collection. The iterator is used to iterate over the elements  in the collection. In this case, the elements are the cards in the hand and the iterator is used to iterate over the cards in the hand. The iterator is used in the for-each loop, so users of the Iterable interface do not need to know the implementation details of the iterator.
 * 
 * Internal:generic interface
 * Iterable<Card>
 * A generic interface is an interface that can be used with any type. In this case, the type is Card. The interface has one method, iterator, which returns an iterator over the elements in this collection.
 * 
 * 
 * Keyword:Comparable<SortedHand>
 * The `Comparable<SortedHand>` interface is a generic interface that represents an object that can be compared to another object. In this case, the type is SortedHand. The interface has one method, `compareTo()`, which compares this object with the specified object for order. The `compareTo()` method is used to compare two objects. In this case, the objects are the hands and the compareTo method is used to compare two hands.
 * 
 * Internal:generic interface
 * Comparable<SortedHand>
 * A generic interface is an interface that can be used with any type. In this case, the type is SortedHand. The interface has one method, `compareTo()`, which compares this object with the specified object for order.
 * 
 */
public class SortedHand implements Iterable<Card>, Comparable<SortedHand>
{
	/*?
	 * Keyword:aCards
	 * The `aCards` field is a list of cards, it is implemented as an ArrayList. The list is used to store the cards in the hand.
	 */
	private final List<Card> aCards = new ArrayList<>();
	/*?
	 * Keyword:aComparator
	 * The `aComparator` field is a comparator, it is used to compare cards. The comparator is used to sort the cards in the hand. By default, the comparator is set to compare cards by rank.
	 * 
	 * Internal:comparator
	 * aComparator
	 * A comparator is an object that can be used to compare two objects. In this case, the objects are cards. The comparator is used to compare two cards.
	 * 
	 */
	private Comparator<Card> aComparator = Card.createByRankComparator();

	/*?
	 * Keyword:aMaxCards
	 * The `aMaxCards` field is an integer, it is used to store the maximum number of cards allowed in the hand. The maximum number of cards is specified in the constructor.
	 */
	private final int aMaxCards;
	
	/**
	 * Creates a new, empty hand, which can hold
	 * a maximum of pMaxCards.
	 * 
	 * @param pMaxCards The maximum number of cards allowed in this hand.
	 * @pre pMaxCards > 0;
	 */
	public SortedHand(int pMaxCards)
	{
		assert pMaxCards > 0;
		aMaxCards = pMaxCards;
	}
	
	/**
	 * Creates a new, empty hand, which can hold
	 * a maximum of pMaxCards. Allows specifying a sorting order
	 * other than the default (by rank) order.
	 * 
	 * @param pMaxCards The maximum number of cards allowed in this hand.
	 * @pre pMaxCards > 0;
	 * @pre pOrder!=null
	 */

	/*?
	 * Keyword:SortedHand
	 * The `SortedHand` constructor is a constructor that creates a new SortedHand object. The constructor takes two parameters, `pMaxCards` and `pOrder`
	 * 
	 * Internal:pMaxCards
	 * SortedHand
	 * The `pMaxCards` parameter is an integer, it is used to store the maximum number of cards allowed in the hand. The maximum number of cards is specified in the constructor.
	 * 
	 * Internal:pOrder
	 * SortedHand
	 * The `pOrder` parameter is a comparator, it is used to compare cards. The comparator is used to sort the cards in the hand. By default, the comparator is set to compare cards by rank. Using the strategy design pattern, the user can specify a different comparator to sort the cards in a different order by passing in a different comparator.
	 * 
	 * Internal: strategy design pattern
	 * SortedHand
	 * The strategy design pattern is a design pattern that allows the user to specify a different algorithm to perform a task. In this case, the user can specify a different comparator to sort the cards in a different order by passing in a different comparator. The cards in the hand are sorted by the comparator every time a card is added to the hand.
	 * 
	 */
	public SortedHand(int pMaxCards, Comparator<Card> pOrder)
	{
		assert pMaxCards > 0 && pOrder != null;
		aMaxCards = pMaxCards;
		aComparator = pOrder;
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

		/*?
		 * Keyword:add(pCard)
		 * The `add()` method is a method that adds an element to the list. The method takes one parameter, `pCard`. The method adds the card to the list of cards.
		 */
		aCards.add(pCard);

		/*?
		 * Keyword:sort(aComparator)
		 * The `sort()` method is a method that sorts the list. The method takes one parameter, `aComparator`. The method sorts the list using the comparator. By default, the comparator is set to compare cards by rank. Using the strategy design pattern, the user can specify a different comparator to sort the cards in a different order by passing in a different comparator.
		 * 
		 * Internal: strategy design pattern
		 * sort(aComparator)
		 * The strategy design pattern is a design pattern that allows the user to specify a different algorithm to perform a task. In this case, the user can specify a different comparator to sort the cards in a different order by passing in a different comparator. The cards in the hand are sorted by the comparator every time a card is added to the hand.
		 */
		aCards.sort(aComparator);
	}
	
	/**
	 * @return True if the number of cards in the hand
	 * is the maximum number of cards allowable, as specified
	 * in the constructor.
	 */
	public boolean isFull()
	{
		return aCards.size() == aMaxCards;
	}
	
	/**
	 * @return True if there are no cards in this hand.
	 */
	public boolean isEmpty()
	{
		return aCards.size() == 0;
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
	public boolean contains(Card pCard)
	{
		assert pCard != null;
		return aCards.contains(pCard);
	}

	@Override
	public Iterator<Card> iterator()
	{
		return aCards.iterator();
	}

	@Override
	/*?
	 * Keyword:compareTo(SortedHand pHand)
	 * The `compareTo()` method is a method that compares this object with the specified object for order. The `compareTo()` method is used to compare two objects. In this case, the objects are the hands and the compareTo method is used to compare two hands.
	 * 
	 * Internal:pHand
	 * compareTo(SortedHand pHand)
	 * The `pHand` parameter is a SortedHand, it is used to store the hand to compare to.
	 * 
	 */
	public int compareTo(SortedHand pHand)
	{
		return aCards.size() - pHand.aCards.size();
	}
	
	/**
	 * @return The number of cards currently in the hand.
	 */
	public int size()
	{
		return aCards.size();
	}
}
