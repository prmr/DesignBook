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

public class TestCos
{
	private static final double ZERO = 0.0;
	private static final double QUARTER = Math.PI/2.0;
	private static final double HALF = Math.PI;
	private static final double THREE_QUARTERS = Math.PI * 1.5;
	
	@Test
	public void testCos_NaN()
	{
		assertEquals(Double.NaN, Math.cos(Double.NaN));
	}
	
	@Test
	public void testCos_Infinity()
	{
		assertEquals(Double.NaN, Math.cos(Double.POSITIVE_INFINITY));
	}
	
	@Test
	public void testCos_Zero()
	{
		assertEquals(1.0, Math.cos(ZERO), Math.ulp(1.0));
	}
	
	@Test
	public void testCos_Quarter()
	{
		assertEquals(0.0, Math.cos(QUARTER), Math.ulp(0.0));
	}
	
	@Test
	public void testCos_Half()
	{
		assertEquals(-1.0, Math.cos(HALF), Math.ulp(-1.0));
	}
	
	@Test
	public void testCos_ThreeQuaters()
	{
		assertEquals(0.0, Math.cos(THREE_QUARTERS), Math.ulp(0.0));
	}
}
