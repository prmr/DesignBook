package chapter4;

/**
 * An object that can be shuffled.
 */
public interface Shufflable
{
	public static final Shufflable NULL_SHUFFLABLE = new Shufflable() 
	{
		@Override
		public void shuffle()
		{ /* Do nothing */ }
	};
	
	/**
	 * Randomly reorder the objects that are the components
	 * of this object.
	 */
	void shuffle();
}
