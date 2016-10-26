/***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
***/
import org.antlr.v4.runtime.*;
import java.util.*;

public class SyntaxErrorListener extends BaseErrorListener {
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg,
                            RecognitionException e)
    {
        // List<String> stack = ((Parser)recognizer).getRuleInvocationStack();
        // Collections.reverse(stack);
        // System.err.println("rule stack: "+stack);
        // System.err.println("line "+line+":"+charPositionInLine+" at "+
        //                    offendingSymbol+": "+msg);

        System.err.println("syntax error at line " + line + ":" + charPositionInLine + " -> " + msg);
        underlineError(recognizer, (Token)offendingSymbol, line, charPositionInLine);
        System.err.println();
    }

    protected void underlineError(Recognizer recognizer, Token offendingToken,
                                  int line, int charPositionInLine) {
        CommonTokenStream tokens = (CommonTokenStream)recognizer.getInputStream();
        String input = tokens.getTokenSource().getInputStream().toString();
        String[] lines = input.split("\n");
        String errorLine = lines[line - 1];

        System.err.println(errorLine);
        for (int i = 0; i < charPositionInLine; i ++) System.err.print(" ");
        int start = offendingToken.getStartIndex();
        int stop = offendingToken.getStopIndex();
        if (start >= 0 && stop >= 0) {
            for (int i = start; i <= stop; i ++) System.err.print("^");
        }

    }

}
