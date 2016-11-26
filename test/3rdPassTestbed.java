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
        return true;
    }

    public int localSymbolFound() {
        return x;
    }

    public int localSymbolNotFound() {
        return p;
    }

    public boolean logicExprWithParams(boolean a, boolean b) {
        return a && b;
    }

    public boolean testPrecedence() {
        return 1 * (2 + 3) - 4 / 5 < 6 || a + b + c > x && y == z;
    }

    public boolean testSelf() {
        return this.testPrecedence();
    }

    public boolean incompatibleCallList() {
        return this.logicExprWithParams(a, w);
    }

    public boolean CompatibleCallList() {
        return this.logicExprWithParams(q, w);
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
