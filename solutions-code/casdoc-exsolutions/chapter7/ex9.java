
/*?
 * Keyword: abstract class
 * An abstract class is a class that cannot be instantiated. It can only be used as a superclass. This is useful when you want to share some functionality between subclasses, but you don't want to instantiate the class itself.
 */
public abstract class AbstractShow implements Show {

    private String aTitle;
    private int aTime;

    /*?
     * Keyword: aRecommended
     * Show instances can hold a reference to a "recommended" show.
     */
    private Show aRecommended;

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

    /*?
     * Keyword: getRecommended
     * Returns the recommended show for this show instance.
     */
    public Show getRecommended() {
        return aRecommended;
    }

    /*?
     * Keyword: setRecommended
     * Sets the recommended show for this show instance by taking the show as a parameter `pShow`.
     */
    public void setRecommended(Show pShow) {
        aRecommended = pShow;
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

    /*?
     * Keyword: @Override
     * The `@Override` annotation is used to indicate that a method overrides a method in a superclass. In this case, we are overriding the `getRecommended()` method from the superclass `AbstractShow` to return a `Movie` instead of a `Show` for Movie instances. Covariant return types are allowed in Java 5 and later. This means that a subclass can return a more specific type than the superclass. In this case, the `Movie` class is a subclass of the `AbstractShow` class, so it is a valid substitution for the `AbstractShow` class. This does not violate the Liskov Substitution Principle (LSP). It is always possible to assign a reference to a more specific type where a more general one is expected. This is useful because it allows us to return a `Movie` instead of a `Show` for Movie instances.
     * 
     * Internal: Liskov Substitution Principle (LSP)
     * @Override
     * The Liskov Substitution Principle (LSP) states that a subclass should be able to substitute for its superclass. This means that a subclass should be able to be used wherever its superclass is used. In this case, the `Movie` class is a subclass of the `AbstractShow` class, so it is a valid substitution for the `AbstractShow` class. This does not violate the Liskov Substitution Principle (LSP) because the `Movie` class is a subclass of the `AbstractShow` class.
     */
    @Override
    public Movie getRecommended()
    {
        return aRecommended;
    }

    /*?
     * Keyword: setRecommended
     * Sets the recommended movie for this movie instance by taking the movie as a parameter `pMovie`. This method overloads the `setRecommended()` method from the superclass `AbstractShow`. This is useful because we want to ensure that the recommended Show for a movie instance is always a movie object. This is not possible if we use the `setRecommended()` method from the superclass `AbstractShow` because it takes a `Show` as a parameter. It does not violate the Liskov Substitution Principle (LSP) because the `Movie` class is a subclass of the `AbstractShow` class. It is always possible to assign a reference to a more specific type where a more general one is expected. This is useful because it allows us to return a `Movie` instead of a `Show` for Movie instances. There is no dynamic binding for this method, as the target overloaded version is determined at compile time based on the type of the argument.
     * 
     * Internal: Liskov Substitution Principle (LSP)
     * setRecommended
     * The Liskov Substitution Principle (LSP) states that a subclass should be able to substitute for its superclass. This means that a subclass should be able to be used wherever its superclass is used. In this case, the `Movie` class is a subclass of the `AbstractShow` class, so it is a valid substitution for the `AbstractShow` class. This does not violate the Liskov Substitution Principle (LSP) because the `Movie` class is a subclass of the `AbstractShow` class.
     * 
     * Internal: dynamic binding
     * setRecommended
     * Dynamic binding is the process of selecting the actual implementation of a method at runtime. This is useful because it allows us to call the correct implementation of a method at runtime. In this case, the target overloaded version is determined at compile time based on the type of the argument. This means that the correct implementation of the `setRecommended()` method is called at compile time based on the type of the argument. For example, if the argument is a `Movie` object, the `setRecommended()` method from the `Movie` class is called. If the argument is a `Show` object, the `setRecommended()` method from the `AbstractShow` class is called. This does not violate the Liskov Substitution Principle (LSP).
     * 
     * Internal: target overloaded version
     * setRecommended
     * The target overloaded version is the version of the overloaded method that is called at runtime.
     * 
     * Internal: compile time
     * setRecommended
     * Compile time is the time when the source code is compiled into bytecode by the Java compiler.
     */
    public void setRecommended(Movie pMovie)
    {
        aRecommended = pMovie;
    }

    public static void main(String[] args) {
        // Create 2 movie instances and set the recommended movie for the second movie instance.
        Movie movie1 = new Movie("Metropolis", 1927, 153);
        Movie movie2 = new Movie("The Good, the Bad, and the Ugly", 1966, 178);
        /*?
         * Keyword: setRecommended
         * Here, setRecommended(Movie) will be selected instead of setRecommended(Show) because the argument is a `Movie` object. The target overloaded version is determined at compile time based on the type of the argument.
         */
        movie2.setRecommended(movie1);

        // Get the recommended movie for the second movie instance.
        /*?
         * Keyword: getRecommended
         * Here, it possible to assign a reference to a more specific type where a more general one is expected.
         */
        Show recommended = movie2.getRecommended(); 

    }

}
