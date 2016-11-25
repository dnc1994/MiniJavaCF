/***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
***/
// import ANTLR's runtime libraries
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.*;

public class Main {
    public static String[] inputLines;

    public static void main(String[] args) throws Exception {
        // create a CharStream that reads from standard input
        ANTLRInputStream input = new ANTLRInputStream(System.in);

        SyntaxErrorListener syntaxErrorListener = new SyntaxErrorListener();

        // create a lexer that feeds off of input CharStream
        MiniJavaLexer lexer = new MiniJavaLexer(input);

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        MiniJavaParser parser = new MiniJavaParser(tokens);

        // customized error reporting
        inputLines = input.toString().split("\n");
        parser.removeErrorListeners();
        parser.addErrorListener(syntaxErrorListener);

        ParseTree tree = parser.goal(); // begin parsing at init rule
        System.out.println(tree.toStringTree(parser) + "\n-----"); // print LISP-style tree

        ParseTreeWalker walker = new ParseTreeWalker();

        // 1st pass
        Map<String, Class> classes = new HashMap<String, Class>();
        ScopeBuilder scopeBuilder = new ScopeBuilder(classes);
        walker.walk(scopeBuilder, tree);
        ErrorReporter.exitOnErrors();

        // 2nd pass
        SymbolChecker symbolChecker = new SymbolChecker(classes);
        walker.walk(symbolChecker, tree);
        ErrorReporter.exitOnErrors();
        // check for cyclic inheritence
        symbolChecker.checkCyclicInheritence();
        ErrorReporter.exitOnErrors();

        // 3rd pass
        TypeChecker typeChecker = new TypeChecker(classes);
        walker.walk(typeChecker, tree);
        ErrorReporter.exitOnErrors();

        // System.out.println(classes.get("Foo").getSymbols());
        // Method method = (Method)classes.get("Foo").getSymbols().get("Excite");
        // System.out.println(method.getParams());
    }
}
