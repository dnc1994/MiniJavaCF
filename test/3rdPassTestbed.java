class Testbed {
    public static void main(String[] x){
        System.out.println(0);
    }
}

class A {
    int xyz;
    boolean a;
    boolean b;
    boolean c;

    public int cha() {
        return b && c || xyz;
    }
}

class B extends A {
    int y;
}


class C {
    public int biu() {
        A a;
        B b;
        b = a;
        return a;
    }
}
