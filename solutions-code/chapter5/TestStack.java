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

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EmptyStackException;
import java.util.Stack;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class TestStack
{
	private final Stack<String> aStack = new Stack<>();
	
	@Test
	public void testPush_Empty()
	{
		String foo = "foo";
		assertSame(foo, aStack.push(foo));
		assertSame(foo, aStack.peek());
	}
	
	@Test
	public void testPush_NonEmpty()
	{
		aStack.push("A");
		String foo = "foo";
		assertSame(foo, aStack.push(foo));
		assertSame(foo, aStack.peek());
	}
	
	@Test
	public void testPush_Null()
	{   // Stack (i.e., Vector) allows null references as elements
		assertNull(aStack.push(null));
		assertNull(aStack.peek());
	}
	
	@Test
	public void testPop_NonEmpty()
	{
		String foo = "foo";
		aStack.push(foo);
		assertSame(foo, aStack.pop());
		assertTrue(aStack.isEmpty());
	}
	
	@Test
	public void testPop_Empty()
	{
		// Lambda expressions will be covered in Chapter 9
		assertThrows(EmptyStackException.class, new Executable()
		{	
			@Override
			public void execute() throws Throwable
			{
				aStack.pop();
			}
		});
	}
}
