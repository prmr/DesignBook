package e3.chapter9;

import static java.util.Comparator.comparing;

import java.util.Comparator;
import java.util.List;

public class SampleSortingApplications {

	public static void sampleSortingApplication1() {
		List<Card> cards = new Deck().getCards();
		cards.sort(
			Comparator
				.comparing((Card card) -> card.suit())
				.reversed()
				.thenComparing(Comparator.comparing((Card card) -> card.rank())
						.reversed()));
	}
	
	public static void sampleSortingApplication2() {
		List<Card> cards = new Deck().getCards();
		cards.sort(comparing((Card card) -> card.suit())
				.reversed()
				.thenComparing(comparing((Card card) -> card.rank())
						.reversed()));
	}
	
	public static void sampleSortingApplication3() {
		List<Card> cards = new Deck().getCards();
		cards.sort(comparing(Card::suit)
				.reversed()
				.thenComparing(comparing(Card::rank)
						.reversed()));
	}
	
	public static void sampleSortingApplication4() {
		List<Card> cards = new Deck().getCards();
		cards.sort(comparing(Card::suit)
				.thenComparing(Card::rank).reversed());
	}
}
