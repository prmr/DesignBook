
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

    /*?
     * Keyword: setTitle
     * setTitle is a method that can be used to set the title of the show. It takes a String as a parameter and sets the field `aTitle` to this value.
     */
    public void setTitle(String pTitle) {
        aTitle = pTitle;
    }

    public int time() {
        return aTime;
    }

    /**
     * setTime is a method that can be used to set the time of the show. It takes an int as a parameter and sets the field `aTime` to this value.
     * @param pTime
     * @pre pTime > 0
     */
    /*?
    * Keyword: setTime
    * setTime is a method that can be used to set the time of the show. It takes an int as a parameter and sets the field `aTime` to this value. The method is annotated with `@pre pTime > 0`. This means that the method expects the parameter `pTime` to be greater than 0. If this is not the case, an `AssertionError` is thrown.
    */
    public void setTime(int pTime) {
        assert pTime > 0;
        aTime = pTime;
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
    /*?
     * Keyword: setTitle
     * We override the `setTitle()` method from the superclass `AbstractShow` to prevent the title from being changed ecause the title of a movie does not change after its release. This is done by throwing an `UnsupportedOperationException`.
     */
    public void setTitle(String pTitle) {
        /*?
         * Keyword: UnsupportedOperationException
         * The `UnsupportedOperationException` is a runtime exception that is thrown when an operation is not supported. In this case, the operation is setting the title of a movie.
         */
        throw new UnsupportedOperationException();
    }

    @Override
    /**
    * setTime is a method that can be used to set the time of the movie. It takes an int as a parameter and sets the field `aTime` to this value.
    * @param pTime
    * @pre pTime > 10
    */
    /*?
    * Keyword: setTime
    * setTime is a method that can be used to set the time of the movie. It takes an int as a parameter and sets the field `aTime` to this value. The method is annotated with `@pre pTime > 10`. This means that the method expects the parameter `pTime` to be greater than 0. If this is not the case, an `AssertionError` is thrown.
    */
    public void setTime(int pTime) {
        assert pTime > 10;
        aTime = pTime;
    }

	@Override
	public String description()
	{
		return String.format("%s (%d)", aTitle, aYear);
	}

}
