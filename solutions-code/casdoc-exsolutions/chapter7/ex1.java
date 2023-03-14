
/*?
 * Keyword: extends
 * extends is used to indicate that a class is a subclass of another class. Here, Concert is the superclass of SponsoredConcert.
 */
public class SponsoredConcert extends Concert
{
   private String aSponsor;
   private int aSponsorTime;

   /*?
    * Keyword: SponsoredConcert
    * The constructor of the class `SponsoredConcert` takes the title, performer, time, sponsor name, and sponsor time as parameters. It calls the constructor of the superclass `Concert` to initialize the fields `aTitle`, `aPerformer`, and `aTime`. It then initializes the fields `aSponsor` and `aSponsorTime`.
    */
   public SponsoredConcert(String pTitle, String pPerformer, int pTime, String pSponsorName, int pSponsorTime)
   {	
    /*?
     * Keyword: super
     * super is used to call the constructor of the superclass. Here, we call the constructor of the superclass `Concert` to initialize the fields `aTitle`, `aPerformer`, and `aTime`.
     */
      super(pTitle, pPerformer, pTime);
      aSponsor = pSponsorName;
      aSponsorTime = pSponsorTime;
   }
	
   @Override
   /*?
    * Keyword: description
    * We override the `description()` method from the superclass `Concert` to add the name of the sponsor to the description.
    */
   public String description()
   {
      return String.format("%s by %s sponsored by %s", title(), aPerformer, aSponsor);
   }
	
   @Override
   /*?
    * Keyword: time
    * We override the `time()` method from the superclass `Concert` to add the time of the sponsor to the time of the concert.
    */
   public int time()
   {
      return super.time() + aSponsorTime;
   }
}
