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
package e3.chapter8;

import java.util.ArrayList;
import java.util.List;

/**
 * A CardStack that whose state changes can be observed. Fulfills the role of
 * the Subject/Model in the Observer pattern.
 */
public class ObservableCardStack extends CardStack {

	private final List<CardStackObserver> aObservers = new ArrayList<>();

	public ObservableCardStack() {}

	/**
	 * Attaches an observer to this observable object.
	 * 
	 * @param pObserver The observer to attach.
	 * @pre pObserver != null
	 */
	public void attach(CardStackObserver pObserver) {
		assert pObserver != null;
		aObservers.add(pObserver);
	}

	@Override
	public void push(Card pCard) {
		super.push(pCard);
		for (CardStackObserver observer : aObservers) {
			observer.pushed(pCard);
		}
	}

	@Override
	public Card pop() {
		Card popped = super.pop();
		for (CardStackObserver observer : aObservers) {
			observer.popped(popped);
		}
		return popped;
	}

	@Override
	public void clear() {
		super.clear();
		for (CardStackObserver observer : aObservers) {
			observer.cleared();
		}
	}
}
