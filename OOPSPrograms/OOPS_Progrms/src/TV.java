public class TV {
    private String brand;
    private int size;
    private double price;

    // Constructor
    public TV(String brand, int size, double price) {
        this.brand = brand;
        this.size = size;
        this.price = price;
    }

    // Method to calculate the discount on the TV based on its size
    public double calculateDiscount() {
        double discountPercentage = 0.0;

        if (size < 32) {
            discountPercentage = 0.1; // 10% discount for TVs with size less than 32 inches
        } else if (size >= 32 && size < 50) {
            discountPercentage = 0.15; // 15% discount for TVs with size between 32 and 49 inches
        } else {
            discountPercentage = 0.2; // 20% discount for TVs with size 50 inches or greater
        }

        double discountAmount = price * discountPercentage;
        return discountAmount;
    }

    // Method to print the TV's details
    public void printDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Size: " + size + " inches");
        System.out.println("Price: $" + price);
    }

    public static void main(String[] args) {
        // Create an instance of TV
        TV myTV = new TV("Samsung", 55, 1000.0);

        // Calculate the discount on the TV
        double discount = myTV.calculateDiscount();

        // Print the TV's details
        myTV.printDetails();

        // Print the discounted price of the TV
        double discountedPrice = myTV.price - discount;
        System.out.println("Discounted Price: $" + discountedPrice);
    }
}
