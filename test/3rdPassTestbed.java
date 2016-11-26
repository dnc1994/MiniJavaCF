class Testbed {
    public static void main(String[] x){
        System.out.println(new nonClass().nonMethod());
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
    int[] a;
    boolean b;

    public int arrayAssignmentValid() {
        a[0] = 0;
        return 0;
    }

    public int arrayAssignmentInvalid() {
        a[0] = false;
        return 0;
    }

    public int arrayIndexingInvalid() {
        a[false] = 0;
        return 0;
    }

    public int arrayLengthValid() {
        return a.length;
    }

    public int arrayLengthInvalid() {
        return b.length;
    }

    public int arrayInitializationValid() {
        a = new int[10];
        return 0;
    }

    public int arrayInitializationInvalid() {
        a = new int[false];
        return 0;
    }    
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
