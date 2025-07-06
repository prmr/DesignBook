/*******************************************************************************
 * Companion code for the book "Introduction to Software Design with Java",
 * 3rd edition by Martin P. Robillard.
 *
 * Copyright (C) 2025 by Martin P. Robillard
 *
 * This code is licensed under a Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * 
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 *******************************************************************************/
package e3.chapter9;

import static java.util.Comparator.comparing;

import java.util.Comparator;
import java.util.List;

import e3.chapter9.Suit.Color;

/**
 * Implementation of a playing card with factory functions
 * to create Comparators using functional-style programming.
 */
public class Card implements Comparable<Card> {
	
	private static final Comparator<Card> COMPARATOR = 
			Comparator.comparing(Card::suit).thenComparing(Card::rank);
	
	// Flyweight store
	private static final Card[][] CARDS = new Card[Suit.values().length][Rank.values().length];
	
	private final Rank aRank;
	private final Suit aSuit;
	
	// Initialization of the flyweight store
	static {
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				CARDS[suit.ordinal()][rank.ordinal()] = new Card(rank, suit);
			}
		}
	}
	
	// Private constructor
	private Card( Rank pRank, Suit pSuit) {
		aRank = pRank;
		aSuit = pSuit;
	}
	
	/**
	 * @param pRank The rank of the requested card.
	 * @param pSuit The suit of the requested card.
	 * @return The unique Card instance with pRank and pSuit
	 * @pre pRank != null && pSuit != null
	 */
	public static Card get(Rank pRank, Suit pSuit) {
		assert pRank != null && pSuit != null;
		return CARDS[pSuit.ordinal()][pRank.ordinal()];
	}
	
	/**
	 * @return The rank of the card.
	 */
	public Rank rank() {
		return aRank;
	}
	
	/**
	 * @return The suit of the card.
	 */
	public Suit suit() {
		return aSuit;
	}
	
	@Override
	public String toString() {
		return String.format("%s of %s", aRank, aSuit);
	}
	
	public static int comparingByRank(Card pCard1, Card pCard2) {
		return pCard1.rank().compareTo(pCard2.rank()); 
	}
	
	public boolean hasBlackSuit() {
		return aSuit.getColor() == Color.BLACK;
	}

	public boolean hasRedSuit() {
		return aSuit.getColor() == Color.RED; 
	}
	
	// ********** Code samples for Section 9.3 **********
	
	public static Comparator<Card> comparingBySuit() {
		return (card1, card2) -> card1.suit().compareTo(card2.suit());
	}
	
	public static Comparator<Card> comparingByRank() {
		return (card1, card2) -> card1.rank().compareTo(card2.rank()); 
	}
	
	/*
	 * This version uses basic comparison logic
	 */
	public static Comparator<Card> comparingBySuitThenRank() {
		return (card1, card2) -> {
			if (card1.suit() == card2.suit()) {
				return card1.rank().compareTo(card2.rank());
			}
			else {
				return card1.suit().compareTo(card2.suit());
			}
		};
	}
	
	/* This version uses comparator factories */
	public static Comparator<Card> comparingBySuitThenRank2() {
		return (card1, card2) -> {
			if(comparingBySuit().compare(card1, card2) == 0) {
				return comparingByRank().compare(card1, card2);
			}
			else {
				return comparingBySuit().compare(card1, card2);
			}
		};
	}
	
	public static Comparator<Card> comparingByRankThenSuit() {
		return (card1, card2) -> {
			if (comparingByRank().compare(card1, card2) == 0) {
				return comparingBySuit().compare(card1, card2);
			}
			else {
				return comparingByRank().compare(card1, card2);
			}
		};
	}

	/*
	 * This version uses the comparing method with a lambda.
	 */
	public static Comparator<Card> comparingByRank2() {
		return Comparator.comparing(card -> card.rank()); 
	}
	
	/*
	 * Uses comparator factories combined with thenComparing
	 */
	public static Comparator<Card> comparingByRankThenSuit2() {
		return comparingByRank().thenComparing(comparingBySuit()); 
	}
	
	/*
	 * Uses comparator factories combined with thenComparing
	 */
	public static Comparator<Card> comparingBySuitThenRank3() {
		return comparingBySuit().thenComparing(comparingByRank());
	}
	
	public static Comparator<Card> comparingByRankReversed() {
		return (card1, card2) -> card2.rank().compareTo(card1.rank()); 
	}
	
	public static Comparator<Card> comparingBySuitReversedThenRank() {
		return comparingBySuit().reversed().thenComparing(comparingByRank());
	}
	
	public static Comparator<Card> comparingBySuitReversedThenRankReversed() {
		return comparingBySuit().reversed().thenComparing(comparingByRank().reversed());
	}
	
	public static void sampleSortingApplication1() {
		List<Card> cards = new Deck().getCards();
		cards.sort(
			Comparator
				.comparing((Card card) -> card.suit())
				.reversed()
				.thenComparing(Comparator.comparing((Card card) -> card.rank())
						.reversed()));
	}
	
	public static void sampleSortingApplication2() {
		List<Card> cards = new Deck().getCards();
		cards.sort(comparing((Card card) -> card.suit())
				.reversed()
				.thenComparing(comparing((Card card) -> card.rank())
						.reversed()));
	}
	
	public static void sampleSortingApplication3() {
		List<Card> cards = new Deck().getCards();
		cards.sort(comparing(Card::suit)
				.reversed()
				.thenComparing(comparing(Card::rank)
						.reversed()));
	}
	
	public static void sampleSortingApplication4() {
		List<Card> cards = new Deck().getCards();
		cards.sort(comparing(Card::suit)
				.thenComparing(Card::rank).reversed());
	}
	
	public boolean isFaceCard() {
		return rank().ordinal() >= Rank.JACK.ordinal(); 
	}

	@Override
	public int compareTo(Card o) {
		return COMPARATOR.compare(this, o);
	}
	
	/**
	 * @return A random card.
	 */
	public static Card random() {
		return new Deck().draw();
	}
}
