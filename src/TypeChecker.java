import org.antlr.v4.runtime.*;
import java.util.*;

public class TypeChecker extends MiniJavaBaseListener {
    private Scope currentScope;
    final private Map<String, Class> classes;
    private TypeEvaluator typeEvaluator;

    public TypeChecker(final Map<String, Class> classes, Scope virtualSuperScope) {
        this.classes = classes;
        this.currentScope = virtualSuperScope;
        this.typeEvaluator = new TypeEvaluator(this, classes);
    }

    public Scope getCurrentScope() {
        return currentScope;
    }

    public void exitScope() {
        currentScope = currentScope.getParentScope();
    }

    // @Override
    // public void enterMainClass(MiniJavaParser.MainClassContext ctx) {
        
    // }

    @Override
    public void enterClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx) {
        String className = ctx.name.getText();
        Class currentClass = classes.get(className);
        currentScope = currentClass;
    }

    @Override
    public void exitClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx) {
        exitScope();
    }

    @Override
    public void enterMethodDeclaration(MiniJavaParser.MethodDeclarationContext ctx) {
        String methodName = ctx.name.getText();
        Method currentMethod = (Method)currentScope.findLocalSymbol(methodName);
        currentScope = currentMethod;
    }

    @Override
    public void exitMethodDeclaration(MiniJavaParser.MethodDeclarationContext ctx) {
        // return type check
        String rightValueType = typeEvaluator.visit(ctx.rightValue());
        String returnType = ((Method)currentScope).getReturnType();
        // System.out.println("In method: " + ctx.name.getText());
        // System.out.println("rightValueType: " + rightValueType);
        // System.out.println("returnType: " + returnType);
        if (!Symbol.isTypeCompatible(returnType, rightValueType)) {
            if (!returnType.equals("<Type Error>") && !rightValueType.equals("<Type Error>"))
                ErrorReporter.reportError(ctx.rightValue(), "Return type not compatible.");
        }
        exitScope();
    }

    @Override public void enterIfStatement(MiniJavaParser.IfStatementContext ctx) {
        String conditionType = typeEvaluator.visit(ctx.expression());
        if (!conditionType.equals("boolean")) {
            ErrorReporter.reportError(conditionType, ctx.expression(), "The condition of if statement must be a boolean.");
        }
    }
    
    @Override public void enterWhileStatement(MiniJavaParser.WhileStatementContext ctx) {
        String conditionType = typeEvaluator.visit(ctx.expression());
        if (!conditionType.equals("boolean")) {
            ErrorReporter.reportError(conditionType, ctx.expression(), "The condition of while statement must be a boolean.");
        }
    }
    
    @Override public void enterPrintStatement(MiniJavaParser.PrintStatementContext ctx) {
        String exprType = typeEvaluator.visit(ctx.expression()); 
        if (!exprType.equals("int")) {
            ErrorReporter.reportError(exprType, ctx.expression(), "System.out.println can only print int.");
        }
    }
    
    @Override public void enterAssignment(MiniJavaParser.AssignmentContext ctx) {
        Symbol leftSymbol = currentScope.findSymbol(ctx.name.getText());
        if (leftSymbol == null) {
            ErrorReporter.reportError(ctx.name, "Symbol not found.");
            return;
        }
        String leftType = leftSymbol.getType();
        String rightType = typeEvaluator.visit(ctx.rightValue());
        if (!Symbol.isTypeCompatible(leftType, rightType)) {
            if (!leftType.equals("<Type Error>") && !rightType.equals("<Type Error>"))
                ErrorReporter.reportError(ctx.name, "Left and right side of assignment are not of compatible types.");
        }
    }
    
    @Override public void enterArrayAssignment(MiniJavaParser.ArrayAssignmentContext ctx) {
        Symbol leftSymbol = currentScope.findSymbol(ctx.name.getText());
        if (leftSymbol == null) {
            ErrorReporter.reportError(ctx.name, "Symbol not found.");
            return;
        } 
        String leftType = leftSymbol.getType();
        if (!leftType.equals("int[]")) {
            ErrorReporter.reportError(leftType, ctx.name, "Only array support [] indexing.");
        }
        String indexType = typeEvaluator.visit(ctx.expression(0));
        if (!indexType.equals("int")) {
            ErrorReporter.reportError(indexType, ctx.expression(0), "Array index must be int.");   
        }
        String rightType = typeEvaluator.visit(ctx.expression(1));
        if (!rightType.equals("int")) {
            ErrorReporter.reportError(rightType, ctx.expression(1), "Array element must be int.");   
        }
    }

}
