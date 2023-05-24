package assignment_Day13;

public class LinkedList {
	Node head;
	
	public void insert(int data){
		Node node = new Node();
		node.data = data;
		node.next = null;
		
		if(head==null){
			head = node;
		}
		else{
			Node n = head;
			while(n.next!=null){
				n = n.next;
			}
			n.next =  node;
		}
		
	}
	public void insertAtStart(int data){
		Node node = new Node();
		node.data = data;
		node.next = null;
		node.next = head;
		head = node;
	}
	
	public void insertAt(int index,int data)
	{
		Node node = new Node();
		node.data = data;
		node.next = null;
		
		if(index==0){
			insertAtStart(data);
		}
		else{
		Node n = head;
		for(int i=0;i<index-1;i++){
			n = n.next;
		}
		node.next = n.next;
		n.next = node;
		}
	}
	
	public void deleteAt(int index){
		if(index==0){
			head = head.next;
		}
		else{
			Node n = head;
			Node n1 = null;
			for(int i=0;i<index-1;i++){
				n = n.next;
			}
			n1 = n.next;
			n.next = n1.next;
			//System.out.println("n1 " + n1.data);
			n1 = null;
		}
	}

	public Node search(int key) {
		Node current = head;

		while (current != null) {
			if (current.data == key) {
				return current;
			}
			current = current.next;
		}

		return null; // key not found in list
	}
	
	public void show(){
		Node node = head;
		
		while(node.next!=null){
			System.out.println(node.data);
			node = node.next;
		}
		System.out.println(node.data);
	}
    
	public void sort() {
		Node current = head, index = null;
		int temp;

		if (head == null) {
			return;
		} else {
			while (current != null) {
				index = current.next;

				while (index != null) {
					if (current.data > index.data) {
						temp = current.data;
						current.data = index.data;
						index.data = temp;
					}
					index = index.next;
				}
				current = current.next;
			}
		}
	}

}
