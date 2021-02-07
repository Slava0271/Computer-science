package com.shpp.p2p.cs.vkolisnichenko.assignment17.previoushomeworks.collecctions.interfaces;

/**
 * The interface for lists in which basic methods are created
 *
 * @param <E> - generic
 */
public interface MyList<E> {
    void add(E e);

    void clear();

    boolean isEmpty();

    boolean contains(E e);

    E remove(int index);

    E get(int index);

    void set(int index, E e);

    int size();

}
