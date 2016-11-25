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
        return "not boolean";
    }
    
    @Override public String visitOrExpr(MiniJavaParser.OrExprContext ctx) { return visitChildren(ctx); }
    @Override public String visitAndExpr(MiniJavaParser.AndExprContext ctx) { return visitChildren(ctx); }
    @Override public String visitCompareExpr(MiniJavaParser.CompareExprContext ctx) { return visitChildren(ctx); }
    @Override public String visitSumExpr(MiniJavaParser.SumExprContext ctx) { return visitChildren(ctx); }
    @Override public String visitProductExpr(MiniJavaParser.ProductExprContext ctx) { return visitChildren(ctx); }
    @Override public String visitCallList(MiniJavaParser.CallListContext ctx) { return visitChildren(ctx); }
    @Override public String visitRightValue(MiniJavaParser.RightValueContext ctx) { return visitChildren(ctx); }
    @Override public String visitAtom(MiniJavaParser.AtomContext ctx) { return visitChildren(ctx); }
    @Override public String visitNonAtom(MiniJavaParser.NonAtomContext ctx) { return visitChildren(ctx); }
    @Override public String visitArray(MiniJavaParser.ArrayContext ctx) { return visitChildren(ctx); }
}
