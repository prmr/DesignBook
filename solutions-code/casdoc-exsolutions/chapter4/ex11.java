package chapter4;

/*?
 * Keyword: GameModel
 * The GameModel class is a singeton class that represents the model of the game. It is a singleton because it is a class that is instantiated only once and shared by all clients.
 * 
 * Internal: singleton
 * GameModel
 * A singleton class is a class that is instantiated only once and shared by all clients. It is a design pattern that is used to ensure that only one instance of a class is created. A singleton class requires a private constructor, a private static field that holds the global variable `INSTANCE` of the class, and a public static `instance()` method that returns the instance of the class.
 */
public class GameModel
{
    /*?
     * Keyword: INSTANCE
     * The INSTANCE field is a private static field that holds the global variable `INSTANCE` of the class. It is private because it is only used by the class itself. It is static because it is a class variable and not an instance variable. It is final because it is a constant. This INSTANCE field shared by all clients, which means that all clients will be able to access the same instance of the class, the state of the game in this case.
     */
	private static final GameModel INSTANCE = new GameModel();
	
	private final Deck aDeck = new Deck();
	
	/**
	 * Depending on the context it can also be reasonable to dispense
	 * with this method altogether and make INSTANCE a public field.
	 */
    /*?
     * Keyword: instance()
     * The instance() method is a public static method that returns the instance of the class.
     */
	public static GameModel instance()
	{
		return INSTANCE;
	}

    /*?
     * Keyword: GameModel()
     * The GameModel() constructor is a private constructor to ensure that clients cannot instantiate the class.
     * 
     */
	private GameModel()
	{}
	
    /*?
     * Keyword: newGame()
     * The newGame() method is a public method that initializes the deck of cards aDeck and shuffles it.
     */
	public void newGame()
	{
		aDeck.shuffle();
	}

}
