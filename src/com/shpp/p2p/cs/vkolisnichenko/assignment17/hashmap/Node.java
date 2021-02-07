package com.shpp.p2p.cs.vkolisnichenko.assignment17.hashmap;

import java.util.LinkedList;

/**
 * The class in which the node is implemented to implement the hashmap
 *
 * @param <K> - generic
 * @param <V> - generic
 */
public class Node<K, V> {
    //The sheet in which the elements will be stored key / value
    private LinkedList<Node<K, V>> list;
    //element key
    private K key;
    //element value
    private V value;
    //index
    private int hash;

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        list = new LinkedList<>();
    }

    public LinkedList<Node<K, V>> getList() {
        return list;
    }

    /**
     * Method in which the index for storing
     * the element in the array
     *
     * @return index
     */
     int hash() {
        int length = new MyHashMap<K, V>().getHashTable().length;
        return hashCode() % length;
    }

     K getKey() {
        return key;
    }

     V getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        hash = 31 * 17 + key.hashCode();
        return hash;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        Node<K, V> node = (Node) obj;
        return key.equals(node.getKey()) &&
                value.equals(node.getValue()) ||
                node.hashCode() == hash;
    }
}

