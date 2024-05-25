package Commands;
import Errors.DivisionByZeroException;
import Errors.StackUnderflowException;
import java.util.Stack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Div implements Command  {
    private static final Logger logger = LoggerFactory.getLogger(Div.class);
    @Override
    public void execute(String[] args, ExecutionContext ctx) throws StackUnderflowException, DivisionByZeroException {
        logger.info("Command DIV is running");
        Stack<Double> stack = ctx.getStack();
        if (stack.size() < 2) {
            logger.error("Not enough arguments to execute DIV command");
            throw new StackUnderflowException("Not enough arguments");
        }
        double v1 = stack.pop();
        double v2 = stack.pop();
        if (v2 == 0) {
            logger.error("Division by zero: {} / {}", v1, v2);
            throw new DivisionByZeroException("Division by zero: " + v1 + " / " + v2);
        }
        stack.push(v1 / v2);
        logger.info("Command DIV has been executed successfully");
    }
}