package chapter2;

/*?
 * Keyword: EnumeratedCard
 * `EnumeratedCard` is an enumerated type that represents all 52 cards in a standard deck of playing cards.
 */
public enum EnumeratedCard
{
	ACE_CLUBS, TWO_CLUBS, THREE_CLUBS, FOUR_CLUBS, FIVE_CLUBS, SIX_CLUBS, SEVEN_CLUBS, 
	EIGHT_CLUBS, NINE_CLUBS, TEN_CLUBS, JACK_CLUBS, QUEEN_CLUBS, KING_CLUBS, 
	ACE_DIAMONDS, TWO_DIAMONDS, THREE_DIAMONDS, FOUR_DIAMONDS, FIVE_DIAMONDS, SIX_DIAMONDS, SEVEN_DIAMONDS, 
	EIGHT_DIAMONDS, NINE_DIAMONDS, TEN_DIAMONDS, JACK_DIAMONDS, QUEEN_DIAMONDS, KING_DIAMONDS, 
	ACE_SPADES, TWO_SPADES, THREE_SPADES, FOUR_SPADES, FIVE_SPADES, SIX_SPADES, SEVEN_SPADES, 
	EIGHT_SPADES, NINE_SPADES, TEN_SPADES, JACK_SPADES, QUEEN_SPADES, KING_SPADES, 
	ACE_HEARTS, TWO_HEARTS, THREE_HEARTS, FOUR_HEARTS, FIVE_HEARTS, SIX_HEARTS, SEVEN_HEARTS, 
	EIGHT_HEARTS, NINE_HEARTS, TEN_HEARTS, JACK_HEARTS, QUEEN_HEARTS, KING_HEARTS;
	
	/**
	 * How to properly write automated tests such as this one 
	 * is the topic of Chapter 5.
	 */
	public static void main(String[] args)
	{
		for( Rank rank : Rank.values() )
		{
			for( Suit suit : Suit.values() )
			{
				EnumeratedCard card = EnumeratedCard.get(rank, suit); // create a new card object with the rank and suit of the current iteration
				assert card.getRank() == rank;
				assert card.getSuit() == suit;
				System.out.println(card);
			}
		}
	}
	
	/*?
	 * Keyword: getSuit
	 * `getSuit` returns the suit of the card by using the ordinal value of the card and dividing it by the number of ranks.
	 * 
	 * Internal: ordinal
	 * getSuit
	 * The ordinal() method returns the ordinal value of the card.
	 * 
	 */
	public Suit getSuit()
	{
		return Suit.values()[ordinal() / Rank.values().length];
	}
	
	/*?
	 * Keyword: getRank
	 * `getRank` returns the rank of the card by using the ordinal value of the card and modding it by the number of ranks.
	 * 
	 * Internal: ordinal
	 * getRank
	 * The ordinal() method returns the ordinal value of the card.
	 * 
	 * Internal: modding
	 * getRank
	 * Modding is a mathematical operation that returns the remainder of a division operation. In this case, it returns the remainder of the ordinal value of the card divided by the number of ranks, which is the rank of the card.
	 * 
	 */
	public Rank getRank()
	{
		return Rank.values()[ordinal() % Rank.values().length];
	}
	
	/*?
	 * Keyword: get(Rank pRank, Suit pSuit)
	 * `get` returns the card with the specified rank and suit by using the ordinal value of the suit and multiplying it by the number of ranks, then adding the ordinal value of the rank.
	 */
	public static EnumeratedCard get(Rank pRank, Suit pSuit)
	{
		return values()[13*pSuit.ordinal() + pRank.ordinal()];
	}
}
