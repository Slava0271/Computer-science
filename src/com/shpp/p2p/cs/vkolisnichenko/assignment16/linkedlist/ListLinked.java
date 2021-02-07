package com.shpp.p2p.cs.vkolisnichenko.assignment16.linkedlist;

import com.shpp.p2p.cs.vkolisnichenko.assignment16.interfaces.MyList;

import java.util.Iterator;

/**
 * The class in which the linked list is
 * implemented based on the linked list
 *
 * @param <E> - generic
 */
public class ListLinked<E> implements MyList<E>, Iterable<E> {
    //first tree node
    private Node<E> firstNode;
    //last tree node
    private Node<E> lastNode;
    //list size
    private int size = 0;


    public ListLinked() {
        lastNode = new Node<E>(null, firstNode, null);
        firstNode = new Node<E>(null, null, lastNode);
    }

    /**
     * A method that checks the index entered by the user for out of bounds
     *
     * @param index - entered index
     * @return Valid or not
     */
    private boolean isIndex(int index) {
        return index > size - 1 || index < 0;
    }

    /**
     * The method in which items are added to
     * the list by changing the last item and links
     *
     * @param e - value
     */
    @Override
    public void add(E e) {
        Node<E> node = lastNode;
        node.setCurrentElement(e);
        lastNode = new Node<>(null, node, null);
        node.setNext(lastNode);
        size++;
    }

    /**
     * A method that adds an element to the beginning of
     * the list by modifying the first element
     * and node references
     *
     * @param e - added element
     */
    public void addFirst(E e) {
        Node<E> node = firstNode;
        node.setCurrentElement(e);
        firstNode = new Node<>(null, null, node);
        node.setPrev(firstNode);
        size++;
    }

    /**
     * Method that checks if the list is empty
     *
     * @return empty or no
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Method for checking a list for the content of an element
     *
     * @param e - The value to be checked
     * @return - contains or no
     */
    @Override
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (get(i).equals(e))
                return true;
        }
        return false;
    }

    /**
     * Method that completely clears
     * the list and resets the size
     */
    //todo
    @Override
    public void clear() {
        firstNode = null;
        lastNode = null;
        size = 0;
    }

    /**
     * Method that checks the size of the list
     * and the entered index for correctness
     *
     * @param index - input index
     */
    private void checkIndexAndSize(int index) {
        if (isIndex(index))
            throw new ArrayIndexOutOfBoundsException
                    ("You entered an invalid index");
        if (size() == 0) {
            throw new NullPointerException("The list is empty");
        }
    }

    /**
     * A method that removes an item from a list
     * by changing the links to the previous and next items
     *
     * @param index - input index
     * @return - Deleted item
     */
    @Override
    public E remove(int index) {
        if (size > 0 && index - 1 < size) {
            Node<E> node = firstNode.next;
            checkIndexAndSize(index);
            if (index == 0) {
                firstNode.next = node.next;
                node.next.prev = firstNode;
            } else if (index > 0) {
                for (int i = 0; i < index; i++) {
                    node = node.next;
                }
                if (size > 1) {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;

                }
            }

            size--;
            return node.currentElement;
        }
        throw new NegativeArraySizeException("The list is empty, deletion is impossible");
    }


    /**
     * A method that returns an element from the
     * list by the index entered in the parameters
     *
     * @param index - entered index
     * @return - element
     */
    @Override
    public E get(int index) {
        checkIndexAndSize(index);
        Node<E> node = firstNode.getNext();
        for (int i = 0; i < index; i++) {
            node = next(node);
        }
        return node.getCurrentElement();
    }

    /**
     * Method that returns the next node
     *
     * @param n - current node
     * @return - next node
     */
    private Node<E> next(Node<E> n) {
        return n.getNext();
    }

    /**
     * Method in which the element in the sheet by the
     * index entered in the parameters is replaced
     * by the element entered in the parameters
     *
     * @param index - entered index
     * @param e     - the element to replace
     */
    @Override
    public void set(int index, E e) {
        checkIndexAndSize(index);
        Node<E> node = firstNode.getNext();
        for (int i = 0; i < index; i++) {
            node = next(node);
        }
        node.setCurrentElement(e);
    }

    /**
     * @return list size
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * A method that implements an iterator for
     * a list in order to iterate over it for-each
     *
     * @return - iterator
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int count = 0;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public E next() {
                return get(count++);
            }
        };
    }

}
