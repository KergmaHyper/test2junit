package test2;

public class Circle extends Figure {
    Point o;
    final double r;

    Circle(Point O, double R) {
        o = O;
        if (R <= 0)
            throw new IllegalArgumentException("Circle collapse.");
        r = R;
    }

    @Override
    public double area() {

        return Math.PI * Math.pow(r, 2);
    }

    @Override
    public String pointsToString() {
        return o.toString();
    }

    @Override
    public String toString() {

        return String.format("Circle[%s%f]", pointsToString(), r);
    }

    @Override
    public Point leftmostPoint() {

        return new Point(o.getX() - r, o.getY());
    }

}
