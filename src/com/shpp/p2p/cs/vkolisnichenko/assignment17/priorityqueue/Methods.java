package com.shpp.p2p.cs.vkolisnichenko.assignment17.priorityqueue;

/**
 * Interface with methods for the priority queue
 * @param <E> - generic
 */
public interface Methods<E> {
    E add(E e);
    E get();
    E delete();
    int size();
}
