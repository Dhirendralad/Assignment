package day14_assignment;

import java.util.*;

public class RemoveWordFromPhrase {

    public static void main(String[] args) {

        // Get the paragraph phrase
        String paragraph = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";

        // Split the paragraph into words
        String[] words = paragraph.split(" ");

        // Create a linked list of MyMapNode objects to store the words and their
        // frequencies
        LinkedList<MyMapNode> linkedList = new LinkedList<>();

        // Iterate through the words
        for (String word : words) {

            // Skip the word to be removed ("avoidable")
            if (word.equals("avoidable")) {
                continue;
            }

            // Get the hash code of the word
            int hashCode = word.hashCode();

            // Create a MyMapNode object
            MyMapNode myMapNode = new MyMapNode(hashCode, 1, word);

            // Find the index of the word in the linked list
            int index = Collections.binarySearch(linkedList, myMapNode);

            // If the word is not found in the linked list, add it to the linked list with
            // frequency 1
            if (index < 0) {
                index = -index - 1;
                linkedList.add(index, myMapNode);
            } else {

                // Get the MyMapNode at the index
                MyMapNode existingMyMapNode = linkedList.get(index);

                // Increment the frequency of the word if it matches the current word
                if (existingMyMapNode.word.equals(word)) {
                    existingMyMapNode.frequency++;
                }
            }
        }

        // Print the remaining words and their frequencies
        System.out.println("The remaining words and their frequencies are:");
        for (MyMapNode myMapNode : linkedList) {
            System.out.println(myMapNode.word + " " + myMapNode.frequency);
        }
    }
}

class MyMapNode implements Comparable<MyMapNode> {

    public String word;
    int hashCode;
    int frequency;

    MyMapNode(int hashCode, int frequency, String word) {
        this.hashCode = hashCode;
        this.frequency = frequency;
        this.word = word;
    }

    @Override
    public int compareTo(MyMapNode other) {
        return this.hashCode - other.hashCode;
    }
}
