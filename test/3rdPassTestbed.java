class Testbed {
    public static void main(String[] x) {
        // Test new
        {
            // Error #1
            System.out.println(new fakeClass().fakeMethod());
            System.out.println(new A().arithemicExpr());
        }
    }
}

class A {
    int a;
    int b;
    int c;
    boolean x;
    boolean y;
    boolean z;

    // Test expressions

    public int arithemicExpr() {
        return 0;
    }

    public boolean logicalExpr() {
        return true;
    }

    public boolean logicalNotValid(boolean x) {
        return !x;
    }

    // Error #2
    public boolean logicalNotInvalid(int x) {
        return !x;
    }

    public boolean testPrecedenceValid() {
        return 1 * (2 + 3) - 4 / 5 < 6 || a + b > c && !(y || z);
    }

    // Test symbol lookup

    public int localSymbolFound() {
        return a;
    }

    // Error #3
    public int localSymbolNotFound() {
        return d;
    }

    // Test method calls

    public boolean testThis() {
        return this.testPrecedenceValid();
    }

    // Error #4
    public boolean localMethodNotFound() {
        return this.fakeMethod();
    }

    public boolean logicalExprWithParams(boolean a, boolean b) {
        return a && b;
    }

    public boolean callListCompatible(boolean a, int b) {
        return this.logicalExprWithParams(a, b);
    }

    // Error #5
    public boolean callListIncompatible(boolean a, boolean b) {
        return this.logicalExprWithParams(a, b);
    }
    
    public int testSystemOutPrintlnValid(int a) {
        System.out.println(a);
        return 0;
    }

    // Error #6
    public int testSystemOutPrintlnInvalid(boolean a) {
        System.out.println(a);
        return 0;
    }
}

class B extends A {
    int[] a;
    int b;

    // Test arrays

    public int arrayAssignmentValid() {
        a[0] = 0;
        return 0;
    }

    // Error #7
    public int arrayAssignmentInvalid() {
        a[0] = false;
        return 0;
    }

    // Error #8
    public int arrayIndexingInvalid() {
        a[false] = 0;
        return 0;
    }

    public int arrayLengthValid() {
        return a.length;
    }

    // Error #9
    public int arrayLengthInvalid() {
        return b.length;
    }

    public int arrayInitializationValid() {
        a = new int[10];
        return 0;
    }

    // Error #10
    public int arrayInitializationInvalid() {
        a = new int[false];
        return 0;
    }    
}

class C {

    // Test type deduction with inheritence

    public A assignmentCompatible() {
        A a;
        B b;
        a = b;
        return a;
    }

    // Error #11
    public B assignmentIncompatible() {
        A a;
        B b;
        b = a;
        return b;
    }

    // Error #12
    public int returnNonAtomIncompatible() {
        A a;
        return a.logicalExpr();
    }

    public int returnNonAtomCompatible() {
        A a;
        return a.arithemicExpr();
    }
}
