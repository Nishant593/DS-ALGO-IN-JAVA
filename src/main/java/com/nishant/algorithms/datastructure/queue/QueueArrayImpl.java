package com.nishant.algorithms.datastructure.queue;

public class QueueArrayImpl<T> implements Queue<T> {

	private T[] arr;

	private int front;

	private int rear;

	private int capacity;

	private int size;

	public QueueArrayImpl() {
		this(10);
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public boolean isFull() {
		return this.size == this.capacity;
	}

	public T front() {
		if (isEmpty())
			throw new IndexOutOfBoundsException("Queue is empty.");
		return this.arr[this.front];
	}

	public T rear() {
		if (isEmpty())
			throw new IndexOutOfBoundsException("Queue is empty.");
		return this.arr[this.rear];
	}

	public QueueArrayImpl(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.front = 0;
		this.rear = this.capacity - 1;
		this.arr = (T[]) new Object[capacity];
	}

	public void enqueue(T t) {
		if (isFull())
			throw new IndexOutOfBoundsException("Queue is full.");
		this.rear = (this.rear + 1) % this.capacity;
		this.arr[this.rear] = t;
		this.size++;
	}

	public T dequeue() {
		if (isEmpty())
			throw new IndexOutOfBoundsException("Queue is empty.");
		T value = this.arr[this.front];
		this.front = (this.front + 1) % this.capacity;
		this.size--;
		return value;
	}

	public static void main(String[] args) {
		QueueArrayImpl<Integer> queue = new QueueArrayImpl<Integer>(5);

		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		System.out.println(queue.dequeue() + " dequeued from queue\n");
		queue.enqueue(40);
		queue.enqueue(50);
		queue.enqueue(60);
		System.out.println(queue.dequeue() + " dequeued from queue\n");
		queue.enqueue(70);
		queue.enqueue(80);

		System.out.println(queue.dequeue() + " dequeued from queue\n");

		System.out.println("Front item is " + queue.front());

		System.out.println("Rear item is " + queue.rear());
	}

}
