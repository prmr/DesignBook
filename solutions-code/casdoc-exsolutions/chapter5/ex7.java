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

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EmptyStackException;
import java.util.Stack;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class TestStack
{
	/*?
	 * Keyword: aStack
	 * Stack is a class that implements a last-in-first-out (LIFO) stack of objects. aStack is an instance of Stack that we use to test the methods of Stack. If we push a string to the stack, the string is on the top of the stack. Push, pop, and peek are the methods of Stack that we test in this class: push adds an item to the top of the stack and returns the item that was added; pop removes the item on the top of the stack and returns the item that was removed; peek returns the item on the top of the stack without removing it from the stack.
	 */
	private final Stack<String> aStack = new Stack<>();
	
	@Test
	/*?
	 * Keyword: testPush_Empty
	 * This is a test method that tests the push method of Stack when the stack is empty. First, we push a string to the stack. Then, we check that the string is the same as the string that we pushed to the stack. Finally, we check that the string is the same as the string that is on the top of the stack using the peek method.
	 */
	public void testPush_Empty()
	{
		String foo = "foo";
		/*?
		 * Keyword: push
		 * Pushes an item onto the top of this stack. Here, we check if the string is the same as the string that we pushed to the stack.
		 */
		assertSame(foo, aStack.push(foo));
		/*?
		 * Keyword: peek
		 * Looks at the object at the top of this stack without removing it from the stack. Here, we check that the string is the same as the string that is on the top of the stack using the peek method.
		 */
		assertSame(foo, aStack.peek());
	}
	
	@Test
	/*?
	 * Keyword: testPush_NonEmpty
	 * This is a test method that tests the push method of Stack when the stack is not empty. First, we push a string to the stack. Then, we push another string to the stack and check that the string that we pushed to the stack is the same as the string that is on the top of the stack using the peek method. Finally, we check that the string that we pushed to the stack is the same as the string that is on the top of the stack.
	 */
	public void testPush_NonEmpty()
	{
		/*?
		 * Keyword: push
		 * Pushes an item onto the top of this stack. Here, we push a string to the stack.
		 */
		aStack.push("A");
		String foo = "foo";
		/*?
		 * Keyword: push
		 * Pushes an item onto the top of this stack. Here, we check if the string is the same as the string that we pushed to the stack.
		 */
		assertSame(foo, aStack.push(foo));
		/*?
		 * Keyword: peek
		 * Looks at the object at the top of this stack without removing it from the stack. Here, we check that the string is the same as the string that is on the top of the stack using the peek method.
		 */
		assertSame(foo, aStack.peek());
	}
	
	@Test
	/*?
	 * Keyword: testPush_Null
	 * This is a test method that tests push and peek methods with a null reference. First, we push a null reference to the stack. Then, we check that the null reference is the same as the null reference that we pushed to the stack. Finally, we check that the null reference is the same as the null reference that is on the top of the stack using the peek method.
	 */
	public void testPush_Null()
	{   // Stack (i.e., Vector) allows null references as elements
		/*?
		 * Keyword: assertNull
		 * Asserts that an object is null. Here, we check that the null reference is the same as the null reference that we pushed to the stack.
		 */
		assertNull(aStack.push(null));
		assertNull(aStack.peek());
	}
	
	@Test
	/*?
	 * Keyword: testPop_NonEmpty
	 * This is a test method that tests the pop method of Stack when the stack is not empty. First, we push a string to the stack. Then, we check that the string is the same as the string that we pushed to the stack using the pop method. Finally, we check that the stack is empty after the pop method is called because the stack should be empty after the pop method is called.
	 */
	public void testPop_NonEmpty()
	{
		String foo = "foo";
		aStack.push(foo);
		/*?
		 * Keyword: pop
		 * Removes the object at the top of this stack and returns that object as the value of this function. Here, we check that the string is the same as the string that we popped from the stack.
		 */
		assertSame(foo, aStack.pop());
		/*?
		 * Keyword: isEmpty
		 * Tests if this stack is empty. Here, we check that the stack is empty after the pop method is called because the stack should be empty after the pop method is called.
		 * 
		 * Keyword: assertTrue
		 * Asserts that a condition is true. Here, we check that the stack is empty after the pop method is called because the stack should be empty after the pop method is called.
		 */
		assertTrue(aStack.isEmpty());
	}
	
	@Test
	/*?
	 * Keyword: testPop_Empty
	 * This is a test method that tests the pop method of Stack when the stack is empty. First, we check that the stack is empty. Then, we check that the pop method throws an EmptyStackException when the stack is empty.
	 */
	public void testPop_Empty()
	{
		// Lambda expressions will be covered in Chapter 9
		/*?
		 * Keyword: assertThrows
		 * Asserts that execution of the supplied executable throws an exception of the expected type. Here, we check that the pop method throws an EmptyStackException when the stack is empty. assertThrows has 2 parameters: the first parameter is the expected exception type and the second parameter is the executable that is expected to throw the exception.
		 * 
		 * Keyword: EmptyStackException
		 * Thrown when an application attempts to pop an empty stack. Here, we check that the pop method throws an EmptyStackException when the stack is empty.
		 * 
		 * Keyword: Executable
		 * A functional interface whose functional method is execute. We create an anonymous class that implements the Executable interface and override the execute method. The execute method is the executable that is expected to throw the exception.
		 * 
		 * Internal: functional interface
		 * Executable
		 * A functional interface is an interface that contains only one abstract method. They can have only one functionality to exhibit. From Java 8 onwards, lambda expressions can be used to represent the instance of a functional interface. A functional interface can have any number of default methods.
         * 
         * Internal: abstract method
         * functional interface
         * An abstract method is a method that is declared without an implementation. It is declared using the abstract keyword. It can have parameters and a return type. It can also throw exceptions.
         * 
         * Internal: lambda expression
         * functional interface
         * A lambda expression provides a clear and concise way to represent one method interface using an expression. It is very useful in collection library. It helps to iterate, filter and extract data from collection. For example, a lambda expression to check if a aStack.pop() throws an EmptyStackException when the stack is empty, we can write the following code: `assertThrows(EmptyStackException.class, () -> aStack.pop());`
		 */
		assertThrows(EmptyStackException.class, new Executable()
		{	
			@Override
			public void execute() throws Throwable
			{
				/*?
				 * Keyword: pop
				 * Removes the object at the top of this stack and returns that object as the value of this function. Here, we check that the pop method throws an EmptyStackException when the stack is empty.
				 */
				aStack.pop();
			}
		});
	}
}
