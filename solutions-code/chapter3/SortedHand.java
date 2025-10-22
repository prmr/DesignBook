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

import e1.chapter3.Card;

/**
 * A collection of cards in a player's hand. Basic version for Exercise 1.
 */
public class SortedHand implements Iterable<Card>, Comparable<SortedHand>
{
	private final List<Card> aCards = new ArrayList<>();
	private Comparator<Card> aComparator = Card.createByRankComparator();
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
		aCards.add(pCard);
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
