import org.antlr.v4.runtime.*;
import java.util.*;

public class TypeChecker extends MiniJavaBaseListener {
    private Scope currentScope = null;
    final private Map<String, Class> classes;
    private TypeEvaluator typeEvaluator = new TypeEvaluator(this);

    public TypeChecker(final Map<String, Class> classes) {
        this.classes = classes;
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
        exitScope();
    }

    @Override public void enterIfStatement(MiniJavaParser.IfStatementContext ctx) {
        String conditionType = typeEvaluator.visit(ctx.expression());
        if (!conditionType.equals("boolean")) {
            ErrorReporter.reportError("The condition for if statement must be boolean.");
        }

    }
    
    @Override public void enterWhileStatement(MiniJavaParser.WhileStatementContext ctx) {

    }
    
    @Override public void enterPrintStatement(MiniJavaParser.PrintStatementContext ctx) {

    }
    
    @Override public void enterAssignment(MiniJavaParser.AssignmentContext ctx) {

    }
    
    @Override public void enterArrayAssignment(MiniJavaParser.ArrayAssignmentContext ctx) {

    }

}
