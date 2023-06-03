public class Book {
    private String title;
    private String author;
    private int numPages;

    // Constructor
    public Book(String title, String author, int numPages) {
        this.title = title;
        this.author = author;
        this.numPages = numPages;
    }

    // Method to calculate the price of the book based on the number of pages
    public double calculatePrice() {
        double pricePerPage = 0.05; // Assuming a price of $0.05 per page
        double price = numPages * pricePerPage;
        return price;
    }

    // Method to print the book's details
    public void printDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Number of Pages: " + numPages);
    }

    public static void main(String[] args) {
        // Create an instance of Book
        Book myBook = new Book("The Great Gatsby", "F. Scott Fitzgerald", 180);

        // Calculate the price of the book
        double price = myBook.calculatePrice();

        // Print the book's details
        myBook.printDetails();

        // Print the price of the book
        System.out.println("Price: $" + price);
    }
}
