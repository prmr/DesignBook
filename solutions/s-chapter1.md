# Chapter 1 Solutions to Practice Exercises

## Problem 1

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

Here is the [complete code](../solutions-code/chaper1/TwelveDaysIterative.java). This code uses the [StringBuilder](https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html) library class, which is a more efficient way to perform string concatenation operations than using the overloaded version of the `+` operator. Because the change can be isolated to within a method, the impact on the design is minimal. Perhaps it makes the code easier to understand for readers unfamiliar with recursion.

## Problem 2

This is [one possible solution](../solutions-code/chaper1/TwelveDays2.java). The highlight of this solution is that instead of retrieving the string that describes the day directly from a data structure, a method `day(int)` now *abstract* this concept, and hides the details of where the string comes from and the switching logic. Abstraction and information hiding are topics covered in Chapter 2. 