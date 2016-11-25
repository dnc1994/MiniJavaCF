class Testbed {
    public static void main(String[] x){
        System.out.println(new Foo().Excite(5));
    }
}

class Foo {
    public int Excite(int x) {
        if (x + 1)
            return 2;
        else 
            return x;
    }
}
