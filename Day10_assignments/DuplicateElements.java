package Day8_assignment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateElements {

    public static void main(String[] args) {

        // Declare and initialize an array.
        int[] arr = {1, 2, 3, 2, 1, 4, 5, 5};

        // Create a set to store the unique elements.
        Set<Integer> uniqueElements = new HashSet<>();

        // Loop through the array and add the elements to the set.
        for (int element : arr) {
            uniqueElements.add(element);
        }

        // Create a list to store the duplicate elements.
        List<Integer> duplicateElements = new ArrayList<>();

        // Loop through the set and compare each element with the elements in the array.
        for (int element : uniqueElements) {
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (element == arr[i]) {
                    count++;
                }
            }

            // If the element is present more than once in the array, add it to the list of duplicate elements.
            if (count > 1) {
                duplicateElements.add(element);
            }
        }

        // Print the duplicate elements.
        System.out.println("Duplicate elements in the array are: ");
        for (int element : duplicateElements) {
            System.out.print(element + " ");
        }
    }
}
