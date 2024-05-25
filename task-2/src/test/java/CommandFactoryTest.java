import Commands.*;
import Errors.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CommandFactoryTest {
    @Test
    public void FactoryCommandsTest() {
        CommandFactory factory = new CommandFactory();
        try {
            assertInstanceOf(Pop.class, factory.createCommand("POP"));
            assertInstanceOf(Push.class, factory.createCommand("PUSH"));
            assertInstanceOf(Print.class, factory.createCommand("PRINT"));
            assertInstanceOf(Define.class, factory.createCommand("DEFINE"));
            assertInstanceOf(Plus.class, factory.createCommand("PLUS"));
            assertInstanceOf(Sub.class, factory.createCommand("SUB"));
            assertInstanceOf(Mul.class, factory.createCommand("MUL"));
            assertInstanceOf(Div.class, factory.createCommand("DIV"));
            assertInstanceOf(Sqrt.class, factory.createCommand("SQRT"));
        } catch (CommandException e) {
            System.out.println(e.getMessage());
        }
    }
}
