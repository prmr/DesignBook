/*******************************************************************************
 * Companion code for the book "Introduction to Software Design with Java" by Martin P. Robillard.
 *
 * Copyright (C) 2019 by Martin P. Robillard
 *
 * This code is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * 
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 *******************************************************************************/
package chapter8;

public class Driver
{
	/**
	 * Sample use of different visitors.
	 */
	public static void main(String[] args)
	{
		CardSource root = createSampleSource();
		
		// Basic printing 
		root.accept(new PrintVisitor());
		
		// Containment checking
		ChecksContainmentVisitor visitor = new ChecksContainmentVisitor(Card.get(Rank.ACE, Suit.CLUBS));
		root.accept(visitor);
		System.out.println(visitor.contains());
		CardSequence sequence = new CardSequence(Card.get(Rank.EIGHT, Suit.DIAMONDS));
		visitor.reset();
		sequence.accept(visitor);
		System.out.println(visitor.contains());
		
		// Counts cards
		CountingVisitor visitor2 = new CountingVisitor();
		root.accept(visitor2);
		System.out.println(visitor2.getCount());
		visitor2.reset();
		sequence.accept(visitor2);
		System.out.println(visitor2.getCount());

		// Fancy printing
		root.accept(new StructurePrinterVisitor());
		sequence.accept(new StructurePrinterVisitor());
		
		// Defining an anonymous visitor which prints the number
		// of cards in card sequences found embedded in the source.
		CardSourceVisitor visitor3 = new AbstractCardSourceVisitor()
		{
			@Override
			public void visitCardSequence(CardSequence pSequence)
			{
				System.out.println(pSequence.size() + " cards");
			}
		};
		root.accept(visitor3);
	}

	private static CardSource createSampleSource()
	{
		CardSequence sequence = new CardSequence(Card.get(Rank.ACE, Suit.CLUBS), Card.get(Rank.ACE, Suit.DIAMONDS),
				Card.get(Rank.ACE, Suit.HEARTS), Card.get(Rank.ACE, Suit.HEARTS));
		CompositeCardSource composite = new CompositeCardSource(new Deck(), sequence);
		return new CompositeCardSource(new Deck(), composite);
	}
}
