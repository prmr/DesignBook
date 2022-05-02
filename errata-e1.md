# Errata for the First Edition

If you spot a problem in the first edition that is not listed here, please [open an issue](https://github.com/prmr/DesignBook/issues). I do not accept pull requests on this repo, but I acknowledge reporters on the [main page](https://github.com/prmr/DesignBook#acknowledgements).

## Chapter 1

* Page 1: "...the only thing left it to put the poem together..." should be "...the only thing left **is** to put the poem together..."

## Chapter 2

* Page 15: "a two-element array of type `int`, which supports `(2^33)+1` values". This should read "... `(2^64)+1` values" (which makes the argument that much more compelling!).

* Page 23: The comment `/* Suffle the cards */` should read `/* Shuffle the cards */`.

* Page 33: In the constructor for `Card` at the bottom of the page, the Boolean conditions are negated. They should read `pRank == null` and `pSuit == null`.

* Page 36: The paragraph "`Card` in Solitaire" refers to the enumerated types as inner types. In fact these had been moved to top level types for version `v1.0`. To see them as inner types, check out version `v0.4`.

## Chapter 3

* Page 52: In the code samples here and elsewhere, an `Iterable` class that aggregates a `List` implements method `iterator()` by delegating the call to its aggregate: `return aCards.iterator()`. Strictly speaking, this idiom can violate the encapsulation of class `Deck` because interface `Iterator` includes a method `remove` that can be optionally implemented (and which *is* implemented by `ArrayList`). Consistent with the book's goal of focusing on general design concerns with minimum coverage of the libraries, I overlook this case. In the context of the book it can be assumed that `Iterator.remove()` is not used. For production code how to best avoid the encapsulation problem would depend on the properties of the context. One option is to return the iterator obtained from an unmodifiable view of the list, e.g., `return Collections.unmodifiableList(aCards).iterator()`.

## Chapter 4

* Page 63: 'A more useful abstract state for Player would be "non-zero score" and one for Deck would be "empty", which in both cases happen to correspond to a single concrete state.' The second clause only applies to the "empty" state. Although "zero score" maps to a single concrete state for an integer, obviously, non-zero scope maps to `2^32-1` concrete states (if the full integer range is permitted).

* Page 74: Field `NULL` of interface `CardSource` does not require the `public` modifier as interface fields are implicitly `public` and `final`.

* Page 86: In the code fragment at the top of the page, the use of the parameter `pRank` is superfluous in `countCards` because this instance method of the anonymous class can refer to the implicit field `pRank` directly. The better version is [here](../chapter-code/chapter4/Deck.java).

## Chapter 5

_Nothing to report._

## Chapter 6

* Page 126: The definition of `CompositeCardSource` is missing the declaration `implements CardSource`, see the [correct version](../chapter-code/chapter6/CompositeCardSource.java).
* Page 143: The definition of class `CompositeCardSource` declares field `aSources` as `final`, but this is not possible due to the requirement to implement method `clone()`. To make the code work, it is necessary to remove the `final` keyword.
* Page 147: The definition of class `Deck` is missing the return type in the declaration of `createDrawCommand()` and the semicolon at the end of the statement. See [`Deck`](../chapter-code/chapter6/Deck.java) for the corrected version.

## Chapter 7

* Page 161: "The fact that the code in class `MemorizingDeck` cannot access (or *see*) the field declared in its superclass does not change anything about the fact that this field is inherited". Surprisingly, the [Java Language Specification (JLS)](https://docs.oracle.com/javase/specs/jls/se8/html/jls-6.html#jls-6.6.1) considers that private fields are not inherited. This is a matter of terminology, because objects of subclasses *do* include  the private fields declared in their parent classes. In the context of teaching object-oriented design, mixing visibility and inheritance is very confusing, so I do *not* retain the terminology of the JLS. In the book, the concepts of field *inheritance* and *visibility* are kept consistently distinct.
* Page 161: In the code example, `pulic` should be `public`.
* Page 162: "the first instruction of any constructor is to call a constructor of its superclass" is not completely accurate because it is also possible to call a constructor *of the same class* with `this(...)`. 
* Page 162: In the first code fragment, `Cards.get` should be `Card.get` and `Suit.SPACES` should be `Suit.SPADES`.
* Page 162: In Figure 7.5, `MemorizingDeck` should have field named `aDrawnCards` not `aCards`.
* Page 176: class `AbstractDecorator` is intended to be also declared as `abstract`.  See [`AbstractDecorator`](../chapter-code/chapter7/AbstractDecorator.java) for the corrected version.
* Page 185: For the first code fragment to work as expected, the first line should read `MemorizingDeck deck = new MemorizingDeck();`

## Chapter 8

* Page 200: "(ISP, see Section **3.2**)" should be (ISP, see Section **3.8**);
* Page 203: In the declaration of interfaces `ChangeObserver` and `BoundsReachedObserver`, the empty method declarations (`{}`) should be replaced with a semicolon. 

## Chapter 9

* Page 238: method `compareByRank` would be best declared `public` so it can be usable outside the class.
* Page 249: there are two extra parentheses in the first sorting code fragment. See the corrected version as method `sampleSortingApplication1` in [Card.java](../chapter-code/chapter9/Card.java).
* Page 255: in the second code fragment, `comparator.comparing..`. should be `Comparator.comparing...`.
* Page 255: the sequence diagram shows two function objects as key extractors (`f1` and `f2`). However, there is only a single key extractor object involved in this scenario.

## License

<a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" /></a>

Unless otherwise noted, the content of this repository is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a>. 

Copyright Martin P. Robillard 2019-2022
