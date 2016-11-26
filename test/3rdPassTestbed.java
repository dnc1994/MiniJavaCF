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

    public int cha() {
        return q && w || x;
    }

    public boolean biu() {
        return 3 * 4 - 6 * 6 - (3 - 4) * a < 14 / b / x && 1 - 2 - 3 < x - y - z;
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
