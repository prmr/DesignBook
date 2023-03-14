package chapter6;

import java.util.EnumMap;

/**
 * Class responsible for managing a program that consists
 * of various shows presented on different days of one week.
 * Each day of the week must be associated with exactly one
 * Show object. If there is not show on a given day, a special 
 * object of type show is used to represent a "non-show".
 * 
 */
/*?
 * Keyword: Iterable
 * The Iterable interface is implemented by classes that can be used in a for-each loop. The interface Iterable defines a method iterator() that returns an iterator over shows.
 */
public class Program implements Iterable<Show>
{
    /*?
    * Keyword: EnumMap
    * EnumMap is a map that uses enum values as keys. It is a special case of HashMap where the key is an enum type and the value is an arbitrary object type (in this case Show). We use EnumMap because it is more efficient than HashMap when the key is an enum type. It is implemented as an array, which means that the key is used as an index to determine the location of the value in the map. This is very efficient for retrieving values. Here aShows is an EnumMap that uses the enum type Day as key and the type Show as value. The constructor EnumMap<>(Day.class) creates an EnumMap with Day as key type. The key type must be specified when creating an EnumMap. The value type is inferred from the type of the first value added to the map. In this case, the value type is Show. We pass Day.class into the constructor because Day is an enum type.
    *
    *
    * Internal: HashMap
    * EnumMap
    * HashMap is a map that uses arbitrary objects as keys. It is a general purpose map that can be used to associate any object with any other object. It is the most commonly used map in Java. It is implemented as a hash table, which means that the key is hashed to determine the location of the value in the map. This is very efficient for retrieving values.
    */ 
	private final EnumMap<Day, Show> aShows = new EnumMap<>(Day.class);


    /*?
     * Keyword: aLastAddedShow
     * getLastAddedShow is a reference that is used to store the last added show to the program. We use an `Optional` type because the last added show may not exist (i.e. The program is empty) and we want to avoid null references and NullPointerExceptions.
     */
    private Optional<Show> aLastAddedShow = Optional.empty();

    /*?
     * Keyword: getLastAddedShow
     * getLastDrawn is a method that returns the last added show from aShows. 
     */
    public Show getLastAddedShow() {
        return aLastAddedShow.get();
    }

    /*?
     * Keyword: aLastRemovedShow
     * getLastRemovedShow is a reference that is used to store the last removed show from the program. We use an `Optional` type because the last removed show may not exist (i.e. The program is empty) and we want to avoid null references and NullPointerExceptions.
     */
    private Optional<Show> aLastRemovedShow = Optional.empty();
    

    /*?
     * Keyword: getLastRemovedShow
     * getLastRemovedShow is a method that returns the last removed show from aShows. 
     */
    public Show getLastRemovedShow() {
        return aLastRemovedShow.get();
    }

    @Override
    /*?
     * Keyword: iterator
     * We define a method that returns an iterator over shows. The iterator is implemented by the class EnumMap. The method iterator() returns an iterator over the values in the map. The iterator is used in a for-each loop to iterate over the shows in the program.
     */
    public Iterator<Show> iterator() {
        return aShows.iterator();
    }


    /*?
     * Keyword: aAdditionObservers
     * We use a list to store the addition observers.
     */
    private final List<ProgramAdditionObserver> aAdditionObservers = new ArrayList<>();

    /*?
     * Keyword: aRemovalObservers
     * We use a list to store the removal observers.
     */
    private final List<ProgramRemovalObserver> aRemovalObservers = new ArrayList<>();

    /*?
     * Keyword: addObserver
     * We define a method that adds an addition observer to the list of addition observers.
     */
    public void addObserver(ProgramAdditionObserver pObserver)
    {
        aAdditionObservers.add(pObserver);
    }

    /*?
     * Keyword: addObserver
     * We define a method that adds a removal observer to the list of removal observers.
     */
    public void addObserver(ProgramRemovalObserver pObserver)
    {
        aRemovalObservers.add(pObserver);
    }


    /*?
     * Keyword: NULL
     * Here we define a special object of type Show that is used to represent a "non-show". This is a common pattern in Java. We use a special object to represent a "non-object". This is called the NULL object pattern. The NULL object is used to represent a non-object. It is used to avoid null references and NullPointerExceptions.
     * 
     * Internal: NULL object pattern
     * NULL
     * The Null Object pattern is a design pattern that is used to represent a non-object. It is used to avoid null references and NullPointerExceptions. It is a special case of the Null Object pattern where the null object is of type Show. The NULL object is used to represent a non-show. It is used to avoid null references and NullPointerExceptions.
     * 
     * Internal: NullPointerException
     * NULL
     * A NullPointerException is an exception that is thrown when a null reference is used where an object is required. It is a common error in Java. It is caused by a null reference. A null reference is a reference that does not refer to an object.
     */
    private static final Show NULL = createNullShow();


