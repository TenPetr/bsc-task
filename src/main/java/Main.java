import static utils.PackageUtils.*;

public class Main {

    public static void main(final String[] args) {
        if (hasInitialPackages(args)) {
            loadInitialPackages(args);
        }
        printAllPackages();
        saveUsersInput();
    }

    private static boolean hasInitialPackages(final String[] args) {
        return args.length != 0;
    }
}