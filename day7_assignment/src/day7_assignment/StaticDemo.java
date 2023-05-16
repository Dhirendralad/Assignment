package day7_assignment;

public class StaticDemo {
    // Static variable
    static int counter = 0;

    // Static method
    static void incrementCounter() {
        counter++;
    }

    // Static block
    static {
        System.out.println("Static block is executed");
    }

    public static void main(String[] args) {
        // Increment the counter
        incrementCounter();

        // Print the value of the counter
        System.out.println("The value of the counter is " + counter);
    }
}
