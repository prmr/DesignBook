package chapter7;

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
	public String description()
	{
		return String.format("%s by %s sponsored by %s", title(), aPerformer, aSponsor);
	}
	
	@Override
	public int time()
	{
		return super.time() + aSponsorTime;
	}
}
