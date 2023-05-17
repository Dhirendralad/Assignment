package Day8_assignment;

import java.util.Scanner;

public class DistanceLoop {
    public static void main(String[] args) {

        // Create a Scanner object to read input from the user
        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt the user to enter the number of points
            System.out.println("Enter the number of points: ");
            int numberOfPoints = scanner.nextInt();

            // Create an array to store the points
            Point[] points = new Point[numberOfPoints];

            // Get input from the user for each point
            for (int i = 0; i < numberOfPoints; i++) {
                System.out.println("Enter the x-coordinate of point " + (i + 1) + ": ");
                int x = scanner.nextInt();

                System.out.println("Enter the y-coordinate of point " + (i + 1) + ": ");
                int y = scanner.nextInt();

                points[i] = new Point(x, y);
            }

            // Calculate the Euclidean distance from each point to the origin
            for (int i = 0; i < numberOfPoints; i++) {
                double distance = points[i].distanceToOrigin();

                System.out.println("The Euclidean distance from the point (" + points[i].x + ", " + points[i].y + ") to the origin is " + distance);
            }
        }
    }
}

class Point {

    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distanceToOrigin() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
}

