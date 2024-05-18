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
package chapter8;

/**
 * An object that observes a Program, designed with push data flow.
 */
public interface ProgramObserver {
	default void added(Show pShow, Day pDay) {}
	default void removed(Day pDay) {}
	default void cleared() {}
}

class ProgramAddLogger implements ProgramObserver {
    @Override
	public void added(Show pShow, Day pDay) {
        System.out.println("New Show" + pShow.toString() + "Added To" + pDay);
    }

	@Override
	public void removed(Day pDay) {
        ;	
	}

	@Override
	public void cleared()
	{}
}