package Day8_assignment;

public class SmallestElement {

    public static void main(String[] args) {

        // Declare and initialize an array.
        int[] arr = {1, 2, 3, 4, 5};

        // Initialize the smallest element with the first element of the array.
        int smallest = arr[0];

        // Loop through the array and compare each element with the smallest element.
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
        }

        // Print the smallest element.
        System.out.println("The smallest element in the array is " + smallest);
    }
}

