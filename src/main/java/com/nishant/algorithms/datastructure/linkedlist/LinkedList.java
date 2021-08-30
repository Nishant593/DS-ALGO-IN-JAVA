package com.nishant.algorithms.datastructure.linkedlist;

public class LinkedList<T> {

	private Node<T> head;

	private int size = 0;

	public LinkedList() {
	}

	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

	public void add(T t) {
		this.size++;
		if (this.head == null) {
			this.head = new Node<T>(t);
			return;
		}
		Node<T> temp = this.head;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		temp.setNext(new Node<T>(t));
	}

	public void add(int index, T t) {
		if (index <0 || index > size)
			throw new IndexOutOfBoundsException();
		int count = 0;
		Node<T> temp = this.head;
		Node<T> prev = null;
		while (temp != null && count < index) {
			prev = temp;
			temp = temp.getNext();
			count++;
		}
		Node<T> node = new Node<T>(t);
		node.setNext(temp);
		if (index == 0) {
			this.head = node;
		} else {
			prev.setNext(node);
		}
		this.size++;
	}

	public boolean remove(T t) {
		if (t == null) {
			return false;
		}
		Node<T> temp = this.head;
		Node<T> prev = null;
		while (temp != null) {
			if (temp.getData().equals(t)) {
				if (temp == this.head)
					this.head = this.head.getNext();
				else
					prev.setNext(temp.getNext());
				this.size--;
				return true;
			}
			prev = temp;
			temp = temp.getNext();
		}
		return false;
	}

	public void removeAt(int index) {
		if (index <0 || index > size)
			throw new IndexOutOfBoundsException();
		int count = 0;
		Node<T> temp = this.head;
		Node<T> prev = null;
		while (temp != null && count < index) {
			prev = temp;
			temp = temp.getNext();
			count++;
		}
		if (index == 0) {
			this.head = this.head.getNext();
		} else {
			prev.setNext(temp.getNext());
		}
		this.size--;
	}
	
	public int indexOf(T t) {
		Node<T> temp = this.head;
		int count = -1;
		while (temp != null) {
			count++;
			if(temp.getData().equals(t)) {
				return count;
			}
			temp = temp.getNext();
		}
		return -1;
	}
	
	public void print() {
		Node<T> temp = this.head;
		while (temp != null) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
	}

	public boolean contains(T t) {
		return this.indexOf(t) != -1;
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> ints = new LinkedList<Integer>();
		ints.add(1);ints.add(2);ints.add(3);ints.add(4);ints.add(5);
		ints.add(3, 11);
		//ints.print();
		ints.removeAt(1);
		ints.print();
		System.out.println(ints.contains(1001));
	}

}
