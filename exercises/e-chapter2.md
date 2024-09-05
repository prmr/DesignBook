# Chapter 2 Practice Exercises

## Exercise 1

Why is it technically possible to represent a playing card using six Boolean values (as mentioned on page 15)? Rewrite class [`Card`](../chapter-code-2ndEdition/e2/chapter2/Card.java) so that it is internally represented as six Boolean values. What is the impact of this change of the maintainers of class `Card`? What is the impact of this change on the users of class `Card`?

## Exercise 2

Re-implement class `Card` as a single enumerated type. For the purpose of the Solitaire application, does this look like a superior or inferior solution to [this version](../chapter-code-2ndEdition/e2/chapter2/Card.java)? Why? Try writing down your answer in specific terms using terminology seen in Chapter 2.

## Exercise 3

Modify the [`Suit`](../chapter-code-2ndEdition/e2/chapter2/Suit.java) enumerated type to include a method `color()` that returns the color of the suit. The return type should be a new enumerated type `Color`.

## Exercise 4

Add a method to class [`Card`](../chapter-code-2ndEdition/e2/chapter2/Card.java) that returns the next card in a circular sequence defined by the order of ranks and suits. For example, the card that follows the Two of Clubs is the Three of Clubs, and the card that follows the King of Hearts is the Ace of Clubs.

## Exercise 5

Modify class [`Card`](../chapter-code-2ndEdition/e2/chapter2/Card.java) to support the concept of a "Joker" (a special card that is not in any suit) while keeping the class as encapsulated as possible.

## Exercise 6 

Further modify your class to support any number of distinct jokers. For example, a "high" joker vs. a "low" joker, or even three jokers, etc. Again, try to keep things encapsulated and respectful of the class design guidelines seen in the chapter.

## Problem 7

Find a different way to implement method `getCards()` to the [`Deck`](../chapter-code-2ndEdition/e2/chapter2/Deck.java) class to return the cards in the deck without breaking encapsulation.

## Exercise 8

Create a new class called `MultiDeck` that contains a list of decks (some card games require multiple decks). Make the class copyable through a copy constructor. First, make a shallow copy of the decks contained. Use the debugger to confirm that the decks in a multi-deck are shared between an original multi-deck and its copies. Then, use deep copying to make copied multi-decks fully distinct object graphs. Use design by contract and the `assert` statement to clarify the class's interface.

## Exercise 9

Create a UML Object Diagram of a `MultiDeck` instance.

## Exercise 10

Improve the code of [TwelveDays](../chapter-code/chapter1/TwelveDays.java) to take advantage of enumerated types. 

_Hint 1: Remember that you can define fields and methods in enumerated types._

_Hint 2: Try implementing your solution using [`StringJoiner`](https://docs.oracle.com/en/java/javase/21/docs//api/java.base/java/util/StringJoiner.html)._ 

## Exercise 11 :mag:

Study an old version of JetUML's [MultiLineString](https://github.com/prmr/JetUML/blob/v1.0/src/ca/mcgill/cs/stg/jetuml/framework/MultiLineString.java) class and assess the quality of its encapsulation. Is it possible to modify its state without going through its methods?

---
<a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" /></a>

Unless otherwise noted, the content of this repository is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a>. 

Copyright Martin P. Robillard 2019-2024
