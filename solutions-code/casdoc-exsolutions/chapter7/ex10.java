package chapter7;

/**
 * Represents a performance that can take place in a theater.
 */
/*?
 * Keyword: Cloneable
 * The Cloneable interface is a marker interface that indicates that the class implements the clone() method to create a copy of the object.
 * 
 * Keyword: extends
 * The `Show` interface extends the `Cloneable` interface. This means that the `Show` interface inherits all the methods of the `Cloneable` interface. This ensures that the `Show` interface implements the `clone()` method to create a copy of the object. This is useful because we want to ensure that the `clone()` method is implemented by all classes that implement the `Show` interface and that the `clone()` method returns an object of type `Show`.
 */
public interface Show extends Cloneable
{
	/**
	 * @return The title of the show.
	 */
	String title();
	
	/**
	 * @return A description of the show.
	 */
	String description();
	
	/**
	 * @return The total time required for the show.
	 */
	int time();

	/**
	 * @return A clone of this show.
	 */
	/*?
	 * Keyword: clone
	 * The clone() method is a protected method of the Object class that is overridden by the Cloneable interface. The clone() method creates a copy of the object and returns it as an Object. The clone() method must be overridden by the class that implements the Cloneable interface.
	 */
	Show clone();
}


/*?
 * Keyword: abstract class
 * An abstract class is a class that cannot be instantiated. It can only be used as a superclass. This is useful when you want to share some functionality between subclasses, but you don't want to instantiate the class itself.
 */
public abstract class AbstractShow implements Show {

    private String aTitle;
    private int aTime;

    /*?
     * Keyword: protected
     * The constructor of the class `AbstractShow` is protected. This means that it can only be called from within the class itself or from a subclass. This is useful when you want to prevent instantiation of the class itself, but you want to allow subclasses to be instantiated.
     */
    protected AbstractShow(String pTitle, int pTime) {
        aTitle = pTitle;
        aTime = pTime;
    }

    public String title() {
        return aTitle;
    }

    public void setTitle(String pTitle) {
        aTitle = pTitle;
    }

    public int time() {
        return aTime;
    }

    public void setTime(int pTime) {
        aTime = pTime;
    }

    @Override
    /*?
     * Keyword: description
     * We apply the Template Method Design Pattern by defining a template method `description()` that returns a description of the show. This ensures that calling description() on an instance of any type of `Show` will return a description of the show in this specified format. The template method needs to get additional information from subclasses, so we define an abstract method `extra()`, which must be implemented by a subclass. This ensures that the description of the show is different for each type of show. The `extra()` method is called from within the `description()` method. This ensures that the description of the show is always in the same format.
     * 
     * Internal: Template Method Design Pattern
     * description
     * The Template Method Design Pattern is a design pattern that defines a template method that is implemented in a superclass, but that needs to get additional information from subclasses. This ensures that the template method is always implemented in the same way, but the additional information is different for each subclass. The `extra()` method is called from within the `description()` method. This ensures that the description of the show is always in the same format.
     */
    public final String description() {
        return String.format("%s: %s (%d minutes)", title(), extra(), time());
    }

    /*?
     * Keyword: abstract
     * An abstract method is a method that is declared in an abstract class, but not implemented. It must be implemented by a subclass. This is useful when you want to define a template method that needs to get additional information from subclasses. This ensures that the template method is always implemented in the same way, but the additional information is different for each subclass. The `extra()` method is called from within the `description()` method. This ensures that the description of the show is always in the same format.
     * 
     * Keyword: protected
     * The method `extra()` is protected. This means that it can only be accessed from within the class itself or from a subclass. This is useful because we want to ensure that the `extra()` method is only called from within the `description()` method.
     */
    protected abstract String extra();

