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

/**
 * A visitor to compute the total number of cards in a card 
 * source.
 */
public class CountingVisitor extends AbstractCardSourceVisitor
{
	private int aCount = 0;
	
	@Override
	public void visitDeck(Deck pDeck)
	{
		for( @SuppressWarnings("unused") Card card : pDeck)
		{
			aCount++;
		}
	}

	@Override
	public void visitCardSequence(CardSequence pCardSequence)
	{
		aCount += pCardSequence.size();
	}
	
	public int getCount() 
	{ 
		return aCount; 
	}
	
	public void reset()
	{
		aCount = 0;
	}
}
