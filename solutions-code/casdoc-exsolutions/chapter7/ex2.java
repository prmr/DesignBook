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
 * Represents a concert.
 */
public class Concert implements Show
{
	private String aTitle;
	private String aPerformer;
	private int aTime;
	
    /*?
     * Keyword: Concert
     * The constructor of the class `Concert` takes the title, performer, and time as parameters. It initializes the fields `aTitle`, `aPerformer`, and `aTime`. These fields are private, so they can only be set by the constructor.
     */
	public Concert(String pTitle, String pPerformer, int pTime)
	{
		aTitle = pTitle;
		aPerformer = pPerformer;
		aTime = pTime;
	}
	
	public String getTitle()
	{
		return aTitle;
	}
	
	public void setTitle(String pTitle)
	{
		aTitle = pTitle;
	}

	@Override
	public String title()
	{
		return aTitle;
	}

	@Override
	public String description()
	{
		return String.format("%s by %s", aTitle, aPerformer);
	}

	@Override
	public int time()
	{
		return aTime;
	}
	
	public void setTime(int pTime)
	{
		aTime = pTime;
	}

    /*?
     * Keyword: getPerformer
     * The method `getPerformer()` returns the performer of the concert. This method is public, so it can be called from outside the class. Strings are immutable, so there is no risk of the caller modifying the performer.
     */
    public String getPerformer() {
        return aPerformer;
    }
}
