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

import static java.util.Comparator.*;

import java.util.Comparator;
import java.util.List;

import chapter9.Suit.Color;

/**
 * Implementation of a playing card. This class yields immutable objects.
 * This version of the class shows an application of the Flyweight design
 * pattern where the flyweight store is pre-initialized.
 */
public class Card implements Comparable<Card>
{
	private static final Comparator<Card> COMPARATOR = Comparator.comparing(Card::getSuit).thenComparing(Card::getRank);
	
	// Flyweight store
	private static final Card[][] CARDS = new Card[Suit.values().length][Rank.values().length];
	
	private final Rank aRank;
	private final Suit aSuit;
	
	// Initialization of the flyweight store
	static
	{
		for( Suit suit : Suit.values() )
		{
			for( Rank rank : Rank.values() )
			{
				CARDS[suit.ordinal()][rank.ordinal()] = new Card(rank, suit);
			}
		}
	}
	
	// Private constructor
	private Card( Rank pRank, Suit pSuit)
	{
		aRank = pRank;
		aSuit = pSuit;
	}
	
	/**
	 * @param pRank The rank of the requested card.
	 * @param pSuit The suit of the requested card.
	 * @return The unique Card instance with pRank and pSuit
	 * @pre pRank != null && pSuit != null
	 */
	public static Card get(Rank pRank, Suit pSuit)
	{
		assert pRank != null && pSuit != null;
		return CARDS[pSuit.ordinal()][pRank.ordinal()];
	}
	
	/**
	 * @return The rank of the card.
	 */
	public Rank getRank()
	{
		return aRank;
	}
	
	/**
	 * @return The suit of the card.
	 */
	public Suit getSuit()
	{
		return aSuit;
	}
	
	@Override
	public String toString()
	{
		return String.format("%s of %s", aRank, aSuit);
	}
	
	public static int compareByRank(Card pCard1, Card pCard2)
	{
		return pCard1.getRank().compareTo(pCard2.getRank()); 
	}
	
	public boolean hasBlackSuit()
	{
		return aSuit.getColor() == Color.BLACK;
	}

	public boolean hasRedSuit()
	{
		return aSuit.getColor() == Color.RED; 
	}
	
	// ********** Code samples for Section 9.3 **********
	
	public static Comparator<Card> bySuitComparator()
	{
		return (card1, card2) -> card1.getSuit().compareTo(card2.getSuit());
	}
	
	public static Comparator<Card> byRankComparator()
	{
		return (card1, card2) -> card1.getRank().compareTo(card2.getRank()); 
	}
	
	/*
	 * This version uses basic comparison logic
	 */
	public static Comparator<Card> bySuitThenRankComparator1()
	{
		return (card1, card2) -> {
			if (card1.getSuit() == card2.getSuit())
			{
				return card1.getRank().compareTo(card2.getRank());
			}
			else
			{
				return card1.getSuit().compareTo(card2.getSuit());
			}
		};
	}
	
	/* This version uses comparator factories */
	public static Comparator<Card> bySuitThenRankComparator2()
	{
		return (card1, card2) -> {
			if(bySuitComparator().compare(card1, card2) == 0)
			{
				return byRankComparator().compare(card1, card2);
			}
			else
			{
				return bySuitComparator().compare(card1, card2);
			}
		};
	}
	
	public static Comparator<Card> byRankThenSuitComparator()
	{
		return (card1, card2) -> {
			if (byRankComparator().compare(card1, card2) == 0)
			{
				return bySuitComparator().compare(card1, card2);
			}
			else
			{
				return byRankComparator().compare(card1, card2);
			}
		};
	}

	/*
	 * This version uses the comparing method.
	 */
	public static Comparator<Card> byRankComparator2()
	{
		return Comparator.comparing(card -> card.getRank()); 
	}
	
	/*
	 * Uses comparator factories combined with thenComparing
	 */
	public static Comparator<Card> byRankThenSuitComparator2()
	{
		return byRankComparator().thenComparing(bySuitComparator()); 
	}
	
	/*
	 * Uses comparator factories combined with thenComparing
	 */
	public static Comparator<Card> bySuitThenRankComparator3()
	{
		return bySuitComparator().thenComparing(byRankComparator());
	}
	
	public static Comparator<Card> byRankComparatorReversed()
	{
		return (card1, card2) -> card2.getRank().compareTo(card1.getRank()); 
	}
	
	public static Comparator<Card> bySuitReversedThenRankComparator()
	{
		return bySuitComparator().reversed().thenComparing(byRankComparator());
	}
	
	public static Comparator<Card> bySuitReversedThenRankReversedComparator()
	{
		return bySuitComparator().reversed().thenComparing(byRankComparator().reversed());
	}
	
	public static void sampleSortingApplication1()
	{
		List<Card> cards = new Deck().getCards();
		cards.sort(
			Comparator
				.comparing((Card card) -> card.getSuit())
				.reversed()
				.thenComparing(Comparator.comparing((Card card) -> card.getRank())
						.reversed()));
	}
	
	public static void sampleSortingApplication2()
	{
		List<Card> cards = new Deck().getCards();
		cards.sort(comparing((Card card) -> card.getSuit())
				.reversed()
				.thenComparing(comparing((Card card) -> card.getRank())
						.reversed()));
	}
	
	public static void sampleSortingApplication3()
	{
		List<Card> cards = new Deck().getCards();
		cards.sort(comparing(Card::getSuit)
				.reversed()
				.thenComparing(comparing(Card::getRank)
						.reversed()));
	}
	
	public static void sampleSortingApplication4()
	{
		List<Card> cards = new Deck().getCards();
		cards.sort(comparing(Card::getSuit)
				.thenComparing(Card::getRank).reversed());
	}
	
	public boolean isFaceCard()
	{
		return getRank().ordinal() >= Rank.JACK.ordinal(); 
	}

	@Override
	public int compareTo(Card o)
	{
		return COMPARATOR.compare(this, o);
	}
}
