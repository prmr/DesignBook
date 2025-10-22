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
package chapter9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Represents a general-purpose stack of cards. New CardStack
 * instances are initially empty.
 */
public class CardStack implements Iterable<Card>
{
	private final List<Card> aCards;
	
	/**
	 * Creates an empty CardStack.
	 */
	public CardStack()
	{
		aCards = new ArrayList<>();
	}
	
	public Stream<Card> stream()
	{ 
		return aCards.stream(); 
	}
	
	/**
	 * Creates a CardStack that contains all the cards
	 * in pCard, in the iteration order, from bottom to top.
	 * 
	 * @param pCards The cards to initialize the stack with.
	 */
	public CardStack(Iterable<Card> pCards)
	{
		this();
		for( Card card : pCards )
		{
			aCards.add(card);
		}
	}
	
	/**
	 * Pushes pCard onto the stack.
	 * 
	 * @param pCard The card to push.
	 * @pre pCard != null;
	 * @pre !aCards.contains(pCard)
	 */
	public void push(Card pCard)
	{
		assert pCard != null && !aCards.contains(pCard);
		aCards.add(pCard);
	}
	
	/**
	 * Removes the card on top of the stack and returns it.
	 * 
	 * @return The card on top of the stack.
	 * @pre !isEmpty()
	 */
	public Card pop()
	{
		assert !isEmpty();
		return aCards.remove(aCards.size()-1);
	}
	
	/**
	 * @return The card at the top of the stack.
	 * @pre !isEmpty();
	 */
	public Card peek()
	{
		assert !isEmpty();
		return aCards.get(aCards.size()-1);
	}
	
	/**
	 * @param pIndex The index to peek in the stack.
	 * @return The card at the position indicated by pIndex
	 * @pre pIndex >= 0 && pIndex < size();
	 */
	public Card peek(int pIndex)
	{
		assert pIndex >= 0 && pIndex < size();
		return aCards.get(pIndex);
	}
	
	/**
	 * @return The number of cards in the stack.
	 */
	public int size()
	{
		return aCards.size();
	}
	
	/**
	 * Removes all the cards in the stack.
	 */
	public void clear()
	{
		aCards.clear();
	}
	
	/**
	 * @return True if and only if the stack has no cards in it.
	 */
	public boolean isEmpty()
	{
		return aCards.size() == 0;
	}

	@Override
	public Iterator<Card> iterator()
	{
		return aCards.iterator();
	}
}
