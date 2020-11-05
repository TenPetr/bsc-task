package utils;

import java.util.TimerTask;

import static factory.DecimalPlacesFactory.addDecimalPlaces;
import static utils.PackageUtils.packages;

public class PackagePrinter {

    public static TimerTask createPrintTask() {
        return new TimerTask() {
            @Override
            public void run() {
                if (packages.size() != 0) {
                    System.out.println("----------------");
                    packages.forEach((k, v) -> System.out.println(k + " " + addDecimalPlaces(v)));
                    System.out.println("----------------");
                }
            }
        };
    }
}