    @Override
    /*?
     * Keyword: clone
     * The clone() method creates a copy of the object and returns it as an Object. The clone() method must be overridden by the class that implements the Cloneable interface. This clone() method returns an object of type `Show` by casting the result of the `super.clone()` method to type `Show`. This is possible because the `super.clone()` method returns an object of type `Object`, which is the superclass of `Show`. This ensures that the clone() method returns an object of type `Show`. Since `Movie` and `Concert` have only primitive and String fields , they can simply inherit this clone() method from `AbstractShow` - the call to `super.clone()` is actually a call to `Object.clone()`, which is implemented by the JVM which copies all the fields of the object.
     */
    public AbstractShow clone() 
    {
        try 
        {
            /*?
             * Keyword: super
             * The `super.clone()` method creates a copy of the object and returns it as an Object. We then cast the result of the `super.clone()` method to type `AbstractShow`. This is possible because the `super.clone()` method returns an object of type `Object`, which is the superclass of `AbstractShow`. This ensures that the clone() method returns an object of type `AbstractShow`.
             */
            return (AbstractShow) super.clone();
        } 
        /*?
         * Keyword: CloneNotSupportedException
         * The `CloneNotSupportedException` is an exception that is thrown when the `clone()` method is called on an object that does not implement the `Cloneable` interface. If the `clone()` method is called on an object that does not implement the `Cloneable` interface, the `clone()` method will throw a `CloneNotSupportedException` and return `null`. This ensures that the `clone()` method returns an object of type `AbstractShow` or `null`.
         */
        catch (CloneNotSupportedException e) 
        {
            return null;
        }
    }
}

/*?
 * Keyword: extends
 * extends is used to indicate that a class is a subclass of another class. Here, Concert is the subclass of AbstractShow.
 */
public class Concert extends AbstractShow {

    /*?
     * Keyword: protected
     * The field `aPerformer` is protected. This means that it can only be accessed from within the class itself or from a subclass. This is useful when you want to prevent access to the field from outside the class, but you want to allow subclasses to access the field.
     */
    protected String aPerformer;

    /*?
     * Keyword: Concert
     * The constructor of the class `Concert` takes the title, performer, and time as parameters. It initializes the field `aPerformer` using the parameter `pPerformer`. This field is protected, so it can only be set by the constructor or by a subclass. The constructor of the superclass `AbstractShow` is called using the `super` keyword. This initializes the fields `aTitle` and `aTime`.
     */
    public Concert(String pTitle, String pPerformer, int pTime) {
        /*?
         * Keyword: super
         * The `super` keyword is used to call the constructor of the superclass. Here, the constructor of the superclass `AbstractShow` is called. This initializes the fields `aTitle` and `aTime`.
         */
        super(pTitle, pTime);
        aPerformer = pPerformer;
    }

    @Override
    public String description() {
        return String.format("%s by %s", title(), aPerformer);
    }

    /*?
     * Keyword: @Override
     * The `@Override` annotation is used to indicate that a method overrides a method in a superclass. In this case, we are overriding the `extra()` method from the superclass `AbstractShow`. This ensures that the `extra()` method is always implemented in the same way, but the additional information is different for each subclass. The `extra()` method is called from within the `description()` method. This ensures that the description of the show is always in the same format.
     */
    @Override
    /*?
     * Keyword: protected
     * The method `extra()` is protected. This means that it can only be accessed from within the class itself or from a subclass. This is useful because we want to ensure that the `extra()` method is only called from within the `description()` method.
     * 
     * Keyword: extra
     * The method `extra()` adds the performer of the concert. This is the additional information that is needed to describe a concert in the specified format of the `description()` method in the superclass `AbstractShow`.
     */
    protected String extra() {
        return "by " + aPerformer;
    }

    @Override
    /*?
     * Keyword: clone
     * The clone() method creates a copy of the object and returns it as an Object. The clone() method must be overridden by the class that implements the Cloneable interface. This clone() method returns an object of type `Concert` by casting the result of the `super.clone()` method to type `Concert`. This is possible because the `super.clone()` method returns an object of type `Object`, which is the superclass of `Show`. Since `Concert` has only primitive and String fields, it can simply inherit the clone() method from `AbstractShow` - the call to `super.clone()` is actually a call to `Object.clone()`, which is implemented by the JVM which copies all the fields of the object no matter what the runtime type of the object is.
     */
    public Concert clone()
    {
        /*?
         * Keyword: (Concert)
         * We override the `clone()` method in the subclass `Concert` to return an object of type `Concert` by downcasting the result of the `super.clone()` method to type `Concert` so that clients can call the `clone()` method on an object of type `Concert` and get an object of type `Concert` back.
         */
        return (Concert) super.clone();
    }
}

/*?
 * Keyword: extends
 * extends is used to indicate that a class is a subclass of another class. Here, Movie is the subclass of AbstractShow.
 */
public class Movie extends AbstractShow
{

