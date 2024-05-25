package Commands;
import Errors.StackUnderflowException;
import java.util.Stack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mul implements Command {
    private static final Logger logger = LoggerFactory.getLogger(Mul.class);
    @Override
    public void execute(String[] args, ExecutionContext ctx) throws StackUnderflowException {
        logger.info("Command MUL is running");
        Stack<Double> stack = ctx.getStack();
        if (stack.size() < 2) {
            logger.error("Not enough arguments to execute MUL command");
            throw new StackUnderflowException("Not enough arguments");
        }
        double v1 = stack.pop();
        double v2 = stack.pop();
        stack.push(v1 * v2);
        logger.info("Command MUL has been executed successfully");
    }
}