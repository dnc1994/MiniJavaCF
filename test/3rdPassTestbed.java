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

    public boolean logicalExpr() {
        return true;
    }

    public boolean logicalNotValid(boolean x) {
        return !x;
    }

    public boolean logicalNotInvalid(int x) {
        return !x;
    }

    public int localSymbolFound() {
        return x;
    }

    public int localSymbolNotFound() {
        return p;
    }

    public boolean testPrecedence() {
        return 1 * (2 + 3) - 4 / 5 < 6 || a + b + c > x && y == z;
    }

    public boolean testSelf() {
        return this.testPrecedence();
    }

    public boolean logicalExprWithParams(boolean a, boolean b) {
        return a && b;
    }

    public boolean callListIncompatible() {
        return this.logicalExprWithParams(a, w);
    }

    public boolean callListCompatible() {
        return this.logicalExprWithParams(q, w);
    }
}

class B extends A {
    int x;
}


class C {
    public int assignmentTypeIncompatible() {
        A a;
        B b;
        b = a;
        return a;
    }

    public int returnIncompatibleNonAtom() {
        A a;
        return a.logicalExpr();
    }

    public int returnCgompatibleNonAtom() {
        A a;
        return a.arithemicExpr();
    }
}
