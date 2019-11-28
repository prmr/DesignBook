package chapter7.copy;

public class SponsoredConcert extends Concert
{
	private String aSponsor;
	private int aSponsorTime;

	public SponsoredConcert(String pTitle, String pPerformer, int pTime, String pSponsorName, int pSponsorTime)
	{	
		super(pTitle, pPerformer, pTime);
		aSponsor = pSponsorName;
		aSponsorTime = pSponsorTime;
	}
	
	@Override
	public String extra()
	{
		return super.extra() + " sponsored by " + aSponsor;
	}
	
	@Override
	public int time()
	{
		return super.time() + aSponsorTime;
	}
}
