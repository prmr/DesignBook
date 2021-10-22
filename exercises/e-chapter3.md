# Chapter 3 Practice Exercises

## Exercise 1

Design and implement a well-encapsulated abstraction to represent a `Hand` of cards in a player's hand as a Java class. A `Hand` should be able to contain between 0 and `N` cards, where `N` is a a parameterizable upper bound that will depend on the card game being played (e.g., 5 for Draw Poker, 13 for Bridge, etc.). Implement the following services on a `Hand`: `add(Card)`, `remove(Card)`, `contains(Card)`, `isEmpty()`, `size()`, and `isFull()`. Find a way to provide access to the cards in the hand. Ensure that all the rules of encapsulation seen in Chapter 2 are respected and use design by contract to clarify valid and invalid inputs. Assume there are no duplicate cards and that there only ever exists only a single instance that represents a given card in a running program (more on this in Chapter 4).

## Exercise 2

Make is possible to compare two `Hand` objects using the `Comparable` interface. Compare hands by increasing number of cards in the hand. Write a small program to test your class. You do not need to handle the case where the argument is `null`.

## Exercise 3

Extend the code of `Hand` to make is possible to compare two `Hand` objects using the `Comparator` interface. Implement two different hand comparison strategies, by increasing or decreasing number of cards in the hand. Define *static factory methods* in the `Hand` class to return anonymous instances of comparators for the different comparison strategies. You do not need to handle the case where the argument is `null`.

## Exercise 4

Draw a class diagram that represents the design of `Hand` realized as part of Exercises 1-3.

## Exercise 5

Add a static factory method to class `Hand` that takes an `Rank` as parameter and returns an instance of a class that can compare hands in increasing number of cards of that rank in the hand. Clients should use this method to compare hands by number of aces, or number kings, or number of fours, etc. For example, if the client chooses to compare hands by number of aces, a hand with one ace should come before a hand with two aces. If two hands have the same number of aces, they should be considered equal and their order does not matter. 

## Exercise 6

Implement a `UniversalComparator` that stores the type of desired comparison from Exercise 3 as an enumerated type, and switches on that type. Note that this will require you to add a `size()` method to the interface of class `Hand`.

## Exercise 7

Extend the design of `Hand` so that instances of `Hand` can be iterated over through the services declared in the `Iterable` interface.

## Exercise 8

Draw a class diagram that illustrates how a `Hand` supports being iterated over. You can omit modeling the comparison behavior.

## Exercise 9 :star: 

Modify your `Hand` class to support a poker game and compare hands in terms of their strengths as [poker hands](https://en.wikipedia.org/wiki/List_of_poker_hands). How should you deal with hands that do not have exactly five cards? 

*Hint: You can start by solving a less challenging variant of this problem by considering the following two simplifications. Once you have a working solution, trying improving it to remove the simplifications.*

* *Only consider ace-low straights. So `Ace, Two, Three, Four, Five` is a straight, but `..., Queen, King, Ace` is not. This will allow you to use the current ordering of `Rank` directly.*
* *Make the comparison based on only the poker hand type, without using the card value for tie-breaking. So, for example, two hands that are three-of-a-kind are considered equal, despite they being of a different rank.*

## Exercise 10

Enhance class `Hand` so that it is kept in *sorted order* using a parameterizable sorting order. Use the Strategy pattern to allow clients to specify how cards should be sorted. The cards in the hand should be sorted according to the required order at all times.

## Exercise 11

Following the Interface Segregation Principle, decompose the interface of class `Hand` so that clients only interested in checking the state of a hand (including iterating over its cards) can use a different interface from clients interested in modifying the hand. Create a UML class diagram of the design first, then code the solution.

## Exercise 12 :mag:

Review the code of class `Foundations` in the Solitaire application and create a class diagram that captures the main design decisions for this class.

---
<a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" /></a>

Unless otherwise noted, the content of this repository is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a>. 

Copyright Martin P. Robillard 2019
