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
package chapter9;

public class DeckCommand
{
	private final Runnable aCommand;
	private final String aName;

	public DeckCommand(String pName, Runnable pCommand)
	{
		aName = pName;
		aCommand = pCommand;
	}

	public void execute()
	{
		aCommand.run();
	}
	
	public String getName()
	{
		return aName;
	}
}