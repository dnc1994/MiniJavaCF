public class SymbolVisitor extends MiniJavaBaseListener {
    @Override
    public void enterClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx) {
        System.out.println(ctx.Identifier());
    }
}
