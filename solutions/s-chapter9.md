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

## Exercise 2

If we add method `isOld` to class `Movie`:

```java
public boolean isOld()
{
    return aYear < 1960;
}
```

then the expression can use a method reference:

```java
movies.removeIf(Movie::isOld);
```

## Exercise 3

With an anonymous class:

```java
Movies.movies().forEach(new Consumer<Movie>() 
{
   @Override
   public void accept(Movie pMovie)
   {
      System.out.println(pMovie);
   }
});
```

With a lambda expression:

```java
Movies.movies().forEach(movie -> System.out.println(movie));
```

With a reference to a static method, assumed to be in class `Exercise3`:

```java
Movies.movies().forEach(Exercise3::print);
	
private static void print(Movie pMovie)
{
   System.out.println(pMovie);
}
```

And with a reference to `System.out.println(Object)`:

```java
Movies.movies().forEach(System.out::println);
```

---
<a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" /></a>

Unless otherwise noted, the content of this repository is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a>. 

Copyright Martin P. Robillard 2019