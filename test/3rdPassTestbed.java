class Testbed {
    public static void main(String[] x){
        A a = new A();
        B b = new B();
        a = b;
        b = a;
    }
}

class A {
    int x;
}

class B extends A {
    int y;
}
