# Chapter 8 Practice Exercises

## Exercise 1

Consider the following implementation of class [`Deck`](../chapter-code/chapter4/Deck.java). Apply the Observer design pattern to make the class *observable*. Assume we have two types of concrete observers: a `DrawLogger` with prints out a description of any card drawn, and a `SizeStatus` observer that prints out the size of the deck whenever it changes. Design and implement all required classes and interfaces, and write a small piece of client code to demonstrate the operation of the pattern. Use the push data-flow strategy. The concrete observers can be implemented as simple `println` statements.

## Exercise 2

Change the design of your observable `Deck` from exercise 1 to use the pull data-flow strategy, using the interface segregation principle to strengthen the constraint that the observers should not change the state of the `Deck` object.


## Exercise 3

Change the design of your observable `Deck` from exercise 1 so that all the observer-supporting code is in a *superclass* of deck. What are the advantages and disadvantages of this decision?

## Exercise 4

Change the design of your observable `Deck` from exercise 1 so that all the observer-supporting code is in a *subclass* of deck. What are the advantages and disadvantages of this decision?

# Exercise 5

Model the solution produced in exercise 4 with a class diagram, object diagram, and sequence diagram that illustrates a call initiated by calling `draw` on a `Deck` object.

---
<a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" /></a>

Unless otherwise noted, the content of this repository is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a>. 

Copyright Martin P. Robillard 2019
