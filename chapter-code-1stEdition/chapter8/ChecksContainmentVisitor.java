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
 * A visitor that checks whether a card is contained in a card source 
 * structure.
 */
public class ChecksContainmentVisitor extends AbstractCardSourceVisitor
{
	private final Card aCard;
	private boolean aResult = false;
	
	public ChecksContainmentVisitor(Card pCard)
	{
		aCard = pCard;
	}
	
	public void reset()
	{
		aResult = false;
	}
	
	@Override
	public void visitDeck(Deck pDeck)
	{
		for( Card card : pDeck)
		{
			if( card.equals(aCard))
			{
				aResult = true; 
				break;
			}
		}
	}

	@Override
	public void visitCardSequence(CardSequence pCardSequence)
	{
		for( int i = 0; i < pCardSequence.size(); i++ )
		{
			if( pCardSequence.get(i).equals(aCard))
			{
				aResult = true;
				break;
			}
		}
	}
	
	@Override
	public void visitCompositeCardSource(CompositeCardSource pCompositeCardSource)
	{
		if( !aResult)
		{
			super.visitCompositeCardSource(pCompositeCardSource);
		}
	}

	public boolean contains()
	{
		return aResult;
	}
}