    /*?
     * Keyword: protected
     * The field `aYear` is protected. This means that it can only be accessed from within the class itself or from a subclass. This is useful when you want to prevent access to the field from outside the class, but you want to allow subclasses to access the field.
     */
	protected int aYear;
	
	public Movie(String pTitle, int pYear, int pTime)
	{
        /*?
         * Keyword: super
         * The `super` keyword is used to call the constructor of the superclass. Here, the constructor of the superclass `AbstractShow` is called. This initializes the fields `aTitle` and `aTime`.
         */
        super(pTitle, pTime);
		aYear = pYear;
	}

	@Override
	public String description()
	{
		return String.format("%s (%d)", aTitle, aYear);
	}

    /*?
     * Keyword: @Override
     * The `@Override` annotation is used to indicate that a method overrides a method in a superclass. In this case, we are overriding the `extra()` method from the superclass `AbstractShow`. This ensures that the `extra()` method is always implemented in the same way, but the additional information is different for each subclass. The `extra()` method is called from within the `description()` method. This ensures that the description of the show is always in the same format.
     */
    @Override
    /*?
     * Keyword: protected
     * The method `extra()` is protected. This means that it can only be accessed from within the class itself or from a subclass. This is useful because we want to ensure that the `extra()` method is only called from within the `description()` method.
     * 
     * Keyword: extra
     * The method `extra()` adds the year of the movie. This is the additional information that is needed to describe a movie in the specified format of the `description()` method in the superclass `AbstractShow`.
     */
    protected String extra()
    {
        return "released in " + aYear;
    }

    @Override
    /*?
     * Keyword: clone
     * The clone() method creates a copy of the object and returns it as an Object. The clone() method must be overridden by the class that implements the Cloneable interface. This clone() method returns an object of type `Movie` by casting the result of the `super.clone()` method to type `Movie`. This is possible because the `super.clone()` method returns an object of type `Object`, which is the superclass of `Show`. Since `Movie` has only primitive and String fields, it can simply inherit the clone() method from `AbstractShow` - the call to `super.clone()` is actually a call to `Object.clone()`, which is implemented by the JVM which copies all the fields of the object no matter what the runtime type of the object is.
     */
    public Movie clone()
    {
        /*?
         * Keyword: (Movie)
         * We override the `clone()` method in the subclass `Movie` to return an object of type `Movie` by downcasting the result of the `super.clone()` method to type `Movie` so that clients can call the `clone()` method on an object of type `Movie` and get an object of type `Movie` back.
         */
        return (Movie) super.clone();
    }

}

/*?
 * Keyword: extends
 * extends is used to indicate that a class is a subclass of another class. Here, SponsoredConcert is the subclass of Concert, which itself is a subclass of AbstractShow so it inherits all the methods and fields from Concert and AbstractShow.
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

    @Override
    /*?
     * Keyword: extra
     * We override the `extra()` method from the superclass `Concert` to add the name of the sponsor to the description.
     */
    public String extra() {

        /*?
         * Keyword: super
         * super is used to call the `extra()` method of the superclass. Here, we call the `extra()` method of the superclass `Concert`. This ensures that the description of the show is always in the same format.
         */
        return super.extra() + " sponsored by " + aSponsor;
    }

    @Override
    /*?
     * Keyword: clone
     * The clone() method creates a copy of the object and returns it as an Object. The clone() method must be overridden by the class that implements the Cloneable interface. This clone() method returns an object of type `SponsoredConcert` by casting the result of the `super.clone()` method to type `SponsoredConcert`. This is possible because the `super.clone()` method returns an object of type `Object`, which is the superclass of `Show`. Since `SponsoredConcert` has only primitive and String fields, it can simply inherit the clone() method from `Concert` - the call to `super.clone()` is actually a call to `Object.clone()`, which is implemented by the JVM which copies all the fields of the object no matter what the runtime type of the object is.
     */
    public SponsoredConcert clone()
    {
        /*?
         * Keyword: (SponsoredConcert)
         * We override the `clone()` method in the subclass `SponsoredConcert` to return an object of type `SponsoredConcert` by downcasting the result of the `super.clone()` method to type `SponsoredConcert` so that clients can call the `clone()` method on an object of type `SponsoredConcert` and get an object of type `SponsoredConcert` back.
         */
        return (SponsoredConcert) super.clone();
    }
}
