# Clarifications and Corrections for Chapter 4

* On p.63, 'A more useful abstract state for Player would be "non-zero score" and one for Deck would be "empty", which in both cases happen to correspond to a single concrete state.' The second clause only applies to the "empty" state. Although "zero score" maps to a single concrete state for an integer, obviously, non-zero scope maps to `2^32-1` concrete states (if the full integer range is permitted).

* On p.74, field `NULL` of interface `CardSource` does not require the `public` modifier as interface fields are implicitly `public` and `final`.

* On p.86, in the code fragment at the top of the page, the use of the parameter `pRank` is superfluous in `countCards` because this instance method of the anonymous class can refer to the implicit field `pRank` directly. The better version is [here](../chapter-code/chapter4/Deck.java).