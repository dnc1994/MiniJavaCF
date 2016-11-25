import org.antlr.v4.runtime.*;
import java.util.*;

public class TypeEvaluator extends MiniJavaBaseVisitor<String> {
    private TypeChecker typeChecker;

    public TypeEvaluator(TypeChecker typeChecker) {
        this.typeChecker = typeChecker;
    }

    @Override public String visitGoal(MiniJavaParser.GoalContext ctx) { return visitChildren(ctx); }
    @Override public String visitMainClass(MiniJavaParser.MainClassContext ctx) { return visitChildren(ctx); }
    @Override public String visitClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx) { return visitChildren(ctx); }
    @Override public String visitVarDeclaration(MiniJavaParser.VarDeclarationContext ctx) { return visitChildren(ctx); }
    @Override public String visitMethodDeclaration(MiniJavaParser.MethodDeclarationContext ctx) { return visitChildren(ctx); }
    @Override public String visitParamList(MiniJavaParser.ParamListContext ctx) { return visitChildren(ctx); }
    @Override public String visitType(MiniJavaParser.TypeContext ctx) { return visitChildren(ctx); }
    @Override public String visitStatement(MiniJavaParser.StatementContext ctx) { return visitChildren(ctx); }
    @Override public String visitIfStatement(MiniJavaParser.IfStatementContext ctx) { return visitChildren(ctx); }
    @Override public String visitWhileStatement(MiniJavaParser.WhileStatementContext ctx) { return visitChildren(ctx); }
    @Override public String visitPrintStatement(MiniJavaParser.PrintStatementContext ctx) { return visitChildren(ctx); }
    @Override public String visitAssignment(MiniJavaParser.AssignmentContext ctx) { return visitChildren(ctx); }
    @Override public String visitArrayAssignment(MiniJavaParser.ArrayAssignmentContext ctx) { return visitChildren(ctx); }
    
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
        else
            return "<Type Error>";
    }
    
    @Override public String visitOrExpr(MiniJavaParser.OrExprContext ctx) { return visitChildren(ctx); }
    @Override public String visitAndExpr(MiniJavaParser.AndExprContext ctx) { return visitChildren(ctx); }
    @Override public String visitCompareExpr(MiniJavaParser.CompareExprContext ctx) { return visitChildren(ctx); }
    @Override public String visitSumExpr(MiniJavaParser.SumExprContext ctx) { return visitChildren(ctx); }
    @Override public String visitProductExpr(MiniJavaParser.ProductExprContext ctx) { return visitChildren(ctx); }
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
                    ErrorReporter.reportError("Only array has .length method.");
                else
                    ErrorReporter.reportError("Only array support [] indexing.");    
                return "<Type Error>";
            }
            // array.length
            if (ctx.atom() == null)
                return "int";
            else {
                String atomType = visit(ctx.atom());
                if (!atomType.equals("int")) {
                    ErrorReporter.reportError("Array index must be int.");    
                    return "<Type Error>";
                }
                return "int";
            }
        }
        else if (ctx.name != null) {
            Symbol symbol = typeChecker.getCurrentScope().findSymbol(ctx.name.getText());
            if (symbol == null) {
                ErrorReporter.reportError("Symbol not found.");
                return "<Type Error>";
            }
            else
                return symbol.getType();
        }
        else if (ctx.nonAtom() != null) {
            // todo
        }
        else if (ctx.atom() != null) {
            String atomType = visit(ctx.atom());
            if (!atomType.equals("boolean")) {
                ErrorReporter.reportError("Only boolean support logical not.");    
                return "<Type Error>";
            }
            return "boolean"
        }
        else if (ctx.expression()) {
            return visit(ctx.expression());
        }

        // temporary
        else
            return "<Type Error>";
    }
    
    @Override public String visitNonAtom(MiniJavaParser.NonAtomContext ctx) { return visitChildren(ctx); }
    @Override public String visitArray(MiniJavaParser.ArrayContext ctx) { return visitChildren(ctx); }
}
