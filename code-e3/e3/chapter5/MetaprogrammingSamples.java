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
package e3.chapter5;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MetaprogrammingSamples {
	
	public static void main(String[] args) {
		introspection();
		manipulation1();
		manipulation2();
	}
	
	/**
	 * Demonstrates basic introspection features
	 */
	private static void introspection() {
		try {
			String fullyQualifiedName = "java.lang.String";
			Class<?> stringClass1 = Class.forName(fullyQualifiedName);
			System.out.println(stringClass1.getName());
			
			Class<String> stringClass2 = String.class;
			
			String title = "Introduction to Software Design";
			
			Class<? extends String> stringClass3 = title.getClass();
			System.out.println(stringClass2 == stringClass3);
			
			for (Method method : stringClass3.getDeclaredMethods()) {
				System.out.println(method.getName());
			}
		}
		catch( ClassNotFoundException e ) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Illustrates how to use metaprogramming to create an instance
	 * of an object with a private constructor.
	 */
	private static void manipulation1() {
		try {
			Card card1 = Card.get(Rank.ACE, Suit.CLUBS);
			Constructor<Card> cardConstructor = Card.class.getDeclaredConstructor(Rank.class, Suit.class);
			cardConstructor.setAccessible(true);
			Card card2 = cardConstructor.newInstance(Rank.ACE, Suit.CLUBS);
			System.out.println(card1 == card2);
		}
		catch( ReflectiveOperationException e ) { 
			e.printStackTrace(); 
		}
	}
	
	/**
	 * Illustrates how to use metaprogramming to change the value of a private
	 * field of an instance.
	 */
	private static void manipulation2() {
		try {
			Card card = Card.get(Rank.TWO, Suit.CLUBS);
			Field rankField = Card.class.getDeclaredField("aRank");
			rankField.setAccessible(true);
			rankField.set(card, Rank.ACE);
			System.out.println(card);
		} catch( ReflectiveOperationException e ) { 
			e.printStackTrace(); 
		}
	}
}
