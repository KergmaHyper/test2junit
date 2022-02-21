package test2;

import java.util.concurrent.atomic.DoubleAdder;

public class Circle extends Figure {
    Point o;
    final double r;

    Circle(Point O, double R) {
        o = O;
        if (R <= 0)
            throw new IllegalArgumentException("Circle collapse.");
        r = R;
    }

    public Point getO() {
        return new Point(o);
    }

    public double getR() {
        double nR = r;
        return nR;
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

    @Override
    public Point centroid() {

        return new Point(o.getX(), o.getY());
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (figure instanceof Circle othCircle)
            if (othCircle.getO().equals(o) && othCircle.getR() == r)
                return true;
        return false;
    }

}
