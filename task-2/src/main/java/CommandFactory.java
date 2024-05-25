import Errors.*;
import Commands.*;
import java.io.InputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommandFactory {
    private static final Logger logger = LoggerFactory.getLogger(CommandFactory.class);
    private final HashMap<String, Command> commandsList = new HashMap<>();

    public CommandFactory() {
        String configFile = "/factory.cfg";
        InputStream inputStream = CommandFactory.class.getResourceAsStream(configFile);
        if (inputStream == null) {
            logger.error("Cfg file was not found");
            return;
        }

        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            for (String name : properties.stringPropertyNames()) {
                String fullName = properties.getProperty(name);
                commandsList.put(name, (Command) Class.forName(fullName).getDeclaredConstructor().newInstance());
            }
        } catch (IOException e) {
            logger.error("Exec cfg error");
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public Command createCommand(String commandName) throws CommandException {
        if (commandsList.containsKey(commandName)) {
            return commandsList.get(commandName);
        }
        else {
            throw new CommandException("No such command: " + commandName);
        }
    }
}