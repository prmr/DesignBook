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
	// Constants for the angles 0, pi/2, pi, and 3pi/2
	private static final double ZERO = 0.0;
	private static final double QUARTER = Math.PI/2.0;
	private static final double HALF = Math.PI;
	private static final double THREE_QUARTERS = Math.PI * 1.5;
	
	@Test
	public void testCos_NaN()
	{
		/*?
		 * Keyword: assertEquals
		 * The assertEquals() method is a static method that asserts that two values are equal. It takes two parameters, the expected value and the actual value. If the two values are equal, the test passes and returns true. If the two values are not equal, the test fails and returns false.
		 */
		assertEquals(Double.NaN, Math.cos(Double.NaN));
		// cos of NaN is NaN
	}
	
	@Test
	public void testCos_Infinity()
	{
		assertEquals(Double.NaN, Math.cos(Double.POSITIVE_INFINITY));
	}
	
	@Test
	public void testCos_Zero()
	{
		/*?
		 * Keyword: assertEquals
		 * The assertEquals() method is a static method that asserts that two values are equal. Here, the third parameter is the delta. The delta is the maximum difference between the expected value and the actual value. If the difference between the expected value and the actual value is less than or equal to the delta, the test passes and returns true. If the difference between the expected value and the actual value is greater than the delta, the test fails and returns false.
		 * 
		 * Keyword: ulp
		 * The Math.ulp() method is a static method that returns the size of an ulp of the specified double value. An ulp is the unit in the last place. An ulp of a float or double value is the positive distance between given value and the next value that is larger in magnitude. For non-NaN x, ulp(-x) == ulp(x). Math.ulp(1.0) is 2^-52. We define the delta as ulp(1.0) as it is a small enough number to be the threshold for the difference between the expected value and the actual value.
		 * 
		 * Internal: NaN
		 * ulp
		 * NaN is a special value that is not equal to any other value, including itself. NaN is returned when the result of a mathematical operation is undefined. For example, 0/0 is undefined and returns NaN. Math.ulp(0.0) is 2^-1074.
		 */
		assertEquals(1.0, Math.cos(ZERO), Math.ulp(1.0));
	}
	
	@Test
	public void testCos_Quarter()
	{
		/*?
		 * Keyword: ulp
		 * Math.ulp(0.0) is 2^-1074
		 */
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
