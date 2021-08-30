package com.nishant.algorithms.datastructure.queue;

import com.nishant.algorithms.datastructure.linkedlist.DoublyNode;

public class QueueLinkedListImpl<T> implements Queue<T> {

	private DoublyNode<T> front;
	
	private DoublyNode<T> rear;
	
	public QueueLinkedListImpl() {
		
	}

	public void enqueue(T t) {
		DoublyNode<T> node = new DoublyNode<T>(t);
		if(isEmpty()) {
			this.front = node;
			this.rear = node;
		}
		node.setPrevious(rear);
		rear.setNext(node);
		this.rear = node;
	}

	public T dequeue() {
		if(isEmpty()) {
			throw new IndexOutOfBoundsException();
		}
		T value = this.front.getData();
		DoublyNode<T> temp = this.front.getNext();
		temp.setPrevious(null);
		this.front.setNext(null);
		this.front = temp;
		temp = null;
		return value;
	}

	public boolean isEmpty() {
		return this.front == null;
	}

	public boolean isFull() {
		return false;
	}

	public T front() {
		T value = null;
		if (this.front != null) {
			value = this.front.getData();
		}
		return value;
	}

	public T rear() {
		T value = null;
		if (this.rear != null) {
			value = this.rear.getData();
		}
		return value;
	}

}
