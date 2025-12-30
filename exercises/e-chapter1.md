# Chapter 1 Practice Exercises

These exercises are designed to help you explore the impact of design decisions by implementing different variants of the [TwelveDays](../chapter-code-2ndEdition/chapter1/TwelveDays.java) program. Exercises 1 to 3 can be completed without the use of any additional library classes and I recommend tackling them without using other classes to focus on the impact of design decisions as opposed to learning libraries. The solutions provide tips on relevant library classes.

## Exercise 1

Rewrite [TwelveDays](../chapter-code-2ndEdition/chapter1/TwelveDays.java) in an iterative style, as opposed to recursive. What is the impact of this change on the design? Does this change move the solution in the design space? If so, how?

[_Solution_](https://codesample.info/samples/designbook/solutions1/Exercise01.html)

## Exercise 2

Change [TwelveDays](../chapter-code-2ndEdition/chapter1/TwelveDays.java) so that it is possible to choose between displaying the number of the days written out (for example "third" day), as in the original version, or using digits (for example "3rd day"). If the user includes the command-line argument `digit`, the program should use digits (remember that command-line arguments are provided to the `main` method). Otherwise, the original, written-out form should be used. Implement this requirement using a global variable, then rewrite the code to avoid using any global variable. What is the impact of your solutions on the quality attributes of the design?

[_Solution_](https://codesample.info/samples/designbook/solutions1/Exercise02.html)

## Exercise 3

Building on your solution to Exercise 2, add a new option to control the capitalization of the gifts. The valid command-line arguments are `digits` and `lower`. Any other command-line argument should be ignored. Decide whether to use static variables or not based on your experience with Exercise 2. Try implementing the solution without using any library class except `String`.

* `digits` -> "On the 1st day... a Partridge in a Pear Tree"
* `digits lower` -> "On the 1st day... a partridge in a pear tree"
* `lower foo digits`  -> "On the 1st day... a partridge in a pear tree"
* `lower` -> "On the first day... a partridge in a pear tree"
* ` ` -> "On the first day... a Partridge in a Pear Tree"

[_Solution_](https://codesample.info/samples/designbook/solutions1/Exercise03.html)

## Exercise 4 ⭐

Modify the code of [TwelveDays](../chapter-code-2ndEdition/chapter1/TwelveDays.java) so that all the strings are _externalized_ in a properties file. Externalizing strings allows you to [localize](https://en.wikipedia.org/wiki/Language_localisation) the program, for example by having versions in different languages. For this project you will need to learn how to use class [ResourceBundle](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/ResourceBundle.html).

[_Solution_](https://codesample.info/samples/designbook/solutions1/Exercise04.html)

---
<a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" /></a>

Unless otherwise noted, the content of this repository is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a>. 

Copyright Martin P. Robillard 2019-2025