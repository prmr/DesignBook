package chapter3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Comparator;


/**
 * A collection of cards in a player's hand. Basic version for Exercise 1.
 */

public class Hand {

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


    /*?
     * Keyword: createAscendingComparator()
     * `createAscendingComparator()` is a static factory method that returns a comparator that compares hands by their size in ascending order.
     * 
     * Internal: static
     * createAscendingComparator()
     * A static method is a method that is called on the class itself, rather than on an instance of the class.
     * 
     * Internal: factory method
     * createAscendingComparator()
     * A factory method is a method that returns an instance of the class. It is called on the class itself, rather than on an instance of the class. For example, `Integer.valueOf(5)` is a factory method that returns an instance of the `Integer` class.
     * 
     * Internal: comparator
     * createAscendingComparator()
     * A Comparator is an object that compares two objects of the same type. It is used to sort collections of objects. For example, `Arrays.sort(a, c)` sorts the array `a` using the comparator `c`.
     */
    public static Comparator<Hand> createAscendingComparator()
	{
		return new Comparator<Hand>() {

            /*?
             * Keyword: @Override
             * `@Override` is an annotation that indicates that the method overrides a method in a superclass. Here, the `compare` method overrides the `compare` method in the `Comparator` interface so that it compares hands by their size in ascending order.
             * 
             * Internal: ascending order
             * @Override
             * The hand with the smallest number of cards is considered to be less than the hand with a larger number of cards.
             * 
             */
			@Override
            /*?
             * Keyword: compare
             * `compare` is a method that compares two hands, pHand1 and pHand2, and returns an integer that indicates which hand is greater than the other. If the first hand is greater than the second hand, the method returns a positive integer. If the first hand is less than the second hand, the method returns a negative integer. If the two hands are equal, the method returns 0. The `compare` method is required by the `Comparator` interface and is used to sort collections of objects. For example, `Arrays.sort(a, c)` sorts the array `a` using the comparator `c`.
             *
             */
			public int compare(Hand pHand1, Hand pHand2)
			{
				return pHand1.aCards.size() - pHand2.aCards.size();
			}};
	}
	
    /*?
     * Keyword: createDescendingComparator()
     * `createDescendingComparator()` is a static factory method that returns a comparator that compares hands by their size in descending order.
     * 
     * Internal: static
     * createDescendingComparator()
     * A static method is a method that is called on the class itself, rather than on an instance of the class.
     * 
     * Internal: factory method
     * createDescendingComparator()
     * A factory method is a method that returns an instance of the class. It is called on the class itself, rather than on an instance of the class. For example, `Integer.valueOf(5)` is a factory method that returns an instance of the `Integer` class.
     * 
     * Internal: comparator
     * createDescendingComparator()
     * A Comparator is an object that compares two objects of the same type. It is used to sort collections of objects. For example, `Arrays.sort(a, c)` sorts the array `a` using the comparator `c`.
     */
	public static Comparator<Hand> createDescendingComparator()
	{
		return new Comparator<Hand>() {

			@Override
            /*?
             * Keyword: compare
             * `compare` is a method that compares two hands, pHand1 and pHand2, and returns an integer that indicates which hand is greater than the other. If the first hand is greater than the second hand, the method returns a positive integer. If the first hand is less than the second hand, the method returns a negative integer. If the two hands are equal, the method returns 0. The `compare` method is required by the `Comparator` interface and is used to sort collections of objects. For example, `Arrays.sort(a, c)` sorts the array `a` using the comparator `c`.
             */
			public int compare(Hand pHand1, Hand pHand2)
			{
				return pHand2.aCards.size() - pHand1.aCards.size();
			}};
	}
}