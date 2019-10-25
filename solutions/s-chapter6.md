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

The solution would entail declaring `CompositeShow` to extend `Iterable<Show>`. The main benefit of declaring only `CompositeShow` to be iterable is that we avoid having to have this behavior defined for (and implemented by) classes for which it makes no sense, namely leaves such as `Concert` or `Movie`. The disadvantage is that it makes client code that works on object graphs very tricky to implement.

One attempt could look like this:


```java
// Incorrect
private static final List<Show> flattenShow(Show pShow)
{
	List<Show> result = new ArrayList<>();
	result.add(pShow);
	if( pShow instanceof Iterable )
	{
		for( Object child : (Iterable<?>)pShow)
		{
			result.addAll(flattenShow((Show)child));
		}
	}
	return result;
}

```

Note how obtaining the children shows requires an `instanceof` check. The fact that `Iterable` is a generic type is an additional obstacle, as it is not possible to dynamically check that the argument to `instanceof` is an iterator over `Show` instances, which makes it necessary to add awkward casts in the code. This could be avoided to a certain extent by using `CompositeShow` as the argument in the `instanceof` expression, but this would make the code more brittle because if we add other iterable shows, such as `DoubleBill`, it would break the code. Finally, this solution does not work because of the `IntroducedShow` wrapper class is oblivious to the concept of iteration, so if an `IntroducedShow` decorates a `CompositeShow`, the shows aggreated by the `CompositeShow` would not be reachable. The flattening code would thus need to be extended to account for this special case (using another `instanceof` check). What a mess.

---
<a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" /></a>

Unless otherwise noted, the content of this repository is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a>. 

Copyright Martin P. Robillard 2019