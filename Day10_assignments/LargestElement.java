package Day8_assignment;

public class LargestElement {

    public static void main(String[] args) {

        // Declare and initialize an array.
        int[] arr = {1, 2, 3, 4, 5};

        // Initialize the largest element with the first element of the array.
        int largest = arr[0];

        // Loop through the array and compare each element with the largest element.
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }

        // Print the largest element.
        System.out.println("The largest element in the array is " + largest);
    }
}

