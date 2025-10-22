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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A CardSource implementation that represents an aggregation
 * of zero or more card sources.
 */
public class CompositeCardSource implements CardSource
{
	private List<CardSource> aElements;
	
	/**
	 * Creates a composite card source comprising all the elements
	 * in pCardSources
	 * 
	 * @param pCardSources A sequence of cards sources to aggregate.
	 */
	public CompositeCardSource(CardSource... pCardSources)
	{
		aElements = Arrays.asList(pCardSources);
	}
	
	@Override
	public Card draw()
	{
	  assert !isEmpty();
	  for( CardSource source : aElements )
	  {
	    if( !source.isEmpty() )
	    {
	      return source.draw();
	    }
	  }
	  assert false;
	  return null;
	}

	@Override
	public boolean isEmpty()
	{
		for( CardSource source : aElements )
		{
			if( !source.isEmpty() )
			{ return false; }
		}
		return true;
	}
	
	@Override
	public CardSource clone()
	{
		try
		{
			CompositeCardSource clone = (CompositeCardSource) super.clone();
			clone.aElements = new ArrayList<>();
			for(CardSource source : aElements)
			{
				clone.aElements.add(source.clone());
			}
			return clone;
		}
		catch (CloneNotSupportedException e)
		{
			return null;
		}
	}
}
