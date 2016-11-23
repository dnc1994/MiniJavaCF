import java.util.*;

public class Class extends Symbol implements Scope {
    private String parentClassName;
    private Scope parentScope;

    private Map<String, Symbol> symbols = new HashMap<String, Symbol>();

    public Class(String className, String parentClassName, Scope parentScope) {
        super(className);
        this.parentClassName = parentClassName;
        this.parentScope = parentScope;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Scope getParentScope() {
        return parentScope;
    }

    @Override
    public void defineSymbol(Symbol symbol) {
        symbols.put(symbol.getName(), symbol);
    }

    @Override
    public Symbol lookupSymbol(String name) {
        if (symbols.containsKey(name))
            return symbols.get(name);
        else
            return this.getParentScope().lookupSymbol(name);
    }

}