    /*?
     * Keyword: createNullShow
     * We define an anonymous class that implements the Show interface and overrides the methods description(), runningTime(), copy(), hashCode() and equals(). The anonymous class is used to create a special object of type Show that is used to represent an absent show. This Null object respects the interface of Show and clients can easily determine if a show is a Null object or not by calling the method isNull(). 
     */
    private static Show createNullShow() {
        return new Show() {
            /*?
             * Keyword: description
             * We override the method description() to return an empty string.
             */
           @Override public String description() { return ""; }
            /*?
            * Keyword: runningTime
            * We override the method runningTime() to return 0.
            */
           @Override public int runningTime() { return 0; }
            /*?
            * Keyword: copy
            * We override the method copy() to return a new Null object.
            */
           @Override public Show copy() { return createNullShow(); }
            /*?
            * Keyword: hashCode
            * We override the method hashCode() to return 0.
            */
           @Override public int hashCode() { return 0; }
            /*?
            * Keyword: equals
            * We override the method equals() to return true if the object is a Null object and false otherwise.
            */
           @Override public boolean equals(Object pObject) 
           { return pObject != null && pObject.getClass() == this.getClass(); }
        };
     }
     /*?
    * Keyword: isNull
    * We define a method that returns true if the show is a Null object and false otherwise. This way clients can easily determine if a show is a Null object or not by calling the method isNull().
    */
    public boolean isNull(Show pShow)
    {
        return NULL.equals(pShow);
    }

	/*?
     * Keyword: Program
     * We define a constructor that clears the program by removing all existing shows and fills the program with Null shows. 
     */
	public Program() {
        clear();
	}
	
	/**
	 * Clear the program by removing all existing shows.
	 */
    /*?
     * Keyword: clear
     * We define a method that removes all existing shows and fills the program with Null shows by looping over all days of the week and setting the show for each day to the Null show.
     */
	public void clear()
	{
	    for( Day day : Day.values() )
        {
            /*?
             * Keyword: put
             * We use the method put() to add a new key-value pair to the enum map. The key is a day of the week and the value is a show. The key is a day of the week and the value is a show, in this case the Null show.
             */
            aShows.put(day, NULL);
        }
        //Notify removal observers
        for( ProgramRemovalObserver observer : aRemovalObservers )
        {
            observer.programCleared();
        }
	}
	
	/**
	 * Adds a new show to the program. Overrides any existing show
	 * on that day.
	 * @param pShow The show to add.
	 * @param pDay The day when the show takes place.
     * @pre pShow != null && pDay != null
	 */
    /*?
     * Keyword: add
     * We define a method that adds a new show to the program. Overrides any existing show on that day. We use the method put() to add a new key-value pair to the enum map. The key is a day of the week and the value is a show. The key is a day of the week and the value is a show, in this case, it is the show that is passed as a parameter.
     */
	public void add(Show pShow, Day pDay)
	{
		assert pShow != null && pDay != null;
        aLastAddedShow = Optional.of(pShow);
        aShows.put(pDay, pShow);
        //Notify addition observers
        for( ProgramAdditionObserver observer : aAdditionObservers )
        {
            observer.showAdded(this);
        }

	}
	
	
	/**
	 * Removes a show from the program.
	 * @param pDay The day when we want to zap the show.
     * @pre pDay != null
	 */
    /*?
     * Keyword: remove
     * We define a method that removes a show from the program. We use the method remove() to remove a key-value pair from the enum map. The key is a day of the week (in this case, it is the day that is passed as a parameter) and the value is a show.
     */
	public void remove(Day pDay)
	{
		assert pDay != null;

        Show aShowToBeRemoved = aShows.get(pDay);

        if( aShowToBeRemoved != null )
        {
            aLastRemovedShow = Optional.of(aShowToBeRemoved); //Store the show to be removed
        }
        /*?
         * Keyword: remove
         * We use the method remove() to remove a key-value pair from the enum map. The key is a day of the week (in this case, it is the day that is passed as a parameter) and the value is a show.
         */
		aShows.remove(pDay);

        //Notify removal observers
        for( ProgramRemovalObserver observer : aRemovalObservers )
        {
            observer.showRemoved(this);
        }
	}
	
	/**
	 * @param pDay The day of the requested show.
	 * @return A copy of the show on a given day.
     * @pre pDay != null && aShows.containsKey(pDay)
	 */
    /*?
     * Keyword: get
     * We define a method that returns a copy of the show on a given day. We use the method get() to retrieve a value from the enum map. The key is a day of the week (in this case, it is the day that is passed as a parameter) and the value retured is a show stored in the enum map for that day.
     */
	public Show get(Day pDay)
	{
        /*?
         * Keyword: containsKey
         * We use the method containsKey() to check if the enum map contains a key-value pair with the key that is passed as a parameter.
         */
        assert pDay != null && aShows.containsKey(pDay);
        /*?
         * Keyword: get
         * We use the method get() to retrieve a value from the enum map. The key is a day of the week (in this case, it is the day that is passed as a parameter) and the value retured is a show stored in the enum map for that day.
         */
        return aShows.get(pDay);
	}
	
