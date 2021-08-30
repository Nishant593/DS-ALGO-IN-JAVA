package com.nishant.algorithms.datastructure.stack;

public interface Stack<T> {

	public void push(T t);

	public T pop();

	public T peek();

	public T top();

	public boolean isEmpty();

}
