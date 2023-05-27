import java.util.Scanner;

public class Circle {
    private double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Method to calculate the area of the circle
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Method to calculate the circumference of the circle
    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    // Main method to test the Circle class
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for radius input
        System.out.print("Enter the radius of the circle: ");
        double radius = scanner.nextDouble();

        // Create a Circle object
        Circle circle = new Circle(radius);

        // Calculate and print the area
        double area = circle.calculateArea();
        System.out.println("Area: " + area);

        // Calculate and print the circumference
        double circumference = circle.calculateCircumference();
        System.out.println("Circumference: " + circumference);

        scanner.close();
    }
}
