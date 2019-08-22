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

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AbsTest
{
	@Test
	public void testAbs_Positive()
	{ 
		assertEquals(5, Math.abs(5)); 
	}
	
	@Test
	public void testAbs_Negative()
	{ 
		assertEquals(5, Math.abs(-5)); 
	}
	
	@Test
	public void testAbs_Max()
	{ 
		// This test will fail.
		assertEquals(Integer.MAX_VALUE, Math.abs(Integer.MIN_VALUE));
	}
}