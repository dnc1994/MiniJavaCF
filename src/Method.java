import java.util.*;

public class Method extends Symbol implements Scope {
    private String returnType;
    private Scope parentScope;
    private boolean valid;

    private Map<String, Symbol> params = new HashMap<String, Symbol>();
    private Map<String, Symbol> locals = new HashMap<String, Symbol>();
    private ArrayList<String> paramTypes = new ArrayList<String>();

    public Method(String methodName, String returnType, Scope parentScope, boolean valid) {
        super(methodName);
        this.returnType = returnType;
        this.parentScope = parentScope;
        this.valid = valid;
    }

    // Fucking Java does not support default parameter ??!!
    public Method(String methodName, String returnType, Scope parentScope) {
        super(methodName);
        this.returnType = returnType;
        this.parentScope = parentScope;
        this.valid = true;
    }

    @Override
    public boolean isValid() {
        return this.valid;
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
        else {
            if (this.getParentScope() == null)
                return null;
            else
                return this.getParentScope().findSymbol(name);
        }
    }

    @Override
    public Symbol findLocalSymbol(String name) {
        if (params.containsKey(name))
            return params.get(name);
        else
            return locals.get(name);
    }

    public void addParam(Symbol param) {
        params.put(param.getName(), param);
        paramTypes.add(param.getType());
    }

    public Symbol findParam(String name) {
        return params.get(name);
    }

    // public Map<String, Symbol> getParams() {
    //     return params;
    // }

    public String getReturnType() {
        return returnType;
    }

    public boolean isCallListCompatible(String callList) {
        if (callList.equals(""))
            return paramTypes.size() == 0;
        String[] callNames = callList.split(",");
        if (callNames.length != paramTypes.size())
            return false;
        for (int i = 0; i < callNames.length; i ++) {
            if (!Symbol.isTypeCompatible(paramTypes.get(i), callNames[i]))
                return false;
        }
        return true;
    }

}
