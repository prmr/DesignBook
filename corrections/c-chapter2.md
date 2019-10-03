# Clarifications and Corrections for Chapter 2

* On p.15, "a two-element array of type `int`, which supports `(2^33)+1` values". This should read "... `(2^64)+1` values" (which makes the argument that much more compelling!).

* On p.33, In the constructor for `Card` at the bottom of the page, the Boolean conditions are negated. They should read `pRank == null` and `pSuit == null`.

* On p.36, the paragraph "`Card` in Solitaire" refers to the enumerated types as inner types. In fact these had been moved to top level types for version `v1.0`. To see them as inner types, check out version `v0.4`.