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
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * Represents a deck of playing cards. In this version, the cards in the deck
 * are stored in a list and the list of cards in the deck can be obtained by
 * client code using an immutable wrapper object.
 * 
 * This version of the Deck class also implements {@link CardSource}.
 * 
 * The Deck is also iterable: it fulfills the role of ConcreteIterable in the
 * Iterator design pattern.
 */
public class Deck implements CardSource, Iterable<Card> {

	private CardStack aCards = new CardStack();
	private Optional<Card> aLastDrawn = Optional.empty();

	public static void main(String[] args) {
		Deck deck = new Deck();
		List<Command> commands = Arrays.asList(deck.createDrawCommand(), deck.createDrawCommand(),
				deck.createDrawCommand());
		for (Command command : commands) {
			command.execute();
		}

		for (Command command : commands.reversed()) {
			command.undo();
		}
	}

	/**
	 * Creates a new deck of 52 cards, shuffled.
	 */
	public Deck() {
		shuffle();
	}

	/**
	 * Reinitializes the deck with all 52 cards, and shuffles them.
	 */
	public void shuffle() {
		List<Card> cards = new ArrayList<>();
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				cards.add(Card.get(rank, suit));
			}
		}
		Collections.shuffle(cards);
		aCards = new CardStack(cards);
		aLastDrawn = Optional.empty();
	}

	/**
	 * Places pCard on top of the deck.
	 * 
	 * @param pCard The card to place on top of the deck.
	 * @pre pCard !=null
	 */
	public void push(Card pCard) {
		assert pCard != null;
		aCards.push(pCard);
	}

	/**
	 * Draws a card from the deck: removes the card from the top of the deck and
	 * returns it.
	 * 
	 * @return The card drawn.
	 * @pre !isEmpty()
	 */
	public Card draw() {
		assert !isEmpty();
		aLastDrawn = Optional.of(aCards.pop());
		return aLastDrawn.get();
	}

	/**
	 * @return The last card drawn from the deck.
	 * @pre At least one card was drawn from the deck.
	 */
	public Card lastDrawn() {
		assert aLastDrawn.isPresent();
		return aLastDrawn.get();
	}

	/**
	 * @return True if and only if there are no cards in the deck.
	 */
	public boolean isEmpty() {
		return aCards.isEmpty();
	}

	@Override
	public Deck copy() {
		Deck copy = new Deck();
		copy.aCards = new CardStack(aCards);
		return copy;
	}

	@Override
	public Iterator<Card> iterator() {
		return aCards.iterator();
	}

	/**
	 * Sample command factory method.
	 * 
	 * @return A command to draw a card from the deck.
	 */
	public Command createDrawCommand() {
		return new Command() {

			Optional<Card> aPreviousLastDrawn = Optional.empty();

			public void execute() {
				aPreviousLastDrawn = aLastDrawn;
				draw();
			}

			public void undo() {
				aCards.push(aLastDrawn.get());
				aLastDrawn = aPreviousLastDrawn;
			}
		};
	}

	@Override
	public String toString() {
		return "Deck [aCards=" + aCards + ", aLastDrawn=" + aLastDrawn + "]";
	}
}
