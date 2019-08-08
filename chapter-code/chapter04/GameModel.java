package chapter04;

/**
 * Stub for a GameModel class that is an application
 * of the Singleton design pattern.
 *
 */
public class GameModel
{
	private static final GameModel INSTANCE = new GameModel();
	
	private GameModel() {}
	
	public static GameModel instance() 
	{ 
		return INSTANCE; 
	}
}