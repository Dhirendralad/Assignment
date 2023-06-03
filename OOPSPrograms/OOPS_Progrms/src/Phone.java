public class Phone {
    private String make;
    private String model;
    private int storage;

    // Constructor
    public Phone(String make, String model, int storage) {
        this.make = make;
        this.model = model;
        this.storage = storage;
    }

    // Method to calculate the price of the phone based on the make, model, and storage capacity
    public double calculatePrice() {
        double basePrice = 500.0; // Assuming a base price of $500
        double pricePerGB = 0.1; // Assuming a price of $0.10 per GB

        double price = basePrice + (storage * pricePerGB);
        return price;
    }

    // Method to print the phone's details
    public void printDetails() {
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Storage Capacity: " + storage + "GB");
    }

    public static void main(String[] args) {
        // Create an instance of Phone
        Phone myPhone = new Phone("Apple", "iPhone 12", 128);

        // Calculate the price of the phone
        double price = myPhone.calculatePrice();

        // Print the phone's details
        myPhone.printDetails();

        // Print the price of the phone
        System.out.println("Price: $" + price);
    }
}

