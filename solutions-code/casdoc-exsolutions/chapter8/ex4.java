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

/**
 * Represents a deck of playing cards. In this version, the cards in the 
 * deck are stored in a list and the list of cards in the deck can 
 * be obtained by client code using an immutable wrapper object.
 */
public class ObservableDeck extends Deck
{
	private final List<Card> aCards = new ArrayList<>();
    /*?
     * Keyword: aObservers
     * aObservers is a list of DeckObserver objects.
     */
	private final List<DeckObserver> aObservers = new ArrayList<>();
	
	/**
	 * Creates a new deck of 52 cards, shuffled.
	 */
    /*?
     * Keyword: ObservableDeck
     * ObservableDeck is a constructor that initializes the deck with all 52 cards, and shuffles them.
     */
	public ObservableDeck()
	{
		shuffle();
	}
	
    /*?
     * Keyword: addObserver
     * addObserver takes a DeckObserver object as a parameter and adds it to the list of observers.
     */
	public void addObserver(DeckObserver pObserver)
	{
		assert pObserver != null;
		aObservers.add(pObserver);
	}
	
	/**
	 * Reinitializes the deck with all 52 cards, and shuffles them.
	 */
    /*?
     * Keyword: shuffle
     * shuffle reinitializes the deck with all 52 cards, and shuffles them. It iterates through the suits and ranks, and adds a new card to the deck for each combination of suit and rank. It then shuffles the deck and notifies all the observers that the deck has been shuffled.
     */
    public void shuffle() 
    {
        /*?
         * Keyword: super
         * super.shuffle() calls the shuffle method of the Deck class which shuffles the deck. This is necessary because the shuffle method in the ObservableDeck class is overriding the shuffle method in the Deck class (the super class)
         */
        super.shuffle();
        // Notify each observer that the deck has been shuffled using the shuffled method of the DeckObserver interface.
        for (DeckObserver1 observer : aObservers) {
            observer.shuffled();
        }
    }
	
	/**
	 * Places pCard on top of the deck.
	 * @param pCard The card to place on top
	 * of the deck.
	 * @pre pCard !=null
	 */
    /*?
     * Keyword: push
     * push takes a Card object as a parameter and adds it to the deck. It then notifies all the observers that a card has been pushed.
     */
	public void push(Card pCard)
	{

        assert pCard != null;
        /*?
         * Keyword: super
         * super.push(pCard) calls the push method of the Deck class which adds a card to the deck. This is necessary because the push method in the ObservableDeck class is overriding the push method in the Deck class (the super class) so we want to call the push method of the super class which adds a card to the deck.
         */
        super.push(pCard);
        // Notify each observer that a card has been pushed using the cardPushed method of the DeckObserver interface.
		for(DeckObserver observer : aObservers)
		{
            /*?
             * Keyword: cardPushed
             * cardPushed is a method in the DeckObserver interface that is called when a card has been pushed. It takes a Card object as a parameter and returns nothing. cardPushed notifies the observer that a card has been pushed.
             */
			observer.cardPushed(pCard);
		}
	}
	
	/**
	 * Draws a card from the deck: removes the card from the top
	 * of the deck and returns it.
	 * @return The card drawn.
	 * @pre !isEmpty()
	 */
    /*?
     * Keyword: draw
     * draw removes the top card from the deck and returns it. It then notifies all the observers that a card has been drawn.
     */
	public Card draw()
	{
		assert !isEmpty();
        /*?
         * Keyword: super
         * super.draw() calls the draw method of the Deck class which removes the top card from the deck and returns it. This is necessary because the draw method in the ObservableDeck class is overriding the draw method in the Deck class (the super class) so we want to call the draw method of the super class which removes the top card from the deck and returns it.
         */
        Card card = super.draw();
        // Notify each observer that a card has been drawn using the cardDrawn method of the DeckObserver interface.
		for(DeckObserver observer : aObservers)
		{
            /*?
             * Keyword: cardDrawn
             * cardDrawn is a method in the DeckObserver interface that is called when a card has been drawn. It takes a Card object as a parameter and returns nothing. cardDrawn notifies the observer that a card has been drawn.
             */
			observer.cardDrawn(card);
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
        /*?
         * Keyword: unmodifiableList
         * Collections.unmodifiableList returns an unmodifiable list of the cards in the deck of cards.
         */
		return Collections.unmodifiableList(aCards);
	}
}

/*?
 * Keyword: DeckObserver
 * DeckObserver is an interface that implements the Observer Design Pattern and defines the methods that are called when the deck is shuffled, a card is drawn, or a card is pushed, which are `shuffled()`, `cardDrawn(Card pCard)`, and `cardPushed(Card pCard)`, respectively. We use the push data-flow strategy for the DeckObserver interface and designed the three callbacks to map as directly as possible to the state changing methods of the model. The `shuffled()` method is called after the deck is shuffled, the `cardDrawn(Card pCard)` method is called after a card is drawn, and the `cardPushed(Card pCard)` method is called after a card is pushed.
 * 
 * Internal: Observer Design Pattern
 * DeckObserver
 * The Observer Design Pattern is a software design pattern in which an object, called the subject, maintains a list of its dependents, called observers, and notifies them automatically of any state changes, usually by calling one of their methods. It is mainly used to implement distributed event handling systems. The Observer pattern is also a key part in the familiar model–view–controller (MVC) architectural pattern. The Observer pattern is implemented in many programming libraries and systems, including almost all GUI toolkits.
 * 
 * Internal: push data-flow strategy
 * DeckObserver
 * The push data-flow strategy is a data-flow strategy in which the model notifies the view of changes in the model.
 * 
 */
interface DeckObserver
{
    /*?
     * Keyword: shuffled
     * shuffled is a method in the DeckObserver interface that is called when the deck has been shuffled. It takes no parameters and returns nothing. shuffled notifies the observer of type DeckObserver that the deck has been shuffled.
     */
	void shuffled();
    /*?
     * Keyword: cardDrawn
     * cardDrawn is a method in the DeckObserver interface that is called when a card has been drawn. It takes a Card object as a parameter and returns nothing. cardDrawn notifies the observer of type DeckObserver that a card has been drawn.
     */
	void cardDrawn(Card pCard);
    /*?
     * Keyword: cardPushed
     * cardPushed is a method in the DeckObserver interface that is called when a card has been pushed. It takes a Card object as a parameter and returns nothing. cardPushed notifies the observer of type DeckObserver that a card has been pushed.
     */
	void cardPushed(Card pCard);
}

/*?
 * Keyword: DrawLogger
 * DrawLogger is a concrete observer which prints out a description of any card drawn from the deck. It implements the DeckObserver interface, which means that it implements the methods: `cardDrawn(Card pCard)` which is called when a card is drawn from the deck and prints out the card that was drawn,`shuffled()` which is called when the deck is shuffled and does nothing, and `cardPushed(Card pCard)` which is called when a card is pushed onto the deck and does nothing.
 * 
 * Internal: concrete observer
 * DrawLogger
 * A concrete observer is an observer that implements the methods of the observer interface. In this case, the DrawLogger class implements the DeckObserver interface, which means that it is a concrete observer.
 */
class DrawLogger implements DeckObserver
{
	@Override
    /*?
     * Keyword: shuffled
     * Here we are overriding the `shuffled()` method of the DeckObserver interface to define an implementation for the shuffled method. The shuffled method does nothing in this case because we do not want to print out anything when the deck is shuffled.
     */
	public void shuffled()
	{}

