package chapter04;

import chapter04.Deck.Shuffler;

public class Client
{
	public static void main(String[] args)
	{
		// Illustration of the use of the Null object
		CardSource source = new Deck();
		System.out.println(source.isNull());
		source = CardSource.NULL;
		System.out.println(source.isNull());
		
		// Illustration of the use of the Shuffler nested class
		Deck deck = new Deck();
		Shuffler shuffler = deck.newShuffler();
		shuffler.shuffle();
		shuffler.shuffle();
		deck.shuffle();
		System.out.println(shuffler.getNumberOfShuffles());
		
		// Illustration of the use of the createByRankComparator static factory method
		// The result should always be zero because both decks are freshly initialized.
		System.out.println(Deck.createByRankComparator(Rank.ACE).compare(new Deck(), new Deck()));
		
	}
}
