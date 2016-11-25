import org.antlr.v4.runtime.*;
import java.util.*;

public class SymbolChecker extends MiniJavaBaseListener {
    private Scope currentScope = null;
    final private Map<String, Class> classes;

    public SymbolChecker(final Map<String, Class> classes) {
        this.classes = classes;
    }

    public void checkCyclicInheritence() {
        Map<String, Integer> mapping = new HashMap<String, Integer>();
        Iterator iter = classes.keySet().iterator();
        int mark = 0;
        while (iter.hasNext()) {
            String className = classes.get(iter.next()).getName();
            System.out.println(className);
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
                System.out.println(className);
            }
        }
    }

    public void exitScope() {
        System.out.println("Exiting scope: " + currentScope);
        currentScope = currentScope.getParentScope();
    }

    // @Override
    // public void enterMainClass(MiniJavaParser.MainClassContext ctx) {
        
    // }

    @Override
    public void enterClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx) {
        String className = ctx.name.getText();
        System.out.println("---\nClass: " + className);
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
        Method currentMethod = (Method)currentScope.findLocalSymbol(methodName);
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
        Symbol currentVar = (Symbol)currentScope.findLocalSymbol(varName);
        // check for type existence
        if (!Symbol.isPrimitiveType(varType) && classes.get(varType) == null) {
            System.err.println("Variable type not found.");
        }
    }

}