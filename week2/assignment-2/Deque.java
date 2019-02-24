import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
	private class Node {
		Item item;
		Node prev;
		Node next;
	}

	private class ListIterator implements Iterator<Item> {
		Node current = first;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if (!hasNext())
				throw new java.util.NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	private Node first, last;
	private int size;

	public Deque() {
		first = null;
		last = null;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void addFirst(Item item) {
		if (item == null) {
			throw new IllegalArgumentException();
		}

		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		if (isEmpty()) {
			last = first;
		} else {
			oldFirst.prev = first;
		}
		++size;
	}

	public void addLast(Item item) {
		if (item == null) {
			throw new IllegalArgumentException();
		}

		Node oldLastNode = last;
		last = new Node();
		last.item = item;
		last.next = null;
		last.prev = oldLastNode;
		if (isEmpty()) {
			first = last;
		} else {
			oldLastNode.next = last;
		}
		++size;
	}

	public Item removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		--size;
		Node prevFirst = first;
		first = prevFirst.next;
		if (isEmpty()) {
			last = first;
		} else {
			first.prev = null;
		}
		return prevFirst.item;
	}

	public Item removeLast() {
		// remove and return the item from the end
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		--size;
		Node prevLast = last;
		last = prevLast.prev;
		if (isEmpty()) {
			first = last;
		} else {
			last.next = null;
		}
		return prevLast.item;
	}

	public static void main(String[] args) {
		// unit testing (optional)
		Deque<Integer> deque = new Deque<Integer>();

		deque.addFirst(2);
		deque.addFirst(1);
		deque.addLast(3);
		deque.addLast(4);
		deque.addLast(5);
		deque.removeFirst();
		deque.removeFirst();
		deque.removeLast();
		deque.removeLast();
		deque.removeLast();

		Iterator<Integer> it = deque.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
}
