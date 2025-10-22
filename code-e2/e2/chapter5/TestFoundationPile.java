/*******************************************************************************
 * Companion code for the book "Introduction to Software Design with Java",
 * 2nd edition by Martin P. Robillard.
 *
 * Copyright (C) 2022 by Martin P. Robillard
 *
 * This code is licensed under a Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * 
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 * 
 *******************************************************************************/
package e2.chapter5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TestFoundationPile {
	
	private static final Card ACE_CLUBS = Card.get(Rank.ACE, Suit.CLUBS);
	private static final Card TWO_CLUBS = Card.get(Rank.TWO, Suit.CLUBS);
	private static final Card THREE_CLUBS = Card.get(Rank.THREE, Suit.CLUBS);
	
	private FoundationPile aPile  = new FoundationPile();
	
	private int size() {
		List<Card> temp = new ArrayList<>();
		int size = 0;
		while( !aPile.isEmpty() ) { 
			size++; 
			temp.add(aPile.pop()); 
		}
		while( !temp.isEmpty() ) { 
			aPile.push(temp.remove(temp.size() - 1)); 
		}
		return size;
	}
	
	@Test
	public void testCanMoveTo_Empty() {
		assertTrue(aPile.canMoveTo(ACE_CLUBS));
		assertFalse(aPile.canMoveTo(THREE_CLUBS));
	}
	
	@Test
	public void testCanMoveTo_NotEmptyAndSameSuit() {
		aPile.push(ACE_CLUBS);
		assertTrue(aPile.canMoveTo(TWO_CLUBS));
		assertFalse(aPile.canMoveTo(THREE_CLUBS));
	}
	
	@Test
	public void testPeek_Empty_Version1()
	{
		assertThrows(EmptyStackException.class, () -> aPile.peek());
	}
	
	@Test
	public void testPeek_Empty_Version2() {
		try {
			aPile.peek();
			fail();
		}
		catch(EmptyStackException e ) 
		{}
		assertTrue(aPile.isEmpty());
	}
	
	@Test
	public void testPop_FromTwoToOne() {
		aPile.push(ACE_CLUBS);
		aPile.push(TWO_CLUBS);
		assertEquals(2, size());
		assertEquals(TWO_CLUBS, aPile.pop());
		assertEquals(1, size());
	}
}
