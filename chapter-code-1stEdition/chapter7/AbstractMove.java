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
 * Root class for all moves that require a reference
 * to the GameModel. Method perform() fulfills the role
 * of the Template Method in an application of the Template
 * Method design pattern.
 */
public abstract class AbstractMove implements Move
{
	protected final GameModel aModel;
	
	protected AbstractMove(GameModel pModel)
	{
		aModel = pModel;
	}
	
	public final void perform()
	{
		aModel.push(this);
		execute();
		log();
	}
	
	protected abstract void execute();
	
	private void log()
	{
		System.out.println(getClass().getName());
	}
}
