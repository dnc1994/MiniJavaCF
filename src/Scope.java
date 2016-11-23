public interface Scope {

    public String getName();

    public Scope getParentScope();

    public void defineSymbol(Symbol symbol);

    public Symbol lookupSymbol(String name);
}
