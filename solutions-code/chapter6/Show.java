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
 * Represents a performance that can take place in a theater. All implementations
 * of this interface should be immutable.
 */
public interface Show
{
	/**
	 * @return A description of the show.
	 */
	String description();
	
	
	/**
	 * @return The running time of the show, in minutes.
	 */
	int runningTime();
}
