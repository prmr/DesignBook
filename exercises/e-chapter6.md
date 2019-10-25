# Chapter 6 Practice Exercises

## Exercise 1

Consider interface [Show](../solutions-code/chapter6/Show.java) and the two implementing classes [Movie](../solutions-code/chapter6/Movie.java) and [Concert](../solutions-code/chapter6/Concert.java). Apply the Composite design pattern to provide support for a kind of show that is a combination of between two and five shows, inclusively. Write a client program that creates a show that consists of a concert followed by two movies, where the two movied are, together, represented by a single `Show` object.

## Exercise 2

Extend the design produced in Exercise 1 to apply the Decorator design pattern so as to provide a `IntroducedShow` feature, which consists of a show introduced by a speaker giving a fixed-time speech (e.g., 10 minutes). In client code, create a `Show` object that is an introduced version of the show created in Exercise 1, where the second movie is also introduced (so, two speakers, one presenting the entire show, and one presenting the second movie).

## Exercise 3

Draw a class diagram of your combined design for exercises 1 and 2.

## Exercise 4

Draw an object diagram of the object graph created as part of exercise 2.

## Exercise 5

Draw a sequence diagram that illustrates the sequence of method calls that results from a call to `description` on the root `Show`.

## Exercise 6

Change the code of [HandDealer.java](../solutions-code/chapter6/HandDealer.java) so that it shows a hand of 13 cards, which each card overlaid on another, as in the figure below. Once the user clicks the button, the cards should be flipped so that they are face-side up. Every subsequent button click should reveal a new, random, hand, also face-side up. Use the Composite and Decorator patterns applied to the `Icon` interface to solve the problem.

![](HandDealer.png)

---
<a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" /></a>

Unless otherwise noted, the content of this repository is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a>. 

Copyright Martin P. Robillard 2019
