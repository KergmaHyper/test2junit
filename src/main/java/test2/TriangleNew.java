package test2;

public class TriangleNew extends Figure {
    Point a;
    Point b;
    Point c;

    TriangleNew(Point A, Point B, Point C) {
        a = A;
        b = B;
        c = C;
        if (a.equals(b) || b.equals(c) || c.equals(a))
            throw new IllegalArgumentException("Invalid Args. Tops collapse.");

    }

    @Override
    public double area() {

        return (new Triangle(a, b, c)).area();
    }

    @Override
    public String pointsToString() {

        return String.format("%s%s%s", a, b, c);
    }

    @Override
    public String toString() {
        return String.format("Triangle:[%s]", pointsToString());
    }

    @Override
    public Point leftmostPoint() {
        Point answer = a;
        if (b.getX() < answer.getX())
            answer = b;
        if (c.getX() < answer.getX())
            answer = c;

        return new Point(answer.getX(), answer.getY());
    }

}
