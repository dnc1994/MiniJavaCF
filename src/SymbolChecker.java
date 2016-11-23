import org.antlr.v4.runtime.*;
import java.util.*;

public class SymbolChecker extends MiniJavaBaseListener {
    private Scope currentScope = null;
    final private Map<String, Symbol> classes;

    public SymbolChecker(final Map<String, Class> classes) {
        this.classes = classes;
    }

    public void exitScope() {
        currentScope = scope.getParentScope();
    }

    // @Override
    // public void enterMainClass(MiniJavaParser.MainClassContext ctx) {
        
    // }

    @Override
    public void enterClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx) {
        String className = ctx.name.getText();
        Class currentClass = classes.get(className);
        String parentClassName = currentClass.getParentClassName();
        if (!parentClassName.equals("<No Parent Class>")) {
            Class parentClass = classes.get(parentClassName);
            if (parentClass == null) {
                System.err.println("Parent class not found.");
            }
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
        currentMethod = currentScope.findLocalSymbol(methodName);
        // check for type existence
        if (!Symbol.isPrimitiveType(methodReturnType) && classes.get(methodReturnType) == null) {
            System.err.println("Method return type not found.");
        }
        currentScope = currentMethod;
    }

    @Override
    public void exitMethodDeclaration(MiniJavaParser.MethodDeclarationContext ctx) {
        exitScope();
    }

    @Override
    public void enterVarDeclaration(MiniJavaParser.VarDeclarationContext ctx) {
        String varName = ctx.name.getText();
        String varType = ctx.vtype.getText();
        currentVar = currentScope.findLocalSymbol(varName);
        // check for type existence
        if (!Symbol.isPrimitiveType(varType) && classes.findSymbol(varType) == null) {
            System.err.println("Variable type not found.");
        }
    }

}