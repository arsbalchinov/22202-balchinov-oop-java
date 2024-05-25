import Commands.*;
import Errors.*;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StackCalculator {
    private static final Logger logger = LoggerFactory.getLogger(StackCalculator.class);
    private final ExecutionContext context;
    private final CommandFactory factory;

    public StackCalculator(CommandFactory factory) {
        this.context = new ExecutionContext();
        this.factory = factory;
    }
    public void execute(String line) throws CommandException, DivisionByZeroException, StackUnderflowException {
        String[] parsed = line.split(" ");
        String[] parameters = Arrays.copyOfRange(parsed, 1, parsed.length);
        Command command = null;
        command = factory.createCommand(parsed[0]);
        if (command != null) {
            try {
                command.execute(parameters, context);
            } catch (CommandException e) {
                throw new CommandException("Impossible to execute command");
            } catch (StackUnderflowException e) {
                throw new StackUnderflowException("Stack Underflow");
            }
            logger.debug("{} was executed.", parsed[0]);
        }
    }
}
