import java.io.*;
import Errors.*;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        Scanner scanner;
        if (args.length == 0) {
            logger.info("Calculator is running in console reading mode");
            scanner = new Scanner(System.in);
        }
        else {
            try {
                logger.info("Calculator is running in file reading mode");
                scanner = new Scanner(new FileInputStream(args[0]));
            }
            catch (FileNotFoundException e) {
                logger.error(e.getMessage());
                return;
            }
        }
        CommandFactory factory = new CommandFactory();
        StackCalculator calculator = new StackCalculator(factory);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("STOP")) {
                logger.info("Calculator has been stopped by \"STOP\"");
                System.out.println("Calculator has been stopped");
                return;
            }
            if (line.charAt(0) == '#') {
                continue;
            }
            try {
                calculator.execute(line);
            } catch (CommandException | DivisionByZeroException | StackUnderflowException e) {
                logger.error(e.getMessage());
            }

        }
        scanner.close();
        logger.info("Calculator has successfully completed its work at the end of the file");
    }
}