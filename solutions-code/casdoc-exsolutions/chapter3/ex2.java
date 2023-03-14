package chapter3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A collection of cards in a player's hand. Basic version for Exercise 1.
 */

/*?
 * Keyword: Comparable<Hand>
 * Comparable<Hand> is an interface that is implemented by the Hand class. This interface allows us to use the `Collections.sort` method to sort a list of hands in ascending order of size. The Comparable interface requires that we implement the `compareTo` method that compares this hand to another hand, pOther.
 */
public class Hand implements Iterable<Card>, Comparable<Hand> {

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
	public Iterator<Card> iterator()
	{
		return aCards.iterator();
	}

    /*?
     * Keyword: size
     * `size` is a method that returns the number of cards in this hand.
     * 
     * Internal: aCards
     * size
     * The `aCards` field represents the cards in this hand.
     */
    public int size()
    {
        return aCards.size();
    }

    /**
	 * Add pCards to the hand.
	 * @param pCard The card to add.
	 * @pre !isFull()
	 * @pre pCard != null;
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
	public boolean isFull()
	{
		return aCards.size() == aMaxCards;
	}


    @Override
    /*?
     * Keyword: compareTo(Hand pOther)
     * `compareTo` is a method that compares this hand to another hand, pOther. The method returns a negative number if this hand is smaller than pOther, a positive number if this hand is larger than pOther, and 0 if this hand is equal to `pOther`. This method is required by the `Comparable<Hand>` interface and is used by the `Collections.sort` method to sort a list of hands in ascending order of size.
     * 
     * Internal: `Comparable<Hand>`
     * compareTo(Hand pOther)
     * The `Comparable<Hand>` interface requires that we implement the `compareTo` method that compares this hand to another hand, pOther.
     * 
     * Internal: `Collections.sort`
     * compareTo(Hand pOther)
     * The `Collections.sort` method sorts a list of hands in ascending order of size. This method requires that the `Hand` class implements the `Comparable<Hand>` interface.
     */
    public int compareTo(Hand pOther)
    {
        return aCards.size() - pOther.aCards.size();
    }

    public static void main(String[] args)
	{
		Hand hand1 = new Hand(5);
		Hand hand2 = new Hand(5);
		Deck deck = new Deck();
		deck.shuffle();
		hand1.add(deck.draw());
		hand2.add(deck.draw());
		hand2.add(deck.draw());
		System.out.println(hand1.compareTo(hand2));
		System.out.println(hand2.compareTo(hand1));
    }
}