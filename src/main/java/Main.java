import static utils.PackageUtils.printAllPackages;
import static utils.PackageUtils.saveUsersInput;

public class Main {

    public static void main(final String[] args) {
        if (hasInitialPackages(args)) {
            // TODO: Initial packages from cmd. arg.
        }
        printAllPackages();
        saveUsersInput();
    }

    private static boolean hasInitialPackages(final String[] args) {
        return args.length != 0;
    }
}