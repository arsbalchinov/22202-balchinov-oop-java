package Commands;
import Errors.StackUnderflowException;
import java.util.Stack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sqrt implements Command {
    private static final Logger logger = LoggerFactory.getLogger(Sqrt.class);
    @Override
    public void execute(String[] args, ExecutionContext ctx) throws StackUnderflowException, ArithmeticException {
        logger.info("Command SQRT is running");
        Stack<Double> stack = ctx.getStack();
        if (stack.isEmpty()) {
            logger.error("Empty stack, impossible to execute SQRT command");
            throw new StackUnderflowException("Can't execute command with empty stack");
        }
        double v1 = stack.pop();
        if (v1 < 0) {
            logger.error("Attempt to take the square root of a negative number");
            throw new ArithmeticException("Can't take the square root of a negative number");
        }
        stack.push(Math.sqrt(v1));
        logger.info("Command SQRT has been executed successfully");
    }
}