	@Override
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		for( Day day : aShows.keySet() )
		{
			if( aShows.containsKey(day))
			{
				result.append(String.format("%9s", day.name()))
					.append(": ").append(aShows.get(day).description()).append("\n");
			}
		}
		return result.toString();
	}
}

/*?
 * Keyword: ProgramAdditionObserver
 * We define a `ProgramAdditionObserver` interface that defines the methods that a `ProgramAdditionObserver` must implement. The interface has one method `showAdded()` that takes a program as a parameter.
 */
interface ProgramAdditionObserver{

    /*?
     * Keyword: showAdded
     * The method `showAdded()` takes a program as a parameter so we can use the pull data flow strategy. The method is implemented in the `ConcreteObserver1` class.
     */
    void showAdded(Iterable<Show> pProgram);
}

/*?
 * Keyword: ProgramRemovalObserver
 * We define a `ProgramRemovalObserver` interface that defines the methods that a `ProgramRemovalObserver` must implement. The interface has two methods `showRemoved()` and `programCleared()` that take a program as a parameter.
 */
interface ProgramRemovalObserver{

    /*?
     * Keyword: showRemoved
     * The method `showRemoved()` takes a `Show` object and a `Day` object as parameters. The method is implemented in the `ConcreteObserver2` and `ConcreteObserver3` classes.
     */
    void showRemoved(Iterable<Show> pProgram);

    /*?
     * Keyword: programCleared
     * The method `programCleared()` takes no parameters. The method is implemented in the `ConcreteObserver2` and `ConcreteObserver3` classes.
     */
    void programCleared();
}

/*?
 * Keyword: ConcreteObserver1
 * ConcreteObserver1 implements the `ProgramAdditionObserver` interface and defines an implementation of the `showAdded()` method.
 */
class ConcreteObserver1 implements ProgramAdditionObserver{

    @Override
    /*?
     * Keyword: showAdded
     * Here, we are overriding the method `showAdded()` of the `ProgramObserver` interface to define an implementation of the `showAdded()` method. The method prints a message to the console that a show has been added.
     */
    public void showAdded(Iterable<Show> pProgram) {
        System.out.println("Show added: " + pProgram.getLastAddedShow().description());
    }

}

/*?
 * Keyword: ConcreteObserver2
 * ConcreteObserver2 implements the `ProgramRemovalObserver` interface and defines an implementation of the `showRemoved()` and `programCleared()` methods.
 */
class ConcreteObserver2 implements ProgramRemovalObserver 
{

    @Override
    /*?
     * Keyword: showRemoved
     * Here, we are overriding the method `showRemoved()` of the `ProgramObserver` interface to define an implementation of the `showRemoved()` method. The method prints a message to the console that a show has been removed.
     */
    public void showRemoved(Iterable<Show> pProgram) {
        System.out.println("Show removed: " + pProgram.getLastRemovedShow().description());
    }

    @Override
    /*?
     * Keyword: programCleared
     * Here, we are overriding the method `programCleared()` of the `ProgramObserver` interface to define an implementation of the `programCleared()` method. The method prints a message to the console that the program has been cleared.
     */
    public void programCleared() {
        System.out.println("Program cleared");
    }
}

/*?
 * Keyword: ConcreteObserver3
 * ConcreteObserver3 implements the `ProgramAdditionObserver` and `ProgramRemovalObserver` interfaces and defines an implementation of the `showAdded()`, `showRemoved()`, and `programCleared()` methods.
 */
class ConcreteObserver3 implements ProgramAdditionObserver, ProgramRemovalObserver
{

    @Override
    /*?
     * Keyword: showAdded
     * Here, we are overriding the method `showAdded()` of the `ProgramObserver` interface to define an implementation of the `showAdded()` method. The method prints a message to the console that a show has been added.
     */
    public void showAdded(Iterable<Show> pProgram) {
        System.out.println("Show added: " + pProgram.getLastAddedShow().description());
    }

    @Override
    /*?
     * Keyword: showRemoved
     * Here, we are overriding the method `showRemoved()` of the `ProgramObserver` interface to define an implementation of the `showRemoved()` method. The method prints a message to the console that a show has been removed.
     */
    public void showRemoved(Iterable<Show> pProgram) {
        System.out.println("Show removed: " + pProgram.getLastRemovedShow().description());
    }

    @Override
    /*?
     * Keyword: programCleared
     * Here, we are overriding the method `programCleared()` of the `ProgramObserver` interface to define an implementation of the `programCleared()` method. The method prints a message to the console that the program has been cleared.
     */
    public void programCleared() {
        System.out.println("Program cleared");
    }
}