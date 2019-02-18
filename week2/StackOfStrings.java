package StackOfStrings;

class Node {
	String item;
	Node next;
}

public class StackOfStrings {
	private Node top;

	public StackOfStrings() {
		top = null;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public void push(String data) {
		Node oldTop = top;
		top = new Node();
		top.item = data;
		top.next = oldTop;
	}

	public String pop() {
		Node deleted = top;
		top = top.next;
		return deleted.item;
	}

	public void print() {
		Node last = top;
		while (last != null) {
			System.out.print(last.item + ", ");
			last = last.next;
		}
		System.out.println("\n");
	}

	public static void main(String[] args) {
		StackOfStrings stack = new StackOfStrings();
		stack.push("1");
		stack.push("2");
		stack.push("3");
		stack.print();
		stack.pop();
		stack.print();
	}
}
