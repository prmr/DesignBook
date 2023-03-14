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

/*?
 * Keyword: implements
 * implemets is used to implement an interface, in this case DeckView, which is an interface that has three methods: `getCards()`, `isEmpty()`, and `getLastDrawn()`. The methods in the interface are implemented in the class ObservableDeck.
 */
public class ObservableDeck implements DeckView {
    /*?
     * Keyword: aCards
     * aCards is a list of cards that is used to store the cards in the deck.
     */
    private final List<Card> aCards = new ArrayList<>();
    /*?
     * Keyword: aObservers
     * aObservers is a list of DeckObservers that is used to store the observers of the deck.
     */
    private final List<DeckObserver> aObservers = new ArrayList<>();
    /*?
     * Keyword: aLastDrawn
     * aLastDrawn is a reference that is used to store the last card that was drawn from the deck. We use an `Optional` type because the last drawn card may not exist (i.e. the deck is empty) and we want to avoid `null` values in our code. Here, we use `Optional.empty()` to represent the absence of a value as the initial value of `aLastDrawn`. With the pull data-flow strategy, useful information such as the last drawn cards might be lost as state changes continue to propagate through the system, so we use `aLastDrawn` to store the last drawn card so that we can access it later.
     *
     *
     * Internal: `Optional`
     * aLastDrawn
     * `Optional` is a class that is used to represent a value that may or may not exist. It is used to avoid `null` values in our code. `Optional` has two static methods: `empty()` and `of()`. `empty()` is used to create an empty `Optional` object, and `of()` is used to create a non-empty `Optional` object. `Optional` also has two instance methods: `isPresent()` and `get()`. `isPresent()` is used to check if the `Optional` object has a value, and `get()` is used to get the value of the `Optional` object. If the `Optional` object is empty, then `get()` will throw an `NoSuchElementException`.
     */
    private Optional<Card> aLastDrawn = Optional.empty();

    /**
     * Creates a new deck of 52 cards, shuffled.
     */
    /*?
     * Keyword: ObservableDeck
     * ObservableDeck is the constructor of the class. It calls the `shuffle()` method to shuffle the deck of cards when the deck is created (i.e. when the constructor is called)
     */
    public ObservableDeck() {
        shuffle();
    }

    /*?
     * Keyword: getLastDrawn
     * getLastDrawn is a method that returns the last drawn card from the deck. It returns the value of `aLastDrawn` which is an `Optional` object. If the `Optional` object is empty, then `getLastDrawn()` will return `null`. Otherwise, it will return the value of the `Optional` object using the `get()` method of `Optional` class. This method is used by observers of the deck to get the last drawn card.
     */
    public Card getLastDrawn() {
        return aLastDrawn.get();
    }

    /*?
     * Keyword: addObserver
     * addObserver is a method that adds an observer to the list of observers of the deck. It takes in a `DeckObserver` object as a parameter and adds it to the list of observers.
     */
    public void addObserver(DeckObserver pObserver) {
        assert pObserver != null;
        aObservers.add(pObserver);
    }

