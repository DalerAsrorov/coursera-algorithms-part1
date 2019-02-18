package StackOfStrings;

public class ResizingArrayStackOfStrings {
	private String[] strs;
	private int index = 0;

	public ResizingArrayStackOfStrings() {
		strs = new String[1];
	}

	public void push(String item) {
		if (index == strs.length) {
			this.resize(strs.length * 2);
		}

		strs[index++] = item;
	}

	public String pop() {
		String item = strs[--index];
		// allow garbage collector to reclaim the memory
		strs[index] = null;
		return item;
	}

	private void resize(int newSize) {
		String[] copy = new String[newSize];

		for (int i = 0; i < strs.length; i++) {
			copy[i] = strs[i];
		}

		strs = copy;
	}

	public void print() {
		for (int i = index - 1; i >= 0; i--) {
			System.out.print(strs[i] + ", ");
		}
		System.out.println("\n");
	}

	public static void main(String[] args) {
		ResizingArrayStackOfStrings stack = new ResizingArrayStackOfStrings();
		stack.push("1");
		System.out.println(stack.strs.length);
		stack.push("2");
		System.out.println(stack.strs.length);
		stack.push("3");
		System.out.println(stack.strs.length);
		stack.print();
		stack.pop();
		stack.print();
	}
}
