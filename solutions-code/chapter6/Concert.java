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
 * Represents a show that consists of the screening of a single movie.
 */
public class Concert implements Show
{
	private String aTitle;
	private String aPerformer;
	private int aRunningTime;
	
	/**
	 * @param pTitle The title of the concert
	 * @param pPerformer The name of the artist or orchestra performing
	 * @param pTime The running time of the concert.
	 */
	public Concert(String pTitle, String pPerformer, int pTime)
	{
		aTitle = pTitle;
		aPerformer = pPerformer;
		aRunningTime = pTime;
	}
	
	@Override
	public String description()
	{
		return String.format("%s by %s", aTitle, aPerformer);
	}

	@Override
	public int runningTime()
	{
		return aRunningTime;
	}
}
