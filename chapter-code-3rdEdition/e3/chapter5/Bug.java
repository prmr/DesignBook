package e3.chapter5;

import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import chapter5.Card;
import chapter5.Rank;
import chapter5.Suit;

public class Bug {
	
	public static void main(String[] args) {
		System.out.println(toCard("Two of Clubs"));
		System.out.println(toCard("jack of spades"));
		System.out.println(toCard("jack if spades"));
	}
	
	/**
	 * Returns the card that corresponds to the input
	 * description.
	 * 
	 * @param A string that describes a card in the form 
	 *     "RANK of SUIT", where RANK is a valid rank name
	 *     and SUIT is a valid suit name (case insensitive).
	 * @return The card described by the string.
	 * @throws IllegalArgumentException if the string does 
	 *     not describe a valid card.
	 * @pre pCardDescription != null
	 */
	public static Card toCard(String pCardDescription) {
		String[] parts = pCardDescription.toUpperCase().split(" ");
		return Card.get(Rank.valueOf(parts[0]), 
				Suit.valueOf(parts[2]));
	}
	
	@ParameterizedTest
	@MethodSource("allCards")
	void testToCard_AllCardsValid(Card pCard) {
		Card actual = toCard("%s of %s".formatted(pCard.getRank(), pCard.getSuit()));
		assertSame(pCard, actual);
	}
	
	static List<Card> allCards() {
		List<Card> result = new ArrayList<>();
		for (Rank rank : Rank.values()) {
			for (Suit suit : Suit.values()) {
				result.add(Card.get(rank, suit));
			}
		}
		return result;
	}
}
