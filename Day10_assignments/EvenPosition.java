package Day8_assignment;

public class EvenPosition {

    public static void main(String[] args) {

        // Declare and initialize an array.
        int[] arr = {1, 2, 3, 4, 5};

        // Loop through the array and print the elements present on even positions.
        for (int i = 0; i < arr.length; i += 2) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
}

