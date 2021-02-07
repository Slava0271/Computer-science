package com.shpp.p2p.cs.vkolisnichenko.assignment17.hashmap;


import java.util.LinkedList;

public class MyHashMap<K, V> implements Methods<K, V> {
    //An array whose value is stored in the linked list
    private Node<K, V>[] hashTable;
    //Number of cells to fill
    private double reserve;
    //map size
    private int size = 0;
    //Factor for filling the map
    private final double FILL_FACTOR = 0.75;
    //begin map size
    private final int beginSize = 16;
    //Counter for counting the number of times the array is increased
    private int countOfIteration = 0;


    public MyHashMap() {
        hashTable = new Node[beginSize];
        reserve = hashTable.length * FILL_FACTOR;
    }

    public Node<K, V>[] getHashTable() {
        return hashTable;
    }

    /**
     * The method in which the elements are added to
     * the map, by the index which the hash
     * method will return
     *
     * @param key   - element key
     * @param value element value
     * @return - value
     */
    @Override
    public V put(K key, V value) {
        if (size + 1 >= reserve) {
            expandArray();
        }
        Node<K, V> node = new Node<>(key, value);
        int index = Math.abs(node.hash());
        if (hashTable[index] == null) {
            hashTable[index] = new Node<>(null, null);
            hashTable[index].getList().add(node);
            size++;
            return value;
        }
        LinkedList<Node<K, V>> linkedList = hashTable[index].getList();
        for (Node<K, V> n : linkedList) {
            if (collision(node, n)) {
                linkedList.add(node);
                size++;
                return value;
            } else if (checkKeyExists(node, n)) {
                n.setValue(value);
                size++;
                return value;
            }

        }
        return null;
    }

    /**
     * The method in which the array expands
     * if it was 75 percent full
     */
    private void expandArray() {
        countOfIteration++;
        reserve = reserve * 2;
        Node<K, V>[] array = hashTable;
        hashTable = new Node[array.length * 2];
        size = 0;
        for (Node<K, V> node : array) {
            if (node != null)
                for (Node<K, V> n : node.getList()) {
                    put(n.getKey(), n.getValue());
                }
        }
    }

    /**
     * The method in which the item in the map is
     * obtained by key, by obtaining the index
     * using the hash method
     *
     * @param key - element key
     * @return value
     */
    @Override
    public V get(K key) {
        int index = Math.abs(hash(key));
        if (hashTable[index] == null) {
            index = index - (countOfIteration * beginSize);
            if (hashTable[index] == null)
                throw new NullPointerException();
        }

        LinkedList<Node<K, V>> linkedList = hashTable[index].getList();

        for (Node<K, V> n : linkedList) {
            if (key.equals(n.getKey()))
                return n.getValue();
        }

        return null;
    }

    /**
     * The method in which the element is removed
     * from the array by key
     *
     * @param key - key element
     * @return - deleted value
     */
    @Override
    public V remove(K key) {
        int index = hash(key);
        if (hashTable[index] == null)
            return null;

        if (hashTable[index].getList().size() == 1) {
            V value = hashTable[index].getList().get(0).getValue();
            hashTable[index] = null;
            size--;
            return value;
        }

        LinkedList<Node<K, V>> list = hashTable[index].getList();
        for (Node<K, V> node : list) {
            if (key.equals(node.getKey())) {
                list.remove(node);
                size--;
                return node.getValue();
            }
        }

        return null;
    }

    /**
     * @return size
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Formula to calculate an array cell for an element
     *
     * @param key element key
     * @return code
     */
    private int hash(K key) {
        int hash = 31 * 17 + key.hashCode();
        return hash % hashTable.length;
    }

    /**
     * The method in which a collision check
     * is performed by comparing hash codes
     * and using the method equals
     *
     * @param node     - input node
     * @param listNode - node in linkedlist
     * @return true or false
     */
    private boolean collision(Node<K, V> node, Node<K, V> listNode) {
        return node.hash() == listNode.hash()
                && !node.getKey().equals(listNode.getKey())
                && !node.getValue().equals(listNode.getValue());

    }


    /**
     * The method in which it is checked whether
     * the same key is already in the map or not
     *
     * @param node - input node
     * @param listNode - list node
     * @return true or false
     */
    private boolean checkKeyExists(Node<K, V> node, Node<K, V> listNode) {
        return node.getKey().equals(listNode.getKey()) &&
                !node.getValue().equals(listNode.getValue());
    }
}

