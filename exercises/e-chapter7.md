# Chapter 7 Practice Exercises

## Exercise 1

Consider the [Show](../solutions-code/chapter7/Show.java) interface and the two implementing classes [Movie](../solutions-code/chapter7/Movie.java) and [Concert](../solutions-code/chapter7/Concert.java). Create a class `SponsoredConcert` that is a subtype of `Concert` with two additional pieces of data: a sponsor name (`String`) and a sponsor time (`int`) that represents the number of minutes the sponsor is allocated to advertise as part of the show. A call to `description()` on an instance of `SponsoredConcert` should include the title and performer of the concert, along with the name of the sponsor. A call to `time()` on an instance of `SponsoredConcert` should return the time of the concert plus the time allocated to the sponsor. 

# Exercise 2

Change the code of `Concert` so that the field `aPerformer` is `private`. What are possible solutions for accessing this information?

# Exercise 3

Create an abstract class `AbstractShow` that groups all the fields that `Concert` and `Movie` have in common. Refactor your class hierarchy to use this abstract class with as tight encapsulation as possible.

# Exercise 4

Draw a class diagram of the refactored design completed in Exercise 3, then extend the diagram to how `CompositeShow` (a composite) and `IntroducedShow` (a decorator) would integrate the design.

# Exercise 5

We want to ensure that calling method `description()` on an instance of any type of `Show` returns a string with the following format:

```
$TITLE$ [...] ($TIME$ minutes)
```

where `$TITLE` is a placeholder for the title of the show, and `$TIME` is a placeholder for the total running time of the show. Implement this functionality by applying the Template Method design pattern.

# Exercise 6

Draw a UML sequence diagram that model the sequence of calls that results from an invocation of method `description` on an instance of `SponsoredConcert`. To clarify which implementation of a method is used, name the call using the convention `Class#Method`, so that for example a call to method `time()` of class `SponsoredConcert` would be labeled as `SponsoredConcert#time()`.


---
<a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" /></a>

Unless otherwise noted, the content of this repository is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a>. 

Copyright Martin P. Robillard 2019
