package utils;

import java.util.TimerTask;

import static utils.PackageUtils.PACKAGES;

public class PackagePrinter {

    public static TimerTask createPrintTask() {
        return new TimerTask() {
            @Override
            public void run() {
                if (PACKAGES.size() != 0) {
                    System.out.println(PACKAGES.toString());
                }
            }
        };
    }
}
