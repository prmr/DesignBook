# Chapter 5 Practice Exercises

## Exercise 1

Write JUnit 5 unit tests for [Math.min(int, int)](https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#min-int-int-).

## Exercise 2

Write JUnit 5 unit test for [Math.cos(double)](https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#cos-double-).

## Exercise 3

Write JUnit 5 unit tests for [String.concat(String)](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#concat-java.lang.String-)

## Exercise 4

Assume a class `Sentence` implements class `Iterable<String>`. Draw an object diagram that shows the relation between the instances of class `Class` that represent `Sentence`, `Iterable`, `Iterator`, and `String`. Assume that all methods of class `Class` that provide information about the class are getters for fields of the same name (e.g., there is a field `interfaces` that matches method `getInterfaces()`). Only use simple names for classes. Use the reflection API documentation and/or a debugger for help if necessary.

## Exercise 5

Using metaprogramming, write a program that takes two command-line arguments: the short name of a subtype of [Number](https://docs.oracle.com/javase/8/docs/api/java/lang/Number.html) and a number literal, and that creates a new instance of that type that represents the number. For example, `Integer` `5` to represent 5 as an integer, or `Double` `5.1` to represent 5.1 as a double.

## Exercise 6

Using metaprogramming, verify whether it is possible to call any parameterless method of class `String` on an empty string without raising an exception.

## Exercise 7

Write unit test for methods `push` and `pop` of class [Stack](https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html). Use a fixture that you initialize before every test, and make sure your tests cover documented exceptional behavior.

## Exercise 8

Class [PokerHand](../solutions-code/chapter5/PokerHand.java) is a partial solution to [exercise 3.9](e-chapter3.md). Write a test class `TestPokerHand` with helper methods than make it possible to test the private method `isStraightFlush`, then write a test case for which the output is `true`. For this method, how many executions of the UUT do we need to test it with *all possible straight flushes*? Does this mean we can achieve exhaustive test coverage with these test cases?

## Exercise 9

Extend your test suite for [PokerHand](../solutions-code/chapter5/PokerHand.java) to achieve *complete statement coverage* with a minimum number of executions of the UUT.

## Exercise 10

Extend your test suite for [PokerHand](../solutions-code/chapter5/PokerHand.java) to achieve *complete branch coverage* with a minimum number of executions of the UUT.

## Exercise 11

Write a test suite for all the public methods of class [BiCardSource](../solutions-code/chapter5/BiCardSource.java) to achieve 100% branch coverage, using stubs to helps isolate the behavior to test.

---
<a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" /></a>

Unless otherwise noted, the content of this repository is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a>. 

Copyright Martin P. Robillard 2019
