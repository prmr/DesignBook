import java.util.Comparator;


public class Game
{
    /*?
     * Keyword: NULL_COMPARATOR
     * `Comparator<Card>` is a generic type. A comparator is an object that can compare two objects of the same type and it is used to sort collections of objects. We create an anonymous comparator that always returns 0. Using a named null object can help clarify the role of the anonymous comparator. Additionally, this provides a clean way to dynamically check if the aComparator field has been initialized with a value other than the default "null" comparator.
     * 
     * Internal: anonymous comparator
     * NULL_COMPARATOR
     * An anonymous comparator is a comparator that is created without a name. We use an anonymous class to create an anonymous comparator.
     */
   private static final Comparator<Card> NULL_COMPARATOR = new Comparator<Card>() {
    /*?
     * Keyword: compare
     * The compare method is used to compare two objects of the same type. Here we are using the Null Object Pattern to create a comparator that always returns 0 because when class `Game` is initialized, the comparison order is undefined. This comparator always returns objects as equal. The compare method is required by the `Comparator<T>` interface.
     * 
     * Internal: Null Object Pattern
     * compare
     * The Null Object Pattern is a design pattern that is used to create a null object that can be used in place of a null reference. The null object is used to avoid NullPointerExceptions. This is consistent with the notion that the comparison order is initially undefined.
     */
      public int compare(Card pCard1, Card pCard2)
      {
         return 0;
      }};
   private Comparator<Card> aComparator = NULL_COMPARATOR;
}