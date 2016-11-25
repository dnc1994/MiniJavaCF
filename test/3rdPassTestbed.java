class Testbed {
    public static void main(String[] x){
        System.out.println(new Foo().Excite(5));
    }
}

class Foo {
    public int Excite(int x) {
        int y;
        if (x + 1)
            y = 2;
        else 
            y = x;
        return y;
    }
}
