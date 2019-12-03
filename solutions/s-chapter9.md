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

## Exercise 4

```java
List<Movie> movies = Movies.movies();
movies.sort((movie1, movie2) -> movie1.time() - movie2.time());
```

If we move the lambda expression to a static factory:

```java
private static Comparator<Show> createByTimeComparator()
{
   return (show1, show2) -> show1.time() - show2.time();
}
```

the client code becomes:

```java
movies.sort(createByTimeComparator());
```

## Exercise 5

We transform the factory into a simple comparison method:

```java
private static int compareByTime(Show pShow1, Show pShow2)
{
   return pShow1.time() - pShow2.time();
}
```

We can then refer to it wherever a function type `(Show,Show)->int` is expected:

```java
movies.sort(Exercise5::compareByTime);
```

## Exercise 6

Assuming we have the static import:

```java
import static java.util.Comparator.comparing;
```

the solution is:

```java
List<Movie> movies = Movies.movies();
movies.sort(comparing(Movie::time).thenComparing(Movie::title));
```

## Exercise 7

As usual with the Flyweight pattern the first step is to make the constructor(s) private. Then we need a static flyweight store:

```java
private static final Map<String, Movie> aMovies = new HashMap<>();
```

and a static accessor method:

```java
public static Movie get(String pTitle, int pYear, int pTime)
{
   return aMovies.computeIfAbsent(pTitle, title -> new Movie(pTitle, pYear, pTime));
}
```

In this simple exercise there's no way to get the year and time for a movie, so we have to provide all the information required to create an object (title, year, time) to the accessor method.

## Exercise 8

I created a helper function to turn a number of minutes into the requires output:

```java
private static String toHHMM(int pMinutes)
{
   assert pMinutes >=0;
   return String.format("%d:%02d", pMinutes/60, pMinutes%60);
}
```

The solution is then:

```java
Movies.movies().stream()
   .map(Movie::time)
   .map(Exercise8::toHHMM)
   .forEach(System.out::println);
```

## Exercise 9

To make the code more readable I import the following static members:

```java
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
```

The solution:

```java
List<Movie> mySelection = Movies.movies().stream()
   .filter(movie -> movie.time() < 2000)
   .sorted(comparing(Movie::time).reversed())
   .limit(3)
   .sorted(comparing(Movie::title).reversed())
   .collect(toList());
```

## Exercise 10

With integers:

```java
Random random = new Random();
System.out.println(
   IntStream.generate(()->random.nextInt(101))
      .limit(1000000)
      .summaryStatistics());
```

With doubles it's only a matter of changing the stream class and working around the `0-1.0` bounds for the random number generation:

```java
DoubleStream.generate(()-> 100 * random.nextDouble())
   .limit(1000000)
   .summaryStatistics()
```

## Exercise 11

The following code assumes `Predicate.isEqual` and `Arrays.stream` are statically imported:

```java
long result = Movies.movies().stream()
   .map(Movie::title)
   .map(String::toLowerCase)
   .flatMap(string -> stream(string.split("[\\s,]+")))
   .filter(isEqual("the"))
   .count();
```

## Exercise 12

```java
Movie result = Movies.movies().stream()
   .reduce((movie1, movie2) ->
      movie1.time() > movie2.time() ? movie1 : movie2).get();
```

## Exercise 13

This code assumes `Collectors.toMap` has been statically imported.

```java
Map<String, Integer> result = 
   Movies.movies().stream()
      .collect(toMap(Movie::title, Movie::time));
```

## Exercise 14

This exercise is easier to organize with a helper function that returns the decade a `Movie` was produced in, for example:

```java
private static String decade(Movie pMovie)
{
   return String.format("%02ds", ((pMovie.year()-1900)%100)/10*10);
}
```

Assuming `Collectors.groupingBy` is statically imported, we have:

```java
Map<String, List<Movie>> result = 
   Movies.movies().stream()
      .collect(groupingBy(Exercise14::decade));
```

## Exercise 15

This solution relies on the fact that we can get a stream of all the entries in a `Map`:

```java
Movies.movies().stream()
   .collect(groupingBy(Exercise15::decade))
   .entrySet().stream()
   .filter( entry -> entry.getKey().equals("50s") || entry.getKey().equals("60s"))
   .flatMap( entry -> entry.getValue().stream() );
```

---
<a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" /></a>

Unless otherwise noted, the content of this repository is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a>. 

Copyright Martin P. Robillard 2019