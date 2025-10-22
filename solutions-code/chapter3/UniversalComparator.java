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

import java.util.Comparator;

import e1.chapter3.Card;
import e1.chapter3.Rank;
import e1.chapter3.Suit;

/**
 * Can compare hands in either increasing or decreasing number of 
 * cards. This is not an example of good design, but the idea of the 
 * exercise is to think about why that may be.
 */
public class UniversalComparator implements Comparator<Hand>
{
	public enum Order { ASCENDING, DESCENDING }
	
	private Order aOrder = Order.ASCENDING;
	
	/**
	 * Creates a comparator that compares in increasing size by default
	 */
	public UniversalComparator() {}
	
	/**
	 * @param pOrder Specifies the order
	 */
	public UniversalComparator(Order pOrder)
	{
		aOrder = pOrder;
	}

	@Override
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
		Hand hand1 = new Hand(3);
		Hand hand2 = new Hand(3);
		hand1.add(new Card(Rank.ACE, Suit.CLUBS));
		UniversalComparator comparator = new UniversalComparator();
		System.out.println(comparator.compare(hand1, hand2));
		comparator.setOrder(Order.DESCENDING);
		System.out.println(comparator.compare(hand1, hand2));
	}
}
