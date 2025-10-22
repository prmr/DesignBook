/*******************************************************************************
 * Companion code for the book "Introduction to Software Design with Java",
 * 3rd edition by Martin P. Robillard.
 *
 * Copyright (C) 2025 by Martin P. Robillard
 *
 * This code is licensed under a Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * 
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 * 
 *******************************************************************************/
package e3.chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A CardSource implementation that represents an aggregation of zero or more
 * card sources.
 */
public class CompositeCardSource implements CardSource {

	private final List<CardSource> aElements;

	/**
	 * Creates a composite card source comprising all the elements in pCardSources
	 * 
	 * @param pCardSources A sequence of cards sources to aggregate.
	 */
	public CompositeCardSource(CardSource... pCardSources) {
		// Uses to ArrayList copy constructor to create a modifiable
		// to support the implementation of copy()
		aElements = new ArrayList<>(Arrays.asList(pCardSources));
	}

	@Override
	public Card draw() {
		assert !isEmpty();
		for (CardSource source : aElements) {
			if (!source.isEmpty()) {
				return source.draw();
			}
		}
		assert false;
		return null;
	}

	@Override
	public boolean isEmpty() {
		for (CardSource source : aElements) {
			if (!source.isEmpty()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public CompositeCardSource copy() {
		CompositeCardSource copy = new CompositeCardSource();
		for (CardSource source : aElements) {
			copy.aElements.add(source.copy());
		}
		return copy;
	}
}
