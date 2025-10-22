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
package chapter4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Represents a deck of playing cards. In this version the class 
 * also defines a nested class Shuffler that can be used
 * to shuffle a deck a remember the number of times it was
 * shuffled.
 */
public class Deck implements CardSource
{
	private List<Card> aCards = new ArrayList<>();
	
	/**
	 * Creates a new deck of 52 cards, shuffled.
	 */
	public Deck()
	{
		shuffle();
	}
	
	/**
	 * Reinitializes the deck with all 52 cards, and shuffles them.
	 */
	public void shuffle()
	{
		aCards.clear();
		for( Suit suit : Suit.values() )
		{
            for( Rank rank : Rank.values() )
            {
                aCards.add( Card.get( rank, suit ));
            }
		}
		Collections.shuffle(aCards);
	}
	
	/**
	 * Places pCard on top of the deck.
	 * @param pCard The card to place on top
	 * of the deck.
	 * @pre pCard !=null
	 */
	public void push(Card pCard)
	{
		assert pCard != null;
		aCards.add(pCard);
	}
	
	/**
	 * Draws a card from the deck: removes the card from the top
	 * of the deck and returns it.
	 * @return The card drawn.
	 * @pre !isEmpty()
	 */
	public Card draw()
	{
		assert !isEmpty();
		return aCards.remove(aCards.size() - 1);
	}
	
	/**
	 * @return True if and only if there are no cards in the deck.
	 */
	public boolean isEmpty()
	{
		return aCards.isEmpty();
	}
	
	/**
	 * @return An instance of shuffler with this Deck as its outer instance.
	 */
	public Shuffler newShuffler() { return new Shuffler(); }

	/**
	 * A class that can shuffle a deck and remember
	 * the number of shuffles.
	 */
	public class Shuffler
	{
		private Shuffler() {}

		private int aNumberOfShuffles = 0;

		public void shuffle()
		{
			aNumberOfShuffles++;
			Deck.this.shuffle();
		}

		public int getNumberOfShuffles()
		{
			return aNumberOfShuffles;
		}
	}
	
	/**
	 * @param pRank The rank to use to compare the decks. 
	 * @return A comparator that compares two decks based on the number of cards
	 * of rank pRank that they contains.
	 * 
	 * Note that this version is improved from the code in the book,
	 * by avoiding the unnecessary parameter pRank in CountCards.
	 */
	public static Comparator<Deck> createByRankComparator(Rank pRank)
	{
		return new Comparator<Deck>()
		{
			public int compare(Deck pDeck1, Deck pDeck2)
			{
				return countCards(pDeck1) - countCards(pDeck2);
			}
			
			private int countCards(Deck pDeck)
			{ 
				int result = 0;
				for( Card card : pDeck.aCards )
				{
					if( card.getRank() == pRank )
					{
						result++;
					}
				}
				return result;
			}
		};
	}
}

