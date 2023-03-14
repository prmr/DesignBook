package chapter6;

import java.util.EnumMap;

/**
 * Class responsible for managing a program that consists
 * of various shows presented on different days of one week.
 * Each day of the week must be associated with exactly one
 * Show object. If there is not show on a given day, a special 
 * object of type show is used to represent a "non-show".
 */
public class Program
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
     * Keyword: aObservers
     * We use a list to store the observers.
     */
    private final List<ProgramObserver> aObservers = new ArrayList<>();

    public void addObserver(ProgramObserver pObserver)
	{
		assert pObserver != null;
		aObservers.add(pObserver);
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
        //Notify observers
        for( ProgramObserver observer : aObservers )
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
        aShows.put(pDay, pShow);
        //Notify observers
        for( ProgramObserver observer : aObservers )
        {
            observer.showAdded(pShow);
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
        /*?
         * Keyword: remove
         * We use the method remove() to remove a key-value pair from the enum map. The key is a day of the week (in this case, it is the day that is passed as a parameter) and the value is a show.
         */

        Show aShowToBeRemoved = aShows.get(pDay);
		aShows.remove(pDay);

        //Notify observers
        for( ProgramObserver observer : aObservers )
        {
            observer.showRemoved(aShowToBeRemoved, pDay);
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
 * Keyword: ProgramObserver
 * We define a `ProgramObserver` interface that defines the methods that a `ProgramObserver` must implement. The methods are `showAdded()`, `showRemoved()`, and `programCleared()`.
 */
interface ProgramObserver{

    void showAdded(Show pShow);

    void showRemoved(Show pShow, Day pDay);

    void programCleared();
}

/*?
 * Keyword: ConcreteProgramObserver
 * ConcreteProgramObserver is a concrete implementation of the `ProgramObserver` interface. It implements the methods `showAdded()`, `showRemoved()`, and `programCleared()`.
 */
class ConcreteProgramObserver implements ProgramObserver{

    @Override
    /*?
     * Keyword: showAdded
     * Here, we are overriding the method `showAdded()` of the `ProgramObserver` interface to define an implementation of the `showAdded()` method. The method prints a message to the console that a show has been added.
     */
    public void showAdded(Show pShow) {
        System.out.println("Show added: " + pShow.description());
    }

    @Override
    /*?
     * Keyword: showRemoved
     * Here, we are overriding the method `showRemoved()` of the `ProgramObserver` interface to define an implementation of the `showRemoved()` method. The method prints a message to the console that a show has been removed.
     */
    public void showRemoved(Show pShow, Day pDay) {
        System.out.println("Show removed: " + pShow.description());
    }

    @Override
    /*?
     * Keyword: programCleared
     * Here, we are overriding the method `programCleared()` of the `ProgramObserver` interface to define an implementation of the `programCleared()` method. The method prints a message to the console that the program has been cleared.
     */
    public void programCleared() {
        System.out.println("Program cleared");
    }

    public static void main(String[] args) {
        //test the ConcreteProgramObserver
        ConcreteProgramObserver observer = new ConcreteProgramObserver(); //Create a new observer
        Program program = new Program(); //Create a new program
        program.addObserver(observer); //Add the observer to the program
        program.clear(); //Clear the program
        program.add(new Show("The Simpsons", 30), Day.MONDAY); //Add a show to the program
        program.remove(Day.MONDAY); //Remove a show from the program

    }
}
