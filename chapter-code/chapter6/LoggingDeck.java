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

/**
 * A deck that logs cards when they are drawn. 
 * Although an implementing class of CardSource,
 * this class is not decorator.
 */
public class LoggingDeck implements CardSource
{
	private CardStack aCards = new CardStack();

	@Override
	public Card draw()
	{
		Card card = aCards.pop();
		System.out.println(card);
		return card;
	}

	@Override
	public boolean isEmpty()
	{
		return aCards.isEmpty();
	}
	
	@Override
	public LoggingDeck clone()
	{
		try
		{
			LoggingDeck clone = (LoggingDeck) super.clone();
			clone.aCards = new CardStack(clone.aCards);
			return clone;
		}
		catch (CloneNotSupportedException e)
		{
			assert false;
			return null;
		}
	}
}
