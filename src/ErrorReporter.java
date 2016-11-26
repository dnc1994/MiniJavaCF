import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

public final class ErrorReporter {
    private static int errorCount = 0;

    public static boolean hasError() {
        return errorCount > 0;
    }

    public static void reportError(String msg) {
        errorCount += 1;
        System.err.println(msg);
    }

    public static void reportError(Token offendingToken, String msg) {
        errorCount += 1;
        System.err.println("line " + offendingToken.getLine() + ":" + offendingToken.getCharPositionInLine() + " error: " + msg);
        underlineError(offendingToken);
    }

    public static void reportError(ParserRuleContext ctx, String msg) {
        reportError(ctx.getStart(), msg);
    }

    public static void reportError(ParseTree tree, String msg) {
        reportError((ParserRuleContext)tree, msg);   
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
        System.err.println();

    }
}
