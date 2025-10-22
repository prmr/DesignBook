/*******************************************************************************
 * Companion code for the book "Introduction to Software Design with Java",
 * 3rd edition by Martin P. Robillard.
 *
 * Copyright (C) 2025 by Martin P. Robillard
 *
 * This code is licensed under a Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * 
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 * 
 *******************************************************************************/
package e3.chapter4;

/**
 * Stub for a GameModel class that is an application of the Singleton design
 * pattern.
 */
public class GameModel {

	private static final GameModel INSTANCE = new GameModel();

	private GameModel() {}

	public static GameModel instance() {
		return INSTANCE;
	}
}
