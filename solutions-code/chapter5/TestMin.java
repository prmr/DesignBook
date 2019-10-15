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
	@Test
	public void testMin_FirstGreater()
	{
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
