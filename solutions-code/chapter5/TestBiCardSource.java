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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestBiCardSource
{
	/*
	 * This stub class takes either no card or a single card that
	 * can be used as a marker to determine which source is used.
	 */
	private static class CardSourceStub implements CardSource
	{
		private Optional<Card> aCard = Optional.empty();
		
		CardSourceStub() {}
		
		CardSourceStub(Card pCard) 
		{ 
			aCard = Optional.of(pCard);
		}

		@Override
		public Card draw()
		{
			assert !isEmpty();
			Card card = aCard.get();
			aCard = Optional.empty();
			return card;
		}

		@Override
		public boolean isEmpty()
		{
			return !aCard.isPresent();
		}
	}
	
	private static final Card ACE = Card.get(Rank.ACE, Suit.CLUBS);
	private static final Card TWO = Card.get(Rank.TWO, Suit.CLUBS);
	private CardSource aEmpty;
	private CardSource aContainsAce;
	private CardSource aContainsTwo;
	
	@BeforeEach
	public void setup()
	{
		aEmpty = new CardSourceStub();
		aContainsAce = new CardSourceStub(ACE);
		aContainsTwo = new CardSourceStub(TWO);
	}

	
	@Test
	public void testEmpty_True()
	{
		assertTrue(new BiCardSource(aEmpty, aEmpty).isEmpty());
	}
	
	@Test
	public void testEmpty_False_FirstEmpty()
	{
		assertFalse(new BiCardSource(aEmpty, aContainsAce).isEmpty());
	}
	
	@Test
	public void testEmpty_False_SecondEmpty()
	{
		assertFalse(new BiCardSource(aContainsAce, aEmpty).isEmpty());
	}
	
	@Test
	public void testEmpty_False_NeitherEmpty()
	{
		assertFalse(new BiCardSource(aContainsAce, aContainsTwo).isEmpty());
	}
	
	@Test
	public void testDraw_FirstEmpty()
	{
		assertSame(ACE, new BiCardSource(aEmpty, aContainsAce).draw());
	}
	
	@Test
	public void testDraw_SecondEmpty()
	{
		assertSame(ACE, new BiCardSource(aContainsAce, aEmpty).draw());
	}
	
	@Test
	public void testDraw_NeitherEmpty()
	{
		assertSame(ACE, new BiCardSource(aContainsAce, aContainsTwo).draw());
	}
}