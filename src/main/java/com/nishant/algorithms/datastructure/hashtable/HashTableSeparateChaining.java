package com.nishant.algorithms.datastructure.hashtable;

import com.nishant.algorithms.datastructure.linkedlist.LinkedList;
import com.nishant.algorithms.datastructure.linkedlist.Node;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Entry<K, V> {
    int hash;
    K key;
    V value;

    public Entry(K k, V v) {
        this.key = k;
        this.value = v;
        this.hash = k.hashCode();
    }

    public boolean equlas(Entry<K, V> entryObj) {
        if (this.hash != entryObj.hash) return false;
        return this.key.equals(entryObj.key);
    }
}

public class HashTableSeparateChaining<K, V> {

    private int size;
    private LinkedList<Entry<K, V>>[] table;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;
    private static final int DEFAULT_CAPACITY = 3;
    private int capacity;
    private double loadFactor;

    public HashTableSeparateChaining() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public HashTableSeparateChaining(int capacity, double loadFactor) {
        if (capacity <= 0 || loadFactor <= 0) {
            throw new IllegalArgumentException("capacity or loadFactor can not be <= 0");
        }
        this.size = 0;
        this.capacity = Math.max(capacity, DEFAULT_CAPACITY);
        this.loadFactor = Math.max(loadFactor, DEFAULT_LOAD_FACTOR);
        this.table = new LinkedList[this.capacity];
    }

    public void put(K key, V value) {
        insert(key, value);
    }

    public Set<K> keyset(){
        Set<K> keyset = new HashSet<>();
        for (LinkedList<Entry<K, V>> list : this.table) {
            if (list == null) {
                continue;
            }
            Node<Entry<K, V>> temp = list.getHead();
            while (temp != null) {
                keyset.add(temp.getData().key);
                temp = temp.getNext();
            }
        }
        return keyset;
    }

    public List<K> keys(){
        List<K> keys = new ArrayList<>();
        for (LinkedList<Entry<K, V>> list : this.table) {
            if (list == null) {
                continue;
            }
            Node<Entry<K, V>> temp = list.getHead();
            while (temp != null) {
                keys.add(temp.getData().key);
                temp = temp.getNext();
            }
        }
        return keys;
    }

    public List<V> values(){
        List<V> values = new ArrayList<>();
        for (LinkedList<Entry<K, V>> list : this.table) {
            if (list == null) {
                continue;
            }
            Node<Entry<K, V>> temp = list.getHead();
            while (temp != null) {
                values.add(temp.getData().value);
                temp = temp.getNext();
            }
        }
        return values;
    }

    public boolean remove(K key){
        if (key == null) {
            new IllegalArgumentException("key can not be null.");
        }
        int index = key.hashCode();
        LinkedList<Entry<K, V>> list =  this.table[index];
        Node<Entry<K, V>> temp = list.getHead();
        while (temp != null) {
            if(temp.getData().key.equals(key)){
                list.remove(temp.getData());
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    public V get(K key) {
        if (key == null) {
            new IllegalArgumentException("key can not be null.");
        }
        int index = key.hashCode();
        LinkedList<Entry<K, V>> list =  this.table[index];
        Node<Entry<K, V>> temp = list.getHead();
        while (temp != null) {
            if(temp.getData().key.equals(key)){
                return temp.getData().value;
            }
            temp = temp.getNext();
        }
        return null;
    }

    private void insert(K key, V value) {
        if (key == null) {
            new IllegalArgumentException("key can not be null.");
        }
        if (isLoadFactorAchieved()) {
            resizeTable();
        }
        int index = getIndex(key);
        if (this.table[index] == null) {
            LinkedList<Entry<K, V>> list = new LinkedList<>();
            this.table[index] = list;
        }
        Node<Entry<K, V>> temp = this.table[index].getHead();
        Entry<K, V> entryObj = new Entry<>(key, value);
        boolean isObjectAvailable = false;
        while (temp != null) {
            isObjectAvailable = temp.getData().equlas(entryObj);
            if (isObjectAvailable) {
                temp.getData().value = value;
            }
            temp = temp.getNext();
        }
        if (!isObjectAvailable) {
            this.table[index].add(entryObj);
            this.size++;
        }
    }

    private void resizeTable() {
        this.capacity *= 2;
        LinkedList<Entry<K, V>>[] tempTable = new LinkedList[this.capacity];
        for (LinkedList<Entry<K, V>> list : this.table) {
            if (list == null) {
                continue;
            }
            Node<Entry<K, V>> temp = list.getHead();
            while (temp != null) {
                LinkedList<Entry<K, V>> entryLinkedList = tempTable[getIndex(temp.getData().key)];
                if (entryLinkedList == null) {
                    entryLinkedList = new LinkedList<Entry<K, V>>();
                    tempTable[getIndex(temp.getData().key)] = entryLinkedList;
                }
                entryLinkedList.add(temp.getData());
                temp = temp.getNext();
            }
        }
        this.table = tempTable;
    }

    private boolean isLoadFactorAchieved() {
        return (this.size / this.capacity) >= this.loadFactor;
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % this.capacity;
    }

}
