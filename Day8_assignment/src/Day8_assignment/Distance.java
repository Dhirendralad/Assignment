package Day8_assignment;

import java.util.Scanner;

public class Distance {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){

            System.out.println("Enter the x-coordinate: ");
            int x = scanner.nextInt();
    
            System.out.println("Enter the y-coordinate: ");
            int y = scanner.nextInt();

        double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

        System.out.println("The Euclidean distance from the point (" + x + ", " + y + ") to the origin is " + distance);
        }
    }

}
