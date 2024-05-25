package Commands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Define implements Command {
    private static final Logger logger = LoggerFactory.getLogger(Define.class);
    @Override
    public void execute(String[] args, ExecutionContext ctx) {
        logger.info("Command DEFINE is running");
        ctx.getParameters().put(args[0], Double.valueOf(args[1]));
        logger.info("Command DEFINE has been executed successfully");
    }
}