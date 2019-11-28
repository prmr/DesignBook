package chapter7.copy;

public abstract class AbstractShow implements Show
{
	private String aTitle;
	private int aTime;
	
	protected AbstractShow(String pTitle, int pTime)
	{
		aTitle = pTitle;
		aTime = pTime;
	}
	
	@Override
	public final String description()
	{
		return String.format("%s: %s (%d minutes", title(), extra(), time());
	}
	
	protected abstract String extra();
	
	public String title()
	{
		return aTitle;
	}
	
	public void setTitle(String pTitle)
	{
		aTitle = pTitle;
	}
	
	public int time()
	{
		return aTime;
	}
	
	public void setTime(int pTime)
	{
		aTime = pTime;
	}
}
