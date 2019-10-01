package chapter4;

public class GameModel4
{
	private static final GameModel4 INSTANCE = new GameModel4();
	
	private final Deck aDeck = new Deck();
	
	/**
	 * Depending on the context it can also be reasonable to dispense
	 * with this method altogether and make INSTANCE a public field.
	 */
	public static GameModel4 instance()
	{
		return INSTANCE;
	}

	private GameModel4()
	{}
	
	public void newGame()
	{
		aDeck.shuffle();
	}

}
