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
package chapter3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * A collection of cards in a player's hand. Basic version for Exercise 1.
 */

/*?
 * Keyword:Iterable<Card>
 * The `Iterable<Card>` interface is a generic interface that represents an object that can be iterated over. In this case, the type is Card. The interface has one method, iterator, which returns an iterator over the elements in this collection. The iterator is used to iterate over the elements  in the collection. In this case, the elements are the cards in the hand and the iterator is used to iterate over the cards in the hand. The iterator is used in the for-each loop, so users of the Iterable interface do not need to know the implementation details of the iterator.
 * 
 * Internal:generic interface
 * Iterable<Card>
 * A generic interface is an interface that can be used with any type. In this case, the type is Card. The interface has one method, iterator, which returns an iterator over the elements in this collection.
 * 
 */
public class Hand implements Iterable<Card>
{
	private List<Card> aCards = new ArrayList<>();
	private int aMaxCards;
	
	/**
	 * Creates a new, empty hand, which can hold
	 * a maximum of pMaxCards.
	 * 
	 * @param pMaxCards The maximum number of cards allowed in this hand.
	 * @pre pMaxCards > 0;
	 */
	public Hand(int pMaxCards)
	{
		assert pMaxCards > 0;
		aMaxCards = pMaxCards;
	}
	
	
	@Override
    /*?
     * Keyword: iterator()
     * The iterator() method returns an iterator over the elements in this collection. The iterator is used to iterate over the elements in the collection. In this case, the elements are the cards in the hand and the iterator is used to iterate over the cards in the hand. The iterator is used in the for-each loop, so users of the Iterator interface do not need to know the implementation details of the iterator.
     */
	public Iterator<Card> iterator()
	{
		return aCards.iterator();
	}

    /*?
     * Keyword:getNextCard()
     * The getNextCard() method returns the next card in the hand. The method uses the iterator to iterate over the cards in the hand. 
     * The iterator is used in the for-each loop, so users of the Iterator interface do not need to know the implementation details of the iterator. 
     * The method returns the next card in the hand. If there are no more cards in the hand, the method returns null.
     * The `Iterator<Card>` interface specifies 2 methods - `hasNext()` and `next()`. 
     * 
     * Internal:`hasNext()`
     * getNextCard()
     * The `hasNext()` method returns true if the iteration has more elements. In this case, the iteration has more elements if there are more cards in the hand.
     * 
     * Internal: `next()`
     * getNextCard()
     * The `next()` method returns the next element in the iteration. In this case, the next element is the next card in the hand.
     */
    public Card getNextCard() {
        Iterator<Card> iterator = this.iterator();
        if (iterator.hasNext()) {
            return iterator.next();
        }
    }

	
	
	/**
	 * This is the driver program.
	 * @param args
	 */
	public static void main(String[] args)
	{
        //create a hand and add a few random cards
        Hand hand = new Hand(5);
        hand.add(new Card(Rank.ACE, Suit.CLUBS));
        hand.add(new Card(Rank.TWO, Suit.CLUBS));
        hand.add(new Card(Rank.THREE, Suit.CLUBS));
        hand.add(new Card(Rank.FOUR, Suit.CLUBS));
        hand.add(new Card(Rank.FIVE, Suit.CLUBS));

        //make an iterator
        Iterator<Card> iterator = hand.iterator();

        //print each card in the hand using getNextCard()
        Card card = hand.getNextCard();
        while (card != null) {
            System.out.println(card);
            card = hand.getNextCard();
        }

	}
}
