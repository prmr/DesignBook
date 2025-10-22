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
package e1.chapter5;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class FoundationPile
{
	private List<Card> aPile = new ArrayList<>();
	
	public boolean isEmpty() 
	{ 
		return aPile.isEmpty();
	}
	
	public Card peek() 
	{
		if( isEmpty() ) 
		{ 
			throw new EmptyStackException(); 
		}
		return aPile.get(aPile.size() - 1);
	}
	
	public Card pop() 
	{ 
		if( isEmpty() ) 
		{ 
			throw new EmptyStackException(); 
		}
		return aPile.remove(aPile.size() - 1 );
	}
	
	public void push(Card pCard) 
	{
		assert pCard != null;
		aPile.add(pCard);
	}
	
	public boolean canMoveTo(Card pCard)
	{
		assert pCard != null;
		if( isEmpty() )
		{
			return pCard.getRank() == Rank.ACE;
		}
		else
		{
			return pCard.getSuit() == peek().getSuit() &&
					pCard.getRank().ordinal() ==
					peek().getRank().ordinal()+1;
		}
	}
}