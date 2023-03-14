package chapter4;

/**
 * An object that can be shuffled.
 */
public interface Shufflable
{
	/*?
	 * Keyword: NULL_SHUFFLABLE
	 *  We use the Null Object Pattern to create a shufflable that does nothing instead of a null reference. This is consistent with the notion that the shuffling order is initially undefined. We use a named null object to clarify the role of the anonymous shufflable. Additionally, this provides a clean way to dynamically check if the aShufflable field has been initialized with a value other than the default "null" shufflable. If Shufflable objects are absent, then shuffle() does nothing.
	 * 
	 * Internal: Null Object Pattern
	 * NULL_SHUFFLABLE
	 * The Null Object Pattern is a design pattern that is used to create a null object that can be used in place of a null reference. The null object is used to avoid NullPointerExceptions. This is consistent with the notion that the shuffling order is initially undefined.
	 */
	public static final Shufflable NULL_SHUFFLABLE = new Shufflable() 
	{
        /*?
         * Keyword: @Override
         * The @Override annotation is used to indicate that a method is intended to override a method in a superclass. Here, we are overriding the shuffle method in the Shufflable interface because we want to create a shufflable that does nothing instead of a null reference so that the shuffle() method does nothing when NULL_SHUFFLABLE is used by a client. If a shufflable object is absent, then shuffle() does nothing. If a shufflable object is present, then shuffle() is called on that object.
         */
		@Override
		/*?
		 * Keyword: shuffle
		 * The shuffle method is used to randomly reorder the objects that are the components of this object. Here we are using the Null Object Pattern to create a shufflable that does nothing instead of a null reference. This is consistent with the notion that the shuffling order is initially undefined. The shuffle method is required by the `Shufflable` interface.
		 */
		public void shuffle()
		{ /* Do nothing */ }
	};
	
	/**
	 * Randomly reorder the objects that are the components
	 * of this object.
	 */
	/*?
	 * Keyword: shuffle
	 * The Shufflable interface defines a method that is used to randomly reorder the objects that are the components of this object. The shuffle method is required by the `Shufflable` interface.
	 */
	void shuffle();
}
