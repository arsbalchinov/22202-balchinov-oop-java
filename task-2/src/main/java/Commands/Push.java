package Commands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Push implements Command {
    private static final Logger logger = LoggerFactory.getLogger(Push.class);
    @Override
    public void execute(String[] args, ExecutionContext ctx) {
        logger.info("Command PUSH is running");
        if (Character.isAlphabetic(args[0].charAt(0))){
            ctx.getStack().push(ctx.getParameters().get(args[0]));
        } else {
            ctx.getStack().push(Double.valueOf(args[0]));
        }
        logger.info("Command PUSH has been executed successfully");
    }
}