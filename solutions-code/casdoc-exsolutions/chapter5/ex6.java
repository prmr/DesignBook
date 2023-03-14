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
package chapter5;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class StringTester
{
	/**
	 * Checks that we can call any parameterless method of class String on an
	 * empty string without raising an exception.
	 */
	public static void main(String[] args)
	{
		/*?
		 * Keyword: Method
		 * Method is a class that represents a method of a class or interface in Java.
		 * 
		 * Keyword: getDeclaredMethods
		 * Returns an array of Method objects reflecting all the methods declared by the class or interface represented by this Class object including public, protected, default (package) access, and private methods, but excluding inherited methods. Here, the methods of the class String are returned.
		 */
		for( Method method : String.class.getDeclaredMethods() )
		{
			/*?
			 * Keyword: getParameterCount
			 * Returns the number of formal parameters (whether explicitly declared or implicitly declared or neither) for the executable represented by this object. If method.getParameterCount() returns 0, then the method has no parameters. For any parameterless method, we try to invoke it on an empty string and if it raises an exception, we print "No, we cannot." and exit the program. Otherwise, we print "Yes, we can!" and exit the program.
			 */
			if( method.getParameterCount() == 0 )
			{
				try
				{
					/*?
					 * Keyword: invoke
					 * Invokes the underlying method represented by this Method object, on the specified object with the specified parameters. Here, the method is invoked on an empty string because the method is parameterless and the object is an empty string.
					 */
					method.invoke("");
				}
				/*?
				 * Keyword: IllegalAccessException
				 * Thrown when an application tries to reflectively create an instance (other than an array), set or get a field, or invoke a method, but the currently executing method does not have access to the definition of the specified class, field, method or constructor.
				 * 
				 * Internal: reflectively
				 * IlegalAccessException
				 * reflectively means that the method is called by reflection.
				 * 
				 * Internal: reflection
				 * reflectively
				 * reflection is a feature of Java that allows a program to examine or modify the behavior of itself at runtime.
				 * 
				 * Keyword: IllegalArgumentException
				 * Thrown to indicate that a method has been passed an illegal or inappropriate argument.
				 * 
				 * Keyword: InvocationTargetException
				 * Thrown by an invoked method or constructor if the underlying method or constructor throws an exception.
				 */
				catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
				{
					System.out.println("No, we cannot.");
					System.exit(0);
				}
			}
		}
		System.out.println("Yes, we can!");
	}
}
