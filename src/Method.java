import java.util.*;

public class Method extends Symbol implements Scope {
    private String name;
    private String type;
    private Scope parent;

    private Map<String, Symbol> params = new HashMap<String, Symbol>();
    private Map<String, Symbol> locals = new HashMap<String, Symbol>();

    public Method(String name, String type, Scope parent) {
        super(name);
        this.name = name;
        this.type = type;
        this.parent = parent;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Scope getParentScope() {
        return this.parent;
    }

    @Override
    public void defineSymbol(Symbol symbol) {
        locals.put(symbol.getName(), symbol);
    }

    @Override
    public Symbol lookupSymbol(String name) {
        if (params.containsKey(name))
            return params.get(name);
        else if (locals.containsKey(name))
            return locals.get(name);
        else
            return this.getParentScope().lookupSymbol(name);
    }

}
