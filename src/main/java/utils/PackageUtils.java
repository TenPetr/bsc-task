package utils;

import models.PackageInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;
import static utils.PackageConvertor.convertPackage;
import static utils.PackagePrinter.createPrintTask;
import static utils.PackageValidator.isPackageValid;

public class PackageUtils {

    private final static Logger LOGGER = Logger.getLogger(PackageUtils.class.getName());

    public static Map<String, Float> packages = new LinkedHashMap<>();

    private static final Timer timer = new Timer();

    private static final String RESOURCES = "resources/";
    private static final String QUIT = "quit";
    private static final int DELAY = 0;
    private static final int PERIOD = 60000;

    public static void printAllPackages() {
        try {
            timer.scheduleAtFixedRate(createPrintTask(), DELAY, PERIOD);
        } catch (final Exception ignored) { }
    }

    public static void saveUsersInput() {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

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
                LOGGER.log(Level.SEVERE, "Package format is not valid.");
                continue;
            }

            final PackageInfo packageInfo = convertPackage(input);
            createOrUpdateInfo(packageInfo);
        }
    }

    public static void loadInitialPackages(final String[] filenames) {
        for (final String filename : filenames) {
            try {
                final Stream<String> lines = Files.lines(Path.of(RESOURCES + filename));
                final Stream<String> filtered = lines.filter(PackageValidator::isPackageValid);
                filtered.map(PackageConvertor::convertPackage).forEach(PackageUtils::createOrUpdateInfo);
            } catch (final IOException ignored) {
                LOGGER.log(Level.SEVERE, "Error while loading initial packages.");
            }
        }
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

    private static void clearTimer() {
        timer.cancel();
        timer.purge();
    }
}
