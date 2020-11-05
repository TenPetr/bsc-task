import models.PackageInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static utils.PackageConvertor.convertPackage;

public class PackageConvertorTest {

    @Test
    void convertPackageShouldReturnCorrectObject() {
        final PackageInfo expected = new PackageInfo("12345", 122.34f);

        final PackageInfo actual = convertPackage("122.34 12345");

        assertEquals(actual.getPostalCode(), expected.getPostalCode());
        assertEquals(actual.getWeight(), expected.getWeight());
    }
}
