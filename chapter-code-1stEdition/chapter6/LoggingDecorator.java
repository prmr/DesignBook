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
package chapter6;

/**
 * A CardSource decorator that logs cards drawn from the
 * source.
 */
public class LoggingDecorator implements CardSource
{
	private CardSource aSource;
	
	public LoggingDecorator( CardSource pSource )
	{
		aSource = pSource;
	}

	@Override
	public Card draw()
	{
		Card card = aSource.draw();
		System.out.println(card);
		return card;
	}

	@Override
	public boolean isEmpty()
	{
		return aSource.isEmpty();
	}
	
	@Override
	public LoggingDecorator clone()
	{
		try
		{
			LoggingDecorator clone = (LoggingDecorator) super.clone();
			clone.aSource = aSource.clone();
			return clone;
		}
		catch (CloneNotSupportedException e)
		{
			assert false;
			return null;
		}
	}
	
}
