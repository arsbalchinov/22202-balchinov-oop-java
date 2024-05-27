package Commands;
import Errors.StackUnderflowException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pop implements Command {
    private static final Logger logger = LoggerFactory.getLogger(Pop.class);
    @Override
    public void execute(String[] args, ExecutionContext ctx) throws StackUnderflowException {
        logger.info("Command POP is running");
        if (ctx.getStack().isEmpty()) {
            logger.error("Empty stack, impossible to execute POP command");
            throw new StackUnderflowException("Can't execute command with empty stack");
        }
        ctx.getStack().pop();
        logger.info("Command POP has been executed successfully");
    }
}