package test2.Figures;

public class Segment {
    Point[] points = new Point[2];
    double k;
    double b;
    double dX;
    double dY;

    public Segment(Point A, Point B) {
        if (A.equals(B))
            throw new IllegalArgumentException("Missing points argument. Segment collapse to point.");
        if (A.getX() <= B.getX()) {
            points[0] = A;
            points[1] = B;
        } else {
            points[0] = B;
            points[1] = A;
        }
        dX = points[1].getX() - points[0].getX();
        dY = points[1].getY() - points[0].getY();

        if (dY == 0) {
            k = 0;
            b = points[0].getY();
        } else if (dX == 0) {
            k = Double.POSITIVE_INFINITY;
            b = Double.POSITIVE_INFINITY;
        } else {
            k = dY / dX;
            b = points[0].getY() - k * points[0].getX();
        }
    }

    public double getK() {
        return k;
    }

    public double getB() {
        return b;
    }

    public boolean isPointInSegment(Point point) {
        double maxX = points[1].getX();
        double minX = points[0].getX();
        double maxY = points[1].getY();
        double minY = points[0].getY();
        if (maxY < minY) {
            maxY = points[0].getY();
            minY = points[1].getY();
        }

        return (minX <= point.getX() && point.getX() <= maxX) &&
                (minY <= point.getY() && point.getY() <= maxY);
    }

    @Override
    public String toString() {
        return String.format("(%s-%s)", points[0], points[1]);
    }

    public double length() {
        return Math.sqrt(
                Math.pow(points[0].getX() - points[1].getX(), 2) +
                        Math.pow(points[0].getY() - points[1].getY(), 2));

    }

    public Point midlePoint() {
        double x = (points[0].getX() + points[1].getX()) / 2;
        double y = (points[0].getY() + points[1].getY()) / 2;
        return new Point(x, y);
    }

    public Point getPointCrossLine(Segment othSeg) {
        Point crossPoint = null;
        if (k != othSeg.getK()) {
            double x = (othSeg.getB() - b) / (k - othSeg.getK());
            double y = k * x + b;
            crossPoint = new Point(x, y);
        }
        return crossPoint;
    }

    public Point getPointCrossSegment(Segment othSeg) {
        Point crossPoint = getPointCrossLine(othSeg);
        if (crossPoint != null)
            if (!isPointInSegment(crossPoint) || !othSeg.isPointInSegment(crossPoint))
                crossPoint = null;
        return crossPoint;
    }

    public static void main(String[] args) {
        Segment segment1 = new Segment(new Point(0, 0), new Point(16, 10));
        Segment segment2 = new Segment(new Point(0, 12), new Point(10, 0));

        System.out.println("segment1: " + segment1 +
                ", length: " + segment1.length() +
                ", midle point" + segment1.midlePoint() +
                segment1.isPointInSegment(segment1.midlePoint()));

        System.out.println("segment2: " + segment2 +
                ", length: " + segment2.length() +
                ", midle point" + segment2.midlePoint() +
                segment2.getPointCrossLine(segment1) +
                segment1.getPointCrossLine(segment2) +
                segment1.getPointCrossLine(segment1) +
                segment1.getPointCrossSegment(segment2));

    }
}
