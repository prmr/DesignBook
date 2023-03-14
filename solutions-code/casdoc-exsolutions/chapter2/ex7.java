package chapter2;

/**
 * A class that represents a deck of cards composed of multiple decks
 * of cards. This version does not implement the copy-constructor 
 * part the exercise.
 * 
 * @author Martin P. Robillard
 */
public class MultiDeck
{
	/*?
	 * Keyword: aDecks
	 * aDecks is an array of decks that are used to create a multi-deck.
	 * 
	 * Internal: array
	 * aDecks
	 * An array is a collection of objects of the same type. In this case, the array is a collection of decks.
	 */
	private Deck[] aDecks;
	
	/**
	 * Creates an initialized, shuffled multi-deck from pNumberOfDecks
	 * decks.
	 * @param pNumberOfDecks The number of decks in the multi-deck
	 * @pre pNumberOfDecks > 0
	 */
	public MultiDeck(int pNumberOfDecks)
	{
		assert pNumberOfDecks > 0;
		aDecks = new Deck[pNumberOfDecks];
		for( int i =0; i < aDecks.length; i++ )
		{
			aDecks[i] = new Deck();
		}
	}

	/**
	 * Creates a new multi-deck from an existing multi-deck pDeck by
	 * copying the decks in pDeck to aDecks and creating new decks for
	 * each deck in pDeck using the copy-constructor.
	 * @param pDeck The multi-deck to copy
	 * @pre pDeck != null
	 * @pre pDeck.aDecks != null
	 * 
	 * @return a shallow copy of the multideck
	 */
	/*?
	 * Keyword: MultiDeck
	 * MultiDeck creates a new multi-deck from an existing multi-deck pDeck by copying the decks in pDeck to aDecks and creating new decks for each deck in pDeck using the copy-constructor.
	 * 
	 * Internal: copy-constructor
	 * MultiDeck
	 * A copy-constructor is a constructor that creates a new object from an existing object. In this case, the copy-constructor creates a new multi-deck from an existing multi-deck by copying the decks in the existing multi-deck to aDecks and creating new decks for each deck in the existing multi-deck using the copy-constructor.
	 * 
	 */
	public MultiDeck(MultiDeck pDeck) {
		assert pDeck != null;
		assert pDeck.aDecks != null;

		aDecks = new Deck[pDeck.aDecks.length];
		for(int i = 0; i < aDecks.length; i++) {
			aDecks[i] = new Deck(pDeck.aDecks[i]);
		}
	}

	/*
	 * @param pDeck The multi-deck to copy
	 * @pre pDeck != null
	 * @pre pDeck.aDecks != null
	 * 
	 * @return a deep copy of the multideck
	 */
	/*?
	 * Keyword: deepCopy
	 * deepCopy creates a new multi-deck from an existing multi-deck pDeck by copying the decks in pDeck to aDecks and creating new decks for each deck in pDeck using the deepCopy method.
	 */
	public MultiDeck deepCopy(MultiDeck pDeck) {
		assert pDeck != null;
		assert pDeck.aDecks != null;

		aDecks = new Deck[pDeck.aDecks.length];
		for(int i = 0; i < aDecks.length; i++) {
			aDecks[i] = new Deck();
			/*?
			 * Keyword: pDeck.aDecks[i].size()
			 * pDeck.aDecks[i].size() returns the number of cards in the deck at index i in the array of decks. We use j < pDeck.aDecks[i].size() to iterate through the cards in the deck at index i in the array of decks and add them to the deck at index i in the array of decks in this multi-deck. 
			 * 
			 * Internal: size()
			 * pDeck.aDecks[i].size()
			 * size() returns the number of elements in a collection. In this case, size() returns the number of cards in the deck at index i in the array of decks.
			 * 
			 */
			for(int j = 0; j < pDeck.aDecks[i].size(); j++) {
				/*?
				 * Keyword: pDeck.aDecks[i].get(j)
				 * pDeck.aDecks[i].get(j) returns the card at index j in the deck at index i in the array of decks. We use pDeck.aDecks[i].get(j) to add the card at index j in the deck at index i in the array of decks to the deck at index i in the array of decks in this multi-deck. This is a deep copy because we are creating new cards and adding them to the deck at index i in the array of decks in this multi-deck.
				 * 
				 * Internal: deep copy
				 * pDeck.aDecks[i].get(j)
				 * A deep copy is a copy of an object that creates new objects from the existing objects. In this case, we are creating new cards and adding them to the deck at index i in the array of decks in this multi-deck. A deep copy is different from a shallow copy because a deep copy creates new objects from the existing objects. A shallow copy creates a new object that points to the existing objects. Copied multi-decks have distinct object graphs from the original multi-decks because the copied multi-decks have new decks and new cards.
				 */
				aDecks[i].add(pDeck.aDecks[i].get(j));
			}
		}
		return this;
	}
	
	/**
	 * @return The next card in the multi-deck
	 * @pre !isEmpty()
	 */
	/*?
	 * Keyword: draw
	 * draw returns the next card in the multi-deck. If the multi-deck is empty, it returns null.
	 */
	public Card draw()
	{
		assert !isEmpty();
		for( Deck deck : aDecks )
		{
			if( deck.isEmpty() )
			{
				continue;
			}
			return deck.draw();
		}
		assert false;
		return null;
	}
	
	/**
	 * @return True if all decks in this multi-deck are empty
	 */

	/*?
	 * Keyword: isEmpty
	 * isEmpty returns true if all decks in this multi-deck are empty. Otherwise, it returns false.
	 */
	public boolean isEmpty()
	{
		for( Deck deck : aDecks )
		{
			if( !deck.isEmpty() )
			{
				return false;
			}
		}
		return true;
	}
}
