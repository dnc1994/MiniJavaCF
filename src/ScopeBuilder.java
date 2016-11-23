import org.antlr.v4.runtime.*;
import java.util.*;

public class ScopeBuilder extends MiniJavaBaseListener {
    private Map<String, Class> classes;
    private Scope currentScope = null;

    public ScopeBuilder(Map<String, Class> classes) {
        this.classes = classes;
    }

    public void exitScope() {
        System.out.println("Exiting scope: " + currentScope);
        currentScope = currentScope.getParentScope();
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
        boolean valid = currentScope.isValid();
        className = ctx.name.getText();
        parentClassName = (ctx.parent != null ? ctx.parent.getText() : "<No Parent Class>");
        System.out.println("---\nClass: " + className + "; Parent: " + parentClassName);
        System.out.println("In scope: " + currentScope);
        
        if (classes.containsKey(className)) {
            System.err.println("Class already exists.");
            valid = false;
        }
        Class currentClass = new Class(className, parentClassName, currentScope, valid);
        if (valid) {
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
        boolean valid = currentScope.isValid();
        System.out.println("Method: " + methodName + "; Return Type: " + methodReturnType);

        System.out.println("In scope: " + currentScope.getName());
        System.out.println("Scope symbols: " + currentScope.getSymbols());
        System.out.println("Lookup result: " + currentScope.findLocalSymbol(methodName));
        
        if (currentScope.findLocalSymbol(methodName) != null) {
            System.err.println("Method already exists.");
            valid = false;
        }
        Method currentMethod = new Method(methodName, methodReturnType, currentScope, valid);
        if (valid) {
            currentScope.addSymbol(currentMethod);
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
        boolean valid = currentScope.isValid();
        varType = ctx.vtype.getText();
        varName = ctx.name.getText();
        // System.out.println("Var: " + varName + "; Type: " + varType);
        
        if (currentScope.findLocalSymbol(varName) != null) {
            System.err.println("Variable already exists.");
            valid = false;
        }
        Symbol currentVar = new Symbol(varName, varType);
        if (valid) {
            currentScope.addSymbol(currentVar);
        }
    }
}
