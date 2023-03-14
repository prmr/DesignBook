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

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class TestConcat
{
	private static final String EMPTY = "";
	private static final String NON_EMPTY = "abc";
	
	@Test
	/*?
	 * Keyword: testConcat_EmptyEmpty
	 * This test documents that calling concat on an empty string with an empty string returns the empty string.
	 */
	public void testConcat_EmptyEmpty()
	{
		/*?
		 * Keyword: assertSame
		 * assertSame is used to test that two objects are the same object. It is different from assertEquals which tests that two objects are equal. Here, the two strings are the same object because they are both empty strings.
		 */
		assertSame(EMPTY, EMPTY.concat(""));
	}
	
	@Test
	/*?
	 * Keyword: testConcat_NonEmptyEmpty
	 * This test documents that calling concat on a non-empty string with an empty string returns the non-empty string. Here, we are confirming that concat called on a non-empty string with an empty string returns the same non-empty string.
	 */
	public void testConcat_NonEmptyEmpty()
	{
		assertSame(NON_EMPTY, NON_EMPTY.concat(""));
	}
	
	@Test
	/*?
	 * Keyword: testConcat_EmptyNonEmpty
	 * This test documents that calling concat on an empty string with a non-empty string returns the non-empty string. We use assertEquals instead of assertSame because the two strings are not the same object, but we want to confirm that they are equal.
	 */
	public void testConcat_EmptyNonEmpty()
	{
		assertEquals(NON_EMPTY, EMPTY.concat(NON_EMPTY));
	}
	
	@Test
	/*?
	 * Keyword: testConcat_NonEmptyNonEmpty
	 * This test documents that calling concat on a non-empty string with a non-empty string returns the concatenation of the two strings.
	 */
	public void testConcat_NonEmptyNonEmpty()
	{
		assertEquals("abcabc", NON_EMPTY.concat(NON_EMPTY));
	}
	
	@Test
	/*?
	 * Keyword: testConcat_Null
	 * This test documents that calling concat on a non-empty string with null throws a NullPointerException.
	 * 
	 * Internal: NullPointerException
	 * testConcat_Null
	 * The NullPointerException is a runtime exception that is thrown when a null reference is used where an object is required.
	 */
	public void testConcat_Null()
	{
		/*?
		 * Keyword: assertThrows
		 * assertThrows is used to test that a particular exception is thrown. It is different from assertSame which tests that two objects are the same object. Here, we are testing that a NullPointerException is thrown when we call concat on a non-empty string with null.
		 * 
		 * Keyword: Executable
		 * Executable is an interface that is used to define an anonymous class that implements the execute method. The execute method is called by assertThrows to test that a NullPointerException is thrown.
		 */
		assertThrows(NullPointerException.class, new Executable()
		{
			// A lambda expression would normally be used here, but
			// they are not covered until Chapter 9.
			/*?
			 * Keyword: @Override
			 * @Override is used to indicate that the execute method overrides a method in the Executable interface. Here, it is used to override the execute method in the Executable interface. By default, the execute method throws a Throwable, but we know that it will throw a NullPointerException, so we can change the signature to throw a NullPointerException instead. 
			 */
			@Override
			/*?
			 * Keyword: execute
			 * The execute method is called by assertThrows to test that a NullPointerException is thrown. Here, we are testing that a NullPointerException is thrown when we call concat on a non-empty string with null.
			 * 
			 * Keyword: throws
			 * throws is a keyword that is used to indicate that a method can throw an exception. Here, we are using throws to indicate that the execute method can throw a NullPointerException.
			 * 
			 * Keyword: Throwable
			 * Throwable is the superclass of all exceptions and errors. Here, we are using Throwable to indicate that the execute method can throw a Throwable. In other words, the execute method can throw any exception or error. Here, we know that the execute method will throw a NullPointerException, so we can change the signature to throw a NullPointerException instead.
			 */
			public void execute() throws Throwable
			{
				NON_EMPTY.concat(null);
			}
		});
	}
}
