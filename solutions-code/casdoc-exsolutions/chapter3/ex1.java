package chapter3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/*?
 * Keyword: implements
 * implements is used to implement an interface.
 * 
 * Internal: interface
 * implements
 * An interface is a collection of methods that a class must implement.
 * 
 * Keyword: Iterable<Card>
 * Iterable<Card> is an interface that is implemented by the Hand class. This interface allows us to use the for-each loop to iterate over the cards in the hand. The Iterable interface requires that we implement the iterator() method that returns an iterator.
 * 
 * Internal: iterator
 * Iterable<Card>
 * An iterator is an object that can be used to iterate over a collection of objects. In this case, the iterator is used to iterate over the cards in the hand, which is a collection of Card objects.
 * 
 * Internal: for-each loop
 * Iterable<Card>
 * A for-each loop is a loop that iterates over a collection of objects. In this case, the for-each loop is used to iterate over the cards in the hand, which is a collection of Card objects. For example, the following code uses a for-each loop to iterate over the cards in the hand: `for (Card card : hand) { ... }`
 */
public class Hand implements Iterable<Card> {
    private List<Card> aCards = new ArrayList<>();

    /*?
     * Keyword: aMaxCards
     * aMaxCards is a field that represents the maximum number of cards in a hand.
     */
	private int aMaxCards;
	
	/**
	 * Creates a new, empty hand, which can hold
	 * a maximum of pMaxCards.
	 * 
	 * @param pMaxCards The maximum number of cards allowed in this hand.
	 * @pre pMaxCards > 0;
	 */
    /*?
     * Keyword: Hand
     * Hand is a constructor that creates a new hand with a maximum number of cards, pMaxCards.
     */
	public Hand(int pMaxCards)
	{
		assert pMaxCards > 0;
		aMaxCards = pMaxCards;
	}
	
	/**
	 * Add pCards to the hand.
	 * @param pCard The card to add.
	 * @pre !isFull()
	 * @pre pCard != null;
	 */
    /*?
     * Keyword: add
     * add is a method that adds a card to the hand. It takes a parameter, pCard, which is the card to add.
     */
	public void add(Card pCard)
	{
		assert pCard != null;
		assert !isFull();
		aCards.add(pCard);
	}
	
	/**
	 * @return True if the number of cards in the hand
	 * is the maximum number of cards allowable, as specified
	 * in the constructor.
	 */
    /*?
     * Keyword: isFull
     * isFull is a method that returns true if the number of cards in the hand is the maximum number of cards allowable, as specified in the constructor.
     */
	public boolean isFull()
	{
		return aCards.size() == aMaxCards;
	}
	
	/**
	 * @return True if there are no cards in this hand.
	 */
    /*?
     * Keyword: isEmpty
     * isEmpty is a method that returns true if there are no cards in the hand.
     */
	public boolean isEmpty()
	{
		return aCards.size() == 0;
	}
	
	/**
	 * Removes pCards if it is in the hand. If it is not in the
	 * hand, does nothing. 
	 * 
	 * @param pCard The card to remove.
	 * @pre pCards != null;
	 */
    /*?
     * Keyword: remove
     * remove is a method that removes a card from the hand. It takes a parameter, pCard, which is the card to remove.
     */
	public void remove(Card pCard)
	{
		assert pCard != null;
		aCards.remove(pCard);
	}
	
	/**
	 * @param pCard A card to check for containment.
	 * @return True if pCard is a card in this hand.
	 * @pre pCard != null
	 */
    /*?
     * Keyword: contains
     * contains is a method that returns true if pCard is a card in the hand.
     */
	public boolean contains(Card pCard)
	{
		assert pCard != null;
		return aCards.contains(pCard);
	}

    	/**
	 * @return The number of cards currently in the hand.
	 */
    /*?
     * Keyword: size
     * size is a method that returns the number of cards currently in the hand.
     */
	public int size()
	{
		return aCards.size();
	}


    /*?
     * Keyword: @Override
     * @Override is an annotation that indicates that the method is overriding a method in a superclass or interface. In this case, the method is overriding the iterator() method in the Iterable interface so that we can use the for-each loop to iterate over the cards in the hand.
     * 
     * Internal: overriding
     * @Override
     * overriding is the process of redefining a method in a subclass that has the same signature as a method in the superclass. In this case, the iterator() method in the Hand class overrides the iterator() method in the Iterable interface.
     * 
     * Internal: superclass
     * @Override
     * A superclass is a class that is extended by a subclass. In this case, the Hand class extends the ArrayList class so the Hand class is the subclass and the ArrayList class is the superclass. Then, the Hand class overrides the iterator() method in the ArrayList class to define the iterator() method for the Hand class.
     */
    @Override
    /*?
     * Keyword: iterator()
     * iterator() is a method that returns an iterator object of the collection. In this case, the iterator is used to iterate over the cards in the hand so it returns an object of type Iterator<Card>. This is useful because it allows us to use the for-each loop to iterate over the cards in the hand. 
     * 
     * Internal: for-each loop
     * iterator()
     * A for-each loop is a loop that iterates over a collection of objects. In this case, the for-each loop is used to iterate over the cards in the hand, which is a collection of Card objects. For example, the following code uses a for-each loop to iterate over the cards in the hand: `for (Card card : hand) { ... }`
     */
	public Iterator<Card> iterator()
	{
		return aCards.iterator();
	}

}