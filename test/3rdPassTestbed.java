class Testbed {
    public static void main(String[] x){
        System.out.println(0);
    }
}

class A {
    int x;
    boolean a;
    boolean b;
    boolean c;

    public int cha() {
        return a || b && c;
    }
}

class B extends A {
    int y;
}


class C {
    public int biu() {
        A a;
        B b;
        a = b;
        return a;
    }
}
