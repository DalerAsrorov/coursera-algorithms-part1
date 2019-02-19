package week2;



public class LinkedQueueOfStrings {

	private Node first, last;
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void enqueue(String item) {
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) {
			first = last;
		} else {
			oldLast.next = last;
		}
	}
	
	public String dequeue() {
		Node deleted = first;
		first = deleted.next;
		if (isEmpty()) {
			last = null;
		}
		
		return deleted.item;
	}
	
	public void print() {
		Node last = first;
		while (last != null) {
			System.out.print(last.item + ", ");
			last = last.next;
		}
		System.out.println("\n");
	}
	
	public static void main(String[] args) {
		LinkedQueueOfStrings queue = new LinkedQueueOfStrings();
		
		queue.enqueue("Hello");
		queue.enqueue("Bye");
		queue.enqueue("Sye");
		queue.print();
		queue.dequeue();
		queue.print();
	}
}
