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
package chapter8;

/**
 * Visitor that prints a representation of the hierarchical structure
 * of a card source.
 */
public class StructurePrinterVisitor extends AbstractCardSourceVisitor
{
	private int aTab = 0;
	
	private String tab()
	{
		StringBuilder result = new StringBuilder();
		for( int i = 0; i < aTab; i++ )
		{
			result.append(" ");
		}
		return result.toString();
	}
	
	@Override
	public void visitCompositeCardSource(CompositeCardSource pCompositeCardSource)
	{
		System.out.println(tab() + "Composite");
		aTab++;
		super.visitCompositeCardSource(pCompositeCardSource);
		aTab--;
	}

	@Override
	public void visitDeck(Deck pDeck)
	{
		System.out.println(tab() + "Deck");
	}

	@Override
	public void visitCardSequence(CardSequence pCardSequence)
	{
		System.out.println(tab() + "CardSequence");
	}
}
