public class Furniture {
    private String type;
    private String material;
    private double price;

    // Constructor
    public Furniture(String type, String material, double price) {
        this.type = type;
        this.material = material;
        this.price = price;
    }

    // Method to calculate the discount on the furniture based on its material
    public double calculateDiscount() {
        double discountPercentage = 0.0;

        if (material.equalsIgnoreCase("wood")) {
            discountPercentage = 0.1; // 10% discount for furniture made of wood
        } else if (material.equalsIgnoreCase("metal")) {
            discountPercentage = 0.2; // 20% discount for furniture made of metal
        } else if (material.equalsIgnoreCase("plastic")) {
            discountPercentage = 0.15; // 15% discount for furniture made of plastic
        }

        double discountAmount = price * discountPercentage;
        return discountAmount;
    }

    // Method to print the furniture's details
    public void printDetails() {
        System.out.println("Type: " + type);
        System.out.println("Material: " + material);
        System.out.println("Price: $" + price);
    }

    public static void main(String[] args) {
        // Create an instance of Furniture
        Furniture myFurniture = new Furniture("Chair", "Wood", 100.0);

        // Calculate the discount on the furniture
        double discount = myFurniture.calculateDiscount();

        // Print the furniture's details
        myFurniture.printDetails();

        // Print the discounted price of the furniture
        double discountedPrice = myFurniture.price - discount;
        System.out.println("Discounted Price: $" + discountedPrice);
    }
}
