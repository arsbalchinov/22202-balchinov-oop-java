package Commands;
import Errors.StackUnderflowException;
import java.util.Stack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sub implements Command {
    private static final Logger logger = LoggerFactory.getLogger(Sub.class);
    @Override
    public void execute(String[] args, ExecutionContext ctx) throws StackUnderflowException {
        logger.info("Command SUB is running");
        Stack<Double> stack = ctx.getStack();
        if (stack.size() < 2) {
            logger.error("Not enough arguments to execute SUB command");
            throw new StackUnderflowException("Not enough arguments");
        }
        double v1 = stack.pop();
        double v2 = stack.pop();
        stack.push(v1 - v2);
        logger.info("Command SUB has been executed successfully");
    }
}