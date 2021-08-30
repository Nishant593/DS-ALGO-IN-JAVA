package com.nishant.algorithms.datastructure.stack;

public class StackDynamicArrayImpl<T> implements Stack<T> {

	private int top = -1;
	private int size;
	private T[] arr;

	public StackDynamicArrayImpl() {
		this(10);
	}

	public StackDynamicArrayImpl(int size) {
		this.size = size;
		arr = (T[]) new Object[this.size];
	}

	public void push(T t) {
		if (this.top == this.size - 1) {
			T[] newArr = (T[]) new Object[this.size * 2];
			System.arraycopy(this.arr, 0, newArr, 0, size);
			this.arr = newArr;
			this.size = this.size* 2;
		}
		this.top++;
		this.arr[this.top] = t;
	}

	public T pop() {
		if (this.top == -1)
			throw new IndexOutOfBoundsException();
		T value = this.arr[this.top];
		this.arr[this.top] = null;
		this.top--;
		return value;
	}

	public T peek() {
		if (this.top == -1)
			throw new IndexOutOfBoundsException();
		return this.arr[this.top];
	}

	public T top() {
		if (this.top == -1)
			throw new IndexOutOfBoundsException();
		return this.arr[this.top];
	}

	public boolean isEmpty() {
		return this.top == -1;
	}
	
	public static void main(String[] args) {
		Stack<String> stack = new StackDynamicArrayImpl<String>(5);
		stack.push("a");stack.push("b");stack.push("c");stack.push("d");stack.push("e");
		stack.push("f");stack.push("g");stack.push("h");stack.push("i");stack.push("j");
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
	}

}
