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

import java.util.Optional;

/**
 * Implementation of a playing card. This class yields immutable objects.
 * This version of the class also implements the Comparable interface and
 * compares cards by rank, with an undefined order for cards of the same rank.
 * The class also includes a static factory method to create Comparator
 * objects that can compare cards according to their rank.
 */
public class Card4 implements Comparable<Card4>
{
	// Use as a tester for the comparisons with jokers
	public static void main(String[] args)
	{
		Card4 whiteJoker = new Card4(true);
		Card4 blackJoker = new Card4(false);
		assert whiteJoker.compareTo(blackJoker) < 0;
		assert whiteJoker.compareTo(whiteJoker) == 0;
		Deck4 deck = new Deck4();
		while( !deck.isEmpty() )
		{
			Card4 card = deck.draw();
			if( !card.isJoker() )
			{
				assert card.compareTo(whiteJoker) < 0;
				assert card.compareTo(blackJoker) < 0;
			}
		}
		System.out.println("Done");
	}
	
	private enum Joker { WHITE, BLACK }
	
	private final Optional<Rank> aRank;
	private final Optional<Suit> aSuit;
	private final Optional<Joker> aJoker;
	
	/**
	 * Creates a new card object that is not a joker
	 * 
	 * @param pRank The rank of the card.
	 * @param pSuit The suit of the card.
	 * @pre pRank != null
	 * @pre pSuit != null
	 */
	public Card4(Rank pRank, Suit pSuit)
	{
		assert pRank != null && pSuit != null;
		aRank = Optional.of(pRank);
		aSuit = Optional.of(pSuit);
		aJoker = Optional.empty();
	}
	
	public Card4(boolean pIsWhite)
	{
		aRank = Optional.empty();
		aSuit = Optional.empty();
		if( pIsWhite )
		{
			aJoker = Optional.of(Joker.WHITE);
		}
		else
		{
			aJoker = Optional.of(Joker.BLACK);
		}
	}
	
	public boolean isJoker()
	{
		return aJoker.isPresent();
	}
	
	public boolean isWhiteJoker()
	{
		return aJoker.isPresent() && aJoker.get() == Joker.WHITE;
	}
	
	public boolean isBlackJoker()
	{
		return aJoker.isPresent() && aJoker.get() == Joker.BLACK;
	}
	
	/**
	 * @return The rank of the card.
	 * @pre !isJoker();
	 */
	public Rank getRank()
	{
		return aRank.get();
	}
	
	/**
	 * @return The suit of the card.
	 * @pre !isJoker()
	 */
	public Suit getSuit()
	{
		return aSuit.get();
	}

	@Override
	public int compareTo(Card4 pCard)
	{
		if( isJoker() && pCard.isJoker() )
		{
			return aJoker.get().compareTo(pCard.aJoker.get());
		}
		else if( isJoker() && !pCard.isJoker())
		{
			return 1;
		}
		else if( !isJoker() && pCard.isJoker() )
		{
			return -1;
		}
		else
		{
			return aRank.get().compareTo(pCard.aRank.get());
		}
	}
}
