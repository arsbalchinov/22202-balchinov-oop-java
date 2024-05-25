package Commands;
import Errors.StackUnderflowException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Print implements Command {
    private static final Logger logger = LoggerFactory.getLogger(Print.class);
    @Override
    public void execute(String[] args, ExecutionContext ctx) throws StackUnderflowException {
        logger.info("Command PRINT is running");
        if (ctx.getStack().isEmpty()) {
            logger.error("Stack is empty, impossible to execute PRINT command");
            throw new StackUnderflowException("The stack is empty");
        }
        System.out.println(ctx.getStack().peek());
        logger.info("Command PRINT has been executed successfully");
    }
}