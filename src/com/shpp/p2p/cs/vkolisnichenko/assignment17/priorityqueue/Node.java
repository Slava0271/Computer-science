package com.shpp.p2p.cs.vkolisnichenko.assignment17.priorityqueue;

/**
 * The class in which a node object is created
 * to implement a singly linked list
 *
 * @param <E> - generic
 */
public class Node<E> {
    //The current element in the node
    private E currentElement;
    //Link to next item
    private Node<E> nextElement;

    /**
     * Method in which a clone of the current object is created
     *
     * @return clone object
     */
    @Override
    protected Object clone() {
        Node<E> node = new Node<>(currentElement, nextElement);
        node.currentElement = this.currentElement;
        node.nextElement = this.nextElement;

        return node;
    }

    public Node(E currentElement, Node<E> nextElement) {
        this.currentElement = currentElement;
        this.nextElement = nextElement;
    }

    E getCurrentElement() {
        return currentElement;
    }

    void setCurrentElement(E currentElement) {
        this.currentElement = currentElement;
    }

    Node<E> getNextElement() {
        return nextElement;
    }

    void setNextElement(Node<E> nextElement) {
        this.nextElement = nextElement;
    }
}
