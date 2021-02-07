package com.shpp.p2p.cs.vkolisnichenko.assignment16.stack;

import com.shpp.p2p.cs.vkolisnichenko.assignment16.interfaces.ForQueueAndStack;
import com.shpp.p2p.cs.vkolisnichenko.assignment16.linkedlist.ListLinked;

/**
 * A class that implements its own
 * stack based on an array list
 *
 * @param <E> - generic
 */
public class MyStack<E> implements ForQueueAndStack<E> {
    //stack size
    private int size = 0;

    ListLinked<E> listLinked;

    public MyStack() {
        listLinked = new ListLinked<>();
    }

    /**
     * Method that checks if the stack is empty
     *
     * @return true or false
     */
    @Override
    public boolean empty() {
        return size == 0;
    }

    /**
     * A method that looks at the last
     * item in the list and returns it
     *
     * @return - last item
     */
    @Override
    public E peek() {
        return listLinked.get(listLinked.size() - 1);
    }

    /**
     * A method that removes the last item in the list,
     * returns it, and decrements the size of the list
     *
     * @return - deleted item
     */
    @Override
    public E pop() {
        size--;
        return listLinked.remove(listLinked.size() - 1);
    }

    /**
     * A method that adds 1 element from the
     * stack and increments the stack size
     *
     * @param e - added element
     * @return - added element
     */
    @Override
    public E push(E e) {
        listLinked.add(e);
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
