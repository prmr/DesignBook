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
package chapter6;

/**
 * Illustration of ab application of the Prototype design pattern.
 */
public class CardSourceManager
{
	private CardSource aPrototype = new Deck(); // Default

	public void setPrototype(CardSource pPrototype)
	{
		aPrototype = pPrototype;
	}

	public CardSource createCardSource()
	{
		return aPrototype.clone();
	}
}