package Commands;

import Errors.*;

public interface Command {
    void execute(String[] args, ExecutionContext context)
            throws StackUnderflowException, DivisionByZeroException, CommandException;
}