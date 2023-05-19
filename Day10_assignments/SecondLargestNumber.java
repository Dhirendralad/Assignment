package Day8_assignment;

public class SecondLargestNumber {

    public static void main(String[] args) {

        // Declare and initialize an array.
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        // Find the largest number in the array.
        int largest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }

        // Find the second largest number in the array.
        int secondLargest = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != largest && (secondLargest == -1 || arr[i] > secondLargest)) {
                secondLargest = arr[i];
            }
        }

        // Print the second largest number.
        System.out.println("The second largest number in the array is " + secondLargest);
    }
}

