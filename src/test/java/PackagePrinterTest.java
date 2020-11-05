import org.junit.jupiter.api.Test;

import java.util.TimerTask;

import static org.assertj.core.api.Assertions.assertThat;

import static utils.PackagePrinter.createPrintTask;

public class PackagePrinterTest {

    @Test
    void createPrintTaskShouldReturnCorrectObject() {
        final TimerTask actual = createPrintTask();

        assertThat(actual).isNotNull();
    }
}
