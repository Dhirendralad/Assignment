import java.util.*;


public class AddressBookMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, AddressBook> addressBooks = new HashMap<>();

        System.out.println("Welcome to Address Book Program!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Create a new Address Book");
            System.out.println("2. Add a Contact to Address Book");
            System.out.println("3. Edit a Contact");
            System.out.println("4. Delete a Contact");
            System.out.println("5. Search Persons by City or State");
            System.out.println("6. View Persons by City or State");
            System.out.println("7. Get Count of Persons by City or State");
            System.out.println("8. Sort Address Book by Name");
            System.out.println("9. Sort Address Book by City");
            System.out.println("10. Sort Address Book by State");
            System.out.println("11. Sort Address Book by Zip");
            System.out.println("12. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the new Address Book: ");
                    String newAddressBookName = scanner.nextLine();
                    addressBooks.put(newAddressBookName, new AddressBook(newAddressBookName));
                    break;
                case 2:
                    System.out.print("Enter the name of the Address Book to add the contact: ");
                    String addressBookName = scanner.nextLine();
                    AddressBook addressBook = addressBooks.get(addressBookName);
                    if (addressBook == null) {
                        System.out.println("Address Book not found!");
                        break;
                    }
                    Contact newContact = getContactDetailsFromUser(scanner);
                    if (addressBook.isDuplicate(newContact)) {
                        System.out.println("Duplicate contact found. Cannot add!");
                    } else {
                        addressBook.addContact(newContact);
                        System.out.println("Contact added successfully!");
                    }
                    break;
                case 3:
                    System.out.print("Enter the name of the Address Book to edit the contact: ");
                    addressBookName = scanner.nextLine();
                    addressBook = addressBooks.get(addressBookName);
                    if (addressBook == null) {
                        System.out.println("Address Book not found!");
                        break;
                    }
                    System.out.print("Enter the first name of the contact to edit: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter the last name of the contact to edit: ");
                    String lastName = scanner.nextLine();
                    newContact = getContactDetailsFromUser(scanner);
                    if (addressBook.editContact(firstName, lastName, newContact)) {
                        System.out.println("Contact edited successfully!");
                    } else {
                        System.out.println("Contact not found!");
                    }
                    break;
                case 4:
                    System.out.print("Enter the name of the Address Book to delete the contact: ");
                    addressBookName = scanner.nextLine();
                    addressBook = addressBooks.get(addressBookName);
                    if (addressBook == null) {
                        System.out.println("Address Book not found!");
                        break;
                    }
                    System.out.print("Enter the first name of the contact to delete: ");
                    firstName = scanner.nextLine();
                    System.out.print("Enter the last name of the contact to delete: ");
                    lastName = scanner.nextLine();
                    if (addressBook.deleteContact(firstName, lastName)) {
                        System.out.println("Contact deleted successfully!");
                    } else {
                        System.out.println("Contact not found!");
                    }
                    break;
                case 5:
                    System.out.print("Enter the city or state to search contacts: ");
                    String cityOrState = scanner.nextLine();
                    searchContactsByCityOrState(addressBooks, cityOrState);
                    break;
                case 6:
                    System.out.print("Enter the city or state to view contacts: ");
                    cityOrState = scanner.nextLine();
                    viewContactsByCityOrState(addressBooks, cityOrState);
                    break;
                case 7:
                    System.out.print("Enter the city or state to get the count of contacts: ");
                    cityOrState = scanner.nextLine();
                    getCountOfContactsByCityOrState(addressBooks, cityOrState);
                    break;
                case 8:
                    System.out.print("Enter the name of the Address Book to sort by name: ");
                    addressBookName = scanner.nextLine();
                    addressBook = addressBooks.get(addressBookName);
                    if (addressBook == null) {
                        System.out.println("Address Book not found!");
                        break;
                    }
                    addressBook.sortByName();
                    System.out.println("Address Book sorted by name!");
                    break;
                case 9:
                    System.out.print("Enter the name of the Address Book to sort by city: ");
                    addressBookName = scanner.nextLine();
                    addressBook = addressBooks.get(addressBookName);
                    if (addressBook == null) {
                        System.out.println("Address Book not found!");
                        break;
                    }
                    addressBook.sortByCity();
                    System.out.println("Address Book sorted by city!");
                    break;
                case 10:
                    System.out.print("Enter the name of the Address Book to sort by state: ");
                    addressBookName = scanner.nextLine();
                    addressBook = addressBooks.get(addressBookName);
                    if (addressBook == null) {
                        System.out.println("Address Book not found!");
                        break;
                    }
                    addressBook.sortByState();
                    System.out.println("Address Book sorted by state!");
                    break;
                case 11:
                    System.out.print("Enter the name of the Address Book to sort by zip: ");
                    addressBookName = scanner.nextLine();
                    addressBook = addressBooks.get(addressBookName);
                    if (addressBook == null) {
                        System.out.println("Address Book not found!");
                        break;
                    }
                    addressBook.sortByZip();
                    System.out.println("Address Book sorted by zip!");
                    break;
                case 12:
                    System.out.println("Exiting Address Book Program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Helper method to get contact details from the user
    private static Contact getContactDetailsFromUser(Scanner scanner) {
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter City: ");
        String city = scanner.nextLine();
        System.out.print("Enter State: ");
        String state = scanner.nextLine();
        System.out.print("Enter Zip: ");
        String zip = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        return new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
    }

    // Helper method to search contacts by city or state
    private static void searchContactsByCityOrState(Map<String, AddressBook> addressBooks, String cityOrState) {
        for (AddressBook addressBook : addressBooks.values()) {
            List<Contact> result = new ArrayList<>();
            result.addAll(addressBook.searchByCity(cityOrState));
            result.addAll(addressBook.searchByState(cityOrState));
            if (!result.isEmpty()) {
                System.out.println("Contacts in " + cityOrState + ":");
                for (Contact contact : result) {
                    System.out.println(contact);
                }
            }
        }
    }

    // Helper method to view contacts by city or state
    private static void viewContactsByCityOrState(Map<String, AddressBook> addressBooks, String cityOrState) {
        for (AddressBook addressBook : addressBooks.values()) {
            List<Contact> result = new ArrayList<>();
            result.addAll(addressBook.searchByCity(cityOrState));
            result.addAll(addressBook.searchByState(cityOrState));
            if (!result.isEmpty()) {
                System.out.println("Contacts in " + cityOrState + " from Address Book: " + addressBook.getName());
                for (Contact contact : result) {
                    System.out.println(contact);
                }
            }
        }
    }

    // Helper method to get the count of contacts by city or state
    private static void getCountOfContactsByCityOrState(Map<String, AddressBook> addressBooks, String cityOrState) {
        int totalCount = 0;
        for (AddressBook addressBook : addressBooks.values()) {
            totalCount += addressBook.getCountByCity(cityOrState);
            totalCount += addressBook.getCountByState(cityOrState);
        }
        System.out.println("Total count of contacts in " + cityOrState + ": " + totalCount);
    }
}
