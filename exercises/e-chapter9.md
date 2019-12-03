# Chapter 9 Practice Exercises

## Exercise 1

Consider a list of [movies](../solutions-code/chapter9/Movies.java). Write code to create a new `ArrayList` of all the movies, then use method `removeIf` of `ArrayList` to remove all movies produced before 1960. First, use an anonymous class as the explicit argument to `removeIf`. Once this work, replace the anonymous class with a lambda expression written as a block of statements, and with type parameter. Finally, transform your lambda expression once again so that it is defined as an expression, has no type parameter or parentheses.

## Exercise 2

Add a method `isOld(): boolean` to class `Movie`, and use a reference to this method in the code of Exercise 1.

## Exercise 3

Use the method `Iterable.forEach` to print the description of all [movies](../solutions-code/chapter9/Movies.java) to `System.out`. First, use an anonymous class. Then, write a lamda expression. Then, write a static method `print(Movie): void` that encapsulates the printing behavior, and use this method in the lambda expression. Then, replace the lambda expression with a method reference. Finally, notice that method `println` has a type signature that is applicable to the argument of `forEach`. Use the reference `System.out::println` in the final version of the exercise.

## Exercise 4

Use method [`List.sort`](https://docs.oracle.com/javase/8/docs/api/java/util/List.html#sort-java.util.Comparator-) to sort the [movies](../solutions-code/chapter9/Movies.java) in order of increasing running time, using a lambda expression to define the required comparator. Move this lambda expression to a static factory method `static createByTimeComparator(): Comparator<Show>` and call this method as the argument to `sort`. Notice how this code compiles even though the type argument of the collection (`Movie`) and the type argument of the comparator (`Show`) don't match exactly. 

## Exercise 5

Transform the static comparator factory from Exercise 5 into a simple static method declaration `compareByTime(Show, Show):int`. Then, change the code of Exercise 4 to use this method implementation instead.

## Exercise 6

Use the methods of class `Comparator` to create a comparator that compares movies by running time, then by title.

## Exercise 7

Turn class `Movie` into a Flyweight class with lazily-instantiated flyweights where the flyweight store is a `Map<String, Movie>` and the key is the title (assumed to be unique for this exercise). Use `Map.computeIfAbsent` with a lambda expression in the implementation of your flyweight object accessor method.

## Exercise 8

Write a stream-based expression that prints the running time of all movies in the database in the format: ``HH:mm` (hours, minutes). Except for the terminal operation, use only mapping operations and method references. You can define helper methods as necessary.

## Exercise 9

Write a stream-based expression that evaluates to a list that contains the three longest movies from before the year 2000, in reverse alphabetical order of title.

## Exercise 10

Use a IntStream-based expression to compute the minimum, maximum, average, and sum of a sequence of one million integers between 0 and 100 (inclusive). Do the same with `double` numbers (in which case `1.0` can be exclusive.

## Exercise 11

Use a flatMap operation to count the number of times the word "the" occurs in the title of any movie (ignore case).

## Exercise 12

Use a single reduce operation to obtain the longest movie in the collection.

## Exercise 13

Write a stream-based expression to create a `Map<String, Integer>` where the key is the title of the movie and the value is its running time. Assume movie titles are unique.

## Exercise 14

Write a stream-based expression to create a map that group movies by decade. For example, all the movies produced in the years 1950-1959 should be accessible using the key `50s`, etc.

## Exercise 15

Using the map created in Exercise 14, write a stream-based expression that evaluates to a list of all the movies from the 50s and 60s.


---
<a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" /></a>

Unless otherwise noted, the content of this repository is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a>. 

Copyright Martin P. Robillard 2019