    /**
     * Reinitializes the deck with all 52 cards, and shuffles them.
     */
    /*?
    * Keyword: shuffle
    * shuffle is a method that shuffles the deck of cards. It first clears the list of cards in the deck, then adds all 52 cards to the deck, and finally shuffles the deck. It also notifies all the observers of the deck that the deck has been shuffled.
    */
    public void shuffle() {
        aCards.clear();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                aCards.add(Card.get(rank, suit));
            }
        }
        Collections.shuffle(aCards);
        // Notify observers that the deck has been shuffled by calling the `shuffled()` method of each observer.
        for (DeckObserver observer : aObservers) {
            /*?
             * Keyword: this
             * `this` is a keyword that refers to the current object. In this case, `this` refers to the current `ObservableDeck` object.
             */
            observer.shuffled(this);
        }
    }

    /**
     * Places pCard on top of the deck.
     * 
     * @param pCard The card to place on top
     *              of the deck.
     * @pre pCard !=null
     */
    /*?
     * Keyword: push
     * push is a method that pushes a card to the top of the deck. It takes in a `Card` object as a parameter and adds it to the list of cards in the deck. It also notifies all the observers of the deck that a card has been pushed to the deck.
     */
    public void push(Card pCard) {
        assert pCard != null;
        aCards.add(pCard);
        // Notify observers that a card has been pushed to the deck by calling the `cardPushed()` method of each observer.
        for (DeckObserver observer : aObservers) {
            /*?
             * Keyword: this
             * `this` is a keyword that refers to the current object. In this case, `this` refers to the current `ObservableDeck` object.
             */
            observer.cardPushed(this);
        }
    }

    /**
     * Draws a card from the deck: removes the card from the top
     * of the deck and returns it.
     * 
     * @return The card drawn.
     * @pre !isEmpty()
     */
    /*?
     * Keyword: draw
     * draw is a method that draws a card from the deck. It removes the last card from the list of cards in the deck and returns it. It also notifies all the observers of the deck that a card has been drawn from the deck.
     */
    public Card draw() {
        assert !isEmpty();
        Card card = aCards.remove(aCards.size() - 1);
        /*?
         * Keyword: aLastDrawn
         * `aLastDrawn` is an `Optional` object that stores the last drawn card from the deck to be able to return it using the `getLastDrawn()` method. Here, we use `Optional.of()` to create a non-empty `Optional` object that contains the last drawn card.
         * 
         * Keyword: of
         * `of` is a static method of the `Optional` class that is used to create a non-empty `Optional` object. It takes in a value as a parameter and returns a non-empty `Optional` object that contains the value. We use the `of()` method here to create a non-empty `Optional` object that contains the last drawn card and store it in `aLastDrawn` to be able to return it using the `getLastDrawn()` method.
         */
        aLastDrawn = Optional.of(card);
        // Notify observers that a card has been drawn from the deck by calling the `cardDrawn()` method of each observer.
        for (DeckObserver observer : aObservers) {
            /*?
             * Keyword: this
             * `this` is a keyword that refers to the current object. In this case, `this` refers to the current `ObservableDeck` object.
             */
            observer.cardDrawn(this);
        }
        return card;
    }

    /**
     * @return True if and only if there are no cards in the deck.
     */
    public boolean isEmpty() {
        return aCards.isEmpty();
    }

    /**
     * @return An unmodifiable list of all the cards in the deck.
     */
    public List<Card> getCards() {
        /*?
         * Keyword: unmodifiableList
         * `unmodifiableList` is a static method of the `Collections` class that is used to create an unmodifiable list. It takes in a list as a parameter and returns an unmodifiable list that contains the same elements as the list passed in as a parameter. We use the `unmodifiableList()` method here to create an unmodifiable list of all the cards in the deck.
         */
        return Collections.unmodifiableList(aCards);
    }
}
/*?
 * Keyword: DeckObserver
 * `DeckObserver` is an interface that implements the Observer Design Pattern using the pull data-flow strategy. `DeckObserver` defines the methods that are called when the deck is shuffled, a card is drawn, or a card is pushed, which are `shuffled()`, `cardDrawn()`, and `cardPushed()` respectively. 
 * 
 * Internal: Observer Design Pattern
 * DeckObserver
 * The Observer Design Pattern is a software design pattern in which an object, called the subject, maintains a list of its dependents, called observers, and notifies them automatically of any state changes, usually by calling one of their methods. It is mainly used to implement distributed event handling systems. The Observer pattern is also a key part in the familiar model–view–controller (MVC) architectural pattern. The Observer pattern is implemented in many programming libraries and systems, including almost all GUI toolkits.
 * 
 * Internal: Pull Data-Flow Strategy
 * DeckObserver
 * In the pull data-flow strategy, the subject is responsible for calling the observer's methods to check the state of the subject. This is the opposite of the push data-flow strategy, in which the subject is responsible for notifying the observer of any changes in the subject's state. The subject passes a reference to itself as a parameter to the observer's methods. The observer can then use the reference to access the subject's state. This strategy is also known as the callback strategy.
 */
interface DeckObserver {

    /*?
     * Keyword: shuffled
     * `shuffled` is a method that is called when the deck is shuffled. It takes in a `DeckView` object as a parameter and returns nothing. 
     * 
     * Keyword: DeckView
     * `DeckView` is an interface that defines the methods that are used to access the state of the deck. It is used here to pass a reference to the method that is called when the deck is shuffled so that the observer can access the state of the deck using the methods defined in `DeckView`. In the methods of ObservableDeck, we pass an object of type `ObservableDeck` as a parameter to the methods of `DeckObserver` interface, and this is allowed because `ObservableDeck` is a subclass of `DeckView`.
     */
    void shuffled(DeckView pDeckView);

    /*?
     * Keyword: cardDrawn
     * `cardDrawn` is a method that is called when a card is drawn from the deck. It takes in a `DeckView` object as a parameter and returns nothing.
     * 
     * Keyword: DeckView
     * `DeckView `is an interface that defines the methods that are used to access the state of the deck. It is used here to pass a reference to the method that is called when a card is drawn from the deck so that the observer can access the state of the deck using the methods defined in `DeckView`. In the methods of ObservableDeck, we pass an object of type `ObservableDeck` as a parameter to the methods of `DeckObserver` interface, and this is allowed because `ObservableDeck` is a subclass of `DeckView`.
     */
    void cardDrawn(DeckView pDeckView);

