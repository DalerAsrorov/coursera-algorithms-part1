package week2.Quiz;

import java.util.Iterator;
import java.util.Stack;

public class QueueWithTwoStacks<Item> {
	private Stack<Item> mainStack;
	private Stack<Item> tempStack;

	public QueueWithTwoStacks() {
		mainStack = new Stack<Item>();
		tempStack = new Stack<Item>();
	}

	public void enqueue(Item item) {
		while (!mainStack.isEmpty()) {
			tempStack.push(mainStack.pop());
		}

		mainStack.push(item);

		while (!tempStack.isEmpty()) {
			mainStack.push(tempStack.pop());
		}
	}

	public Item peek() {
		return mainStack.peek();
	}

	public Item dequeue() {
		return mainStack.pop();
	}

	public boolean isEmpty() {
		return mainStack.isEmpty();
	}

	public String toString() {
		return this.mainStack.toString();
	}

	public static void main(String[] args) {
		QueueWithTwoStacks<String> queue = new QueueWithTwoStacks<>();

		queue.enqueue("Daler");
		queue.enqueue("Asrorov");
		queue.enqueue("Hello");
		System.out.println(queue);
		queue.dequeue();
		System.out.println(queue);
	}
}
