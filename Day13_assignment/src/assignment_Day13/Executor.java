package assignment_Day13;

public class Executor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		list.insert(56);
		list.insert(30);
		list.insert(70);
		System.out.println("Linked List elements:");
		list.show();
		list.insertAtStart(25);
		System.out.println("Linked List elements after insertAtStart:");
		list.show();
		list.insertAt(2, 55);
		System.out.println("Linked List elements after insertAt:");
		list.show();
		list.deleteAt(0);
		System.out.println("Linked List elements after deleteAt:");
		list.show();
		// populate list with nodes...

		Node result = list.search(30); // look for node with data == 30

		if (result != null) {
			System.out.println("Found node with data: " + result.data);
		} else {
			System.out.println("Key not found in list");
		}
		System.out.println("Linked List elements after sort:");
		list.sort();
		list.show();

	}

}
