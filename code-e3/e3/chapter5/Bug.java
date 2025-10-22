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
 * 
 *******************************************************************************/
package e3.chapter5;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class Bug {
	
	/*
	 * Primitive testing of the toCard method.
	 */
	public static void main(String[] args) {
		System.out.println(toCard("Two of Clubs"));
		System.out.println(toCard("jack of spades"));
		System.out.println(toCard(""));
		System.out.println();
	}
	
	/**
	 * Returns the card that corresponds to the input
	 * description.
	 * 
	 * @param A string that describes a card in the form 
	 *     "RANK of SUIT", where RANK is a valid rank name
	 *     and SUIT is a valid suit name (case insensitive).
	 * @return The card described by the string.
	 * @throws IllegalArgumentException if the string does 
	 *     not describe a valid card.
	 * @pre pCardDescription != null
	 */
	public static Card toCard(String pCardDescription) {
		String[] parts = pCardDescription.toUpperCase().split(" ");
		return Card.get(Rank.valueOf(parts[0]), 
				Suit.valueOf(parts[2]));
	}
	
	@ParameterizedTest
	@MethodSource("allCards")
	void testToCard_AllCardsValid(Card pCard) {
		Card actual = toCard("%s of %s".formatted(pCard.rank(), pCard.suit()));
		assertSame(pCard, actual);
	}
	
	@ParameterizedTest
	@MethodSource("allCards")
	void testToCard_AllCardsValidLowercase(Card pCard) {
		Card actual = toCard("%s of %s".formatted(pCard.rank().toString().toLowerCase(), 
				pCard.suit().toString().toLowerCase()));
		assertSame(pCard, actual);
	}
	
	static List<Card> allCards() {
		List<Card> result = new ArrayList<>();
		for (Rank rank : Rank.values()) {
			for (Suit suit : Suit.values()) {
				result.add(Card.get(rank, suit));
			}
		}
		return result;
	}
	
	@Test
	void testToCard_InvalidRank() {
		assertThrows(IllegalArgumentException.class, () -> toCard("X of Clubs"));
	}
	
	@Test
	void testToCard_InvalidSuit() {
		assertThrows(IllegalArgumentException.class, () -> toCard("Two of X"));
	}
	
	@Test
	void testToCard_InvalidMiddleComponent() {
		assertThrows(IllegalArgumentException.class, () -> toCard("Two X Clubs"));
	}
	
	@Test
	void testToCard_MissingMiddleComponent() {
		assertThrows(IllegalArgumentException.class, () -> toCard("Two Clubs"));
	}
	
	@Test
	void testToCard_Empty() {
		assertThrows(IllegalArgumentException.class, () -> toCard(""));
	}
	
	@Test
	void testToCard_Blank() {
		assertThrows(IllegalArgumentException.class, () -> toCard("   "));
	}
	
	@Test
	void testToCard_ExtraComponent() {
		assertThrows(IllegalArgumentException.class, () -> toCard("Two of Clubs and then some"));
	}
}
