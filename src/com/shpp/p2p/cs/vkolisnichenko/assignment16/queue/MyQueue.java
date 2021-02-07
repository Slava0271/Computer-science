package com.shpp.p2p.cs.vkolisnichenko.assignment16.queue;

import com.shpp.p2p.cs.vkolisnichenko.assignment16.arraylist.ListArray;
import com.shpp.p2p.cs.vkolisnichenko.assignment16.interfaces.ForQueueAndStack;

/**
 * A class that implements its own queue based on a linked list
 *
 * @param <E> - generic
 */
public class MyQueue<E> implements ForQueueAndStack<E> {
    //queue size
    private int size = 0;
    ListArray<E> listArray;

    public MyQueue() {
        listArray = new ListArray<>();
    }

    /**
     * Method that checks if the queue is empty
     *
     * @return - true or false
     */
    @Override
    public boolean empty() {
        return size == 0;
    }

    /**
     * A method that looks at the first
     * item in the queue and returns it
     *
     * @return - first element
     */
    @Override
    public E peek() {
        return listArray.get(0);
    }

    /**
     * A method that removes the first element from
     * the queue and decreases the queue size by 1
     *
     * @return - deleted item
     */
    @Override
    public E pop() {
        size--;
        return listArray.remove(0);
    }

    /**
     * A method that adds 1 element to the end
     * of the queue and increases the size by 1
     *
     * @param e - added element
     * @return - added element
     */
    @Override
    public E push(E e) {
        listArray.add(e);
        size++;
        return e;
    }

    /**
     * @return size
     */
    @Override
    public int size() {
        return size;
    }
}
