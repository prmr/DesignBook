package chapter8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * Class responsible for managing a program that consists
 * of various shows presented on different days of one week.
 * Each day of the week must be associated with exactly one
 * Show object. If there is not show on a given day, a special 
 * object of type show is used to represent a "non-show".
 */
public class Program
{
	private final EnumMap<Day, Show> aShows = new EnumMap<>(Day.class);
	private final List<ProgramObserver> aObservers = new ArrayList<>();

	private static final Show NULL = createNullShow();
	private final CommandProcessor pCP = new CommandProcessor();

	private static Show createNullShow() {
		return new Show() {
			@Override public String description() {return "";}
			@Override public int runningTime() {return 0;}
			@Override public Show copy() {return createNullShow();}
			@Override public int hashCode() { return 0; }
         	@Override public boolean equals(Object pObject)
			{ return pObject != null && pObject.getClass() == this.getClass(); }
			@Override public Iterator<Show> iterator() {return Collections.emptyIterator();}
		};
	}

	public Program() { 
		clear();
	}
	
	/**
	 * Clear the program by removing all existing shows.
	 */
	public void clear()
	{
		for (Day day : Day.values()) {
			aShows.put(day, NULL);
		}
		for( ProgramObserver observer : aObservers ) {
			observer.cleared();
		}
	}
	
	public void addObserver(ProgramObserver pObserver)
	{
		assert pObserver != null;
		aObservers.add(pObserver);
	}

	/**
	 * Adds a new show to the program. Overrides any existing show
	 * on that day.
	 * @param pShow The show to add.
	 * @param pDay The day when the show takes place.
	 */
	public void baseAdd(Show pShow, Day pDay) {
		assert pShow != null && pDay != null;
		aShows.put(pDay, pShow);
		for( ProgramObserver observer : aObservers ) {
			observer.added(pShow, pDay);
		}
	}

	/**
	 * Adds a new show to the program utilising the command processor. 
	 * Overrides any existing show on that day.
	 * @param pShow The show to add.
	 * @param pDay The day when the show takes place.
	 */
	public void add(Show pShow, Day pDay) {
		assert pShow != null && pDay != null;
		pCP.add(createAdd(pShow, pDay));
		for( ProgramObserver observer : aObservers ) {
			observer.added(pShow, pDay);
		}
	}
	
	/**
	 * Removes a show from the program.
	 * @param pDay The day when we want to zap the show.
	 */
	public void remove(Day pDay)
	{
		assert pDay != null;
		aShows.remove(pDay);
		for( ProgramObserver observer : aObservers ) {
			observer.removed(pDay);
		}
	}
	
	/**
	 * @param pDay The day of the requested show.
	 * @return A copy of the show on a given day.
	 */
	public Show get(Day pDay)
	{
		assert pDay != null;
		return aShows.get(pDay);
	}
	
	public Command createAdd(Show pShow, Day pDay) {
		return new Command() {
			 @Override
			 public Optional<Card> execute() {
				baseAdd(pShow, pDay);
				return Optional.empty();
			 }

			 @Override
			 public void undo() {
				remove(pDay);
			 }
		};
	}

	public Command createRemoveCommand(Day pDay) {
   		return new Command() {
			Show remShow = aShows.get(pDay);
			@Override
			public Optional<Card> execute() {
				remove(pDay);
				return Optional.empty();		
			}

			public void undo() {
				baseAdd(remShow, pDay);
			}
   		};
	}

	public Command createClear() {
		return new Command() {
			EnumMap<Day, Show> remProg;
			@Override
			public Optional<Card> execute() {
				remProg = aShows.clone();
				clear();
				return Optional.empty();
			}

			public void undo() {
				for (Day day : Day.values()) {
					aShows.put(day, remProg.get(day));
				}
			}
		};
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
