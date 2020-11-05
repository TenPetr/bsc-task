package utils;

import java.util.TimerTask;

import static utils.PackageUtils.packages;

public class PackagePrinter {

    private static final String FORMAT = "%.3f";
    private static final String TARGET = ",";
    private static final String REPLACEMENT = ".";

    public static TimerTask createPrintTask() {
        return new TimerTask() {
            @Override
            public void run() {
                if (packages.size() != 0) {
                    System.out.println("----------------");
                    packages.forEach(
                            (k, v) -> System.out.println(
                                    k + " " + String.format(FORMAT, v).replace(TARGET, REPLACEMENT)));
                    System.out.println("----------------");
                }
            }
        };
    }
}
