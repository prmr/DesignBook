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

public class TestBiCardSource
{
	/*
	 * This stub class takes either no card or a single card that
	 * can be used to verify which of the two card sources in the 
	 * BiCardSource was the origin of the card.
	 */
	private static class CardSourceStub implements CardSource
	{
		/*?
		 * Keyword: empty
		 * Optional.empty() returns an empty Optional instance. Here, we use it to initialize the field aCard to an empty Optional because we don't know which card the stub will contain.
		 */
		private Optional<Card> aCard = Optional.empty();
		
		/*?
		 * Keyword: CardSourceStub()
		 * CardSourceStub() is a constructor that takes no parameters. Here, we use it to initialize the field aCard to an empty Optional because we don't know which card the stub will contain.
		 */
		CardSourceStub() {}
		
		/*?
		 * Keyword: CardSourceStub(Card pCard)
		 * CardSourceStub(Card pCard) is a constructor that takes a Card as a parameter. Here, we use it to initialize the field aCard to an Optional containing the card pCard using the of() method.
		 */
		CardSourceStub(Card pCard) 
		{ 
			aCard = Optional.of(pCard);
		}

		/*?
		 * Keyword: @Override
		 * @Override is an annotation that indicates that the method that follows is overriding a method in a superclass. Here, we use it to override the draw() method in the CardSource interface because we want to return the card that was passed to the constructor and set the field aCard to an empty Optional after the card has been drawn. If we didn't override the method, the default implementation in the interface would be used instead.
		 */
		@Override
		public Card draw()
		{
			assert !isEmpty();
			Card card = aCard.get();
			aCard = Optional.empty();
			return card;
		}

		/*?
		 * Keyword: @Override
		 * @Override is an annotation that indicates that the method that follows is overriding a method in a superclass. Here, we use it to override the isEmpty() method in the CardSource interface because we want to return true if the field aCard is empty and false otherwise. If we didn't override the method, the default implementation in the interface would be used instead.
		 */
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
	/*?
	 * Keyword: testEmpty_True()
	 * testEmpty_True() is a test method that tests the isEmpty() method of the BiCardSource class. Here, we use it to test that the isEmpty() method returns true when both card sources are empty. If the isEmpty() method returns false or throws an exception, the test fails.
	 * 
	 */
	public void testEmpty_True()
	{
		assertTrue(new BiCardSource(aEmpty, aEmpty).isEmpty());
	}
	
	@Test
	/*?
	 * Keyword: testEmpty_False_FirstEmpty()
	 * testEmpty_False_FirstEmpty() is a test method that tests the isEmpty() method of the BiCardSource class. Here, we use it to test that the isEmpty() method returns false when the first card source is empty and the second card source is not empty. If the isEmpty() method returns true or throws an exception, the test fails.
	 */
	public void testEmpty_False_FirstEmpty()
	{
		assertFalse(new BiCardSource(aEmpty, aContainsAce).isEmpty());
	}
	
	@Test
	/*?
	 * Keyword: testEmpty_False_SecondEmpty()
	 * testEmpty_False_SecondEmpty() is a test method that tests the isEmpty() method of the BiCardSource class. Here, we use it to test that the isEmpty() method returns false when the first card source is not empty and the second card source is empty. If the isEmpty() method returns true or throws an exception, the test fails.
	 */
	public void testEmpty_False_SecondEmpty()
	{
		assertFalse(new BiCardSource(aContainsAce, aEmpty).isEmpty());
	}
	
	@Test
	/*?
	 * Keyword: testEmpty_False_NeitherEmpty()
	 * testEmpty_False_NeitherEmpty() is a test method that tests the isEmpty() method of the BiCardSource class. Here, we use it to test that the isEmpty() method returns false when neither card source is empty. If the isEmpty() method returns true or throws an exception, the test fails.
	 */
	public void testEmpty_False_NeitherEmpty()
	{
		assertFalse(new BiCardSource(aContainsAce, aContainsTwo).isEmpty());
	}
	
	@Test
	/*?
	 * Keyword: testDraw_FirstEmpty()
	 * testDraw_FirstEmpty() is a test method that tests the draw() method of the BiCardSource class. Here, we use it to test that the draw() method returns the card from the first card source when the first card source is  empty and the second card source is not empty. If the draw() method returns a different card or throws an exception, the test fails.
	 */
	public void testDraw_FirstEmpty()
	{
		assertSame(ACE, new BiCardSource(aEmpty, aContainsAce).draw());
	}
	
	@Test
	/*?
	 * Keyword: testDraw_SecondEmpty()
	 * testDraw_SecondEmpty() is a test method that tests the draw() method of the BiCardSource class. Here, we use it to test that the draw() method returns the card from the second card source when the first card source is not empty and the second card source is empty. If the draw() method returns a different card or throws an exception, the test fails.
	 */
	public void testDraw_SecondEmpty()
	{
		assertSame(ACE, new BiCardSource(aContainsAce, aEmpty).draw());
	}
	
	@Test
	/*?
	 * Keyword: testDraw_NeitherEmpty()
	 * testDraw_NeitherEmpty() is a test method that tests the draw() method of the BiCardSource class. Here, we use it to test that the draw() method returns the card from the first card source when neither card source is empty. If the draw() method returns a different card or throws an exception, the test fails.
	 */
	public void testDraw_NeitherEmpty()
	{
		assertSame(ACE, new BiCardSource(aContainsAce, aContainsTwo).draw());
	}
}