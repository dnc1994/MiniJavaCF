public interface Scope {

    public String getName();

    public Scope getParentScope();

    public void addSymbol(Symbol symbol);

    public Symbol findSymbol(String name);
}
