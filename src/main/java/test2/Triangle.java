package test2;

public class Triangle {
    final int TOPS_COUNT = 3;
    Point[] tops = new Point[TOPS_COUNT];
    double[] lens = new double[TOPS_COUNT];
    final double P;
    Point[][] edges = new Point[TOPS_COUNT][2];
    Point[] edgeVectors = new Point[TOPS_COUNT];

    Triangle(Point A, Point B, Point C) {

        tops[0] = A;
        tops[1] = B;
        tops[2] = C;
        double p = 0;

        for (int i = 0; i < TOPS_COUNT; i++) {
            lens[i] = lengthEdge(i, (i + 1) % TOPS_COUNT);
            p += lens[i];
        }
        P = p;

        int indMaxLens = 0;
        for (int i = 0; i < TOPS_COUNT; i++) {
            if (lens[i] == 0)
                throw new IllegalArgumentException("Illegal args - tops collaps.");
            if (lens[i] > lens[indMaxLens])
                indMaxLens = i;
        }

        if ((P - lens[indMaxLens]) <= lens[indMaxLens])
            throw new IllegalArgumentException("Illegal arg - triangle collaps.");

        for (int i = 0; i < TOPS_COUNT; i++) {
            edges[i][0] = tops[i];
            edges[i][1] = tops[(i + 1) % TOPS_COUNT];
        }

        for (int i = 0; i < TOPS_COUNT; i++) {
            edgeVectors[i] = new Point(edges[i][1].getX() - edges[i][0].getX(),
                    edges[i][1].getY() - edges[i][0].getY());
        }

    }

    private double lengthEdge(Point A, Point B) {
        return (new Segment(A, B)).length();
    }

    private double lengthEdge(int indTopA, int indTopB) {
        return lengthEdge(tops[indTopA], tops[indTopB]);
    }

    public double area() {
        return Math.abs(edgeVectors[1].getX() * edgeVectors[0].getY() - edgeVectors[0].getX() * edgeVectors[1].getY())
                / 2;
    }

    public Point centroid() {

        Segment saA = new Segment(tops[0], (new Segment(tops[1], tops[2])).midlePoint());
        Segment sbB = new Segment(tops[1], (new Segment(tops[0], tops[2])).midlePoint());
        Segment scC = new Segment(tops[2], (new Segment(tops[0], tops[1])).midlePoint());
        Point center = saA.getPointCrossSegment(sbB);
        if (center != null)
            return center;
        center = sbB.getPointCrossSegment(scC);
        if (center != null)
            return center;
        center = scC.getPointCrossSegment(saA);
        if (center != null)
            return center;
        return null;
    }

    @Override
    public String toString() {

        return String.format("(%s-%s-%s)", tops[0], tops[1], tops[2]);
    }

    public static void main(String[] args) {
        Point A = new Point(-1, 0);
        Point B = new Point(0, 2);
        Point C = new Point(1, 0);

        Triangle tr1 = new Triangle(A, B, C);
        System.out.printf("Square triangle %s: %.1f. Center triangle: %s\n", tr1, tr1.area(), tr1.centroid());

    }
}
