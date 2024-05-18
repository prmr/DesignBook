/*******************************************************************************
 * Companion code for the book "Introduction to Software Design with Java",
 * 2nd edition by Martin P. Robillard.
 *
 * Copyright (C) 2022 by Martin P. Robillard
 *
 * This code is licensed under a Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * 
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 * 
 *******************************************************************************/
package chapter8;

import java.util.List;
import java.util.ArrayList;

public class CommandProcessor {
    private final List<Command> aCommands = new ArrayList<Command>();
    private final List<Command> aUndoneCommands = new ArrayList<Command>();

    public CommandProcessor() {

    }

    public void add(Command pCommand) {
        pCommand.execute();
        aCommands.add(pCommand);
    }

    public void undoLast() {
        assert !aCommands.isEmpty();
        Command command = aCommands.remove(aCommands.size()-1);
        command.undo();
        aUndoneCommands.add(command);
    }

    public void redo() {
        assert !aUndoneCommands.isEmpty();
        Command command = aUndoneCommands.remove(aCommands.size()-1);
        add(command);
    }
}
