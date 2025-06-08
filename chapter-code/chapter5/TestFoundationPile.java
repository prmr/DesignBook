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

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestFoundationPile
{
	private static final Card ACE_CLUBS = Card.get(Rank.ACE, Suit.CLUBS);
	private static final Card TWO_CLUBS = Card.get(Rank.TWO, Suit.CLUBS);
	private static final Card THREE_CLUBS = Card.get(Rank.THREE, Suit.CLUBS);
	
	private FoundationPile aPile;
	
	@Before
	public void setUp() 
	{ 
		aPile = new FoundationPile(); 
	}
	
	private int size()
	{
		List<Card> temp = new ArrayList<>();
		int size = 0;
		while( !aPile.isEmpty() ) 
		{ 
			size++; 
			temp.add(aPile.pop()); 
		}
		while( !temp.isEmpty() )
		{ 
			aPile.push(temp.remove(temp.size() - 1)); 
		}
		return size;
	}
	
	@Test
	public void testCanMoveTo_Empty()
	{
		assertTrue(aPile.canMoveTo(ACE_CLUBS));
		assertFalse(aPile.canMoveTo(THREE_CLUBS));
	}
	
	@Test
	void testCanMoveTo_EmptyReturnsFalse()
	{
		FoundationPile emptyPile = new FoundationPile();
		Card threeOfClubs = Card.get(Rank.THREE, Suit.CLUBS);
		assertFalse(emptyPile.canMoveTo(threeOfClubs));
	}
	
	@Test
	public void testCanMoveTo_NotEmptyAndSameSuit()
	{
		aPile.push(ACE_CLUBS);
		assertTrue(aPile.canMoveTo(TWO_CLUBS));
		assertFalse(aPile.canMoveTo(THREE_CLUBS));
	}
	
	@Test(expected = EmptyStackException.class)
	public void testPeek_Empty_Version1()
	{
		aPile.peek();
	}
	
	@Test
	public void testPeek_Empty_Version2()
	{
		try
		{
			aPile.peek();
			fail();
		}
		catch(EmptyStackException e ) 
		{}
		assertTrue(aPile.isEmpty());
	}
	
	@Test
	public void testPop_FromTwoToOne()
	{
		aPile.push(ACE_CLUBS);
		aPile.push(TWO_CLUBS);
		assertEquals(2, size());
		assertEquals(TWO_CLUBS, aPile.pop());
		assertEquals(1, size());
	}
}