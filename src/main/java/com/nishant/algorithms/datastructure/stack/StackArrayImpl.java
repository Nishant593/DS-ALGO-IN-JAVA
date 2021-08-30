package com.nishant.algorithms.datastructure.stack;

public class StackArrayImpl<T> implements Stack<T> {

	private int top = -1;
	private int size;
	private T[] arr;
	
	public StackArrayImpl() {
		this(10);
	}
	
	public StackArrayImpl(int size) {
		this.size = size;
		arr = (T[]) new Object[this.size];
	}

	public void push(T t) {
		if(this.top == this.size -1) throw new IndexOutOfBoundsException();
		this.top++;
		this.arr[this.top] = t;
	}

	public T pop() {
		if(this.top == -1) throw new IndexOutOfBoundsException();
		T value = this.arr[this.top];
		this.arr[this.top] = null;
		this.top--;
		return value;
	}

	public T peek() {
		if(this.top == -1) throw new IndexOutOfBoundsException();
		return this.arr[this.top];
	}

	public T top() {
		if(this.top == -1) throw new IndexOutOfBoundsException();
		return this.arr[this.top];
	}

	public boolean isEmpty() {
		return this.top == -1;
	}

}
