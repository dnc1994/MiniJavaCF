class Testbed {
    public static void main(String[] x){
        System.out.println(new Foo().Excite(5, 6));
        // System.out.println(0);
    }
}

class Foo {
    public int Excite(int x, int z) {
        if (x < 1)
            y = 1;
        else 
            y = x * (this.Excite(x-1));
        return x + y + z;
    }

}
