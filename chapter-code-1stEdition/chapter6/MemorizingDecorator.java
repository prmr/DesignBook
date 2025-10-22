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
package chapter6;

import java.util.ArrayList;
import java.util.List;

/**
 * A CardSource decorator that memorizes cards drawn from the
 * source.
 */
public class MemorizingDecorator implements CardSource
{
	private CardSource aElement;
	private List<Card> aDrawnCards = new ArrayList<>();

	public MemorizingDecorator(CardSource pCardSource)
	{
		aElement = pCardSource;
	}

	@Override
	public boolean isEmpty()
	{
		return aElement.isEmpty();
	}

	@Override
	public Card draw()
	{
		// 1. Delegate the original request to the decorated object
		Card card = aElement.draw();
		// 2. Implement the decoration
		aDrawnCards.add(card);
		return card;
	}
	
	@Override
	public MemorizingDecorator clone()
	{
		try
		{
			MemorizingDecorator clone = (MemorizingDecorator) super.clone();
			clone.aElement = aElement.clone();
			clone.aDrawnCards = new ArrayList<>(aDrawnCards);
			return clone;
		}
		catch (CloneNotSupportedException e)
		{
			assert false;
			return null;
		}
	}
}