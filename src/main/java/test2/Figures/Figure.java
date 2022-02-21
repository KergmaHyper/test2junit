package test2.Figures;

public abstract class Figure {
    abstract public double area();

    abstract public String pointsToString();

    abstract public String toString();

    abstract public Point leftmostPoint();

    abstract public Point centroid();

    abstract public boolean isTheSame(Figure figure);
}
