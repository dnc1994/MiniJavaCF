class Testbed {
    public static void main(String[] x) {
        System.out.println(new Foo().foo(5));
    }
}

class Foo {
    public int foo(int x) {
        int y;
        // Error #1
        Bar z;
        if (x < 1)
            y = 1;
        else 
            y = x * (this.biu(x-1));
        return y;
    }

    // Error #2
    public Bar bar(int x) {
        return 0;
    }

}

// Error #3
class Foobar extends Bar {
    public int foobar(int x) {
        return 0;
    }
}