    /*?
     * Keyword: cardPushed
     * `cardPushed` is a method that is called when a card is pushed to the deck. It takes in a `DeckView` object as a parameter and returns nothing.
     * 
     * Keyword: DeckView
     * `DeckView` is an interface that defines the methods that are used to access the state of the deck. It is used here to pass a reference to the method that is called when a card is pushed to the deck so that the observer can access the state of the deck using the methods defined in `DeckView`. In the methods of ObservableDeck, we pass an object of type `ObservableDeck` as a parameter to the methods of `DeckObserver` interface, and this is allowed because `ObservableDeck` is a subclass of `DeckView`.
     */
    void cardPushed(DeckView pDeckView);
}

/*?
 * Keyword: DrawLogger
 * `DrawLogger` is a concrete observer which prints out a description of any card drawn from the deck. It implements the DeckObserver interface, which means that it implements the methods: `cardDrawn(DeckView)` which is called when a card is drawn from the deck and prints out the last card that was drawn, `shuffled(DeckView)` which is called when the deck is shuffled and does nothing, and `cardPushed(DeckView)` which is called when a card is pushed to the deck and does nothing.
 * 
 * Internal: concrete observer
 * DrawLogger
 * A concrete observer is an observer that implements the methods of the observer interface. In this case, the DrawLogger class implements the DeckObserver interface, which means that it is a concrete observer.
 */
class DrawLogger implements DeckObserver {
    @Override
    /*?
     * Keyword: shuffled
     * Here we are overriding the `shuffled()` method of the DeckObserver interface to define an implementation for the shuffled method. The shuffled method does nothing in this case because we do not want to print out anything when the deck is shuffled. The observer can check the state of the deck using the methods defined in the DeckView interface using the reference to the deck that is passed in as a parameter.
     */
    public void shuffled(DeckView pDeckView) {
    }

    @Override
    /*?
     * Keyword: cardDrawn
     * Here we are overriding the `cardDrawn()` method of the DeckObserver interface to define an implementation for the cardDrawn method. The cardDrawn method prints out the last card that was drawn from the deck. The observer can check the state of the deck using the methods defined in the DeckView interface using the reference to the deck that is passed in as a parameter. 
     */
    public void cardDrawn(DeckView pDeckView) {
        /*?
         * Keyword: getLastDrawn
         * `getLastDrawn` is a method that is defined in the DeckView interface and is implemented in ObservableDeck. It returns the last card that was drawn from the deck. We use this method here to print out the last card that was drawn from the deck. We are using the pull data-flow strategy, which means that the subject is responsible for calling the observer's methods to check the state of the subject and retrieve the last drawn card to be able to print it out.
         */
        System.out.println(pDeckView.getLastDrawn() + " drawn");

    }

    @Override
    /*?
     * Keyword: cardPushed
     * Here we are overriding the `cardPushed()` method of the DeckObserver interface to define an implementation for the cardPushed method. The cardPushed method does nothing in this case because we do not want to print out anything when a card is pushed to the deck. The observer can check the state of the deck using the methods defined in the DeckView interface using the reference to the deck that is passed in as a parameter.
     */
    public void cardPushed(DeckView pDeckView) {
    }
}

/*?
 * Keyword: SizeStatus
 * `SizeStatus` is a concrete observer which prints out the size of the deck whenever the deck is shuffled, a card is drawn from the deck, or a card is pushed to the deck. It implements the DeckObserver interface, which means that it implements the methods: `cardDrawn(DeckView)` which is called when a card is drawn from the deck and prints out the size of the deck, `shuffled(DeckView)` which is called when the deck is shuffled and prints out the size of the deck, and `cardPushed(DeckView)` which is called when a card is pushed to the deck and prints out the size of the deck.
 * 
 * Internal: concrete observer
 * SizeStatus
 * A concrete observer is an observer that implements the methods of the observer interface. In this case, the SizeStatus class implements the DeckObserver interface, which means that it is a concrete observer.
 *
 */
class SizeStatus implements DeckObserver {
    @Override
    /*?
     * Keyword: shuffled
     * Here we are overriding the `shuffled()` method of the DeckObserver interface to define an implementation for the shuffled method. The shuffled method prints out the size of the deck after it has been shuffled. The observer can check the state of the deck using the size() method defined in the DeckView interface using the reference to the deck that is passed in as a parameter.
     */
    public void shuffled(DeckView pDeckView) {

        /*?
         * Keyword: size
         * `size` is a method that is defined in the DeckView interface. It returns the size of the deck. We use this method here to print out the size of the deck. We are using the pull data-flow strategy, which means that the subject is responsible for calling the observer's methods to check the state of the subject and retrieve the size of the deck to be able to print it out.
         */
        System.out.println(pDeckView.size());
    }

