package week2.Quiz;

import week2.Stack;

public class MaxStack {
	private Stack<Integer> mainStack;
	private Stack<Integer> maxStack;

	public MaxStack() {
		mainStack = new Stack<>();
		maxStack = new Stack<>();
	}

	public void push(Integer item) {
		mainStack.push(item);

		if (maxStack.isEmpty() || item > maxStack.peek()) {
			maxStack.push(item);
		} else {
			maxStack.push(maxStack.peek());
		}
	}

	public Integer pop() {
		maxStack.pop();
		return mainStack.pop();
	}

	public Integer max() {
		return maxStack.peek();
	}

	public static void main(String[] args) {
		MaxStack stack = new MaxStack();

		stack.push(2);
		System.out.println(stack.max());
		stack.push(12);
		System.out.println(stack.max());
		stack.push(4);
		System.out.println(stack.max());
		stack.push(3);
		System.out.println(stack.max());
		stack.push(22);
		System.out.println(stack.max());
		stack.push(1);
		System.out.println(stack.max());

		stack.pop();
		System.out.println("After pop: " + stack.max());
		stack.pop();
		System.out.println("After pop: " + stack.max());
	}
}
