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
        if (!left.equals("boolean")) {
            ErrorReporter.reportError(ctx.getChild(0), "Only boolean support logical or.");
            return "<Type Error>";
        }
        if (!right.equals("boolean")) {
            ErrorReporter.reportError(ctx.getChild(2), "Only boolean support logical or.");
            return "<Type Error>";
        }
        return "boolean";
    }

    @Override
    public String visitAndExpr(MiniJavaParser.AndExprContext ctx) {
        String left = visit(ctx.getChild(0));
        String right = visit(ctx.getChild(2));
        if (!left.equals("boolean")) {
            ErrorReporter.reportError(ctx.getChild(0), "Only boolean support logical or.");
            return "<Type Error>";
        }
        if (!right.equals("boolean")) {
            ErrorReporter.reportError(ctx.getChild(2), "Only boolean support logical or.");
            return "<Type Error>";
        }
        return "boolean";
    }

    @Override public String visitCompareExpr(MiniJavaParser.CompareExprContext ctx) { 
        String left = visit(ctx.getChild(0));
        String right = visit(ctx.getChild(2));
        if (!left.equals("int")) {
            ErrorReporter.reportError(ctx.getChild(0), "Only int support comparison.");
            return "<Type Error>";
        }
        if (!right.equals("int")) {
            ErrorReporter.reportError(ctx.getChild(2), "Only int support comparison.");
            return "<Type Error>";
        }
        return "boolean";
    }
    
    @Override public String visitSumExpr(MiniJavaParser.SumExprContext ctx) {
        String left = visit(ctx.getChild(0));
        String right = visit(ctx.getChild(2));
        if (!left.equals("int")) {
            ErrorReporter.reportError(ctx.getChild(0), "Only int support addition.");
            return "<Type Error>";
        }
        if (!right.equals("int")) {
            ErrorReporter.reportError(ctx.getChild(2), "Only int support addition.");
            return "<Type Error>";
        }
        return "int";
    }
    
    @Override public String visitProductExpr(MiniJavaParser.ProductExprContext ctx) {
        String left = visit(ctx.getChild(0));
        String right = visit(ctx.getChild(2));
        if (!left.equals("int")) {
            ErrorReporter.reportError(ctx.getChild(0), "Only int support multiplication.");
            return "<Type Error>";
        }
        if (!right.equals("int")) {
            ErrorReporter.reportError(ctx.getChild(2), "Only int support multiplication.");
            return "<Type Error>";
        }
        return "int";
    }
    
    @Override public String visitCallList(MiniJavaParser.CallListContext ctx) {
        String list = visit(ctx.rightValue());
        if (ctx.callList() != null);
            list = list + "," + visit(ctx.callList());
        return list;
    }
    
    @Override public String visitRightValue(MiniJavaParser.RightValueContext ctx) {
        System.out.println("In visitRightValue, ctx = " + ctx.getText());
        if (ctx.expression() != null)
            return visit(ctx.expression());
        else if (ctx.nonAtom() != null)
            return visit(ctx.nonAtom());
        else if (ctx.array() != null)
            return visit(ctx.array());
        return null;
    }
    
    @Override
    public String visitAtom(MiniJavaParser.AtomContext ctx) {
        System.out.println("In visitAtom, ctx = " + ctx.getText());
        if (ctx.Int() != null) {
            System.out.println("visitAtom -> Int");
            return "int";
        }
        else if (ctx.bool != null)
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
        else if (ctx.nonAtom() != null) {
            String objectName = visit(ctx.nonAtom());
            String methodName = ctx.name.getText();
            String callList = (ctx.callList() != null ? visit(ctx.callList()) : "");
            System.out.println("In visitAtom, subrule nonAtom: " + objectName + "."  + methodName);
            Class object = (Class)(typeChecker.getCurrentScope().findSymbol(objectName));
            if (object == null) {
                ErrorReporter.reportError("Object not found.");
                return "<Type Error>";
            }
            Method method = (Method)object.findSymbol(methodName);
            if (method == null) {
                ErrorReporter.reportError("Method not found.");
                return "<Type Error>";
            }
            if (!method.isCallListCompatible(callList)) {
                ErrorReporter.reportError("Call list not compatible.");
                return "<Type Error>";
            }
            return method.getReturnType();
        }
        else if (ctx.name != null) {
            System.out.println("visitAtom -> Identifier: " + ctx.name.getText());
            // System.out.println("typeChecker getCurrentScope: " + typeChecker.getCurrentScope());
            Symbol symbol = typeChecker.getCurrentScope().findSymbol(ctx.name.getText());
            if (symbol == null) {
                ErrorReporter.reportError(ctx, "Symbol not found.");
                return "<Type Error>";
            }
            else
                return symbol.getType();
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
    
    @Override public String visitNonAtom(MiniJavaParser.NonAtomContext ctx) {
        System.out.println("In visitNonAtom: ctx = " + ctx.getText());
        System.out.println(ctx.getChild(0));
        System.out.println(ctx.self);
        // nonAtom '.' name=Identifier '(' callList? ')'
        if (ctx.nonAtom() != null) {
            String objectName = visit(ctx.nonAtom());
            String methodName = ctx.name.getText();
            String callList = (ctx.callList() != null ? visit(ctx.callList()) : "");
            Class object = (Class)(typeChecker.getCurrentScope().findSymbol(objectName));
            if (object == null) {
                ErrorReporter.reportError("Object not found.");
                return "<Type Error>";
            }
            Method method = (Method)object.findSymbol(methodName);
            if (method == null) {
                ErrorReporter.reportError("Method not found.");
                return "<Type Error>";
            }
            if (!method.isCallListCompatible(callList)) {
                ErrorReporter.reportError("Call list not compatible.");
                return "<Type Error>";
            }
            return method.getReturnType();
        }
        // This
        else if (ctx.self != null) {
            System.out.println("In visitNonAtom subrule this");
            try {
                Class object = (Class)typeChecker.getCurrentScope();
                System.out.println("In visitNonAtom [This]: "+ object.getName());
                return object.getName();
            }
            catch (ClassCastException e) {
                ErrorReporter.reportError("'this' is only referrable in a class.");
            }
        }
        // New name=Identifier '(' ')'
        else if (ctx.create != null) {

        }
        // name=Identifier
        else if (ctx.name != null) {
            Symbol symbol = typeChecker.getCurrentScope().findSymbol(ctx.name.getText());
            if (symbol == null) {
                ErrorReporter.reportError(ctx, "Symbol not found.");
                return "<Type Error>";
            }
            else
                return symbol.getType();
        }
        // '(' expression ')'
        else if (ctx.expression() != null) {
            return visit(ctx.expression());
        }
        return null;
    }

    @Override public String visitArray(MiniJavaParser.ArrayContext ctx) { return visitChildren(ctx); }
}
