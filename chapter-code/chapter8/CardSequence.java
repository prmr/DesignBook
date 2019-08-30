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
package chapter8;

import java.util.Arrays;
import java.util.List;

public class CardSequence implements CardSource
{
	private final List<Card> aCards;

	public CardSequence(Card... pCards)
	{
		aCards = Arrays.asList(pCards);
	}

	public boolean isEmpty()
	{
		return aCards.isEmpty();
	}

	public Card get(int pPosition)
	{
		return aCards.get(pPosition);
	}

	public Card draw()
	{
		return aCards.remove(size() - 1);
	}

	public int size()
	{
		return aCards.size();
	}

	@Override
	public void accept(CardSourceVisitor pVisitor)
	{
		pVisitor.visitCardSequence(this);
	}
}
