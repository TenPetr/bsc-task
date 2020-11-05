import org.junit.jupiter.api.Test;

import static factory.DecimalPlacesFactory.addDecimalPlaces;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecimalPlacesFactory {

    @Test
    void addDecimalPlacesShouldAddDotAndThreeZeros() {
        final String expected = "123.000";

        final String actual = addDecimalPlaces(123f);

        assertEquals(expected, actual);
    }

    @Test
    void addDecimalPlacesShouldAddTwoZeros() {
        final String expected = "123.400";

        final String actual = addDecimalPlaces(123.4f);

        assertEquals(expected, actual);
    }

    @Test
    void addDecimalPlacesShouldAddOneZeros() {
        final String expected = "123.450";

        final String actual = addDecimalPlaces(123.45f);

        assertEquals(expected, actual);
    }

    @Test
    void addDecimalPlacesShouldReturnConvertedValue() {
        final String expected = "123.458";

        final String actual = addDecimalPlaces(123.458f);

        assertEquals(expected, actual);
    }
}
