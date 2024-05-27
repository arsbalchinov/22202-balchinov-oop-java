package Commands;
import Errors.StackUnderflowException;

import java.util.Stack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sinus implements Command {
    private static final Logger logger = LoggerFactory.getLogger(Sinus.class);
    @Override
    public void execute(String[] args, ExecutionContext ctx) throws StackUnderflowException {
        logger.info("Command SINUS is running");
        Stack<Double> stack = ctx.getStack();
        if (stack.isEmpty()) {
            logger.error("Empty stack, impossible to execute SINUS command");
            throw new StackUnderflowException("Can't execute command with empty stack");
        }
        double v1 = stack.pop();

        stack.push(Math.sin(v1));
        logger.info("Command SINUS has been executed successfully");
    }
}