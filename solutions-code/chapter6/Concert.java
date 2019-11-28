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

import java.util.Objects;

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
	
	public Concert(Concert pConcert)
	{
		this(pConcert.aTitle, pConcert.aPerformer, pConcert.aRunningTime);
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

	@Override
	public Show copy()
	{
		return new Concert(this);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(aPerformer, aRunningTime, aTitle);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Concert other = (Concert) obj;
		return Objects.equals(aPerformer, other.aPerformer) && aRunningTime == other.aRunningTime
				&& Objects.equals(aTitle, other.aTitle);
	}
}
