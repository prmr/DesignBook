# Chapter 8 Practice Exercises

## Exercise 1

Consider the following implementation of class [`Deck`](../chapter-code/chapter2/Deck.java). Apply the Observer design pattern to make the class *observable*. Assume we have two types of concrete observers: a `DrawLogger` with prints out a description of any card drawn, and a `SizeStatus` observer that prints out the size of the deck whenever it changes. Design and implement all required classes and interfaces, and write a small piece of client code to demonstrate the operation of the pattern. Use the push data-flow strategy. The concrete observers can be implemented as simple `println` statements.

## Exercise 2

Change the design of your observable `Deck` from exercise 1 to use the pull data-flow strategy, using the interface segregation principle to strengthen the constraint that the observers should not change the state of the `Deck` object.


## Exercise 3

Change the design of your observable `Deck` from exercise 1 so that all the observer-supporting code is in a *superclass* of deck. What are the advantages and disadvantages of this decision?

## Exercise 4

Change the design of your observable `Deck` from exercise 1 so that all the observer-supporting code is in a *subclass* of deck. What are the advantages and disadvantages of this decision?

## Exercise 5

Model the solution produced in exercise 4 with a class diagram, object diagram, and sequence diagram that illustrates a call initiated by calling `draw` on an `ObservableDeck` object.

## Exercise 6

Apply the Observer design pattern to make it possible to observe class [Program](../solutions-code/chapter6/Program.java) from exercise 6.14. Use the push data-flow strategy and a single observer interface. Create a dummy concrete observer class to test the application of the pattern.

## Exercise 7

Change the design produced in Exercise 6 to use the pull data-flow strategy and a two different observer interfaces, one for addition events, and one for clearing and removing shows from the program. Use the interface segregation principle to ensure observers do not reference methods that can change the state of the subject.

## Exercise 8

Extend the [LuckyNumber](../chapter-code/chapter8/LuckyNumber.java) JavaFX application to support an additional panel that shows the number in Roman numerals. For an extra challenge, parameterize the text panel so that it is possible to use a single class to create different representations of the number.

## Exercise 9

Extend the [UserInterface](../solutions-code/chapter8/UserInterface.java) skeleton JavaFX program to create a GUI with a single [Label](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Label.html) and a single [Button](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Button.html), where the label shows the current date and time, and gets updated every time the button is clicked. Try to create the solution by using only the API documentation, without looking at sample code. You will also need a [Pane](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/Pane.html) (consider using a subclass). For a quick solution to obtain the current time, you can use `LocalDateTime.now().toString()`.

## Exercise 10

Extend the [UserInterface](../solutions-code/chapter8/UserInterface.java) skeleton JavaFX program to create a GUI with two [TextField](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TextField.html) instances and a single [Button](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Button.html), where any text in the two text fields is swapped when the button is clicked. Organize the logical arrangement of the GUI components so that both text fields are in one parent, and the button is a child of the root.

## Exercise 11

Extend Exercise 10 to embed the node that contains the textfields in a [ScrollPane](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ScrollPane.html). Draw an object diagram that shows your component graph. What design patterns are being applied in this design? Add the event handler to your object diagram.

## Exercise 12

Consider the sample class [Node](../solutions-code/chapter8/Node.java) class hierarchy to support a file system. Apply the Visitor pattern to support the traversal of object graphs created from this class hierarchy. Implement the traversal code in the `Node` hierarchy, then write client code to try out your visitor support. Write a `PrintVisitor` to pretty-print all the nodes in a sample file tree. Try indenting the names of the nodes based on their depth in the tree. Draw a sequence diagram for the visit of a directory with one file and one symbolic link.

## Exercise 13

Change the design of Exercise 12 to include an `AbstractVisitor` class. Move the traversal code to this class, and change your `PrintVisitor` so it extends `AbstractVisitor`. Draw a sequence diagram for the visit of a directory with one file and one symbolic link, and make sure to see the difference with the diagram created as part of exercise 12.

---
<a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" /></a>

Unless otherwise noted, the content of this repository is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a>. 

Copyright Martin P. Robillard 2019
