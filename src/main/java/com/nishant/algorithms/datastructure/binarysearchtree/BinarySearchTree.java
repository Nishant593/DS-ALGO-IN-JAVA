package com.nishant.algorithms.datastructure.binarysearchtree;

import com.nishant.algorithms.datastructure.queue.Queue;
import com.nishant.algorithms.datastructure.queue.QueueLinkedListImpl;

public class BinarySearchTree<T extends Comparable<T>> {

    private int nodeCount = 0;
    private Node<T> root;

    public boolean add(T data) {
        boolean containsData = contains(data);
        if (!containsData) {
            add(this.root, data);
            this.nodeCount++;
        }
        return !containsData;
    }

    private Node<T> add(Node<T> root, T data) {
        if (root == null) {
            root = new Node<>();
            root.setData(data);
        } else {
            if (data.compareTo(root.getData()) > 0) {
                root.setLeft(add(root.getLeft(), data));
            } else {
                root.setRight(add(root.getRight(), data));
            }
        }
        return root;
    }

    public boolean remove(T data) {
        boolean containsData = contains(data);
        if (containsData) {
            remove(this.root, data);
            this.nodeCount--;
        }
        return containsData;
    }

    private Node<T> remove(Node<T> root, T data) {
        if (root == null) return null;
        int compareValue = data.compareTo(root.getData());
        if (compareValue > 0) {
            return remove(root.getRight(), data);
        } else if (compareValue < 0) {
            return remove(root.getLeft(), data);
        } else {
            if (root.getLeft() == null) {
                return root.getRight();
            } else if (root.getRight() == null) {
                return root.getLeft();
            } else {
                Node<T> temp = findMin(root.getRight());
                root.setData(temp.getData());
                remove(root.getRight(), temp.getData());

                /*
                Alternate approach
                Node<T> temp = findMax(root.getLeft());
                root.setData(temp.getData);
                remove(root.getLeft(), temp.getData());
                 */
            }
        }
        return root;
    }

    private Node<T> findMin(Node<T> node) {
        Node<T> temp = node;
        while (temp.getLeft() != null) {
            temp = temp.getLeft();
        }
        return temp;
    }

    private Node<T> findMax(Node<T> node) {
        Node<T> temp = node;
        while (temp.getRight() != null) {
            temp = temp.getRight();
        }
        return temp;
    }

    private boolean contains(T data) {
        return contains(this.root, data);
    }

    private boolean contains(Node<T> root, T data) {
        if (root == null) return false;
        int compareValue = data.compareTo(root.getData());
        if (compareValue > 0) return contains(root.getRight(), data);
        else if (compareValue < 0) return contains(root.getLeft(), data);
        else return true;
    }

    public void preOrder(Node<T> node) {
        if (node == null) {
            return;
        }
        System.out.println(node.getData());
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    public void inOrder(Node<T> node) {
        if (node == null) {
            return;
        }
        inOrder(node.getLeft());
        System.out.println(node.getData());
        inOrder(node.getRight());
    }

    public void postOrder(Node<T> node) {
        if (node == null) {
            return;
        }
        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.println(node.getData());
    }

    public void levelOrder() {
        if (this.root == null) {
            return;
        }
        Queue<Node<T>> buffer = new QueueLinkedListImpl<>();
        buffer.enqueue(this.root);
        while (!buffer.isEmpty()) {
            System.out.println(buffer.front().getData());
            Node<T> temp = buffer.dequeue();
            if (temp.getLeft() != null) {
                buffer.enqueue(temp.getLeft());
            }
            if (temp.getRight() != null) {
                buffer.enqueue(temp.getRight());
            }
        }
    }

    public int height(){
        return height(this.root);
    }

    private int height(Node<T> root) {
        if(root==null) return 0;
        return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
    }

    public int size() {
        return this.nodeCount;
    }

    public boolean isEmpty() {
        return this.nodeCount == 0;
    }

}
