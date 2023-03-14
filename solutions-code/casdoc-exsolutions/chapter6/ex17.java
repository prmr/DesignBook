package chapter6;

import java.util.EnumMap;

/*?
 * Keyword: Command
 * We define a `Command` interface for the Command design pattern. The interface defines a single method `execute()` which is used to execute the command.
 * 
 * Internal: Command design pattern
 * Command
 * The Command design pattern is a design pattern that is used to encapsulate a request as an object. It is used to decouple the object that invokes the operation from the one that knows how to perform it. It is useful because it allows us to add new commands without changing the existing code, implement undo and redo functionality, and implement logging and transactional behavior. To implement the command design pattern, we define an interface that defines a single method `execute()` which is used to execute the command.
 */
interface Command
{
    /*?
     * Keyword: execute
     * We define a method `execute()` which is used to execute the command and is implemented by all concrete commands that implement the interface `Command`.
     */
	void execute();

    /*?
     * Keyword: undo
     * We define a method `undo()` which is used to undo the command and is implemented by all concrete commands that implement the interface `Command`.
     */
    void undo();
}

/*?
 * Keyword: CommandProcessor
 * We define a class `CommandProcessor` which is an abstraction of a command processor that allows clients to execute commands, store executed commads, and undo the last executed command. This design respects the Law of Demeter because it only calls methods on the object it is called on, and not on any of the object's fields.
 * 
 * Internal: Law of Demeter
 * CommandProcessor
 * The law of Demeter is a design principle that states that a method should only call methods on the object it is called on, and not on any of the object's fields. It is also known as the principle of least knowledge. It is useful because it reduces coupling between classes and makes code easier to understand and maintain. This design respects the law of Demeter because it only calls methods on the object it is called on, and not on any of the object's fields, for example the `execute()` method on the `Command` interface is called on the `Command` object `pCommand` and not on the `CommandProcessor` object `this`.
 */
public class CommandProcessor
{
    /*?
     * Keyword: aCommands
     * We define a list `aCommands` which is used to store executed commands so that they can be undone.
     */
   private final List<Command> aCommands = new ArrayList<>();
	
   /*?
    * Keyword: consume
    * We define a method `consume()` which is used to execute a command and store it in the list of executed commands. It takes a command as an argument, executes it, and stores it in the list of executed commands.
    */
   public void consume(Command pCommand)
   {
      pCommand.execute();
      aCommands.add(pCommand);
   }
   
   /**
    * @pre !aCommands.isEmpty()
    */
   /*?
    * Keyword: undoLast
    * We define a method `undoLast()` which is used to undo the last executed command. It removes the last command from the list of executed commands and calls the `undo()` method on it.
    */
   public void undoLast()
   {
      assert !aCommands.isEmpty();
      Command command = aCommands.remove(aCommands.size()-1); // remove last command from list of executed commands and store it in variable command
      command.undo(); // call undo() method on command
   }
}