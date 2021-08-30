package com.nishant.algorithms.datastructure.stack;

import com.nishant.algorithms.datastructure.linkedlist.Node;

public class StackLinkedListImpl<T> implements Stack<T> {

	Node<T> head;

	public StackLinkedListImpl() {
		// TODO Auto-generated constructor stub
	}

	public StackLinkedListImpl(T data) {
		this.head = new Node<T>(data);
	}

	public void push(T t) {
		Node<T> node = new Node<T>(t);
		node.setNext(this.head);
		this.head.setNext(head);
	}

	public T pop() {
		if (this.head == null)
			throw new IndexOutOfBoundsException();
		T value = this.head.getData();
		this.head.setNext(this.head.getNext());
		return value;
	}

	public T peek() {
		if (this.head == null)
			throw new IndexOutOfBoundsException();
		return this.head.getData();
	}

	public T top() {
		if (this.head == null)
			throw new IndexOutOfBoundsException();
		return this.head.getData();
	}

	public boolean isEmpty() {
		return this.head == null;
	}

}
