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

    public static boolean isPrimitiveType(String type) {
        return type.equals("int") || type.equals("int[]") || type.equals("boolean");
    }
}
