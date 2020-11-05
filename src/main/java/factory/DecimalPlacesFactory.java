package factory;

public class DecimalPlacesFactory {

    private static final String DOT = ".";
    private static final String DOT_REGEX = "\\.";

    public static String addDecimalPlaces(final Float original) {
        final String converted = String.valueOf(original);

        if (!converted.contains(DOT)) {
            return converted + ".000";
        }

        final String[] parts = converted.split(DOT_REGEX);

        if (parts[1].length() == 1) {
            return converted + "00";
        }

        if (parts[1].length() == 2) {
            return converted + "0";
        }

        return converted;
    }
}
