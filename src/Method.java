import java.utils.*;

public class Method extends Symbol implements Scope {
    private String name;
    private String type;
    private Scope parent;

    private Map<String, Map> locals = new Map<String, Map>();

    public Method(String name, String type, Scope parent) {
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
    public defineSymbol(Symbol symbol) {

    }

    @Override
    public lookupSymbol(String name) {

    }

}
