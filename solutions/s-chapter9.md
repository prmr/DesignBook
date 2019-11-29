# Chapter 9 Solutions to Practice Exercises

## Exercise 1

With an anonymous class:

```java
ArrayList<Movie> movies = new ArrayList<>(Movies.movies());
    movies.removeIf( new Predicate<Movie>()
    {
        @Override
        public boolean test(Movie pMovie)
        {
            return pMovie.year() < 1960;
        }
    });
```

As a lambda expression:

```java
movies.removeIf( movie -> movie.year() < 1960 );
```

---
<a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" /></a>

Unless otherwise noted, the content of this repository is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a>. 

Copyright Martin P. Robillard 2019