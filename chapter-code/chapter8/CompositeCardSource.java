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
package chapter8;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * A card source composed of other card sources.
 */
public class CompositeCardSource implements CardSource, Iterable<CardSource>
{
	private final List<CardSource> aElements;
	
	@Override
	public Iterator<CardSource> iterator()
	{
		return aElements.iterator();
	}
	
	public CompositeCardSource(CardSource... pSources)
	{
		aElements = Arrays.asList(pSources);
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
	public void accept(CardSourceVisitor pVisitor)
	{
		pVisitor.visitCompositeCardSource(this);
	}
}
