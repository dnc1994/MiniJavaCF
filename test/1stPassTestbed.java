class Testbed {
    public static void main(String[] x){
        System.out.println(new Foo().Excite(5));
    }
}

class Foo {
    public int Excite(int x) {
        int y;
        int y;
        if (x < 1)
            y = 1;
          else 
            y = x * (this.Excite(x-1));
        return y;
    }

    public int Excite(int x) {
        return 0;
    }

}

class Foo {
    public int ExciteX(int x) {
        return 0;
    }
}

class Bar extends Foo {
    public int ExciteY(int x) {
        return 0;
    }
}
