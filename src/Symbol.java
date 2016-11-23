public class Symbol {
    String name;
    String type;

    public Symbol(String name) {
        this.name = name;
    }

    public Symbol(String name, String type) {
        this(name);
        this.type = type;
    }

    public String getName() {
        return name;
    }
}
