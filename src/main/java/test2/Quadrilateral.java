package test2;

public class Quadrilateral extends Figure {
    Point a, b, c, d;

    Quadrilateral(Point A, Point B, Point C, Point D) {
        a = A;
        b = B;
        c = C;
        d = D;
        if (a.equals(b) || b.equals(c) || c.equals(d) || d.equals(a) || a.equals(c) || b.equals(d))
            throw new IllegalArgumentException("Top collapse");
        if (((new Segment(a, c).getPointCrossSegment(new Segment(b, d))) != null) ||
                ((new Segment(b, c).getPointCrossSegment(new Segment(a, d))) != null))
            throw new IllegalArgumentException("An antiquadrilateral.");
    }

    @Override
    public double area() {

        return (new Triangle(a, b, d)).area() + (new Triangle(b, c, d)).area();
    }

    @Override
    public String pointsToString() {
        return String.format("%s%s%s%s", a, b, c, d);
    }

    @Override
    public String toString() {

        return String.format("Quadrilateral:[%s]", pointsToString());
    }

    @Override
    public Point leftmostPoint() {
        Point answer = a;
        if (b.getX() < answer.getX())
            answer = b;
        if (c.getX() < answer.getX())
            answer = c;
        if (d.getX() < answer.getX())
            answer = d;

        return new Point(answer.getX(), answer.getY());
    }

}
