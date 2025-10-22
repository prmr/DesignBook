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
package chapter7;

public abstract class AbstractDecorator implements CardSource
{
	private final CardSource aElement;
	
	protected AbstractDecorator( CardSource pElement )
	{
		aElement = pElement;
	}
	
	@Override
	public Card draw()
	{
		return aElement.draw();
	}

	@Override
	public boolean isEmpty()
	{
		return aElement.isEmpty();
	}
}
