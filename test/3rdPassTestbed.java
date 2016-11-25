class Testbed {
    public static void main(String[] x){
        System.out.println(0);
    }
}

class A {
    int x;
}

class B extends A {
    int y;
}


class C {
    public int biu() {
        A a;
        B b;
        a = b;
        b = a;
        return a;
    }
}
