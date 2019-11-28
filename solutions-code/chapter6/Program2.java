package chapter6;

import java.util.EnumMap;

/**
 * Class responsible for managing a program that consists
 * of various shows presented on different days of one week.
 * Each day of the week must be associated with exactly one
 * Show object. If there is not show on a given day, a special 
 * object of type show is used to represent a "non-show".
 */
public class Program2
{
	public static void main(String[] args)
	{
		Program2 p = new Program2();
		Show nullShow = p.get(Day.FRIDAY);
		Show copy = nullShow.copy();
		System.out.println(copy.getClass().getName());
	}
	
	private final EnumMap<Day, Show> aShows = new EnumMap<>(Day.class);
	
	private static final Show NULL = createNullShow();
	
	private static Show createNullShow() {
		return new Show() {
			@Override public String description() { return ""; }
			@Override public int runningTime() { return 0; }
			@Override public Show copy() { return createNullShow(); }
			@Override public int hashCode() { return 0; }
			@Override public boolean equals(Object pObject) 
			{ return pObject != null && pObject.getClass() == this.getClass(); }
		};
	}
	
	public boolean isNull(Show pShow)
	{
		return NULL.equals(pShow);
	}
	
	public Program2() { 
		clear();
	}
	
	/**
	 * Clear the program by removing all existing shows.
	 */
	public void clear()
	{
		for( Day day : Day.values() )
		{
			aShows.put(day, NULL);
		}
	}
	
	/**
	 * Adds a new show to the program. Overrides any existing show
	 * on that day.
	 * @param pShow The show to add.
	 * @param pDay The day when the show takes place.
	 */
	public void add(Show pShow, Day pDay)
	{
		assert pShow != null && pDay != null;
		aShows.put(pDay, pShow);
	}
	
	
	/**
	 * Removes a show from the program.
	 * @param pDay The day when we want to zap the show.
	 */
	public void remove(Day pDay)
	{
		assert pDay != null;
		aShows.remove(pDay);
	}
	
	/**
	 * @param pDay The day of the requested show.
	 * @return A copy of the show on a given day.
	 */
	public Show get(Day pDay)
	{
		assert pDay != null && aShows.containsKey(pDay);
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
