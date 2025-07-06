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
 * Defines the ability to visit all types of card sources in
 * a composite structure.
 */
public interface CardSourceVisitor
{
	void visitCompositeCardSource(CompositeCardSource pCompositeCardSource);

	void visitDeck(Deck pDeck);

	void visitCardSequence(CardSequence pCardSequence);
}
