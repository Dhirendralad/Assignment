import java.util.*;
import java.util.stream.Collectors;

class Contact {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;

    public Contact(String firstName, String lastName, String address, String city, String state, String zip,
                   String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getters and setters

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public String getCity() {

        return city;
    }

    public void setCity(String city) {

        this.city = city;
    }

    public String getState() {

        return state;
    }

    public void setState(String state) {

        this.state = state;
    }

    public String getZip() {

        return zip;
    }

    public void setZip(String zip) {

        this.zip = zip;
    }

    public String getPhoneNumber() {

        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {

        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    @Override
    public boolean equals (Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Contact contact = (Contact) obj;
        return Objects.equals(firstName, contact.firstName) && Objects.equals(lastName, contact.lastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {

        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
       if (!contacts.contains(contact)) {
           contacts.add(contact);
           System.out.println("Contact added successfully.");
       } else {
           System.out.println("Duplicate entry. Contact already exists.");
       }
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public Contact searchContactByName(String firstName, String lastName) {
        return contacts.stream()
                .filter(contact -> contact.getFirstName().equalsIgnoreCase(firstName) &&
                        contact.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }

    public void editContact(String firstName, String lastName) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(firstName) &&
                    contact.getLastName().equalsIgnoreCase(lastName)) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter new address: ");
                String address = scanner.nextLine();
                System.out.print("Enter new city: ");
                String city = scanner.nextLine();
                System.out.print("Enter new state: ");
                String state = scanner.nextLine();
                System.out.print("Enter new zip: ");
                String zip = scanner.nextLine();
                System.out.print("Enter new phone number: ");
                String phoneNumber = scanner.nextLine();
                System.out.print("Enter new email: ");
                String email = scanner.nextLine();

                contact.setAddress(address);
                contact.setCity(city);
                contact.setState(state);
                contact.setZip(zip);
                contact.setPhoneNumber(phoneNumber);
                contact.setEmail(email);

                System.out.println("Contact updated successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public void deleteContact(String firstName, String lastName) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(firstName) &&
                    contact.getLastName().equalsIgnoreCase(lastName)) {
                contacts.remove(contact);
                System.out.println("Contact deleted successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            System.out.println("Contacts:");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }
}

public class AddressBookSystem {
    private Map<String, List<Contact>> cityDictionary;
    private Map<String, List<Contact>> stateDictionary;
    private Map<String, AddressBook> addressBooks;

    public AddressBookSystem() {
        this.cityDictionary = new HashMap<>();
        this.stateDictionary = new HashMap<>();
        this.addressBooks = new HashMap<>();
    }

    public void addAddressBook(String name) {
        AddressBook addressBook = new AddressBook();
        addressBooks.put(name, addressBook);
        System.out.println("Address book '" + name + "' created successfully.");
    }

    public void addContact(String addressBookName, Contact contact) {
        AddressBook addressBook = addressBooks.get(addressBookName);
        if (addressBook != null) {
            addressBook.addContact(contact);
            updateCityDictionary(contact);
            updateStateDictionary(contact);
        } else {
            System.out.println("Address book '" + addressBookName + "' not found.");
        }
    }

    private void updateCityDictionary(Contact contact) {
        List<Contact> cityContacts = cityDictionary.getOrDefault(contact.getCity(), new ArrayList<>());
        cityContacts.add(contact);
        cityDictionary.put(contact.getCity(), cityContacts);
    }

    private void updateStateDictionary(Contact contact) {
        List<Contact> stateContacts = stateDictionary.getOrDefault(contact.getState(), new ArrayList<>());
        stateContacts.add(contact);
        stateDictionary.put(contact.getState(), stateContacts);
    }

    public void viewPersonsByCity(String city) {
        List<Contact> contactsInCity = cityDictionary.getOrDefault(city, new ArrayList<>());
        if (contactsInCity.isEmpty()) {
            System.out.println("No contacts found in the city: " + city);
        } else {
            System.out.println("Contacts in the city: " + city);
            contactsInCity.forEach(System.out::println);
        }
    }

    public void viewPersonsByState(String state) {
        List<Contact> contactsInState = stateDictionary.getOrDefault(state, new ArrayList<>());
        if (contactsInState.isEmpty()) {
            System.out.println("No contacts found in the state: " + state);
        } else {
            System.out.println("Contacts in the state: " + state);
            contactsInState.forEach(System.out::println);
        }
    }

    public void getCountByCity() {
        System.out.println("Contact count by city:");
        cityDictionary.forEach((city, contacts) -> System.out.println(city + ": " + contacts.size()));
    }

    public void getCountByState() {
        System.out.println("Contact count by state:");
        stateDictionary.forEach((state, contacts) -> System.out.println(state + ": " + contacts.size()));
    }

    public List<Contact> searchPersonsByCity(String city) {
        return addressBooks.values().stream()
                .flatMap(addressBook -> addressBook.getContacts().stream())
                .filter(contact -> contact.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    public List<Contact> searchPersonsByState(String state) {
        return addressBooks.values().stream()
                .flatMap(addressBook -> addressBook.getContacts().stream())
                .filter(contact -> contact.getState().equalsIgnoreCase(state))
                .collect(Collectors.toList());
    }

    public void editContact(String addressBookName, String firstName, String lastName) {
        AddressBook addressBook = addressBooks.get(addressBookName);
        if (addressBook != null) {
            addressBook.editContact(firstName, lastName);
        } else {
            System.out.println("Address book '" + addressBookName + "' not found.");
        }
    }

    public void deleteContact(String addressBookName, String firstName, String lastName) {
        AddressBook addressBook = addressBooks.get(addressBookName);
        if (addressBook != null) {
            addressBook.deleteContact(firstName, lastName);
        } else {
            System.out.println("Address book '" + addressBookName + "' not found.");
        }
    }

    public void displayContacts(String addressBookName) {
        AddressBook addressBook = addressBooks.get(addressBookName);
        if (addressBook != null) {
            addressBook.displayContacts();
        } else {
            System.out.println("Address book '" + addressBookName + "' not found.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program in AddressBookMain class on Master Branch");

        AddressBookSystem addressBookSystem = new AddressBookSystem();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("Select an option:");
            System.out.println("1. Add an address book");
            System.out.println("2. Add a contact");
            System.out.println("3. Edit a contact");
            System.out.println("4. Delete a contact");
            System.out.println("5. Display contacts");
            System.out.println("6. Search Person by City");
            System.out.println("7. Search Person by State");
            System.out.println("8. View persons by city");
            System.out.println("9. View persons by state");
            System.out.println("10. Get count by city");
            System.out.println("11. Get count by state");
            System.out.println("12. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the address book: ");
                    String addressBookName = scanner.nextLine();
                    addressBookSystem.addAddressBook(addressBookName);
                    break;
                case 2:
                    System.out.print("Enter the name of the address book: ");
                    addressBookName = scanner.nextLine();
                    System.out.print("Enter first name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter last name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter city: ");
                    String city = scanner.nextLine();
                    System.out.print("Enter state: ");
                    String state = scanner.nextLine();
                    System.out.print("Enter zip: ");
                    String zip = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();

                    Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
                    addressBookSystem.addContact(addressBookName, contact);
                    break;
                case 3:
                    System.out.print("Enter the name of the address book: ");
                    addressBookName = scanner.nextLine();
                    System.out.print("Enter first name of the contact to edit: ");
                    String editFirstName = scanner.nextLine();
                    System.out.print("Enter last name of the contact to edit: ");
                    String editLastName = scanner.nextLine();

                    addressBookSystem.editContact(addressBookName, editFirstName, editLastName);
                    break;
                case 4:
                    System.out.print("Enter the name of the address book: ");
                    addressBookName = scanner.nextLine();
                    System.out.print("Enter first name of the contact to delete: ");
                    String deleteFirstName = scanner.nextLine();
                    System.out.print("Enter last name of the contact to delete: ");
                    String deleteLastName = scanner.nextLine();

                    addressBookSystem.deleteContact(addressBookName, deleteFirstName, deleteLastName);
                    break;
                case 5:
                    System.out.print("Enter the name of the address book: ");
                    addressBookName = scanner.nextLine();
                    addressBookSystem.displayContacts(addressBookName);
                    break;
                case 6:
                    System.out.print("Enter city to search: ");
                    String searchCity = scanner.nextLine();
                    List<Contact> personsByCity = addressBookSystem.searchPersonsByCity(searchCity);
                    if (personsByCity.isEmpty()) {
                        System.out.println("No persons found in the given city.");
                    } else {
                        System.out.println("Persons in the city '" + searchCity + "':");
                        for (Contact person : personsByCity) {
                            System.out.println(person);
                        }
                    }
                    break;
                case 7:
                    System.out.print("Enter state to search: ");
                    String searchState = scanner.nextLine();
                    List<Contact> personsByState = addressBookSystem.searchPersonsByState(searchState);
                    if (personsByState.isEmpty()) {
                        System.out.println("No persons found in the given state.");
                    } else {
                        System.out.println("Persons in the state '" + searchState + "':");
                        for (Contact person : personsByState) {
                            System.out.println(person);
                        }
                    }
                    break;
                case 8:
                    System.out.print("Enter city to view persons: ");
                    String citi = scanner.nextLine();
                    addressBookSystem.viewPersonsByCity(citi);
                    break;
                case 9:
                    System.out.print("Enter state to view persons: ");
                    String states = scanner.nextLine();
                    addressBookSystem.viewPersonsByState(states);
                    break;
                case 10:
                    addressBookSystem.getCountByCity();
                    break;
                case 11:
                    addressBookSystem.getCountByState();
                    break;
                case 12:
                    exit = true;
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();
        }
    }
}
