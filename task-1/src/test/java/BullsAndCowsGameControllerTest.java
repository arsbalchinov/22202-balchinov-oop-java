import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BullsAndCowsGameControllerTest {
    @Test
    public void bullsTest() {
        BullsAndCowsGameController bac = new BullsAndCowsGameController(1023);
        bac = bac.guess(4567);
        assertEquals(0, bac.getBulls());

        bac = new BullsAndCowsGameController(1357);
        bac = bac.guess(1023);
        assertEquals(1, bac.getBulls());

        bac = new BullsAndCowsGameController(2469);
        bac = bac.guess(9462);
        assertEquals(2, bac.getBulls());

        bac = new BullsAndCowsGameController(9876);
        bac = bac.guess(9876);
        assertEquals(4, bac.getBulls());
    }
    @Test
    public void cowsTest() {
        BullsAndCowsGameController bac = new BullsAndCowsGameController(1023);
        bac = bac.guess(4567);
        assertEquals(0, bac.getCows());

        bac = new BullsAndCowsGameController(6789);
        bac = bac.guess(6789);
        assertEquals(0, bac.getCows());

        bac = new BullsAndCowsGameController(4328);
        bac = bac.guess(8092);
        assertEquals(2, bac.getCows());

        bac = new BullsAndCowsGameController(9843);
        bac = bac.guess(4937);
        assertEquals(3, bac.getCows());

        bac = new BullsAndCowsGameController(6789);
        bac = bac.guess(9876);
        assertEquals(4, bac.getCows());
    }
}
