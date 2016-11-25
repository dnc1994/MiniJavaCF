import org.antlr.v4.runtime.*;

public final class ErrorReporter {
    private static int errorCount = 0;

    public static boolean hasError() {
        return errorCount > 0;
    }

    public static void reportError(String msg) {
        errorCount += 1;
        System.err.println(msg);
    }

    public static void exitOnErrors() {
        if (hasError()) {
            System.out.println(errorCount + " errors found.");
            // todo: change this to 1
            System.exit(0);
        }
    }

    public static void underlineError(Token offendingToken) {
        String errorLine = Main.inputLines[offendingToken.getLine() - 1];
        System.err.println(errorLine);
        for (int i = 0; i < offendingToken.getCharPositionInLine(); i ++)
            System.err.print(" ");
        int start = offendingToken.getStartIndex();
        int stop = offendingToken.getStopIndex();
        if (start >= 0 && stop >= 0) {
            for (int i = start; i <= stop; i ++) System.err.print("^");
        }

    }
}
