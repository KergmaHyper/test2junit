package test2;

public class Line {
    int k;
    int b;

    class Point {
        public double x;
        public double y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return String.format("(%.1f; %.1f)", x, y);
        }
    }

    Line(int k, int b) {
        this.k = k;
        this.b = b;
    }

    public Point intersection(Line xLine) {
        if (b == xLine.b && k == xLine.k)
            return new Point(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        if (b == xLine.b)
            return new Point(0, 0);
        if (k == xLine.k)
            return null;
        double xIn = (k - xLine.k) / (b - xLine.b);
        return new Point(xIn, k * xIn + b);
    }

    public static void main(String[] args) {
        Line line1 = new Line(1, 1);
        Line line2 = new Line(1, 1);
        System.out.println(
                line1.intersection(
                        line2));
    }
}
