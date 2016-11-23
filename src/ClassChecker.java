import org.antlr.v4.runtime.*;
import java.util.*;

public class ClassChecker extends MiniJavaBaseListener {
    private Map<String, Class> classes;

    public ClassChecker(Map<String, Class> classes) {
        this.classes = classes;
    }

    @Override
    public void enterClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx) {
        String className, parentClassName;
        className = ctx.name.getText();
        parentClassName = (ctx.parent != null ? ctx.parent.getText() : "");
        System.out.println("Class: " + className + " Parent: ");
        Class currentClass = new Class(className, parentClassName);
        if (classes.containsKey(className))
            System.err.println("Duplicate classes.");
        else
            classes.put(className, currentClass);
    }
}
