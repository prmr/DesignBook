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
import java.util.Optional;

/**
 * Represents a deck of playing cards. In this version, the cards in the 
 * deck are stored in a list and the list of cards in the deck can 
 * be obtained by client code using an immutable wrapper object.
 */
public class ObservableDeck2 implements DeckView
{
	private final List<Card> aCards = new ArrayList<>();
	private final List<DeckObserver2> aObservers = new ArrayList<>();
	private Optional<Card> aLastDrawn = Optional.empty();
	
	/**
	 * Creates a new deck of 52 cards, shuffled.
	 */
	public ObservableDeck2()
	{
		shuffle();
	}
	
	public Card getLastDrawn()
	{
		return aLastDrawn.get();
	}
	
	public void addObserver(DeckObserver2 pObserver)
	{
		assert pObserver != null;
		aObservers.add(pObserver);
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
		for(DeckObserver2 observer : aObservers)
		{
			observer.shuffled(this);
		}
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
		for(DeckObserver2 observer : aObservers)
		{
			observer.cardPushed(this);
		}
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
		aLastDrawn = Optional.of(card);
		for(DeckObserver2 observer : aObservers)
		{
			observer.cardDrawn(this);
		}
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

interface DeckObserver2
{
	void shuffled(DeckView pDeckView);
	void cardDrawn(DeckView pDeckView);
	void cardPushed(DeckView pDeckView);
}

class DrawLogger2 implements DeckObserver2
{
	@Override
	public void shuffled(DeckView pDeckView)
	{}

	@Override
	public void cardDrawn(DeckView pDeckView)
	{
		System.out.println(pDeckView.getLastDrawn() + " drawn");
		
	}

	@Override
	public void cardPushed(DeckView pDeckView)
	{}
}

class SizeStatus2 implements DeckObserver2
{
	@Override
	public void shuffled(DeckView pDeckView)
	{
		System.out.println(pDeckView.size());
	}

	@Override
	public void cardDrawn(DeckView pDeckView)
	{
		System.out.println(pDeckView.size());
	}

	@Override
	public void cardPushed(DeckView pDeckView)
	{
		System.out.println(pDeckView.size());
	}
}

interface DeckView
{
	List<Card> getCards();
	
	boolean isEmpty();
	
	Card getLastDrawn();
	
	default int size() 
	{ 
		return getCards().size(); 
	}
}

