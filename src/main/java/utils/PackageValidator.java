package utils;

public class PackageValidator {

    private static final String SPACE = " ";
    private static final String DOT = ".";
    private static final String DOT_REGEX = "\\.";
    private static final String NUMBERS = "[0-9]+";

    public static boolean isPackageValid(final String packageInfo) {
        if (isEmpty(packageInfo)) {
            return false;
        }

        if (!packageInfo.contains(SPACE)) {
            return false;
        }

        final String[] info = packageInfo.split(SPACE);

        if (containsMoreThanThreeDecimal(info[0])) {
            return false;
        }

        if (!hasPostalCodeCorrectFormat(info[1])) {
            return false;
        }

        try {
            final float weight = Float.parseFloat(info[0]);

            if (weight <= 0) {
                return false;
            }
        } catch (final NumberFormatException exception) {
            return false;
        }
        return true;
    }

    private static boolean isEmpty(final String input) {
        return input == null || input.trim().length() == 0;
    }

    private static boolean containsMoreThanThreeDecimal(final String input) {
        if (input.contains(DOT)) {
            if (input.split(DOT_REGEX).length != 2) {
                return true;
            }
            return input.split(DOT_REGEX)[1].length() > 3;
        }
        return false;
    }

    private static boolean hasPostalCodeCorrectFormat(final String input) {
        return input.length() == 5 && input.matches(NUMBERS);
    }
}
