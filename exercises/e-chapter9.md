# Chapter 9 Practice Exercises

## Exercise 1

Consider a list of [movies](../solutions-code/chapter9/Movies.java). Write code to create a new `ArrayList` of all the movies, then use method `removeIf` of `ArrayList` to remove all movies produced before 1960. First, use an anonymous class as the explicit argument to `removeIf`. Once this work, replace the anonymous class with a lambda expression written as a block of statements, and with type parameter. Finally, transform your lambda expression once again so that it is defined as an expression, has no type parameter or parentheses.

## Exercise 2

Add a method `isOld(): boolean` to class `Movie`, and use a reference to this method in the code of Exercise 1.

## Exercise 3

Use the method `Iterable.forEach` to print the description of all [movies](../solutions-code/chapter9/Movies.java) to `System.out`. First, use an anonymous class. Then, write a lamda expression. Then, write a static method `print(Movie): void` that encapsulates the printing behavior, and use this method in the lambda expression. Then, replace the lambda expression with a method reference. Finally, notice that method `println` has a type signature that is applicable to the argument of `forEach`. Use the reference `System.out::println` in the final version of the exercise.

## Exercise 4

Use method `Collections.sort` to sort the [movies](../solutions-code/chapter9/Movies.java) by running time, using a lambda expression to define the required comparator. Move this lambda expression to a static factory method `static createByTimeComparator(): Comparator<Show>` and call this method as a second argument to `sort`. Notice how this code compiles even though the type argument of the collection (`Movie`) and the type argument of the comparator (`Show`) don't match exactly. 

## Exercise 5

Transform the static comparator factory from Exercise 5 into a simple static method declaration `compare(Show, Show):int`. Then, change the code of Exercise 4 to use this method implementation instead.

## Exercise 6

Use the methods of class `Comparator` to create a comparator that compares movies by running time, then by title.


---
<a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" /></a>

Unless otherwise noted, the content of this repository is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a>. 

Copyright Martin P. Robillard 2019
