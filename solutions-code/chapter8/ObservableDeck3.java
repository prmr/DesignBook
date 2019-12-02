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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Optional;

/**
 * Represents a deck of playing cards. In this version, the cards in the 
 * deck are stored in a list and the list of cards in the deck can 
 * be obtained by client code using an immutable wrapper object.
 */
public class ObservableDeck3 extends Observable
{
	private final List<Card> aCards = new ArrayList<>();
	
	/**
	 * Creates a new deck of 52 cards, shuffled.
	 */
	public ObservableDeck3()
	{
		shuffle();
	}
	
	/**
	 * Reinitializes the deck with all 52 cards, and shuffles them.
	 */
	public void shuffle()
	{
		aCards.clear();
		for( Suit suit : Suit.values() )
		{
            for( Rank rank : Rank.values() )
            {
                aCards.add( Card.get( rank, suit ));
            }
		}
		Collections.shuffle(aCards);
		setChanged();
		notifyObservers(DeckChangeType.SHUFFLED);
	}
	
	/**
	 * Places pCard on top of the deck.
	 * @param pCard The card to place on top
	 * of the deck.
	 * @pre pCard !=null
	 */
	public void push(Card pCard)
	{
		assert pCard != null;
		aCards.add(pCard);
		setChanged();
		notifyObservers(new DeckChangeEvent(DeckChangeType.CARD_PUSHED, pCard));
	}
	
	/**
	 * Draws a card from the deck: removes the card from the top
	 * of the deck and returns it.
	 * @return The card drawn.
	 * @pre !isEmpty()
	 */
	public Card draw()
	{
		assert !isEmpty();
		Card card = aCards.remove(aCards.size() - 1);
		setChanged();
		notifyObservers(new DeckChangeEvent(DeckChangeType.CARD_DRAWN, card));
		return card;
	}
	
	/**
	 * @return True if and only if there are no cards in the deck.
	 */
	public boolean isEmpty()
	{
		return aCards.isEmpty();
	}
	
	/**
	 * @return An unmodifiable list of all the cards in the deck.
	 */
	public List<Card> getCards()
	{
		return Collections.unmodifiableList(aCards);
	}
}

class DrawLogger3 implements Observer
{
	@Override
	public void update(Observable pDeck, Object pEvent)
	{
		DeckChangeEvent event = (DeckChangeEvent)pEvent;
		if( event.getChangeType() == DeckChangeType.CARD_DRAWN)
		{
			System.out.println(event.getCard().get() + " drawn");
		}
	}
}

class SizeStatus3 implements Observer
{
	@Override
	public void update(Observable pDeck, Object pEvent)
	{
		System.out.println(((ObservableDeck3)pDeck).getCards().size());
	}
}

enum DeckChangeType
{
	SHUFFLED, CARD_DRAWN, CARD_PUSHED
}

class DeckChangeEvent
{
	private final DeckChangeType aChangeType;
	private final Optional<Card> aCard;
	
	public DeckChangeEvent(DeckChangeType pType)
	{
		aChangeType = pType;
		aCard = Optional.empty();
	}
	
	public DeckChangeEvent(DeckChangeType pType, Card pCard)
	{
		aChangeType = pType;
		aCard = Optional.of(pCard);
	}
	
	public DeckChangeType getChangeType()
	{
		return aChangeType;
	}
	
	public Optional<Card> getCard()
	{
		return aCard;
	}
}

