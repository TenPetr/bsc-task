package utils;

import models.PackageInfo;

public class PackageConvertor {

    private static final String SPACE = " ";

    public static PackageInfo convertPackage(final String rawPackage) {
        final String[] info = rawPackage.split(SPACE);
        final String postalCode = info[1];
        final Double weight = Double.parseDouble(info[0]);

        return new PackageInfo(postalCode, weight);
    }
}
