import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private String name;
    private List<Contact> contacts;

    // Constructor
    public AddressBook(String name) {
        this.name = name;
        this.contacts = new ArrayList<>();
    }

    // Getters and Setters for fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    // Method to add a new contact
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    // Method to edit a contact by name
    public boolean editContact(String firstName, String lastName, Contact newContact) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
                // Update the existing contact with the newContact details
                // Implement setters for Contact class if not already present
                contact.setFirstName(newContact.getFirstName());
                contact.setLastName(newContact.getLastName());
                contact.setAddress(newContact.getAddress());
                contact.setCity(newContact.getCity());
                contact.setState(newContact.getState());
                contact.setZip(newContact.getZip());
                contact.setPhoneNumber(newContact.getPhoneNumber());
                contact.setEmail(newContact.getEmail());
                return true;
            }
        }
        return false; // Contact not found
    }

    // Method to delete a contact by name
    public boolean deleteContact(String firstName, String lastName) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
                contacts.remove(contact);
                return true;
            }
        }
        return false; // Contact not found
    }

    // Method to check for duplicate contact
    public boolean isDuplicate(Contact contact) {
        return contacts.contains(contact);
    }

    // Method to search contacts in the same city
    public List<Contact> searchByCity(String city) {
        // Use Java Streams to filter contacts by city
        return contacts.stream().filter(contact -> contact.getCity().equals(city)).toList();
    }

    // Method to search contacts in the same state
    public List<Contact> searchByState(String state) {
        // Use Java Streams to filter contacts by state
        return contacts.stream().filter(contact -> contact.getState().equals(state)).toList();
    }

    // Method to get the number of contacts in the same city
    public long getCountByCity(String city) {
        // Use Java Streams to count contacts in the same city
        return contacts.stream().filter(contact -> contact.getCity().equals(city)).count();
    }

    // Method to get the number of contacts in the same state
    public long getCountByState(String state) {
        // Use Java Streams to count contacts in the same state
        return contacts.stream().filter(contact -> contact.getState().equals(state)).count();
    }

    // Method to sort contacts by name
    public void sortByName() {
        contacts.sort((c1, c2) -> c1.getFirstName().compareToIgnoreCase(c2.getFirstName()));
    }

    // Method to sort contacts by city
    public void sortByCity() {
        contacts.sort((c1, c2) -> c1.getCity().compareToIgnoreCase(c2.getCity()));
    }

    // Method to sort contacts by state
    public void sortByState() {
        contacts.sort((c1, c2) -> c1.getState().compareToIgnoreCase(c2.getState()));
    }

    // Method to sort contacts by zip
    public void sortByZip() {
        contacts.sort((c1, c2) -> c1.getZip().compareTo(c2.getZip()));
    }

    // Override toString() method to print the address book details
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address Book: ").append(name).append("\n");
        for (Contact contact : contacts) {
            sb.append(contact.toString()).append("\n");
        }
        return sb.toString();
    }
}
