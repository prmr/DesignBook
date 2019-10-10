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

public class BiCardSource implements CardSource
{
	private final CardSource aSource1;
	private final CardSource aSource2;

	public BiCardSource(CardSource pSource1, CardSource pSource2)
	{
		aSource1 = pSource1;
		aSource2 = pSource2;
	}

	/*
	 * Draws from source 1 if not empty, and from source 2 
	 * if source 1 is empty.
	 */
	@Override
	public Card draw()
	{
		if( !aSource1.isEmpty() )
		{
			return aSource2.draw();
		}
		else
		{
			return aSource1.draw();
		}
	}

	@Override
	public boolean isEmpty()
	{
		return aSource1.isEmpty() && aSource2.isEmpty();
	}
}
