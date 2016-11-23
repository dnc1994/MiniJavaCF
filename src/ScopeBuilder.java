import org.antlr.v4.runtime.*;
import java.util.*;

public class ScopeBuilder extends MiniJavaBaseListener {
    private Map<String, Class> classes;
    private Scope currentScope = null;
    private boolean invalidScope = false;

    public ScopeBuilder(Map<String, Class> classes) {
        this.classes = classes;
    }

    public void exitScope() {
        currentScope = currentScope.getParentScope();
        invalidScope = false;
    }

    @Override
    public void enterMainClass(MiniJavaParser.MainClassContext ctx) {
        String className = ctx.name.getText();
        Class mainClass = new Class(className, "<Main Class>", null);
        classes.put(className, mainClass);
        currentScope = mainClass;
    }

    // @Override
    // public void exitMainClass(MiniJavaParser.MainClassContext ctx) {
    //     currentScope = null;
    // }

    @Override
    public void enterClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx) {
        String className, parentClassName;
        className = ctx.name.getText();
        parentClassName = (ctx.parent != null ? ctx.parent.getText() : "<No Parent Class>");
        System.out.println("Class: " + className + "; Parent: " + parentClassName);

        Class currentClass = new Class(className, parentClassName, currentScope);
        if (invalidScope) {
            return;
        }
        else if (classes.containsKey(className)) {
            invalidScope = true;
            System.err.println("Class already exists.");
        }
        else {
            classes.put(className, currentClass);
        }
        currentScope = currentClass;
    }

    @Override
    public void exitClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx) {
        exitScope();
    }

    @Override
    public void enterMethodDeclaration(MiniJavaParser.MethodDeclarationContext ctx) {
        String methodName = ctx.name.getText();
        String methodReturnType = ctx.rtype.getText();
        System.out.println("Method: " + methodName + "; Return Type: " + methodReturnType);

        System.out.println("In scope: " + currentScope.getName());
        System.out.println("Scope symbols: " + currentScope.getSymbols());
        System.out.println("Lookup result: " + currentScope.findLocalSymbol(methodName));

        Method currentMethod = new Method(methodName, methodReturnType, currentScope);
        if (invalidScope) {
            return;
        }
        else if (currentScope.findLocalSymbol(methodName) != null) {
            invalidScope = true;
            System.err.println("Method already exists.");
        }
        else {
            System.out.println("Add a method: " + methodName);
            currentScope.addSymbol(currentMethod);
            System.out.println("Scope symbols: " + currentScope.getSymbols());
        }
        currentScope = currentMethod;
    }

    @Override
    public void exitMethodDeclaration(MiniJavaParser.MethodDeclarationContext ctx) {
        exitScope();
    }

    @Override
    public void enterVarDeclaration(MiniJavaParser.VarDeclarationContext ctx) {
        String varType, varName;
        varType = ctx.vtype.getText();
        varName = ctx.name.getText();
        System.out.println("Var: " + varName + "; Type: " + varType);
        
        Symbol currentVar = new Symbol(varName, varType);
        if (invalidScope) {
            return;
        }
        else if (currentScope.findLocalSymbol(varName) != null) {
            invalidScope = true;
            System.err.println("Variable already exists.");
        }
        else {
            currentScope.addSymbol(currentVar);
        }
    }
}
