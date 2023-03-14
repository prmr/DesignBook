package chapter3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Comparator;


/**
 * A collection of cards in a player's hand. Basic version for Exercise 1.
 */

public class Hand implements Iterable<Card> {

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

    /**
	 * Creates a comparator that compares hands in terms of ascending number
	 * of cards of rank pRank in the hand.
	 * 
	 * @param pRank The rank to test against.
	 * @return A new Comparator instance that can compare by number
	 * of cards of the specified rank.
	 */
    /*?
     * Keyword: createByRankComparator(Rank pRank)
     * `createByRankComparator(Rank pRank)` is a static factory method that returns a comparator that compares hands in terms of ascending number of cards of rank pRank in the hand.
     * 
     * Internal: static
     * createByRankComparator(Rank pRank)
     * A static method is a method that is called on the class itself, rather than on an instance of the class.
     * 
     * Internal: factory method
     * createByRankComparator(Rank pRank)
     * A factory method is a method that returns an instance of the class. It is called on the class itself, rather than on an instance of the class. For example, `Integer.valueOf(5)` is a factory method that returns an instance of the `Integer` class.
     * 
     * Internal: comparator
     * createByRankComparator(Rank pRank)
     * A comparator is an object that compares two objects. It is used to sort collections of objects. For example, `Collections.sort(List<T>, Comparator<T>)` takes a comparator as a parameter.
     * 
     * 
     * 
     */
	public static Comparator<Hand> createByRankComparator(Rank pRank)
	{
		return new Comparator<Hand>()
		{
			@Override
            /*?
             * Keyword: compare(Hand pHand1, Hand pHand2)
             * `compare(Hand pHand1, Hand pHand2)` is an abstract method that compares two hands. It uses the `countCards(Hand pHand, Rank pRank)` method to count the number of cards of rank pRank in each hand. It returns the difference between the number of cards of rank pRank in pHand1 and pHand2. The compare() method is required by the Comparator interface so that we can use the Collections.sort() method to sort the hands.
             */
			public int compare(Hand pHand1, Hand pHand2)
			{
				return countCards(pHand1, pRank) - countCards(pHand2, pRank);
			}
			
            /**
             * Counts the number of cards of rank pRank in pHand.
             * 
             * @param pHand The hand to count cards in.
             * @param pRank The rank to count.
             * @return The number of cards of rank pRank in pHand.
             */
            /*?
             * Keyword: countCards(Hand pHand, Rank pRank)
             * `countCards(Hand pHand, Rank pRank)` is a helper method that counts the number of cards of rank pRank in pHand. It uses a for-each loop to iterate through the cards in pHand. It returns the number of cards of rank pRank in pHand. 
             * 
             * Internal: helper method
             * countCards(Hand pHand, Rank pRank)
             * A helper method is a method that is used by another method. In this case, the `compare(Hand pHand1, Hand pHand2)` method uses the `countCards(Hand pHand, Rank pRank)` method to count the number of cards of rank pRank in each hand.
             */
			private int countCards(Hand pHand, Rank pRank)
			{
				int total = 0;
				for( Card card : pHand)
				{
                    /*?
                     * Keyword: getRank()
                     * `getRank()` is a method that returns the rank of the card. It is used to get the rank of the card in the for-each loop. 
                     */
					if( card.getRank() == pRank )
					{
						total++;
					}
				}
				return total;
			}
		};
	}
}