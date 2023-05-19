package Day8_assignment;

import java.util.Arrays;

public class SortArray {

    public static void main(String[] args) {

        // Declare and initialize an array.
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        // Sort the array using the built-in sort() method.
        Arrays.sort(arr);

        // Print the sorted array.
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
