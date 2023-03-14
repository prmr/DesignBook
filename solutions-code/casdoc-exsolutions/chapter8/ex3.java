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
/*?
 * Keyword: Observable
 * java.util.Observable is used to create subclasses that other parts of the program can observe. When an object of such subclass undergoes a change, observing classes are notified. The update( ) method is called when an observer is notified of a change. An object that is being observed must follow two rules : If it is changed, it must call setChanged( ) method and when it is ready to notify observers of this change, it must call notifyObservers( ) method. This causes the update( ) method in the observing object(s) to be called.
 * 
 */
public class Deck extends Observable
{
	private final List<Card> aCards = new ArrayList<>();
	
	/**
	 * Creates a new deck of 52 cards, shuffled.
	 */
    /*?
     * Keyword: Deck
     * This is the constructor of the Deck class. It calls the shuffle() method to clear the deck, shuffle the deck of cards and call the setChanged() and notifyObservers() methods to notify the observers of the change.
     */
	public Deck()
	{
		shuffle();
	}
	
	/**
	 * Reinitializes the deck with all 52 cards, and shuffles them.
	 */
    /*?
     * Keyword: shuffle
     * This method clears the deck, shuffles the deck of cards and calls the setChanged() and notifyObservers() methods to notify the observers of the change.
     */
	public void shuffle()
	{
        /*?
         * Keyword: clear
         * This method removes all the elements from the list of cards.
         */
		aCards.clear();
        // This for loop adds all the cards to the deck.
		for( Suit suit : Suit.values() )
		{
            for( Rank rank : Rank.values() )
            {
                aCards.add( Card.get( rank, suit ));
            }
		}
        /*?
         * Keyword: shuffle
         * Collections.shuffle() method shuffles the elements in the list of cards randomly.
         */
		Collections.shuffle(aCards);
        /*?
         * Keyword: setChanged
         * The setChanged() method is used to set the changed flag to true. This flag is used to check if the object has changed or not.
         */
		setChanged();
        /*?
         * Keyword: notifyObservers
         * The notifyObservers() method is used to notify the observers of the change. It calls the update() method in the observing object(s).
         *
         * Keyword: DeckChangeType.SHUFFLED
         * This is an enum that represents the type of change that has occurred. In this case, the deck has been shuffled. This is passed as an argument to the notifyObservers() method to notify the observers of the change.
         */
		notifyObservers(DeckChangeType.SHUFFLED);
	}
	
	/**
	 * Places pCard on top of the deck.
	 * @param pCard The card to place on top
	 * of the deck.
	 * @pre pCard !=null
	 */
    /*?
     * Keyword: push
     * This method adds the card to the top of the deck and calls the setChanged() and notifyObservers() methods to notify the observers of the change.
     */
	public void push(Card pCard)
	{
		assert pCard != null;
		aCards.add(pCard);
        /*?
         * Keyword: setChanged
         * The setChanged() method is used to set the changed flag to true. This flag is used to check if the object has changed or not.
         */
		setChanged();
        /*?
         * Keyword: notifyObservers
         * The notifyObservers() method is used to notify the observers of the change. It calls the update() method in the observing object(s).
         *
         * Keyword: DeckChangeType.CARD_PUSHED
         * This is an enum that represents the type of change that has occurred. In this case, a card has been pushed to the top of the deck. This is passed as an argument to the notifyObservers() method to notify the observers of the change.
         * 
         * Keyword: DeckChangeEvent
         * This is a class that represents the event that has occurred. It contains the type of change that has occurred and the card that has been pushed to the top of the deck. This is passed as an argument to the notifyObservers() method to notify the observers of the change. We pass the card that has been pushed to the top of the deck as an argument to the DeckChangeEvent constructor with the DeckChangeType.CARD_PUSHED enum. This implies that the card that has been pushed to the top of the deck is the card that has been changed.
         */
		notifyObservers(new DeckChangeEvent(DeckChangeType.CARD_PUSHED, pCard));
	}
	
