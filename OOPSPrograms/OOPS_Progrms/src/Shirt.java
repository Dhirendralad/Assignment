public class Shirt {
    private String size;
    private String color;
    private double price;

    // Constructor
    public Shirt(String size, String color, double price) {
        this.size = size;
        this.color = color;
        this.price = price;
    }

    // Method to calculate the discount on the shirt based on its size
    public double calculateDiscount() {
        double discountPercentage = 0.0;

        if (size.equalsIgnoreCase("small")) {
            discountPercentage = 0.1; // 10% discount for small-sized shirts
        } else if (size.equalsIgnoreCase("medium")) {
            discountPercentage = 0.15; // 15% discount for medium-sized shirts
        } else if (size.equalsIgnoreCase("large")) {
            discountPercentage = 0.2; // 20% discount for large-sized shirts
        }

        double discountAmount = price * discountPercentage;
        return discountAmount;
    }

    // Method to print the shirt's details
    public void printDetails() {
        System.out.println("Size: " + size);
        System.out.println("Color: " + color);
        System.out.println("Price: $" + price);
    }

    public static void main(String[] args) {
        // Create an instance of Shirt
        Shirt myShirt = new Shirt("Medium", "Blue", 30.0);

        // Calculate the discount on the shirt
        double discount = myShirt.calculateDiscount();

        // Print the shirt's details
        myShirt.printDetails();

        // Print the discounted price of the shirt
        double discountedPrice = myShirt.price - discount;
        System.out.println("Discounted Price: $" + discountedPrice);
    }
}
