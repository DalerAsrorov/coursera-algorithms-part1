package week2;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
	private class Node {
		Item item;
		Node next;
	}

	private class ListIterator implements Iterator<Item> {
		private Node current = top;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}

	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();

	}

	private Node top;

	public Stack() {
		top = null;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public Item peek() {
		return top.item;
	}

	public void push(Item data) {
		Node oldTop = top;
		top = new Node();
		top.item = data;
		top.next = oldTop;
	}

	public Item pop() {
		Item deleted = top.item;
		top = top.next;
		return deleted;
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
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.pop();

		Iterator<Integer> it = stack.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
