package com.shpp.p2p.cs.vkolisnichenko.assignment17.previoushomeworks.collecctions.linkedlist;

/**
 * The class that represents the node
 * for the LinkedList implementation
 *
 * @param <E> - generic
 */
class Node<E> {
    //element
    E currentElement;
    //next node
    Node<E> next;
    //previous node
    Node<E> prev;

    Node(E currentElement, Node<E> prev, Node<E> next) {
        this.currentElement = currentElement;
        this.next = next;
        this.prev = prev;
    }

    public E getCurrentElement() {
        return currentElement;
    }

    public void setCurrentElement(E currentElement) {
        this.currentElement = currentElement;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getPrev() {
        return prev;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }
}