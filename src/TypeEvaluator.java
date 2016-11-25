import org.antlr.v4.runtime.*;
import java.util.*;

public class TypeEvaluator extends MiniJavaBaseVisitor<String> {
    private TypeChecker typeChecker;

    public TypeEvaluator(TypeChecker typeChecker) {
        this.typeChecker = typeChecker;
    }

    @Override
    public String visitExpression(MiniJavaParser.ExpressionContext ctx) {
        if (ctx.orExpr() != null)
            return visit(ctx.orExpr());
        else if (ctx.andExpr() != null)
            return visit(ctx.andExpr());
        else if (ctx.compareExpr() != null)
            return visit(ctx.compareExpr());
        else if (ctx.sumExpr() != null)
            return visit(ctx.sumExpr());
        else if (ctx.productExpr() != null)
            return visit(ctx.productExpr());
        else if (ctx.atom() != null)
            return visit(ctx.atom());
        // Should never reach here
        return null;
    }
    
    @Override
    public String visitOrExpr(MiniJavaParser.OrExprContext ctx) {
        String left = visit(ctx.getChild(0));
        String right = visit(ctx.getChild(2));
        // System.out.println("visiting or expression: " + left + " || " + right);
        if (!left.equals("boolean") || !right.equals("boolean")) {
            ErrorReporter.reportError(ctx, "Only boolean support logical or.");
            return "<Type Error>";
        }
        return "boolean";
    }

    @Override
    public String visitAndExpr(MiniJavaParser.AndExprContext ctx) {
        String left = visit(ctx.getChild(0));
        String right = visit(ctx.getChild(2));
        if (!left.equals("boolean") || !right.equals("boolean")) {
            ErrorReporter.reportError(ctx, "Only boolean support logical or.");
            return "<Type Error>";
        }
        return "boolean";
    }

    @Override public String visitCompareExpr(MiniJavaParser.CompareExprContext ctx) { 
        String left = visit(ctx.getChild(0));
        String right = visit(ctx.getChild(2));
        if (!left.equals("int") || !right.equals("int")) {
            ErrorReporter.reportError(ctx, "Only int support comparison.");
            return "<Type Error>";
        }
        return "boolean";
    }
    
    @Override public String visitSumExpr(MiniJavaParser.SumExprContext ctx) {
        String left = visit(ctx.getChild(0));
        String right = visit(ctx.getChild(2));
        if (!left.equals("int") || !right.equals("int")) {
            ErrorReporter.reportError(ctx, "Only int support addition.");
            return "<Type Error>";
        }
        return "int";
    }
    
    @Override public String visitProductExpr(MiniJavaParser.ProductExprContext ctx) {
        String left = visit(ctx.getChild(0));
        String right = visit(ctx.getChild(2));
        if (!left.equals("int") || !right.equals("int")) {
            ErrorReporter.reportError(ctx, "Only int support multiplication.");
            return "<Type Error>";
        }
        return "int";
    }
    
    @Override public String visitCallList(MiniJavaParser.CallListContext ctx) { return visitChildren(ctx); }
    
    @Override public String visitRightValue(MiniJavaParser.RightValueContext ctx) { return visitChildren(ctx); }
    
    @Override
    public String visitAtom(MiniJavaParser.AtomContext ctx) {
        // System.out.println(ctx.getText());
        if (ctx.Int() != null)
            return "int";
        else if (ctx.Bool() != null)
            return "boolean";
        else if (ctx.array() != null) {
            String arrayType = visit(ctx.array());
            if (!arrayType.equals("int[]")) {
                if (ctx.atom() == null)
                    ErrorReporter.reportError(ctx, "Only array has .length method.");
                else
                    ErrorReporter.reportError(ctx, "Only array support [] indexing.");    
                return "<Type Error>";
            }
            // array.length
            if (ctx.atom() == null)
                return "int";
            // array[index]
            else {
                String atomType = visit(ctx.atom());
                if (!atomType.equals("int")) {
                    ErrorReporter.reportError(ctx, "Array index must be int.");    
                    return "<Type Error>";
                }
                return "int";
            }
        }
        else if (ctx.name != null) {
            Symbol symbol = typeChecker.getCurrentScope().findSymbol(ctx.name.getText());
            if (symbol == null) {
                ErrorReporter.reportError(ctx, "Symbol not found.");
                return "<Type Error>";
            }
            else
                return symbol.getType();
        }
        else if (ctx.nonAtom() != null) {
            String object = visit(ctx.nonAtom());
            String methodName = ctx.name.getText();
            String callList = (ctx.callList() != null ? visit(ctx.callList()) : "");
            // todo
        }
        else if (ctx.atom() != null) {
            String atomType = visit(ctx.atom());
            if (!atomType.equals("boolean")) {
                ErrorReporter.reportError(ctx, "Only boolean support logical not.");    
                return "<Type Error>";
            }
            return "boolean";
        }
        else if (ctx.expression() != null) {
            return visit(ctx.expression());
        }

        return null;
    }
    
    @Override public String visitNonAtom(MiniJavaParser.NonAtomContext ctx) { return visitChildren(ctx); }
    @Override public String visitArray(MiniJavaParser.ArrayContext ctx) { return visitChildren(ctx); }
}
