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

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestMin
{
	/*?
	 * Keyword: @Test
	 * The @Test annotation is an annotation that indicates that the method is a test method. It is a JUnit annotation that is used to indicate that the method is a test method. It is a marker annotation that does not take any parameters.
	 * 
	 * Internal: JUnit
	 * @Test
	 * JUnit is a unit testing framework for the Java programming language. It is used to write and run tests.
	 * 
	 * Internal: test
	 * @Test
	 * A test method is a method that is used to test the behavior of a class. It is a method that is annotated with the @Test annotation.
	 */
	@Test
	public void testMin_FirstGreater()
	{
		/*?
		 * Keyword: assertEquals
		 * The assertEquals() method is a static method that asserts that two values are equal. It takes two parameters, the expected value and the actual value. If the two values are equal, the test passes and returns true. If the two values are not equal, the test fails and returns false.
		 */
		assertEquals(0, Math.min(2, 0));
	}
	
	@Test
	public void testMin_SecondGreater()
	{
		assertEquals(0, Math.min(0, 2));
	}
	
	@Test
	public void testMin_SamePositive()
	{
		assertEquals(2, Math.min(2, 2));
	}
	
	@Test
	public void testMin_SameNegative()
	{
		assertEquals(-2, Math.min(-2, -2));
	}
}
