package Commands;
import Errors.StackUnderflowException;
import java.util.Stack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Plus implements Command {
    private static final Logger logger = LoggerFactory.getLogger(Plus.class);
    @Override
    public void execute(String[] args, ExecutionContext ctx) throws StackUnderflowException {
        logger.info("Command PLUS is running");
        Stack<Double> stack = ctx.getStack();
        if (stack.size() < 2) {
            logger.error("Not enough arguments to execute PLUS command");
            throw new StackUnderflowException("Not enough arguments");
        }
        double v1 = stack.pop();
        double v2 = stack.pop();
        stack.push(v1 + v2);
        logger.info("Command PLUS has been executed successfully");
    }
}