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
interface Command {
    /*?
     * Keyword: execute
     * We define a method `execute()` which is used to execute the command and is implemented by all concrete commands that implement the interface `Command`.
     */
    void execute();

    /*?
     * Keyword: undo
     * We define a method `undo()` which is used to undo the command and is
     * implemented by all concrete commands that implement the interface `Command`.
     */
    void undo();
}

/*?
 * Keyword: CommandProcessor
 * We define a class `CommandProcessor` which is an abstraction of a command
 * processor that allows clients to execute commands, store executed commads,
 * undo the last executed command, and redoing commands. This design respects
 * the Law of Demeter because it only calls methods on the object it is called
 * on, and not on any of the object's fields.
 * 
 * Internal: Law of Demeter
 * CommandProcessor
 * The law of Demeter is a design principle that states that a method should
 * only call methods on the object it is called on, and not on any of the
 * object's fields. It is also known as the principle of least knowledge. It is
 * useful because it reduces coupling between classes and makes code easier to
 * understand and maintain. This design respects the law of Demeter because it
 * only calls methods on the object it is called on, and not on any of the
 * object's fields, for example the `execute()` method on the `Command`
 * interface is called on the `Command` object `pCommand` and not on the
 * `CommandProcessor` object `this`.
 */
public class CommandProcessor {
    /*?
     * Keyword: aExecutedCommands
     * We define a list `aExecutedCommands` which is used to store execute commands so that they can be undone.
     */
    private final List<Command> aExecutedCommands = new ArrayList<>();

    /*?
     * Keyword: aUndoneCommands
     * We define a list `aUndoneCommands` which is used to store undone commands so that they can be redone.
     */
    private final List<Command> aUndoneCommands = new ArrayList<>();

    /*?
     * Keyword: consume
     * We define a method `consume()` which is used to execute a command and store it in the list of executed commands. It takes a command as an argument, executes it, and stores it in the list of executed commands after it has been executed.
     */
    public void consume(Command pCommand) {
        pCommand.execute();
        aExecutedCommands.add(pCommand);
    }

    /**
     * @pre !aExecutedCommands.isEmpty()
     */
    /*?
     * Keyword: undoLast
     * We define a method `undoLast()` which is used to undo the last executed command. It removes the last command from the list of executed commands and calls the `undo()` method on it, and then adds it to the list of undone commands.
     */
    public void undoLast() {
        assert !aExecutedCommands.isEmpty();
        Command command = aExecutedCommands.remove(aExecutedCommands.size() - 1); // remove last command from list of executed commands
        command.undo(); // call undo() method on command
        aUndoneCommands.add(command); // add command to list of undone commands
    }

    /**
     * @pre !aUndoneCommands.isEmpty()
     */
    /*?
     * Keyword: redoLast
     * We define a method `redoLast()` which is used to redo the last undone command. It removes the last command from the list of undone commands and calls the `consume()` method on it, which executes the command and then adds it to the list of executed commands.
     */
    public void redoLast() {
        assert !aUndoneCommands.isEmpty();
        Command command = aUndoneCommands.remove(aUndoneCommands.size() - 1); // remove last command from list of undone commands
        consume(command); // call consume() method on command to execute it and add it to list of executed commands
    }
}