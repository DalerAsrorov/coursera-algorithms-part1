package week2;

public class FixedCapacityStackOfStrings {
	private String[] strs;
	private int index = 0;

	public FixedCapacityStackOfStrings(int size) {
		strs = new String[size];
	}

	public boolean isEmpty() {
		return index == 0;
	}

	public void push(String item) {
		strs[index++] = item;
	}

	public String pop() {
		String item = strs[--index];
		// allow garbage collector to reclaim the memory
		strs[index] = null;
		return item;
	}

	public void print() {
		for (int i = index - 1; i >= 0; i--) {
			System.out.print(strs[i] + ", ");
		}
		System.out.println("\n");
	}

	public static void main(String[] args) {
		int size = 10;
		FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(size);
		stack.push("1");
		stack.push("2");
		stack.push("3");
		stack.print();
		stack.pop();
		stack.print();
	}
}
