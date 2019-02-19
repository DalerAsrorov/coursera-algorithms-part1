package week2;

public class ArrayQueueOfStrings {
	String[] queue;
	int first;
	int last;
	int numberOfItems;
	
	public ArrayQueueOfStrings(int n) {
		queue = new String[1];
		first = 0;
		last = 0;
		numberOfItems = 0;
	}
	
	public String top() {
		if (isEmpty()) {
			return null;
		}
		return queue[first];
	}
	
	public boolean isEmpty() {
		return numberOfItems == 0;
	}
	
	public void resize(int newSize) {
		String[] copy = new String[newSize];
		
		for (int i = 0; i < queue.length; i++) {
			copy[i] = queue[i];
		}
		
		queue = copy;
	}
	
	public void enqueue(String item) {
		if (last == queue.length) {
			this.resize(queue.length * 2);
		}

		queue[last++] = item;
		numberOfItems++;
	}
	
	public String dequeue() {
		if (isEmpty()) {
			System.out.println("Cannot dequeue an empty queue");
			return "";
		}
		String item = queue[first++];
		numberOfItems--;
		return item;
	}
	
	public void print() {
		for (int i = first; i < last; i++) {
			System.out.print(this.queue[i] + "=>");
		}
		System.out.println("\n");
	}
	
	public static void main(String [] args) {
		ArrayQueueOfStrings queue = new ArrayQueueOfStrings(10);
		queue.enqueue("hi");
		queue.enqueue("bye");
		queue.print();
		queue.dequeue();
		queue.print();
		queue.enqueue("trello");
		queue.enqueue("bello");
		queue.print();
		queue.dequeue();
		queue.dequeue();
		queue.print();
	}
}
