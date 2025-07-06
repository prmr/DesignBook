/*******************************************************************************
 * Companion code for the book "Introduction to Software Design with Java",
 * 3rd edition by Martin P. Robillard.
 *
 * Copyright (C) 2025 by Martin P. Robillard
 *
 * This code is licensed under a Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * 
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 *******************************************************************************/
package e3.chapter9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Code samples for Sections 9.1-9.2 and 9.6. The code samples for Section 9.3 are in 
 * their corresponding classes.
 */
public class Samples
{	
	public static void main(String[] args) {
		samples1(); // Section 9.1
		samples2(); // Section 9.2
		samples3(); // Section 9.6
	}
	
	/**
	 * For Section 9.1
	 */
	private static void samples1() {
		
		List<Card> cards = new Deck().getCards();
		
		// Calling 'sort' with an object of an anonymous class
		Collections.sort(cards, new Comparator<Card>() {
			public int compare(Card pCard1, Card pCard2) { 
				return pCard1.rank().compareTo(pCard2.rank()); 
			}
		});
		printAll(cards);
		
		// Calling 'sort' with a method reference
		Collections.sort(cards, Card::comparingByRank);
		printAll(cards);
	}
	
	/**
	 * For Section 9.2
	 */
	@SuppressWarnings("unused")
	private static void samples2() {
		// Defining a function object of type Filter, which is an application-defined functional interface
		Filter blackCards1 = new Filter() {
			public boolean accept(Card pCard) {
				return pCard.suit().getColor() == Suit.Color.BLACK;
			}
		};
		
		// Defining a function object whose type is a library functional interface
		Predicate<Card> blackCards2 = new Predicate<Card>() {
			public boolean test(Card pCard) {
				return pCard.suit().getColor() == Suit.Color.BLACK;
			}
		};
		
		// Defining a predicate using a lambda expression (expression syntax with parameter type specified)
		Predicate<Card> blackCards3 = (Card card) -> card.suit().getColor() == Suit.Color.BLACK;
		
		// Defining a predicate using a lambda expression (block syntax with parameter type specified)
		Predicate<Card> blackCards4 =
				(Card card) -> { return card.suit().getColor() == Suit.Color.BLACK; };
				
		// Defining a predicate using a lambda expression (expression syntax with parameter type not specified)
		Predicate<Card> blackCards5 = (card) -> card.suit().getColor() == Suit.Color.BLACK;
		
		// Defining a predicate using a lambda expression (expression syntax with parameter type not specified
		// and no parentheses around the parameter
		Predicate<Card> blackCards6 = card -> card.suit().getColor() == Suit.Color.BLACK;
		
		// Sample use of the filter:
		int total = 0;
		for( Card card : new Deck().getCards() ) {
			if( blackCards6.test(card) ) {
				total++;
			}
		}
		System.out.println(total);
		
		// Example use of removeIf with a lambda that implements the filter
		ArrayList<Card> cards = new ArrayList<>(new Deck().getCards());
		cards.removeIf(card -> card.suit().getColor() == Suit.Color.BLACK );
		printAll(cards);
		
		// Using a lambda expression that delegates to an implementation method
		cards = new ArrayList<>(new Deck().getCards());
		cards.removeIf(card -> card.hasBlackSuit() );
		printAll(cards);
		
		
		// Using a reference to an instance method of an arbitrary object of a particular type
		cards = new ArrayList<>(new Deck().getCards());
		cards.removeIf(Card::hasBlackSuit);
		printAll(cards);
		
		// Using a reference to a static method 
		cards = new ArrayList<>(new Deck().getCards());
		cards.removeIf(CardUtils::hasBlackSuit);
		printAll(cards);
		
		// Using a reference to an instance method of a particular object
		Deck deck = new Deck();
		cards = new ArrayList<>(new Deck().getCards());
		cards.removeIf(deck::topSameColorAs);
		printAll(cards);
	}
	
	/**
	 * For Section 9.6
	 */
	@SuppressWarnings("unused")
	public static void samples3() {
		
		// Data as a stream
		Stream<Card> cards = new Deck().stream();
		long total = cards.count();
		System.out.println(total);
		
		Stream<Card> sortedCards = new Deck().stream().sorted();
		sortedCards.forEach(System.out::println);
		
		Stream<Card> sortedCards2 = new Deck().stream().sorted().limit(10);
		sortedCards2.forEach(System.out::println);
		
		Stream<Card> cards2 = Stream.concat(new Deck().stream(), new Deck().stream());
		System.out.println(cards2.count());

		Stream<Card> withDuplicates = Stream.concat(new Deck().stream(), new Deck().stream());
		Stream<Card> withoutDuplicates = withDuplicates.distinct();
		
		// Applying Higher-Order Functions to Streams
		new Deck().stream().forEach(card -> System.out.println(card)); // or
		new Deck().stream().forEach(System.out::println);

		boolean allClubs = new Deck().stream()
				.allMatch(card -> card.suit() == Suit.CLUBS );
		
		// Filtering streams
		long numberOfFaceCards = new Deck().stream()
				.filter(card -> card.rank().ordinal() >= Rank.JACK.ordinal()).count();
		
		long numberOfFaceCards2 = new Deck().stream()
				.filter(Card::isFaceCard)
				.count();
		
		long result = new Deck().stream()
				.filter(card -> card.rank().ordinal() >= Rank.JACK.ordinal()
				&& card.suit()==Suit.CLUBS).count();
		
		long result2 = new Deck().stream()
				.filter(Card::isFaceCard)
				.filter(card -> card.suit() == Suit.CLUBS)
				.count();
		
		// Mapping data elements
		new Deck().stream().map(card -> card.suit().getColor() );
		
		long result3 = new Deck().stream()
				.map(card -> card.suit().getColor() )
				.filter( color -> color == e3.chapter9.Suit.Color.BLACK )
				.count();
		
		new Deck().stream()
			.map(card -> Math.min(10, card.rank().ordinal() + 1));
		
		int total2 = new Deck().stream()
				.mapToInt(card -> Math.min(10, card.rank().ordinal() + 1))
				.sum();
		
		int total3 = new Deck().stream()
				.map(Card::rank)
				.mapToInt(Rank::ordinal)
				.map(ordinal -> Math.min(10, ordinal + 1))
				.sum();
		
		// Flat-mapping
		List<Deck> listOfDecks = Arrays.asList(new Deck(), new Deck());
		
		listOfDecks.stream()
			.flatMap(deck -> deck.getCards().stream())
			.forEach(System.out::println);
		
		// Reducing Streams
		
		// Not ideal
		List<Card> result4 = new ArrayList<>();
		new Deck().stream()
			.filter(Card::isFaceCard)
			.forEach(card -> result4.add(card));
		
		// Better
		List<Card> result5 = new Deck().stream()
				.filter(Card::isFaceCard)
				.collect(Collectors.toList());
	}
	
	private static void printAll(List<Card> pCards) {
		for( Card card : pCards) {
			System.out.println(card);
		}
	}
}