	/**
	 * Draws a card from the deck: removes the card from the top
	 * of the deck and returns it.
	 * @return The card drawn.
	 * @pre !isEmpty()
	 */
    /*?
     * Keyword: draw
     * This method removes the card from the top of the deck and calls the setChanged() and notifyObservers() methods to notify the observers of the change.
     */
	public Card draw()
	{
		assert !isEmpty();
		Card card = aCards.remove(aCards.size() - 1);
        /*?
         * Keyword: setChanged
         * The setChanged() method is used to set the changed flag to true. This flag is used to check if the object has changed or not.
         */
		setChanged();
        /*?
         * Keyword: notifyObservers
         * The notifyObservers() method is used to notify the observers of the change. It calls the update() method in the observing object(s).
         *
         * Keyword: DeckChangeType.CARD_DRAWN
         * This is an enum that represents the type of change that has occurred. In this case, a card has been drawn from the top of the deck. This is passed as an argument to the notifyObservers() method to notify the observers of the change.
         * 
         * Keyword: DeckChangeEvent
         * This is a class that represents the event that has occurred. It contains the type of change that has occurred and the card that has been drawn from the top of the deck. This is passed as an argument to the notifyObservers() method to notify the observers of the change. We pass the card that has been drawn from the top of the deck as an argument to the DeckChangeEvent constructor with the DeckChangeType.CARD_DRAWN enum. This implies that the card that has been drawn from the top of the deck is the card that has been changed.
         */
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

/*?
 * Keyword: DrawLogger
 * This class implements the Observer interface. It is used to observe the Deck class. It implements the update() method which is called when the Deck class calls the notifyObservers() method. The update() method is called with the Deck object and the DeckChangeEvent object as arguments when the Deck class calls the notifyObservers() method. The update() method prints the card that has been drawn from the top of the deck.
 */
class DrawLogger implements Observer
{
	@Override
    /*?
     * Keyword: update
     * This method is called when the `Deck` class calls the `notifyObservers()` method. The `update()` method is called with the `Deck` object and the `DeckChangeEven`t object as arguments when the Deck class calls the `notifyObservers()` method. For example, if the `Deck` class calls the `notifyObservers()` method with the `DeckChangeType.CARD_DRAWN` enum as an argument, the `update()` method is called with the `Deck` object and the `DeckChangeEvent` object with the `DeckChangeType.CARD_DRAWN` enum as arguments. This causes the `update()` method to print the card that has been drawn from the top of the deck because the `DeckChangeEvent` object contains the card that has been drawn from the top of the deck.
     * 
     * Keyword: pDeck
     * This is the Deck object that has been passed as an argument to the notifyObservers() method in the Deck class.
     * 
     * Keyword: pEvent
     * This is the DeckChangeEvent object that has been passed as an argument to the notifyObservers() method in the Deck class.
     */
	public void update(Observable pDeck, Object pEvent)
	{
        /*?
         * Keyword: event
         * This is a DeckChangeEvent object that is cast from the pEvent object. The pEvent object is the DeckChangeEvent object that has been passed as an argument to the notifyObservers() method in the Deck class. We cast the pEvent object to a DeckChangeEvent object so that we can access the getChangeType() and getCard() methods in the DeckChangeEvent class.
         */
		DeckChangeEvent event = (DeckChangeEvent)pEvent;
        /*?
         * Keyword: getChangeType
         * This method is used to get the type of change that has occurred. In this case, we check if the type of change that has occurred is a card being drawn from the top of the deck or not. If the type of change that has occurred is a card being drawn from the top of the deck, we print the card that has been drawn from the top of the deck. If not, we do nothing.
         */
		if( event.getChangeType() == DeckChangeType.CARD_DRAWN)
		{
            /*?
             * Keyword: getCard
             * This method is used to get the card that has been drawn from the top of the deck. We print the card that has been drawn from the top of the deck.
             */
			System.out.println(event.getCard().get() + " drawn");
		}
	}
}

/*?
 * Keyword: SizeStatus
 * This class implements the `Observer` interface. It is used to observe the `Deck` class. It implements the `update()` method which is called when the `Deck` class calls the `notifyObservers()` method. The `update()` method is called with the `Deck` object and the `DeckChangeEvent` object as arguments when the `Deck` class calls the `notifyObservers()` method. The `update()` method prints the number of cards in the deck.
 */
class SizeStatus implements Observer
{
	@Override
    /*?
     * Keyword: update
     * This method is called when the `Deck` class calls the `notifyObservers()` method. The `update()` method is called with the `Deck` object and the `DeckChangeEven`t object as arguments when the Deck class calls the `notifyObservers()` method. For example, if the `Deck` class calls the `notifyObservers()` method with the `DeckChangeType.CARD_DRAWN` enum as an argument, the `update()` method is called with the `Deck` object and the `DeckChangeEvent` object with the `DeckChangeType.CARD_DRAWN` enum as arguments. This causes the `update()` method to print the number of cards in the deck because the `Deck` object contains the number of cards in the deck.
     * 
     * Keyword: pDeck
     * This is the `Deck` object that has been passed as an argument to the `notifyObservers()` method in the `Deck` class.
     * 
     * Keyword: pEvent
     * This is the `DeckChangeEvent` object that has been passed as an argument to the `notifyObservers()` method in the `Deck` class.
     */
	public void update(Observable pDeck, Object pEvent)
	{
        /*?
         * Keyword: (Deck)pDeck
         * This is a `Deck` object that is cast from the `pDeck` object. The `pDeck` object is the `Deck` object that has been passed as an argument to the `notifyObservers()` method in the `Deck` class. We cast the `pDeck` object to a `Deck` object so that we can access the `getCards()` method in the `Deck` class.
         */
		System.out.println(((Deck)pDeck).getCards().size());
	}
}

/*?
 * Keyword: DeckChangeType
 * This enum is used to represent the type of change that has occurred in the deck. The type of change that can occur in the deck is a card being drawn from the top of the deck (`CARD_DRAWN`), a card being pushed to the top of the deck (`CARD_PUSHED`), or the deck being shuffled (`SHUFFLED`).
 */
enum DeckChangeType
{
	SHUFFLED, CARD_DRAWN, CARD_PUSHED
}

/*?
 * Keyword: DeckChangeEvent
 * This class is used to represent the event that has occurred in the deck. The event that can occur in the deck is a card being drawn from the top of the deck (`CARD_DRAWN`), a card being pushed to the top of the deck (`CARD_PUSHED`), or the deck being shuffled (`SHUFFLED`).
 */
class DeckChangeEvent
{
	private final DeckChangeType aChangeType;
    /*?
     * Keyword: aCard
     * This is an `Optional` object that contains the card that has been drawn from the top of the deck. If the type of change that has occurred is not a card being drawn from the top of the deck, the `aCard` object will be empty. We use the `Optional` class to represent the `aCard` object because the `aCard` object may be empty.
     */
	private final Optional<Card> aCard;
	
    /*?
     * Keyword: DeckChangeEvent
     * This is the constructor for the `DeckChangeEvent` class. It takes the type of change that has occurred as an argument. If the type of change that has occurred is not a card being drawn from the top of the deck, the `aCard` object will be empty.
     * 
     * Keyword: pType
     * This is the type of change that has occurred in the deck. It can be a card being drawn from the top of the deck (`CARD_DRAWN`), a card being pushed to the top of the deck (`CARD_PUSHED`), or the deck being shuffled (`SHUFFLED`). If the type of change that has occurred is not a card being drawn from the top of the deck, the `aCard` object will be empty.
     */
	public DeckChangeEvent(DeckChangeType pType)
	{
		aChangeType = pType;
		aCard = Optional.empty();
	}
	
    /*?
     * Keyword: DeckChangeEvent
     * This is the constructor for the `DeckChangeEvent` class. It takes the type of change that has occurred and the card that has been drawn from the top of the deck as arguments.
     * 
     * Keyword: pType
     * This is the type of change that has occurred in the deck. It can be a card being drawn from the top of the deck (`CARD_DRAWN`), a card being pushed to the top of the deck (`CARD_PUSHED`), or the deck being shuffled (`SHUFFLED`). If the type of change that has occurred is not a card being drawn from the top of the deck, the `aCard` object will be empty.
     * 
     * Keyword: pCard
     * This is the card that has been drawn from the top of the deck. It will be stored in the `aCard` object using the `Optional` class.
     */
	public DeckChangeEvent(DeckChangeType pType, Card pCard)
	{
		aChangeType = pType;
		aCard = Optional.of(pCard);
	}
	
    /*?
     * Keyword: getChangeType
     * This method is used to get the type of change that has occurred in the deck. It returns the type of change that has occurred in the deck.
     *
     */
	public DeckChangeType getChangeType()
	{
		return aChangeType;
	}
	
    /*?
     * Keyword: getCard
     * This method is used to get the card that has been drawn from the top of the deck. It returns the card that has been drawn from the top of the deck.
     *
     */
	public Optional<Card> getCard()
	{
		return aCard;
	}
}

