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
package chapter5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

// Let's assume we only consider ace-low as valid for straights, for simplicity.
public class PokerHand
{
	private final List<Card> aCards;
	
	public PokerHand( Card... pCards)
	{
		assert pCards.length == 5;
		aCards = Arrays.asList(pCards);
		aCards.sort(new Comparator<Card>() {
			@Override
			public int compare(Card pCard1, Card pCard2)
			{
				return pCard1.getRank().compareTo(pCard2.getRank());
			}});
	}
	
	@SuppressWarnings("unused")
	private boolean isStraightFlush()
	{
		Suit suit  = aCards.get(0).getSuit();
		Rank rank = aCards.get(0).getRank();
		Iterator<Card> iterator = aCards.iterator();
		iterator.next();
		while( iterator.hasNext() )
		{
			Card card = iterator.next();
			if( card.getSuit() != suit || card.getRank().ordinal() - rank.ordinal() != 1)
			{
				return false;
			}
			rank = card.getRank();
		}
		return true;
	}
}
