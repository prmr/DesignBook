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
package chapter7;

/**
 * Skeleton of a class that encapsulates the move of a 
 * card between two piles in Solitaire. Sample concrete
 * class that extends an abstract class and plays a role 
 * in the Template Method design pattern.
 */
public final class CardMove extends AbstractMove
{
	/**
	 * In practice this would also need to accept the source
	 * and destination piles.
	 * 
	 * @param pModel The game model on which the move is performed.
	 */
	public CardMove(GameModel pModel)
	{
		super(pModel);
	}

	@Override
	public void undo()
	{
		/* Undo the move */
	}

	@Override
	protected void execute()
	{
		/* Execute the move */
	}
}
