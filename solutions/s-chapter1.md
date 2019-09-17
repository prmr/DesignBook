# Chapter 1 Solutions to Practice Exercises

## Exercise 1

The only change required is limited to the body of method `allGifts(int day)`:

```java
static String allGifts(int day)
{
   StringBuilder result = new StringBuilder();
   for( int i = day; i > 0; i-- )
   {
      result.append(GIFTS[i] + "\n");
   }
   result.append("and " + GIFTS[0]);
   return result.toString();
}
```

Here is the [complete code](../solutions-code/chapter1/TwelveDaysIterative.java). Because the change can be isolated to within a method, the impact on the design is minimal. Perhaps it makes the code easier to understand for readers unfamiliar with recursion.

## Exercise 2

This is [one possible solution](../solutions-code/chapter1/TwelveDays2.java). The highlight of this solution is that instead of retrieving the string that describes the day directly from a data structure, a method `day(int)` now *abstracts* this concept, and hides the details of where the string comes from and the switching logic. Abstraction and information hiding are topics covered in Chapter 2. 

---
<a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" /></a>

Unless otherwise noted, the content of this repository is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a>. 

Copyright Martin P. Robillard 2019