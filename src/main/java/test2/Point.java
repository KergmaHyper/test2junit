package test2;

public class Point {
    private final double x;
    private final double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Object other) {
        return (x == ((Point) other).getX() && y == ((Point) other).getY());
    }

    @Override
    public String toString() {
        return String.format("(%.1f; %.1f)", x, y);
    }

}
