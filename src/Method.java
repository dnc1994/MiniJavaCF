import java.util.*;

public class Method extends Symbol implements Scope {
    private String returnType;
    private Scope parentScope;

    private Map<String, Symbol> params = new HashMap<String, Symbol>();
    private Map<String, Symbol> locals = new HashMap<String, Symbol>();

    public Method(String methodName, String returnType, Scope parentScope) {
        super(methodName);
        this.returnType = returnType;
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
    public void addSymbol(Symbol symbol) {
        locals.put(symbol.getName(), symbol);
    }

    @Override
    public Symbol findSymbol(String name) {
        if (params.containsKey(name))
            return params.get(name);
        else if (locals.containsKey(name))
            return locals.get(name);
        else
            return this.getParentScope().findSymbol(name);
    }

}
