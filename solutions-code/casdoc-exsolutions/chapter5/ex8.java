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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

public class TestPokerHand
{
	/*
	 * Helper method to reflectively invoke the private method 
	 * isStraightFlush() and return the result of the invocation.
	 */
	private boolean invokeIsStraightFlush(PokerHand pHand)
	{
		try
		{ // Use reflection to invoke the private method isStraightFlush() on pHand and return the result. 
			/*?
			 * Keyword: getDeclaredMethod
			 * getDeclaredMethod() returns a Method object that reflects the specified declared method of the class or interface represented by this Class object. It takes a String as a parameter, which is the name of the method to be reflected. 
			 */
			Method method = PokerHand.class.getDeclaredMethod("isStraightFlush");
			/*?
			 * Keyword: setAccessible
			 * setAccessible() sets the accessible flag for this method object to the indicated boolean value. A value of true indicates that the reflected object should suppress Java language access checking when it is used. A value of false indicates that the reflected object should enforce Java language access checks. Here, we set the accessible flag to true, so that we can invoke the private method isStraightFlush() on pHand without getting an IllegalAccessException.
             * 
             * Internal: IllegalAccessException
             * setAccessible
             * IllegalAccessException is thrown when a method is not accessible. For example, if a method is private, it is not accessible outside of its class. 
			 * 
			 * Internal: accessible flag
			 * setAccessible
			 * The accessible flag is a boolean flag that indicates whether or not the reflected object should suppress Java language access checking when it is used.
			 * 
			 * Internal: access checking
			 * setAccessible
			 * access checking is the process of determining whether the currently executing code is permitted to access a field or invoke a method of a given class.
			 */
			method.setAccessible(true);
			/*?
			 * Keyword: (boolean)
			 * (boolean) casts the result of the invocation of the method isStraightFlush() on pHand to a boolean value. We do this because the method isStraightFlush() returns a boolean value, but the invoke() method returns an Object. The cast is allowed because boolean is a subclass of Object.
			 */
			return (boolean) method.invoke(pHand);
		}
		/*?
		 * Keyword: ReflectiveOperationException
		 * ReflectiveOperationException is the superclass of all exceptions that can be thrown during reflective operations. It is a checked exception, so it must be caught or declared to be thrown.
		 * 
		 * Internal: checked exception
		 * ReflectiveOperationException
		 * A checked exception is an exception that is checked at compile time. If a method does not handle a checked exception, the method must declare it using the throws keyword. If a method handles a checked exception, it must either catch the exception or declare it using the throws keyword.
		 */
		catch(ReflectiveOperationException e)
		{
			/*?
			 * Keyword: printStackTrace
			 * printStackTrace() prints this throwable and its backtrace to the standard error stream. This method prints a stack trace for this Throwable object on the error output stream that is the value of the field `System.err`. This is useful for debugging. 
             * 
             * Internal: System.err
             * printStackTrace
             * System.err is the standard error output stream. By default, this stream is connected to the console via the `FileOutputStream`.
			 * 
			 * Internal: backtrace
			 * printStackTrace
			 * A backtrace is a list of the methods that were called to get to the current point in the program.
			 * 
			 * Internal: error output stream
			 * printStackTrace
			 * The error output stream is the stream to which error output is written. By default, this stream is connected to the console via the `FileOutputStream`. The error output stream is also referred to as the standard error stream or the standard error output stream.
			 * 
			 * Internal: throwable
			 * printStackTrace
			 * A throwable is an object that represents an error or exception. It is the superclass of all errors and exceptions in the Java language. For example, the class Exception and its subclasses are a form of Throwable that indicates conditions that a reasonable application might want to catch.
			 */
			e.printStackTrace();
			/*?
			 * Keyword: fail
			 * fail() is used to indicate that a test has failed. It is used when an exception is thrown that is not expected. Here, we use it to indicate that the private method isStraightFlush() could not be invoked and the test failed.
			 */
			fail();
			return false;
		}
	}
	
	@Test
	/*?
	 * Keyword: testIsStraightFlush_True
	 * testIsStraightFlush_True() is a test method that tests the private method isStraightFlush() on a PokerHand object that contains a straight flush. It uses the helper method invokeIsStraightFlush() to invoke the private method isStraightFlush() on the PokerHand object. It then uses the assertTrue() method to check that the result of the invocation is true.
	 */
	public void testIsStraightFlush_True()
	{
		PokerHand hand = new PokerHand(Card.get(Rank.TWO, Suit.CLUBS),
				Card.get(Rank.THREE, Suit.CLUBS),
				Card.get(Rank.FOUR, Suit.CLUBS),
				Card.get(Rank.FIVE, Suit.CLUBS),
				Card.get(Rank.SIX, Suit.CLUBS));
		assertTrue(invokeIsStraightFlush(hand));
	}
	
	@Test
	/*?
	 * Keyword: testIsStraightFlush_WrongSuit
	 * testIsStraightFlush_WrongSuit() is a test method that tests the private method isStraightFlush() on a PokerHand object where the cards are not all of the same suit. It uses the helper method invokeIsStraightFlush() to invoke the private method isStraightFlush() on the PokerHand object. It then uses the assertFalse() method to check that the result of the invocation is false.
	 * 
	 */
	public void testIsStraightFlush_WrongSuit()
	{
		PokerHand hand = new PokerHand(Card.get(Rank.TWO, Suit.CLUBS),
				Card.get(Rank.THREE, Suit.CLUBS),
				Card.get(Rank.FOUR, Suit.CLUBS),
				Card.get(Rank.FIVE, Suit.CLUBS),
				Card.get(Rank.SIX, Suit.DIAMONDS));
		assertFalse(invokeIsStraightFlush(hand));
	}
	
	@Test
	/*?
	 * Keyword: testIsStraightFlush_WrongRank
	 * testIsStraightFlush_WrongRank() is a test method that tests the private method isStraightFlush() on a PokerHand object that contains a straight flush where the ranks of cards are not all in sequence. It uses the helper method invokeIsStraightFlush() to invoke the private method isStraightFlush() on the PokerHand object. It then uses the assertFalse() method to check that the result of the invocation is false.
	 */
	public void testIsStraightFlush_WrongRank()
	{
		PokerHand hand = new PokerHand(Card.get(Rank.TWO, Suit.CLUBS),
				Card.get(Rank.THREE, Suit.CLUBS),
				Card.get(Rank.FOUR, Suit.CLUBS),
				Card.get(Rank.FIVE, Suit.CLUBS),
				Card.get(Rank.SEVEN, Suit.CLUBS));
		assertFalse(invokeIsStraightFlush(hand));
	}
}
