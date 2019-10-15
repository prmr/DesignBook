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
	public void testConcat_EmptyEmpty()
	{
		assertSame(EMPTY, EMPTY.concat(""));
	}
	
	@Test
	public void testConcat_NonEmptyEmpty()
	{
		assertSame(NON_EMPTY, NON_EMPTY.concat(""));
	}
	
	@Test
	public void testConcat_EmptyNonEmpty()
	{
		assertEquals(NON_EMPTY, EMPTY.concat(NON_EMPTY));
	}
	
	@Test
	public void testConcat_NonEmptyNonEmpty()
	{
		assertEquals("abcabc", NON_EMPTY.concat(NON_EMPTY));
	}
	
	@Test // This test documents that calling concat with a null argument throws an NPE
	public void testConcat_Null()
	{
		assertThrows(NullPointerException.class, new Executable()
		{
			// A lambda expression would normally be used here, but
			// they are not covered until Chapter 9.
			@Override
			public void execute() throws Throwable
			{
				NON_EMPTY.concat(null);
			}
		});
	}
}
