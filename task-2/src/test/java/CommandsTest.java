import Commands.*;
import Errors.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CommandsTest {
    private final ExecutionContext ctx = new ExecutionContext();
    @Test
    public void plusTest() {
        Command command = new Plus();
        ctx.getStack().push(5.0);
        ctx.getStack().push(2.0);
        try {
            command.execute(null, ctx);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        double res = ctx.getStack().pop();
        assertEquals(7.0, res);
    }

    @Test
    public void subTest() {
        Command command = new Sub();
        ctx.getStack().push(2.0);
        ctx.getStack().push(5.0);
        try {
            command.execute(null, ctx);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        double res = ctx.getStack().pop();
        assertEquals(3.0, res);
    }

    @Test
    public void mulTest() {
        Command command = new Mul();
        ctx.getStack().push(2.0);
        ctx.getStack().push(2.5);
        try {
            command.execute(null, ctx);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        double res = ctx.getStack().pop();
        assertEquals(5.0, res);
    }

    @Test
    public void divTest() {
        Command command = new Div();
        ctx.getStack().push(5.0);
        ctx.getStack().push(50.0);
        try {
            command.execute(null, ctx);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        double res = ctx.getStack().pop();
        assertEquals(10.0, res);

        ctx.getStack().push(0.0);
        ctx.getStack().push(5.0);
        assertThrows(DivisionByZeroException.class, () -> command.execute(null, ctx));
    }

    @Test
    public void sqrtTest() {
        Command command = new Sqrt();
        ctx.getStack().push(25.0);
        String[] parameters = new String[0];
        try {
            command.execute(parameters, ctx);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        double res = ctx.getStack().pop();
        assertEquals(5.0, res);
    }

    @Test
    public void sinusTest() {
        Command command = new Sinus();
        ctx.getStack().push(1.57079);
        try {
            command.execute(null, ctx);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        double res = ctx.getStack().pop();
        assertEquals(1.0, res, 0.0001);
    }

    @Test
    public void defineTest(){
        Command command = new Define();
        String[] parameters = new String[2];
        parameters[0] = "a";
        parameters[1] = "5";
        try {
            command.execute(parameters, ctx);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertTrue(ctx.getParameters().containsKey("a"));
        assertEquals(ctx.getParameters().get("a"), 5.0);
    }

    @Test
    public void definePushTest() {
        Command define = new Define();
        Command push = new Push();
        String[] parameters = new String[2];
        parameters[0] = "a";
        parameters[1] = "10";
        try {
            define.execute(parameters, ctx);
            push.execute(parameters, ctx);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        try {
            double res = ctx.getStack().pop();
            assertEquals(10.0, res);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
