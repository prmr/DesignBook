/*******************************************************************************
 * Companion code for the book "Introduction to Software Design with Java",
 * 3nd edition by Martin P. Robillard.
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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

import org.junit.jupiter.api.Test;

public class FoundationPileTest {
	
	private static final Card ACE_CLUBS = Card.get(Rank.ACE, Suit.CLUBS);
	private static final Card TWO_CLUBS = Card.get(Rank.TWO, Suit.CLUBS);
	private static final Card THREE_CLUBS = Card.get(Rank.THREE, Suit.CLUBS);
	
	private FoundationPile aPile  = new FoundationPile();
	
	private int size() {
		List<Card> cards = new ArrayList<>();
		while (!aPile.isEmpty()) { 
			cards.add(aPile.pop()); 
		}
		int size = cards.size();
		while (!cards.isEmpty()) { 
			aPile.push(cards.removeLast()); 
		}
		return size;
	}
	
	private static int size(FoundationPile pPile) {
		List<Card> cards = new ArrayList<>();
		while (!pPile.isEmpty()) { 
			cards.add(pPile.pop()); 
		}
		int size = cards.size();
		while (!cards.isEmpty()) { 
			pPile.push(cards.removeLast()); 
		}
		return size;
	}
	
	@Test
	void testCanMoveTo_Empty_ReturnsFalse() {
		FoundationPile emptyPile = new FoundationPile();
		Card threeOfClubs = Card.get(Rank.THREE, Suit.CLUBS);
		assertFalse(emptyPile.canMoveTo(threeOfClubs));
	}
	
	@Test
	void testCanMoveTo_NotEmptyAndSameSuit_ReturnsFalse() {
		FoundationPile pile = new FoundationPile();
		Card aceOfClubs = Card.get(Rank.ACE, Suit.CLUBS);
		pile.push(aceOfClubs);
		Card threeOfClubs = Card.get(Rank.THREE, Suit.CLUBS);
		assertFalse(pile.canMoveTo(threeOfClubs));
	}
	
	@Test
	void testCanMoveTo_Empty() {
		assertTrue(aPile.canMoveTo(ACE_CLUBS));
		assertFalse(aPile.canMoveTo(THREE_CLUBS));
	}
	
	@Test
	void testCanMoveTo_NotEmptyAndSameSuit() {
		aPile.push(ACE_CLUBS);
		assertTrue(aPile.canMoveTo(TWO_CLUBS));
		assertFalse(aPile.canMoveTo(THREE_CLUBS));
	}
	
	@Test
	void testPeek_Empty_Version1(){
		assertThrows(EmptyStackException.class, () -> aPile.peek());
	}
	
	@Test
	void testPeek_Empty_Version2() {
		try {
			aPile.peek();
			fail();
		}
		catch(EmptyStackException e ) {}
		assertTrue(aPile.isEmpty());
	}
	
	@Test
	void testPop_FromTwoToOne() {
		aPile.push(ACE_CLUBS);
		aPile.push(TWO_CLUBS);
		assertEquals(2, size());
		assertEquals(TWO_CLUBS, aPile.pop());
		assertEquals(1, size());
	}
	
	private Suit executeGetSuit() {
		try {
			Method method = FoundationPile.class.getDeclaredMethod("getSuit");
			method.setAccessible(true);
			return (Suit) method.invoke(aPile);
		}
		catch (ReflectiveOperationException exception) {
			throw new AssertionError("Reflection error");
		}
	}
	
	@Test
	void testGetSuit() {
		aPile.push(ACE_CLUBS);
		assertSame(Suit.CLUBS, executeGetSuit());
	}
}
