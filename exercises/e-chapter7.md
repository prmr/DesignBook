# Chapter 7 Practice Exercises

## Exercise 1

Consider the [Show](../solutions-code/chapter7/Show.java) interface and the two implementing classes [Movie](../solutions-code/chapter7/Movie.java) and [Concert](../solutions-code/chapter7/Concert.java). Create a class `SponsoredConcert` that is a subtype of `Concert` with two additional pieces of data: a sponsor name (`String`) and a sponsor time (`int`) that represents the number of minutes the sponsor is allocated to advertise as part of the show. A call to `description()` on an instance of `SponsoredConcert` should include the title and performer of the concert, along with the name of the sponsor. A call to `time()` on an instance of `SponsoredConcert` should return the time of the concert plus the time allocated to the sponsor. 

## Exercise 2

Change the code of `Concert` so that the field `aPerformer` is `private`. What are possible solutions for accessing this information?

## Exercise 3

Create an abstract class `AbstractShow` that groups all the fields that `Concert` and `Movie` have in common. Refactor your class hierarchy to use this abstract class with as tight encapsulation as possible.

## Exercise 4

Draw a class diagram of the refactored design completed in Exercise 3, then extend the diagram to show how `CompositeShow` (a composite) and `IntroducedShow` (a decorator) would integrate the design.

## Exercise 5

We want to ensure that calling method `description()` on an instance of any type of `Show` returns a string with the following format:

```
$TITLE$ [...] ($TIME$ minutes)
```

where `$TITLE` is a placeholder for the title of the show, and `$TIME` is a placeholder for the total running time of the show. Implement this functionality by applying the Template Method design pattern.

## Exercise 6

Draw a UML sequence diagram that model the sequence of calls that results from an invocation of method `description` on an instance of `SponsoredConcert`. To clarify which implementation of a method is used, name the call using the convention `Class#Method`, so that for example a call to method `time()` of class `SponsoredConcert` would be labeled as `SponsoredConcert#time()`.

## Exercise 7

Consider the class `AbstractShow` created as part of Exercise 3. Add a method `setTitle(String)` in `AbstractShow` to set the title of the show. Because the title of a movie does not change after the movie is released, override `setTitle` to throw an [UnsupportedOperationException](https://docs.oracle.com/javase/8/docs/api/java/lang/UnsupportedOperationException.html). Similarly, implement a method `setTime` in `AbstractShow` with an input precondition of `> 0`, and override this method in `Movie` to have the precondition `> 10`. Does class `Movie` respect the Liskov Substitution Principle? Support your answer with a piece of demonstration client code.

## Exercise 8

Assume class `AbstractShow` provides a method `setTime(int minutes)`. Add an additional method `setTime(int hours, int minutes)` that sets the time of the show as `hours * 60 + minutes`. Is this a case of overloading or overriding? Now remove the implementation of `setTime(int hours, int minutes)` and add it to class `Movie` instead. Is this a case of overloading or overriding? Does it make a difference whether we place this method in `AbstractShow` or `Movie`?

## Exercise 9

We wish to add a *recommendation* feature to our `Show` type hierarchy, where `Show` instances can hold a reference to a "recommended" show (if a person likes a given show). For this purpose, add a field `Show aRecommended` to class `AbstractShow`, together with public methods `Show setRecommended(Show)` and `Show getRecommended()`. For movies, we wish to constrain recommendations to movies only, so that movies can only hold recommendations to other movies. Override methods `setRecommended` and `getRecommended` in class `Movie` to only take `Movie` as parameter and return `Movie`, respectively. Does this design respect the Liskov Substitution Principle? Support your answer with a piece of demonstration client code.

## Exercise 10

Make the `Show` class hierarchy `Cloneable` so that it is possible to clone instances of `Concert`, `Movie`, or `SponsoredConcert`.

---
<a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" /></a>

Unless otherwise noted, the content of this repository is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a>. 

Copyright Martin P. Robillard 2019
