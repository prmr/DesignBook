package chapter2;

public enum EnumeratedCard
{
	ACE_CLUBS, TWO_CLUBS, THREE_CLUBS, FOUR_CLUBS, FIVE_CLUBS, SIX_CLUBS, SEVEN_CLUBS, 
	EIGHT_CLUBS, NINE_CLUBS, TEN_CLUBS, JACK_CLUBS, QUEEN_CLUBS, KING_CLUBS, 
	ACE_DIAMONDS, TWO_DIAMONDS, THREE_DIAMONDS, FOUR_DIAMONDS, FIVE_DIAMONDS, SIX_DIAMONDS, SEVEN_DIAMONDS, 
	EIGHT_DIAMONDS, NINE_DIAMONDS, TEN_DIAMONDS, JACK_DIAMONDS, QUEEN_DIAMONDS, KING_DIAMONDS, 
	ACE_HEARTS, TWO_HEARTS, THREE_HEARTS, FOUR_HEARTS, FIVE_HEARTS, SIX_HEARTS, SEVEN_HEARTS, 
	EIGHT_HEARTS, NINE_HEARTS, TEN_HEARTS, JACK_HEARTS, QUEEN_HEARTS, KING_HEARTS, 
	ACE_SPADES, TWO_SPADES, THREE_SPADES, FOUR_SPADES, FIVE_SPADES, SIX_SPADES, SEVEN_SPADES, 
	EIGHT_SPADES, NINE_SPADES, TEN_SPADES, JACK_SPADES, QUEEN_SPADES, KING_SPADES;
	
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
				EnumeratedCard card = EnumeratedCard.get(rank, suit);
				assert card.getRank() == rank;
				assert card.getSuit() == suit;
				System.out.println(card);
			}
		}
	}
	
	public Suit getSuit()
	{
		return Suit.values()[ordinal() / Rank.values().length];
	}
	
	public Rank getRank()
	{
		return Rank.values()[ordinal() % Rank.values().length];
	}
	
	public static EnumeratedCard get(Rank pRank, Suit pSuit)
	{
		return values()[13*pSuit.ordinal() + pRank.ordinal()];
	}
}
