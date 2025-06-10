/*******************************************************************************
 * Companion code for the book "Introduction to Software Design with Java",
 * 3nd edition by Martin P. Robillard.
 *
 * Copyright (C) 2025 by Martin P. Robillard
 *
 * This code is licensed under a Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * 
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 * 
 *******************************************************************************/
package e3.chapter5;

/*
 * Sample class under test.
 */
public class GameModel implements GameModelView {
	
	private final PlayingStrategy aPlayingStrategy;

	public GameModel(PlayingStrategy pStrategy) {
		aPlayingStrategy = pStrategy;
	}
	
	public void tryToAutoPlay() {
		aPlayingStrategy.computeNextMove(this);
	}
}
