package com.nishant.algorithms.datastructure.queue;

public interface Queue<T> {

	public void enqueue(T t);
	
	public T dequeue();
	
	public boolean isEmpty();

	public boolean isFull();

	public T front();

	public T rear();
	
}
