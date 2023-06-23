import java.util.Objects;

class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class Line {
    private final Point startPoint;
    private final Point endPoint;

    public Line(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public double calculateLength() {
        int xDiff = endPoint.getX() - startPoint.getX();
        int yDiff = endPoint.getY() - startPoint.getY();
        return Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
    }

    public boolean equals(Line otherLine) {
        return startPoint.equals(otherLine.startPoint) && endPoint.equals(otherLine.endPoint);
    }

    public int compareTo(Line otherLine) {
        double thisLength = calculateLength();
        double otherLength = otherLine.calculateLength();

        if (thisLength < otherLength)
            return -1;
        else if (thisLength > otherLength)
            return 1;
        else
            return 0;
    }
}

public class LineComparisonComputation {
    public static void main(String[] args) {
        System.out.println("Welcome to Line Comparison Computation Program on Master Branch");

        // Create lines with points
        Point point1 = new Point(1, 2);
        Point point2 = new Point(4, 6);
        Line line1 = new Line(point1, point2);

        Point point3 = new Point(2, 3);
        Point point4 = new Point(5, 7);
        Line line2 = new Line(point3, point4);

        // Calculate length of lines
        double length1 = line1.calculateLength();
        double length2 = line2.calculateLength();

        // Check equality of lines
        boolean isEqual = line1.equals(line2);

        // Compare lines
        int comparison = line1.compareTo(line2);

        // Displaying the results
        System.out.println("Length of Line 1: " + length1);
        System.out.println("Length of Line 2: " + length2);
        System.out.println("Line 1 equals Line 2: " + isEqual);
        System.out.println("Comparison result: " + comparison);
    }
}