package utils;

import models.PackageInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Timer;

import static java.util.stream.Collectors.toMap;
import static utils.PackageConvertor.convertPackage;
import static utils.PackagePrinter.createPrintTask;
import static utils.PackageValidator.isPackageValid;

public class PackageUtils {

    public static Map<String, Float> packages = new LinkedHashMap<>();

    private static final Timer timer = new Timer();

    private static final String QUIT = "quit";
    private static final int DELAY = 0;
    private static final int PERIOD = 60000;

    public static void printAllPackages() {
        try {
            timer.scheduleAtFixedRate(createPrintTask(), DELAY, PERIOD);
        } catch (Exception ignored) { }
    }

    public static void saveUsersInput() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please, enter package code. Type 'quit' to exit the app.");

        while (true) {
            String input = "";
            try {
                input = reader.readLine();
            } catch (final IOException ignored) { }

            if (input.toLowerCase().equals(QUIT)) {
                clearTimer();
                break;
            }

            if (!isPackageValid(input)) {
                System.out.println("Package format is not valid.");
                continue;
            }

            final PackageInfo packageInfo = convertPackage(input);
            createOrUpdateInfo(packageInfo);
        }
    }

    private static void clearTimer() {
        timer.cancel();
        timer.purge();
    }

    private static void createOrUpdateInfo(final PackageInfo packageInfo) {
        Float updatedPackage = packages.computeIfPresent(
                packageInfo.getPostalCode(), (k, v) -> v + packageInfo.getWeight());
        if (updatedPackage == null) {
            packages.put(packageInfo.getPostalCode(), packageInfo.getWeight());
        }
        packages = sortPackages();
    }

    private static LinkedHashMap<String, Float> sortPackages() {
        return packages.entrySet().stream()
                .sorted(Map.Entry.<String, Float>comparingByValue().reversed())
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}
