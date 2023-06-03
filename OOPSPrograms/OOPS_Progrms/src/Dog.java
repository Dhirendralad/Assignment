public class Dog {
    private String breed;
    private int age;
    private double weight;

    // Constructor
    public Dog(String breed, int age, double weight) {
        this.breed = breed;
        this.age = age;
        this.weight = weight;
    }

    // Method to calculate the dog's age in human years
    public int calculateAgeInHumanYears() {
        int humanYears = 0;
        if (age <= 2) {
            humanYears = age * 11;
        } else {
            humanYears = 22 + ((age - 2) * 5);
        }
        return humanYears;
    }

    // Method to print the dog's details
    public void printDetails() {
        System.out.println("Breed: " + breed);
        System.out.println("Age: " + age);
        System.out.println("Weight: " + weight);
    }

    public static void main(String[] args) {
        // Create an instance of Dog
        Dog myDog = new Dog("Labrador Retriever", 3, 25.5);

        // Calculate the dog's age in human years
        int humanYears = myDog.calculateAgeInHumanYears();

        // Print the dog's details
        myDog.printDetails();

        // Print the dog's age in human years
        System.out.println("Age in human years: " + humanYears);
    }
}