	@Override
    /*?
     * Keyword: cardDrawn
     * Here we are overriding the `cardDrawn(Card pCard)` method of the `DeckObserver` interface to define an implementation for the `cardDrawn` method. The `cardDrawn` method prints out the card that was drawn from the deck.
     */
	public void cardDrawn(Card pCard)
	{
		System.out.println(pCard + " drawn");
		
	}

	@Override
    /*?
     * Keyword: cardPushed
     * Here we are overriding the `cardPushed(Card pCard)` method of the `DeckObserver` interface to define an implementation for the `cardPushed` method. The `cardPushed` method does nothing in this case because we do not want to print out anything when a card is pushed onto the deck.
     */
	public void cardPushed(Card pCard)
	{}
}

/*?
 * Keyword: SizeStatus
 * SizeStatus is a concrete observer which prints out the number of cards in the deck whenever it changes. It implements the DeckObserver interface which means that it implements the methods: `cardDrawn(Card pCard)` which is called when a card is drawn from the deck and prints out the number of cards in the deck, `shuffled()` which is called when the deck is shuffled and prints out the number of cards in the deck, and `cardPushed(Card pCard)` which is called when a card is pushed onto the deck and prints out the number of cards in the deck. Instead of pushing the size of the deck, we build a workaround to calculate the current size of the deck by keeping track of the number of cards that have been drawn and pushed in order to avoid the anti-pattern of overfitting the design of the Observer interface. We use the push data-flow strategy for the DeckObserver interface and designed the three callbacks to map as directly as possible to the state changing methods of the model. The `shuffled()` method is called after the deck is shuffled, the `cardDrawn(Card pCard)` method is called after a card is drawn, and the `cardPushed(Card pCard)` method is called after a card is pushed.
 * 
 * Internal: concrete observer
 * SizeStatus
 * A concrete observer is an observer that implements the methods of the observer interface. In this case, the SizeStatus class implements the DeckObserver interface, which means that it is a concrete observer.
 * 
 * Internal: push data-flow strategy
 * SizeStatus
 * The push data-flow strategy is a strategy in which the observer is responsible for pushing data to the subject.
 */
class SizeStatus implements DeckObserver
{
    /*?
     * Keyword: aSize
     * aSize is an integer that represents the number of cards in the deck. It is initialized to -1 because we do not know the size of the deck when the SizeStatus object is created.
     */
	private int aSize = -1;
	
	@Override
    /*?
     * Keyword: shuffled
     * Here we are overriding the `shuffled()` method of the DeckObserver interface to define an implementation for the shuffled method. The shuffled method sets the number of cards in the deck to 52 and prints out the number of cards in the deck after the deck has been shuffled.
     */
	public void shuffled()
	{
		aSize = 52;
		System.out.println(aSize);
	}


	@Override
    /*?
     * Keyword: cardDrawn
     * Here we are overriding the `cardDrawn(Card pCard)` method of the `DeckObserver` interface to define an implementation for the `cardDrawn` method. The `cardDrawn` method decreases the number of cards in the deck by 1 and prints out the number of cards in the deck after a card has been drawn from the deck.
     */
	public void cardDrawn(Card pCard)
	{
		if( aSize >=0 )
		{
			aSize--;
			System.out.println(aSize);
		}
		else
		{
			System.out.println("Size unknown");
		}
	}

	@Override
    /*?
     * Keyword: cardPushed
     * Here we are overriding the `cardPushed(Card pCard)` method of the `DeckObserver` interface to define an implementation for the `cardPushed` method. The `cardPushed` method increases the number of cards in the deck by 1 and prints out the number of cards in the deck after a card has been pushed onto the deck.
     */
	public void cardPushed(Card pCard)
	{
		if( aSize >=0 )
		{
			aSize++;
			System.out.println(aSize);
		}
		else
		{
			System.out.println("Size unknown");
		}
	}
}

