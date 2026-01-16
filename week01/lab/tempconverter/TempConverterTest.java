package week01.lab.tempconverter;
import static org.junit.Assert.*;
import org.junit.Test;

public class TempConverterTest {
    @Test
    public void testNormalConversion() {
        TempConverter tc = new TempConverter();
        assertEquals(32, tc.toFahrenheit(0), 0.0001);
        // expected result -> 32, actual result -> tc.toFahrenheit(0), tolerance -> 0.0001
    }

    @Test
    public void testNegativeValue() {
        TempConverter tc = new TempConverter();
        assertEquals(-40, tc.toFahrenheit(-40), 0.0001);
        // expected result -> 40, actual result -> tc.toFahrenheit(-40), tolerance -> 0.0001
    }

    @Test(expected = IllegalArgumentException.class) // test passes if IllegalArgumentException is thrown
    public void testExceptionCase() {
        TempConverter tc = new TempConverter();
        tc.toFahrenheit(-300); // expected to throw IllegalArgumentException
    }
}
