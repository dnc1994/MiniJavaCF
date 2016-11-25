public final class ErrorReporter {
    private static int errorCount = 0;

    public static boolean hasError() {
        return errorCount > 0;
    }

    public static void reportError() {
        System.err.println(msg);
    }

    public static void exitOnError(String msg) {
        if hasError() {
            System.exit(1);
        }
    }
}
