class Testbed {
    public static void main(String[] x){
        System.out.println(0);
    }
}

class A {
    int x;
    int y;
    int z;
    int a;
    int b;
    int c;
    boolean q;
    boolean w;
    boolean e;

    public int logicExpr() {
        return q && w || x;
    }

    public boolean precedence() {
        return 1 * (2 + 3) - 4 / 5 < 6 || a + b + c > x && y == z;
    }

    public boolean testThis() {
        return this.precedence();
    }
}

class B extends A {
    int x;
}


class C {
    public int assignment() {
        A a;
        B b;
        b = a;
        return a;
    }
}
