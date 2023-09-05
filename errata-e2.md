# Errata for the Second Edition

If you spot a problem in the second edition that is not listed here, please [open an issue](https://github.com/prmr/DesignBook/issues). I do not accept pull requests on this repo, but I acknowledge reporters on the [main page](https://github.com/prmr/DesignBook#acknowledgements).

## Chapter 3

* Page 65: "...interface `PlayingStrategy`, which defines a method `computeNextMove`." This method was renamed to `getLegalMove` in version 1.2, the version the book is based on. All mentions to `computeNextMove` refer to `getLegalMove`.

## Chapter 9

* Page 270: "It some cases, however..." should be "In some cases, however".