public class Student {
    private String name;
    private int age;
    private String ID;

    // Constructor
    public Student(String name, int age, String ID) {
        this.name = name;
        this.age = age;
        this.ID = ID;
    }

    // Method to print name and age
    public void printNameAndAge() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Id number: " + ID);
    }

    // Main method to test the Student class
    public static void main(String[] args) {
        // Create a Student object
        Student student = new Student("John Doe", 20, "S12345");

        // Call the method to print name and age
        student.printNameAndAge();
    }
}
