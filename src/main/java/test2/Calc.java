package test2;

public class Calc {

    public static int add(int x, int y) {
        return x + y;
    }

    public static int mlt(int x, int y) {
        return x * y;
    }

    public static int dvd(int x, int y) {
        return x / y;
    }

    public static int sub(int x, int y) {
        return x - y;
    }

    public static void main(String[] args) {
        System.out.println(Calc.add(2, 3));
    }
}
