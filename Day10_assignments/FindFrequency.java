package Day8_assignment;

import java.util.HashMap;
import java.util.Map;

public class FindFrequency {

    public static void main(String[] args) {

        // Declare and initialize an array.
        int[] arr = {1, 2, 3, 2, 1};

        // Create a map to store the frequency of each element.
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Loop through the array and increment the frequency of each element.
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            if (!frequencyMap.containsKey(element)) {
                frequencyMap.put(element, 1);
            } else {
                frequencyMap.put(element, frequencyMap.get(element) + 1);
            }
        }

        // Print the frequency of each element.
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

