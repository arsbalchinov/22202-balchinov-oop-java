import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {
    @Test
    public void testValid() {
        Validator validator = new Validator();
        assertTrue(validator.isValid(1023));
        assertTrue(validator.isValid(1234));
        assertTrue(validator.isValid(3612));
        assertTrue(validator.isValid(9582));
        assertTrue(validator.isValid(9876));
    }

    @Test
    public void testOutOfRange() {
        Validator validator = new Validator();
        assertFalse(validator.isValid(0));
        assertFalse(validator.isValid(987));
        assertFalse(validator.isValid(10234));
        assertFalse(validator.isValid(1234567890));
        assertFalse(validator.isValid(-10));
    }

    @Test
    public void testRepeatedDigits() {
        Validator validator = new Validator();
        assertFalse(validator.isValid(1000));
        assertFalse(validator.isValid(9999));
        assertFalse(validator.isValid(1337));
        assertFalse(validator.isValid(5292));
        assertFalse(validator.isValid(3493));
    }
}
