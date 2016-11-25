class Testbed {
    public static void main(String[] x){
        System.out.println(new Foo().Excite(5));
    }
}

class Foo {
    public int Excite(int x) {
        int y;
        Bar z;
        if (x < 1)
            y = 1;
        else 
            y = x * (this.Excite(x-1));
        return y;
    }

    public Bar ExciteX(int x) {
        return 0;
    }

}

class Biu extends Cha {
    public int ExciteY(int x) {
        return 0;
    }
}
