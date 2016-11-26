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

    public int arithemicExpr() {
        return 0;
    }

    public boolean logicExpr() {
        // return q && w || x;
        return true;
    }

    public boolean testPrecedence() {
        return 1 * (2 + 3) - 4 / 5 < 6 || a + b + c > x && y == z;
    }

    public boolean testSelf() {
        return this.testPrecedence();
    }
}

class B extends A {
    int x;
}


class C {
    public int incompatibleTypeAssignment() {
        A a;
        B b;
        b = a;
        return a;
    }

    public int incompatibleNonAtomReturn() {
        A a;
        return a.logicExpr();
    }

    public int compatibleNonAtomReturn() {
        A a;
        return a.arithemicExpr();
    }
}
