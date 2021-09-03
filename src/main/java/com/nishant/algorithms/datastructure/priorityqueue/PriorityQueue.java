package com.nishant.algorithms.datastructure.priorityqueue;

public class PriorityQueue<T extends Comparable<T>> {

	private T[] arr;
	private int capacity;
	private int size;

	// private java.util.PriorityQueue<T>pq;

	public PriorityQueue() {
		this(10);
	}

	public PriorityQueue(int capacity) {
		this.capacity = capacity;
		this.arr = (T[]) new Comparable[this.capacity];
	}

	public void add(T t) {
		if (isFull())
			throw new IndexOutOfBoundsException("PriorityQueue is full.");
		arr[this.size] = t;
		this.size++;
		bubbleUp();
	}

	private void bubbleUp() {
		int index = this.size - 1;
		int parentIndex = (index - 1) / 2;
		while (this.arr[index].compareTo(this.arr[parentIndex]) < 0) {
			swap(index, parentIndex);
			index = parentIndex;
			parentIndex = (index - 1) / 2;
		}
	}

	private void swap(int index, int parentIndex) {
		T temp = this.arr[parentIndex];
		this.arr[parentIndex] = this.arr[index];
		this.arr[index] = temp;
	}

	public T poll() {
		if (isEmpty())
			throw new IndexOutOfBoundsException("PriorityQueue is empty.");
		T value = this.arr[0];
		swap(0, this.size - 1);
		sinkDown(0);
		this.arr[this.size - 1] = null;
		this.size--;
		return value;
	}

	private void sinkDown(int index) {
		while (true) {
			int leftChildIndex = 2 * index + 1;
			int rightChildIndex = 2 * index + 2;
			if (leftChildIndex < this.size - 1 && this.arr[index].compareTo(this.arr[leftChildIndex]) > 0) {
				swap(index, leftChildIndex);
				index = leftChildIndex;
			} else if (rightChildIndex < this.size - 1 && this.arr[index].compareTo(this.arr[leftChildIndex]) < 0) {
				swap(index, rightChildIndex);
				index = rightChildIndex;
			} else {
				break;
			}
		}
	}

	public T peek() {
		if (isEmpty())
			throw new IndexOutOfBoundsException("PriorityQueue is empty.");
		return this.arr[this.size - 1];
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public boolean isFull() {
		return this.capacity == this.size;
	}

	public void printQueue() {
		for (T t : arr) {
			System.out.println(t);
		}
	}

	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.add(11);
		System.out.println(pq.poll());
		pq.add(1);
		pq.add(90);
		pq.add(32);
		pq.add(63);
		pq.add(93);
		pq.add(77);
		pq.add(17);
		pq.add(11);
		pq.add(42);
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.size);
		pq.printQueue();
	}

}
