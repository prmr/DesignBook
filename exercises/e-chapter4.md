# Chapter 4 Practice Exercises

## Exercise 1

Create a UML State Diagram that models the abstract states of a hypothetical `Dryer` object that behaves as follows:

> The dryer is normally off. To get it to operate you have to put in a laundry token. Once the token is inserted, you cannot add additional credit until the drying is over. To start the machine once the token is inserted, you have to close the door and press the start button. The dryer will then operate for exactly 60 minutes, and then stop by itself. If you open the door while it is in operation, the dryer will stop and whatever time was left is lost.

[_Solution (and more)_](https://codesample.info/samples/designbook/solutions4/Exercise01.html)

## Exercise 2

Create a UML State Diagram that models the abstract states of a hypothetical `VendingMachine` object that behaves as follows. 

> The machine sells a selection of different drinks. All drinks have a price, not necessarily the same. If a user selects a drink, the price is displayed. If the user adds enough coins within 60 seconds, the drink is provided and change is returned. If a user adds coins without selecting a drink, the available balance is shown. If a user selects a drink that is worth less than the balance, the drink is provided and change is returned. If not, an error message shows "insufficient balance". A reset button resets any selection and returns the balance.

[_Solution (and more)_](https://codesample.info/samples/designbook/solutions4/Exercise02.html)

## Exercise 3

Change the version of class [Card](../code-e3/e3/chapter3/Card.java) seen in Chapter 3 to support a "white" and a "black" joker. Use optional types to return the rank and suit of cards. When compared with other cards, the white joker should come after any card except the black joker, and the black joker should come after any cards including the other joker. Modify the [Deck](../code-e3/e3/chapter3/Deck.java) class to include the two jokers in the shuffle.

[_Solution (and more)_](https://codesample.info/samples/designbook/solutions4/Exercise03.html)

## Exercise 4

In a given context we need a comparator for cards:

```java
public class Game {
   private Comparator<Card> aComparator;
}
```

When class `Game` is initialized, the comparison order is not determined. However, we do not wish to assign `null` to `aComparator` to help prevent bugs. Design a solution that does not change the type of the field.

[_Solution (and more)_](https://codesample.info/samples/designbook/solutions4/Exercise04.html)

## Exercise 5

In a given design context simulated by some stub method `performShuffle`, we need objects that can be shuffled, but where shufflable objects can also be absent. Using interfaces, design a type hierarchy where the client code only requires a method `shuffle()` from some other object. In addition, use the Null Object pattern to support the situation where shufflable objects can be null. Consider that the following code is the design context:

```java
public static void performShuffle(SOME_TYPE pSomeArgument) {
    if ( /* pSomeArgument is not absent */ ) {
       pSomeArgument.shuffle();
    }
} 
```

[_Solution (and more)_](https://codesample.info/samples/designbook/solutions4/Exercise05.html)

## Exercise 6

Change Chapter 3's version of class [Card](../code-e3/e3/chapter3/Card.java) so that it is possible to test if two cards are equal. Two cards are equal if they have the same rank and suit. Test that your code works by attempting to add two equal cards to the same `HashSet<Card>`.

[_Solution (and more)_](https://codesample.info/samples/designbook/solutions4/Exercise06.html)

## Exercise 7

Change Chapter 3's version of class [Card](../code-e3/e3/chapter3/Card.java) to ensure the uniqueness of its instances through the use of the Flyweight Design Pattern using a pre-initialization strategy and using a `Map` to store flyweights.

[_Solution (and more)_](https://codesample.info/samples/designbook/solutions4/Exercise07.html)

## Exercise 8

Change the code written in Exercise 9 so that card flyweights are lazily created. Using [System.currentTimeMillis()](https://docs.oracle.com/javase/8/docs/api/java/lang/System.html#currentTimeMillis--), compare the time needed to obtain all 52 cards for both approaches. What do you conclude?

[_Solution (and more)_](https://codesample.info/samples/designbook/solutions4/Exercise08.html)

## Exercise 9

Using the Singleton Design Pattern, design a `GameModel` class that is a Singleton. The class should have a single instance variable of type `Deck` and initialize the deck whenever a `newGame()` method is called. The class can remain a stub, meaning that it does not need to do anything else.

[_Solution (and more)_](https://codesample.info/samples/designbook/solutions4/Exercise09.html)

---
<a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" /></a>

Unless otherwise noted, the content of this repository is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a>. 

Copyright Martin P. Robillard 2026