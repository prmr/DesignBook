# Chapter 6 Solutions to Practice Exercises

## Exercise 1

The following is a sample [Composite](../solutions-code/chapter6/CompositeShow.java) and [Client](../solutions-code/chapter6/CompositeShow.java) (first block). Other approaches are possible to specify and enforce the cardinality constraint for initializing the composite show, e.g., design by contract or overloaded constructors.

## Exercise 2

The following is a sample [Decorator](../solutions-code/chapter6/IntroducedShow.java) and [Client](../solutions-code/chapter6/CompositeShow.java) (second block). 

## Exercise 3

![](c6-exercise3.png)

[Diagram file](c6-exercise3.class.jet)

## Exercise 4

![](c6-exercise4.png)

[Diagram file](c6-exercise4.object.jet)

## Exercise 5

![](c6-exercise5.png)

[Diagram file](c6-exercise5.sequence.jet)

## Exercise 6

The first steps are to create helper classes [CompositeIcon](../solutions-code/chapter6/CompositeIcon.java) and [ShiftedIcon](../solutions-code/chapter6/ShiftedIcon.java). Then a method to create the desired icon becomes relatively simple. Assuming `SHIFT_X` and `SHIFT_Y` denote `int` values that represent a number of pixels.

```java
private Icon createHandIcon(Card[] pHand, boolean pHidden)
{
	CompositeIcon result = new CompositeIcon();
	for( int i = 0; i < pHand.length; i++ )
	{
		result.addIcon(new ShiftedIcon(pHidden?CardImages.getBack():CardImages.getCard(pHand[i]), SHIFT_X, SHIFT_Y));
	}
	return result;
}
```

## Exercise 7

The solution entails declaring `CompositeShow` to implement `Iterable<Show>`:

```java
public class CompositeShow implements Show, Iterable<Show>
```

This requires implementing the `iterator()` method in `CompositeShow`, which is straightforward:

```java
@Override
public Iterator<Show> iterator()
{
   return aShows.iterator();
}
```

The main benefit of declaring only `CompositeShow` to be iterable is that we avoid having to have this behavior defined for (and implemented by) classes for which it makes no sense, namely leaves such as `Concert` or `Movie`. The disadvantage is that it requires client code that works instances of `Show` to explicitly check whether an instance can be unpacked or not:

```java
Show show = ...;
if( show instanceof CompositeShow )
{
   for( Show subshow : show )
   { /* ... */ }
}
```

## Exercise 8

To add a method `iterator()` to the interface of `Show` our best bet is to declare `Show` to extend `Iterable<Show>` so that we also benefit from the subtyping relationship this introduces:

```java
public interface Show extends Iterable<Show>
```

The advantage of this solution is that client code can be more polymorphic:

```java
Show show = ...;
for( Show subshow : show ) 
{ /* ... */ } // Not executed if an empty iterator is returned.
```

The disadvantage of this approach is that an implementation of `iterator()` must also be supplied for classes that have nothing to unpack. However, with Java 8 it is a relatively minor concern because we can declare a default method that returns an empty iterator in the `Show` interface:

```java
@Override
default Iterator<Show> iterator()
{
   return Collections.emptyIterator();
}
```

## Exercise 9

For `DoubleBill` to work with `Movie` instances specifically (as opposed to `Show` instances), and thereby not be a constructor, it is simply a matter of declaring the two aggregated objects to be of type `Movie`:

```java
/**
 * Represents a show that consists of the screening of two movies
 * in sequence.
 */
public class DoubleBill implements Show
{
   private Movie aMovie1;
   private Movie aMovie2;
	
   /**
    * @param pMovie1 The first movie.
    * @param pMovie2 The second movie.
    */
   public DoubleBill(Movie pMovie1, Movie pMovie2)
   {
      aMovie1 = pMovie1;
      aMovie2 = pMovie2;
   }
	
   @Override
   public String description() 
   { 
      return String.format("%s and %s", aMovie1.description(), aMovie2.description()); 
   }

   @Override
   public int runningTime() 
   { 
      return aMovie1.runningTime() + aMovie2.runningTime(); 
   }
}

```


---
<a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" /></a>

Unless otherwise noted, the content of this repository is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a>. 

Copyright Martin P. Robillard 2019