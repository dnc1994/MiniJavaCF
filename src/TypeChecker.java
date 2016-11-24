import org.antlr.v4.runtime.*;
import java.util.*;

public class TypeChecker extends MiniJavaBaseListener {
    private Scope currentScope = null;
    final private Map<String, Class> classes;

    public SymbolChecker(final Map<String, Class> classes) {
        this.classes = classes;
    }

    public void exitScope() {
        currentScope = currentScope.getParentScope();
    }

    // @Override
    // public void enterMainClass(MiniJavaParser.MainClassContext ctx) {
        
    // }

    @Override
    public void enterClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx) {

    }

    @Override
    public void exitClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx) {
    }

    @Override
    public void enterMethodDeclaration(MiniJavaParser.MethodDeclarationContext ctx) {
    }

    @Override
    public void exitMethodDeclaration(MiniJavaParser.MethodDeclarationContext ctx) {
    }

    @Override
    public void enterVarDeclaration(MiniJavaParser.VarDeclarationContext ctx) {
    }

}