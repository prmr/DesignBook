/*******************************************************************************
 * Companion code for the book "Introduction to Software Design with Java",
 * 2nd edition by Martin P. Robillard.
 *
 * Copyright (C) 2022 by Martin P. Robillard
 *
 * This code is licensed under a Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * 
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 * 
 *******************************************************************************/
package e3.chapter8;

/**
 * Visitor that prints a representation of the hierarchical structure
 * of a card source.
 */
public class StructurePrinterVisitor extends AbstractCardSourceVisitor
{
	private static final String TAB = "   ";
	private String aTab = "";
	
	private void tab() {
		aTab += TAB;
	}
	
	private void untab() {
		aTab = aTab.substring(TAB.length());
	}
	
	@Override
	public void visitCompositeCardSource(CompositeCardSource pCompositeCardSource) {
		System.out.println(aTab + "Composite");
		tab();
		super.visitCompositeCardSource(pCompositeCardSource);
		untab();
	}

	@Override
	public void visitDeck(Deck pDeck) {
		System.out.println(aTab + "Deck");
	}

	@Override
	public void visitCardSequence(CardSequence pCardSequence) {
		System.out.println(aTab + "CardSequence");
	}
}
