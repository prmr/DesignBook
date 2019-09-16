# Chapter 4 Practice Exercises

## Exercise 1

Considering the version of class [Card](../chapter-code/chapter3/Card.java) seen in Chapter 3. How many concrete states form the life cycle of objects of the class?

## Exercise 2

Does it make sense to model the abstract state space of a Java interface? Why or why not?

## Exercise 3

Create a UML State Diagram that models the abstract states of a hypothetical `Dryer` object that behaves as follows:

> The dryer is normally off. To get it to operate you have to put in a laundry token. Once the token is inserted, you cannot add additional credit until the drying is over. To start the machine once the token is inserted, you have to close the door and press the start button. The dryer will then operate for exactly 60 minutes, and then stop by itself. If you open the door while it is in operation, the dryer will stop and whatever time was left is lost.

## Exercise 4

Create a UML State Diagram that models the abstract states of a hypothetical `VendingMachine` object that behaves as follows. 

> The machine sells a selection of different drinks. All drinks have a price, not necessarily the same. If a user selects a drink, the price is displayed. If the user adds enough coins within 60 seconds, the drink is provided and change is returned. If a user adds coins without selecting a drink, the available balance is shown. If a user selects a drink that is worth less than the balance, the drink is provided and change is returned. If not, an error message shows "insufficient balance". A reset button resets any selection and returns the balance.

## Exercise 5

Change the version of class [Card](../chapter-code/chapter3/Card.java) seen in Chapter 3 to support a "white" and a "black" joker. Use optional types to return the rank and suit of cards. When compared with other cards, the white joker should come after any card except the black joker, and the black joker should come after any cards including the other joker. Modify the [Deck](../chapter-code/chapter3/Deck.java) class to include the two jokers in the shuffle.


---
<a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" /></a>

Unless otherwise noted, the content of this repository is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a>. 

Copyright Martin P. Robillard 2019
