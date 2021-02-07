package com.shpp.p2p.cs.vkolisnichenko.assignment17.previoushomeworks.collecctions.interfaces;

/**
 * the interface where the methods needed
 * for the stack and queue are created
 *
 * @param <E> - generic
 */
public interface ForQueueAndStack<E> {
    boolean empty();

    E peek();

    E pop();

    E push(E e);

    int size();
}
