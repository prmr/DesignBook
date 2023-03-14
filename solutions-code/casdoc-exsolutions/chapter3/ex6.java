package chapter3;

import java.util.Comparator;

/**
 * Can compare hands in either increasing or decreasing number of 
 * cards. This is not an example of good design, but the idea of the 
 * exercise is to think about why that may be.
 */

/*?
 * Block:1
 * Comparator<Hand> 
 * The Comparator<Hand> interface is a generic interface that compares two objects of the same type. In this case, the type is Hand. The interface has one method, compare, which takes two objects of the same type and returns an integer. The integer is positive if the first object is greater than the second, negative if the first object is less than the second, and 0 if the two objects are equal. The compare method is used to sort objects in a collection.
 * 
 * Internal: generic interface
 * 1
 * A generic interface is an interface that can be used with any type. In this case, the type is Hand. The interface has one method, compare, which takes two objects of the same type and returns an integer.
 */
public class UniversalComparator implements Comparator<Hand> {
	/*?
	 * Keyword: Order
	 * The Order enum is an enum that represents the order of the comparator. It has two values, ASCENDING and DESCENDING. The enum is used to set the order of the comparator, which is used to sort the hands in the deck in either increasing or decreasing order.
	 */
	public enum Order { ASCENDING, DESCENDING }
	
	/*?
	 * Keyword: aOrder
	 * aOrder is a field that represents the order of the comparator. It is an Order enum and is set to `ASCENDING` by default.
	 */
	private Order aOrder = Order.ASCENDING;
	
	/**
	 * Creates a comparator that compares in increasing size by default
	 */
	/*?
	 * Keyword: UniversalComparator()
	 * The UniversalComparator() constructor creates a comparator that compares in increasing size by default. It sets the order of the comparator to `ASCENDING`.
	 */
	public UniversalComparator() {}
	
	/**
	 * @param pOrder Specifies the order
	 */
	/*?
	 * Keyword: UniversalComparator(Order pOrder)
	 * The UniversalComparator(Order pOrder) constructor creates a comparator that compares in the order specified by `pOrder`. 
	 * It sets the order of the comparator to `pOrder`.
	 * 
	 * Internal: `pOrder`
	 * UniversalComparator(Order pOrder)
	 * `pOrder` is a parameter that represents the order of the comparator. It is an Order enum.
	 */
	public UniversalComparator(Order pOrder)
	{
		aOrder = pOrder;
	}

	@Override
	/*?
	 * Keyword: compare(Hand pHand1, Hand pHand2)
	 * The compare(Hand pHand1, Hand pHand2) method compares two hands and returns an integer. If aOrder is `ASCENDING`, the method returns the difference between the size of the first hand and the size of the second hand. If aOrder is `DESCENDING`, the method returns the difference between the size of the second hand and the size of the first hand.
	 * 
	 * Internal: pHand1
	 * compare(Hand pHand1, Hand pHand2)
	 * pHand1 is a parameter that represents the first hand. It is a Hand object.
	 * 
	 * Internal: pHand2
	 * compare(Hand pHand1, Hand pHand2)
	 * pHand2 is a parameter that represents the second hand. It is a Hand object.
	 */
	public int compare(Hand pHand1, Hand pHand2)
	{
		if( aOrder == Order.ASCENDING )
		{
			return pHand1.size() - pHand2.size();
		}
		else
		{
			return pHand2.size() - pHand1.size();
		}
	}
	
	/**
	 * @param pOrder The comparison order.
	 * @pre pOrder != null
	 */
	/*?
	 * Keyword: setOrder(Order pOrder)
	 * The setOrder(Order pOrder) method sets the order of the comparator to `pOrder`.
	 * 
	 * Internal: `pOrder`
	 * setOrder(Order pOrder)
	 * `pOrder` is a parameter that represents the order of the comparator. It is an Order enum.
	 */
	public void setOrder(Order pOrder)
	{
		aOrder = pOrder;
	}
	
	/**
	 * Driver program.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		// the following lines of code are used to test the class.
		Hand hand1 = new Hand(3); // a hand with 3 cards
		Hand hand2 = new Hand(3); // a hand with 3 cards
		hand1.add(new Card(Rank.ACE, Suit.CLUBS)); // add an ace of clubs to the hand 
		UniversalComparator comparator = new UniversalComparator(); // create a comparator that compares in increasing size
		System.out.println(comparator.compare(hand1, hand2)); // print the result of comparing the two hands (should be positive)
		comparator.setOrder(Order.DESCENDING); // set the order of the comparator to decreasing size
		System.out.println(comparator.compare(hand1, hand2)); // print the result of comparing the two hands (should be negative)
	}
}
