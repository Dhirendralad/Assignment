package assignment_Day13;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Queue {
    private LinkedList<Integer> list;

    public Queue() {
        list = new LinkedList<>();
    }

    public void enqueue(int data) {
        list.addLast(data);
    }

    public int dequeue() {
        if (list.isEmpty()) {
            throw new NoSuchElementException();
        }
        return list.removeFirst();
    }

    public int peek() {
        if (list.isEmpty()) {
            throw new NoSuchElementException();
        }
        return list.peekFirst();
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(56);
        queue.enqueue(30);
        queue.enqueue(70);
        
        System.out.println(queue.dequeue()); // prints 56
        System.out.println(queue.dequeue()); // prints 30
        System.out.println(queue.dequeue()); // prints 70
    }
}
