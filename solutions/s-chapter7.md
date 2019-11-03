# Chapter 7 Solutions to Practice Exercises

## Exercise 1

```java
public class SponsoredConcert extends Concert
{
   private String aSponsor;
   private int aSponsorTime;

   public SponsoredConcert(String pTitle, String pPerformer, int pTime, 
      String pSponsorName, int pSponsorTime)
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

```

## Exercise 2

A solution that would make proper use of inheritance would be to access `aPerformer` through a getter method, either public or protected. 


---
<a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" /></a>

Unless otherwise noted, the content of this repository is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a>. 

Copyright Martin P. Robillard 2019