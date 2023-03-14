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

import java.util.Iterator;
import java.util.Collections;

/**
 * Represents a performance that can take place in a theater. All implementations
 * of this interface should be immutable.
 */
public interface Show extends Iterable<Show>
{
	/**
	 * @return A description of the show.
	 */
	String description();
	
	
	/**
	 * @return The running time of the show, in minutes.
	 */
	int runningTime();
	
	Show copy();

    /*?
     * Keyword: iterator
     * Returns an iterator over the shows in the show. iterator() is a method in the Iterable interface that returns an iterator over the elements in the show. We can use it to iterate over the shows in the show by using a for-each loop as follows:
     * `for( Show subshow : show ) { ... }`
     */
    Iterator<Show> iterator();

    //default iterator() method that returns empty iterator for shows that don't have subshows. This is needed because we are using a for-each loop to iterate over the shows in the show. If we don't have a default iterator() method, we will get a compilation error when we try to iterate over a show that doesn't have subshows.

    /*?
     * Keyword: @Override
     * Indicates that the method overrides a method in a superclass. Here, we use it to indicate that the iterator() method overrides the iterator() method in the Iterable interface.
     */
    @Override
    /*?
     * Keyword: default
     * Indicates that the method is a default method. Here, we use it to indicate that the iterator() method is a default method. Default methods are methods that are defined in an interface but have a default implementation. This allows us to add new methods to an interface without breaking existing implementations of the interface. Default methods are only allowed in interfaces that have a single abstract method. This is called a functional interface. The Iterable interface is a functional interface. The default iterator() method is needed because we are using a for-each loop to iterate over the shows in the show. If we don't have a default iterator() method, we will get a compilation error when we try to iterate over a show that doesn't have subshows.
     * 
     * Internal: abstract method
     * default
     * an abstract method is a method that is declared in an interface but not implemented. The method must be implemented by any class that implements the interface. Here, the abstract method is the iterator() method in the Iterable interface.
     */
    default Iterator<Show> iterator()
    {
        return Collections.emptyIterator();
    }
}
