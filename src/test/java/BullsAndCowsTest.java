import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BullsAndCowsTest {
    @Test
    public void bullsTest() {
        BullsAndCows bac = new BullsAndCows(1023, 4567);
        assertEquals(0, bac.getBulls());

        bac = new BullsAndCows(1357, 1023);
        assertEquals(1, bac.getBulls());

        bac = new BullsAndCows(2469, 9462);
        assertEquals(2, bac.getBulls());

        bac = new BullsAndCows(9876, 9876);
        assertEquals(4, bac.getBulls());
    }
    @Test
    public void cowsTest() {
        BullsAndCows bac = new BullsAndCows(1023, 4567);
        assertEquals(0, bac.getCows());

        bac = new BullsAndCows(6789, 6789);
        assertEquals(0, bac.getCows());

        bac = new BullsAndCows(4328, 8092);
        assertEquals(2, bac.getCows());

        bac = new BullsAndCows(9843, 4937);
        assertEquals(3, bac.getCows());

        bac = new BullsAndCows(6789, 9876);
        assertEquals(4, bac.getCows());
    }
}
