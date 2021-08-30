/**
 * 
 */
package com.nishant.algorithms.datastructure.dynamicarray;

/**
 * @author nisha
 *
 */
public class DynamicArray<T> {

	private int capacity;

	private int size;

	private T[] arr;
	
	public DynamicArray() {
		this(10);
	}

	public DynamicArray(int capacity) {
		this.capacity = capacity;
		this.arr = (T[]) new Object[this.capacity];
	}
	
	public void add(T t) {
		if(this.size == this.capacity) {
			T[] newArr = (T[]) new Object[this.capacity*2];
			System.arraycopy(this.arr, 0, newArr, 0, this.size);
			this.arr = newArr;
			this.capacity *= 2;
		}
		this.arr[this.size] = t;
		this.size++;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public void add(int index, T t) {
		this.arr[index] = t;
	}
	
	public void arraycopy(T[] src, int srcStart, T[] dest, int destStart, int length) {
		
		if(src == null || dest == null || dest.length - destStart + 1 < length || src.length - srcStart + 1 < length) {
			return;
		}
		
		for(int i = srcStart, j = destStart; i < length; i++, j++) {
			dest[j] = src[i];
		}
	}

	public void remove(T t) {
		int index = indexOf(t);
		if(index == -1) {
			return;
		}
		for(int i = index; i < size-1; i++) {
			this.arr[i] = this.arr[i+1];
		}
		this.arr[this.size] = null;
		this.size--;
	}

	public void removeAt(int index) {
		if(index < 0 || index >= this.arr.length) {
			throw new IndexOutOfBoundsException();
		}
		for(int i = index; i < size-1; i++) {
			this.arr[i] = this.arr[i+1];
		}
		this.arr[this.size] = null;
		this.size--;
	}
	
	public int indexOf(T t) {
		for(int i = 0; i < this.size; i++) {
			if(this.arr[i].equals(t)) {
				return i;
			}
		}
		return -1;
	}
	
}
