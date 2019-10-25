package chapter6;

public class IntroducedShow implements Show
{
	private final Show aShow;
	private final String aSpeaker;
	private final int aSpeechTime;
	
	public IntroducedShow(String pName, int pTime, Show pShow )
	{
		aShow = pShow;
		aSpeaker = pName;
		aSpeechTime = pTime;
	}
	
	@Override
	public String description() { return "[" + aSpeaker + " introduces " + aShow.description() + "]"; }

	@Override
	public int runningTime() { return aSpeechTime + aShow.runningTime(); }
}
