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
package e2.chapter5;

/*
 * Sample class under test.
 */
public class GameModel implements GameModelView {
	
	private static GameModel INSTANCE = new GameModel();
	
	private PlayingStrategy aPlayingStrategy;
	
	public static GameModel instance() {
		return INSTANCE;
	}
	
	public void tryToAutoPlay() {
		aPlayingStrategy.computeNextMove(this);
	}
}
