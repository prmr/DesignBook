package chapter7;

public abstract class AbstractDecorator implements CardSource
{
	private final CardSource aElement;
	
	protected AbstractDecorator( CardSource pElement )
	{
		aElement = pElement;
	}
	
	@Override
	public Card draw()
	{
		return aElement.draw();
	}

	@Override
	public boolean isEmpty()
	{
		return aElement.isEmpty();
	}
}
