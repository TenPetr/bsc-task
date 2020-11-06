import static utils.PackageUtils.*;

public class Main {

    public static void main(final String[] args) {
        System.out.println("Please, enter information about packages");
        if (hasInitialPackages(args)) {
            loadInitialPackages(args);
        }
        printAllPackages();
        processUsersInput();
    }

    private static boolean hasInitialPackages(final String[] args) {
        return args.length != 0;
    }
}