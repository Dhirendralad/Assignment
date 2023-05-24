package assignment_Day13;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Stack {
    private LinkedList<Integer> list;

    public Stack() {
        list = new LinkedList<Integer>();
    }

    public void push(int data) {
        list.addFirst(data);
    }

    public int pop() {
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
        Stack stack = new Stack();
        stack.push(70);
        stack.push(30);
        stack.push(56);

        while (!stack.isEmpty()) {
            System.out.println("Peek: " + stack.peek());
            System.out.println("Pop: " + stack.pop());
        }
    }

    public boolean isEmpty() {
        return false;
    }
}