    @Override
    /*?
     * Keyword: cardDrawn
     * Here we are overriding the `cardDrawn()` method of the DeckObserver interface to define an implementation for the cardDrawn method. The cardDrawn method prints out the size of the deck after a card has been drawn from the deck. The observer can check the state of the deck using the size() method defined in the DeckView interface using the reference to the deck that is passed in as a parameter.
     */
    public void cardDrawn(DeckView pDeckView) {
        /*?
         * Keyword: size
         * `size` is a method that is defined in the DeckView interface. It returns the size of the deck. We use this method here to print out the size of the deck after a card has been drawn from the deck. We are using the pull data-flow strategy, which means that the subject is responsible for calling the observer's methods to check the state of the subject and retrieve the size of the deck to be able to print it out.
         */
        System.out.println(pDeckView.size());
    }

    @Override
    /*?
     * Keyword: cardPushed
     * Here we are overriding the `cardPushed()` method of the DeckObserver interface to define an implementation for the cardPushed method. The cardPushed method prints out the size of the deck after a card has been pushed to the deck. The observer can check the state of the deck using the size() method defined in the DeckView interface using the reference to the deck that is passed in as a parameter.
     */
    public void cardPushed(DeckView pDeckView) {
        /*?
         * Keyword: size
         * `size` is a method that is defined in the DeckView interface. It returns the size of the deck. We use this method here to print out the size of the deck after a card has been pushed to the deck. We are using the pull data-flow strategy, which means that the subject is responsible for calling the observer's methods to check the state of the subject and retrieve the size of the deck to be able to print it out.
         */
        System.out.println(pDeckView.size());
    }
}

/*?
 * Keyword: DeckView
 * `DeckView` is an interface that defines the methods that can be used to check the state of the deck. It is used by the observers to check the state of the deck. It is implemented by the ObservableDeck class and the Deck class. The DeckView interface is used to apply the observer design pattern using a pull data-flow strategy.
 * 
 * Internal: observer design pattern
 * DeckView
 * The observer design pattern is a design pattern in which an object, called the subject, maintains a list of its dependents, called observers, and notifies them automatically of any state changes, usually by calling one of their methods or by passing a reference to itself to the observer. The observers can check the state of the subject using the methods defined in the DeckView interface. In this case, the DeckView interface defines the methods that can be used to check the state of the deck. The DeckView interface is used to apply the observer design pattern using a pull data-flow strategy.
 * 
 * Internal: pull data-flow strategy
 * DeckView
 * The pull data-flow strategy is a data-flow strategy in which the subject is responsible for calling the observer's methods to check the state of the subject. In this case, the observers can check the state of the deck using the methods defined in the DeckView interface. The DeckView interface is used to apply the observer design pattern using a pull data-flow strategy.
 */
interface DeckView {
    /*?
     * Keyword: getCards
     * `getCards()` is a method that returns a list of cards. It is used to check the state of the deck. It is used by the observers to check the state of the deck. It is implemented by the ObservableDeck class and the Deck class.
     */
    List<Card> getCards();
    
    /*?
     * Keyword: isEmpty
     * `isEmpty()` is a method that returns a boolean value. It is used to check the state of the deck. It is used by the observers to check the state of the deck. It is implemented by the ObservableDeck class and the Deck class.
     */
    boolean isEmpty();
    
    /*?
     * Keyword: getLastDrawn
     * `getLastDrawn()` is a method that returns the last drawn card. It is used to check the state of the deck. It is used by the observers to check the state of the deck and to print out the last drawn card. It is implemented by the ObservableDeck class and the Deck class. 
     */
    Card getLastDrawn();

    /*?
     * Keyword: size
     * `size()` is a method that returns the size of the deck. It is used to check the state of the deck. It is used by the observers to check the state of the deck and to print out the size of the deck. It is implemented as a default method in the DeckView interface.
     * 
     * Keyword: default
     * `default` is a keyword that is used to define a default method in an interface. A default method is a method that is defined in an interface and that can be overridden in a class that implements the interface. In this case, the size() method is defined in the DeckView interface and is used by the observers to check the state of the deck and to print out the size of the deck. The size() method is implemented as a default method in the DeckView interface. The default method is used to avoid duplicating code in classes that implement the DeckView interface.
     */
    default int size() {
        /*?
         * Keyword: size
         * getCards() returns a list of cards. The size() method of a list returns the size of the list. In this case, the size() method returns the size of the deck. It is used by the observers to check the state of the deck and to print out the size of the deck.
         */
        return getCards().size();
    }
}
