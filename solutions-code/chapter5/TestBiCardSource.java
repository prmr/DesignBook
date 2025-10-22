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

import org.junit.jupiter.api.Test;

import e1.chapter5.Card;
import e1.chapter5.Rank;
import e1.chapter5.Suit;

public class TestBiCardSource
{
	/*
	 * This stub class takes either no card or a single card that
	 * can be used to verify which of the two card sources in the 
	 * BiCardSource was the origin of the card.
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
	
	/*
	 * The field initialization relies on the fact that in JUnit,
	 * a new instance of the test class is created for each test
	 * method. The solution for the first edition of the book
	 * initialized the field in a method annotated with @BeforeEach
	 * instead.
	 */
	private CardSource aEmpty = new CardSourceStub();
	private CardSource aContainsAce = new CardSourceStub(ACE);;
	private CardSource aContainsTwo = new CardSourceStub(TWO);;
	
	@Test
	void testEmpty_True()
	{
		assertTrue(new BiCardSource(aEmpty, aEmpty).isEmpty());
	}
	
	@Test
	void testEmpty_False_FirstEmpty()
	{
		assertFalse(new BiCardSource(aEmpty, aContainsAce).isEmpty());
	}
	
	@Test
	void testEmpty_False_SecondEmpty()
	{
		assertFalse(new BiCardSource(aContainsAce, aEmpty).isEmpty());
	}
	
	@Test
	void testEmpty_False_NeitherEmpty()
	{
		assertFalse(new BiCardSource(aContainsAce, aContainsTwo).isEmpty());
	}
	
	@Test
	void testDraw_FirstEmpty()
	{
		assertSame(ACE, new BiCardSource(aEmpty, aContainsAce).draw());
	}
	
	@Test
	void testDraw_SecondEmpty()
	{
		assertSame(ACE, new BiCardSource(aContainsAce, aEmpty).draw());
	}
	
	@Test
	void testDraw_NeitherEmpty()
	{
		assertSame(ACE, new BiCardSource(aContainsAce, aContainsTwo).draw());
	}
}