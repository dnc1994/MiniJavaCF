import org.antlr.v4.runtime.*;

public class ClassChecker extends MiniJavaBaseListener {
    Scope currentScope = null;

    @Override
    public void enterClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx) {
        System.out.println(ctx.identifier(0).getText());
    }
}
