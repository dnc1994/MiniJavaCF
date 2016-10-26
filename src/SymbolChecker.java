import org.antlr.v4.runtime.*;

public class SymbolChecker extends MiniJavaBaseListener {
    @Override
    public void enterClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx) {
        System.out.println(ctx.identifier(0).getText());
    }
}
