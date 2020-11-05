import Utils.PackageValidator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PackageValidatorTest {

    private static Stream<String> badInputs() {
        return Stream.of(
                "", " ", null, "123.1234 12345", "123.12 12", "test",
                "test test", "12.test 1234", "-12.23 12345",
                "123.x12 12345", "0 12345", "123.124 12x45");
    }

    private static Stream<String> correctInputs() {
        return Stream.of("12 12345", "12.123 12345", "121212.1 12345", "123.12 12345", "123456 12345");
    }

    @ParameterizedTest
    @MethodSource("badInputs")
    void isPackageValidShouldReturnFalseWhenInputsAreNotValid(final String input) {
        final boolean actual = PackageValidator.isPackageValid(input);

        assertFalse(actual);
    }

    @ParameterizedTest
    @MethodSource("correctInputs")
    void isPackageValidShouldReturnTrueWhenInputsAreValid(final String input) {
        final boolean actual = PackageValidator.isPackageValid(input);

        assertTrue(actual);
    }
}
