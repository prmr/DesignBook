# Clarifications and Corrections for Chapter 6

* The definition of `CompositeCardSource` on page 126 is missing the declaration `implements CardSource`, see the [correct version](../chapter-code/chapter6/CompositeCardSource.java).
* The definition of class `CompositeCardSource` on page 143 declares field `aSources` as `final`, but this is not possible due to the requirement to implement method `clone()`. To make the code work, it is necessary to remove the `final` keyword.
* The definition of class `Deck` on page 147 is missing the return type in the declaration of `createDrawCommand()` and the semicolon at the end of the statement. See [`Deck`](../chapter-code/chapter6/Deck.java) for the corrected version.