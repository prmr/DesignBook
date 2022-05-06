/*******************************************************************************
 * Companion code for the book "Introduction to Software Design with Java",
 * 2nd edition by Martin P. Robillard.
 *
 * Copyright (C) 2022 by Martin P. Robillard
 *
 * This code is licensed under a Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * 
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 * 
 *******************************************************************************/
package e2.chapter8;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * This source code file shows how to use generic types
 * to apply the Visitor pattern so that data flow is accomplished
 * via parameters and return types, as opposed to state accumulation 
 * within the visitor. This is a simplified version of the CardSource 
 * sample referenced in the chapter.
 */
public class GenericVisitorSample {
	public static void main(String[] args) {
		GenericCardSource root = new GenericCompositeCardSource(
				new GenericDeck(),
				new GenericCompositeCardSource(
						new GenericDeck(),
						new GenericCompositeCardSource(new GenericDeck()),
						new GenericDeck()
						),
				new GenericDeck()
				);
		// There are five decks in the structure and 5 gets returned and printed
		System.out.println(root.accept(new DeckCountingVisitor()));
	}
}

interface GenericCardSourceVisitor<R> {
	R visitCompositeCardSource(GenericCompositeCardSource pCardSource);
	R visitDeck(GenericDeck pCardSource);
}

interface GenericCardSource
{
	Card draw();
	boolean isEmpty();
	<R> R accept(GenericCardSourceVisitor<R> pVisitor);
}

/**
 * Stub composite class to demonstrate the implementation of the accept method.
 */
class GenericCompositeCardSource implements GenericCardSource, Iterable<GenericCardSource>
{
	private final List<GenericCardSource> aElements;
	
	public GenericCompositeCardSource(GenericCardSource... pCardSources) {
		aElements = Arrays.asList(pCardSources);
	}
	
	@Override
	public Card draw() { /* stub */ return null; }

	@Override
	public boolean isEmpty() { /* stub */ return false; }
	
	@Override
	public <R> R accept(GenericCardSourceVisitor<R> pVisitor) {
		return pVisitor.visitCompositeCardSource(this);
	}

	@Override
	public Iterator<GenericCardSource> iterator() {
		return aElements.iterator();
	}
}

/**
 * Stub leaf class to demonstrate the implementation of the accept method.
 */
class GenericDeck implements GenericCardSource
{
	@Override
	public Card draw() { /* stub */ return null; }

	@Override
	public boolean isEmpty() { /* stub */ return false; }
	
	@Override
	public <R> R accept(GenericCardSourceVisitor<R> pVisitor) {
		return pVisitor.visitDeck(this);
	}
}

/** Demonstrates how to invoke the generic type to an Integer to return the
 * number of deck objects in the structure.
 */
class DeckCountingVisitor implements GenericCardSourceVisitor<Integer> {

	@Override
	public Integer visitCompositeCardSource(GenericCompositeCardSource pCardSource) {
		int result = 0;
		for( GenericCardSource source : pCardSource ) {
			result += source.accept(this);
		}
		return result;
	}

	@Override
	public Integer visitDeck(GenericDeck pCardSource) {
		return 1;
	}
}
