import org.antlr.v4.runtime.*;
import java.util.*;

public class ScopeBuilder extends MiniJavaBaseListener {
    private Map<String, Class> classes;

    public ScopeBuilder(Map<String, Class> classes) {
        this.classes = classes;
    }

    @Override
    public void enterClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx) {
        String className, parentClassName;
        className = ctx.name.getText();
        parentClassName = (ctx.parent != null ? ctx.parent.getText() : "");
        System.out.println("Class: " + className + "; Parent: " + parentClassName);
        Class currentClass = new Class(className, parentClassName);
        if (classes.containsKey(className))
            System.err.println("Duplicate classes.");
        else
            classes.put(className, currentClass);
    }

    @Override
    public void enterMethodDeclaration(MiniJavaParser.MethodDeclarationContext ctx) {
        String methodName, methodReturnType;
        methodName = ctx.name.getText();
        methodReturnType = ctx.ret_type.getText();
        System.out.println("Method: " + methodName + "; Return Type: " + methodReturnType);
        Method currentMethod = new Method(methodName, methodReturnType);
        // put in scope's symbol table
    }
}
