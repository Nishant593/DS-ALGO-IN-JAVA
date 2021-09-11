package com.nishant.algorithms.datastructure.binarysearchtree;

public class Node<T extends Comparable<T>> {

    private T data;
    private Node<T> right;
    private Node<T> left;

    public Node(){}

    public Node(T data){
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }
}
