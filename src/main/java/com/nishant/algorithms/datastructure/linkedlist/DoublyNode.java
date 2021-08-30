package com.nishant.algorithms.datastructure.linkedlist;

public class DoublyNode<T> {

	private T data;
	private DoublyNode<T> next;
	private DoublyNode<T> previous;

	public DoublyNode() {
	}

	public DoublyNode(T data) {
		this.data = data;
		this.next = null;
	}

	public DoublyNode<T> getNext() {
		return next;
	}

	public void setNext(DoublyNode<T> next) {
		this.next = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public DoublyNode<T> getPrevious() {
		return previous;
	}

	public void setPrevious(DoublyNode<T> previous) {
		this.previous = previous;
	}

}
