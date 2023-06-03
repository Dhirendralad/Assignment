public class Computer {
    private String processor;
    private int RAM;
    private int storage;

    // Constructor
    public Computer(String processor, int RAM, int storage) {
        this.processor = processor;
        this.RAM = RAM;
        this.storage = storage;
    }

    // Method to calculate the price of the computer based on the processor, RAM, and storage capacity
    public double calculatePrice() {
        double processorPrice = 0.0;
        double ramPrice = 0.0;
        double storagePrice = 0.0;

        // Determine processor price based on the processor type
        if (processor.equalsIgnoreCase("i3")) {
            processorPrice = 200.0;
        } else if (processor.equalsIgnoreCase("i5")) {
            processorPrice = 400.0;
        } else if (processor.equalsIgnoreCase("i7")) {
            processorPrice = 600.0;
        }

        // Determine RAM price based on the RAM size
        if (RAM == 4) {
            ramPrice = 100.0;
        } else if (RAM == 8) {
            ramPrice = 200.0;
        } else if (RAM == 16) {
            ramPrice = 400.0;
        }

        // Determine storage price based on the storage size
        if (storage == 256) {
            storagePrice = 100.0;
        } else if (storage == 512) {
            storagePrice = 200.0;
        } else if (storage == 1024) {
            storagePrice = 400.0;
        }

        double totalPrice = processorPrice + ramPrice + storagePrice;
        return totalPrice;
    }

    // Method to print the computer's details
    public void printDetails() {
        System.out.println("Processor: " + processor);
        System.out.println("RAM: " + RAM + "GB");
        System.out.println("Storage Capacity: " + storage + "GB");
    }

    public static void main(String[] args) {
        // Create an instance of Computer
        Computer myComputer = new Computer("i5", 8, 512);

        // Calculate the price of the computer
        double price = myComputer.calculatePrice();

        // Print the computer's details
        myComputer.printDetails();

        // Print the price of the computer
        System.out.println("Price: $" + price);
    }
}
