# Chapter 8 Practice Exercises

## Exercise 1

Consider the following implementation of class [`Deck`](../code-e3/e3/chapter2/Deck.java). Apply the Observer design pattern to make the class *observable*. Assume we have two types of concrete observers: a `DrawLogger` with prints out a description of any card drawn, and a `SizeStatus` observer that prints out the size of the deck whenever it changes. Design and implement all required classes and interfaces, and write a small piece of client code to demonstrate the operation of the pattern. Use the push data-flow strategy. The concrete observers can be implemented as simple `println` statements.

[_Solution (and more)_](https://codesample.info/samples/designbook/solutions8/Exercise01.html)

## Exercise 2

Change the design of your observable `Deck` from exercise 1 to use the pull data-flow strategy, using the interface segregation principle to strengthen the constraint that the observers should not change the state of the `Deck` object.

[_Solution (and more)_](https://codesample.info/samples/designbook/solutions8/Exercise02.html)

## Exercise 3

Change the design of your observable `Deck` from exercise 1 so that all the observer-supporting code is in a *superclass* of deck. What are the advantages and disadvantages of this decision?

[_Solution (and more)_](https://codesample.info/samples/designbook/solutions8/Exercise03.html)

## Exercise 4

Change the design of your observable `Deck` from exercise 1 so that all the observer-supporting code is in a *subclass* of deck. What are the advantages and disadvantages of this decision?

[_Solution (and more)_](https://codesample.info/samples/designbook/solutions8/Exercise04.html)

## Exercise 5

Model the solution produced in exercise 4 with a class diagram, object diagram, and sequence diagram that illustrates a call initiated by calling `draw` on an `ObservableDeck` object.

[_Solution (and more)_](https://codesample.info/samples/designbook/solutions8/Exercise05.html)

## Exercise 6

Apply the Observer design pattern to make it possible to observe class from [Exercise 6.13](https://codesample.info/samples/designbook/solutions6/Exercise13.html). Use the push data-flow strategy and a single observer interface. Create a dummy concrete observer class to test the application of the pattern.

[_Solution (and more)_](https://codesample.info/samples/designbook/solutions8/Exercise06.html)

## Exercise 7

Change the design produced in Exercise 6 to use the pull data-flow strategy and a two different observer interfaces, one for addition events, and one for clearing and removing shows from the program. Use the interface segregation principle to ensure observers do not reference methods that can change the state of the subject.

[_Solution (and more)_](https://codesample.info/samples/designbook/solutions8/Exercise07.html)

## Exercise 8

Extend the [LuckyNumber](../code-e3/e3/chapter8/LuckyNumber.java) JavaFX application to support an additional panel that shows the number in Roman numerals. For an extra challenge, parameterize the text panel so that it is possible to use a single class to create different representations of the number.

[_Solution (and more)_](https://codesample.info/samples/designbook/solutions8/Exercise08.html)

## Exercise 9

Extend the [UserInterface](../exercise-code/chapter8/UserInterface.java) skeleton JavaFX program to create a GUI with a single [Label](https://docs.oracle.com/en/java/java-components/javafx/25/docs/javafx.controls/javafx/scene/control/Label.html) and a single [Button](https://docs.oracle.com/en/java/java-components/javafx/25/docs/javafx.controls/javafx/scene/control/Button.html), where the label shows the current date and time, and gets updated every time the button is clicked. Try to create the solution by using only the API documentation, without looking at sample code. You will also need a [Pane](https://docs.oracle.com/en/java/java-components/javafx/25/docs/javafx.graphics/javafx/scene/layout/Pane.html) (consider using a subclass). For a quick solution to obtain the current time, you can use `LocalDateTime.now().toString()`.

[_Solution (and more)_](https://codesample.info/samples/designbook/solutions8/Exercise09.html)

## Exercise 10

Extend the [UserInterface](../exercise-code/chapter8/UserInterface.java) skeleton JavaFX program to create a GUI with two [TextField](https://docs.oracle.com/en/java/java-components/javafx/25/docs/javafx.controls/javafx/scene/control/TextField.html) instances and a single [Button](https://docs.oracle.com/en/java/java-components/javafx/25/docs/javafx.controls/javafx/scene/control/Button.html), where any text in the two text fields is swapped when the button is clicked. Organize the logical arrangement of the GUI components so that both text fields are in one parent, and the button is a child of the root.

[_Solution (and more)_](https://codesample.info/samples/designbook/solutions8/Exercise10.html)

## Exercise 11

Extend Exercise 10 to embed the node that contains the textfields in a [ScrollPane](https://docs.oracle.com/en/java/java-components/javafx/25/docs/javafx.controls/javafx/scene/control/ScrollPane.html). Draw an object diagram that shows your component graph. What design patterns are being applied in this design? Add the event handler to your object diagram.

[_Solution (and more)_](https://codesample.info/samples/designbook/solutions8/Exercise11.html)

## Exercise 12

Consider the sample class [Node](../exercise-code/chapter8/Node.java) class hierarchy to support a file system. Apply the Visitor pattern to support the traversal of object graphs created from this class hierarchy. Implement the traversal code in the `Node` hierarchy, then write client code to try out your visitor support. Write a `PrintVisitor` to pretty-print all the nodes in a sample file tree. Try indenting the names of the nodes based on their depth in the tree. Draw a sequence diagram for the visit of a directory with one file and one symbolic link.

[_Solution (and more)_](https://codesample.info/samples/designbook/solutions8/Exercise12.html)

## Exercise 13

Change the design of Exercise 12 to include an `AbstractVisitor` class. Move the traversal code to this class, and change your `PrintVisitor` so it extends `AbstractVisitor`. Draw a sequence diagram for the visit of a directory with one file and one symbolic link, and make sure to see the difference with the diagram created as part of exercise 12.

[_Solution (and more)_](https://codesample.info/samples/designbook/solutions8/Exercise13.html)

---
<a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" /></a>

Unless otherwise noted, the content of this repository is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a>. 

Copyright Martin P. Robillard 2019-2026