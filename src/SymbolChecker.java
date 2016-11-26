import org.antlr.v4.runtime.*;
import java.util.*;

public class SymbolChecker extends MiniJavaBaseListener {
    private Scope currentScope;
    final private Map<String, Class> classes;

    public SymbolChecker(final Map<String, Class> classes, Scope virtualSuperScope) {
        this.classes = classes;
        this.currentScope = virtualSuperScope;
    }

    public void checkCyclicInheritence() {
        Map<String, Integer> mapping = new HashMap<String, Integer>();
        Iterator iter = classes.keySet().iterator();
        int mark = 0;
        while (iter.hasNext()) {
            String className = classes.get(iter.next()).getName();
            if (mapping.containsKey(className))
                continue;
            mark += 1;
            while (!className.equals("<No Parent Class>")) {
                if (mapping.containsKey(className)) {
                    if (mapping.get(className).equals(mark))
                        ErrorReporter.reportError("Cyclic inheritence detected.");
                    break;
                } 
                mapping.put(className, mark);
                className = classes.get(className).getParentClassName();
            }
        }
    }

    public void exitScope() {
        // System.out.println("Exiting scope: " + currentScope);
        currentScope = currentScope.getParentScope();
    }

    // @Override
    // public void enterMainClass(MiniJavaParser.MainClassContext ctx) {
        
    // }

    @Override
    public void enterClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx) {
        String className = ctx.name.getText();
        // System.out.println("---\nClass: " + className);
        Class currentClass = classes.get(className);
        String parentClassName = currentClass.getParentClassName();
        if (!parentClassName.equals("<No Parent Class>")) {
            Class parentClass = classes.get(parentClassName);
            if (parentClass == null) {
                ErrorReporter.reportError(ctx.name, "Parent class not found.");
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
        Method currentMethod = (Method)currentScope.findLocalSymbol(methodName);
        // check for type existence
        if (!Symbol.isPrimitiveType(methodReturnType) && classes.get(methodReturnType) == null) {
            ErrorReporter.reportError(ctx.rtype, "Method return type not found.");
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
        Symbol currentVar = (Symbol)currentScope.findLocalSymbol(varName);
        // check for type existence
        if (!Symbol.isPrimitiveType(varType) && classes.get(varType) == null) {
            ErrorReporter.reportError(ctx.vtype, "Variable type not found.");
        }
    }

}