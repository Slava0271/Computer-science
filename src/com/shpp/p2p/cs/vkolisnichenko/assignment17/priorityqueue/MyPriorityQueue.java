package com.shpp.p2p.cs.vkolisnichenko.assignment17.priorityqueue;

import java.util.EmptyStackException;

/**
 * The class in which the priority queue is implemented with such methods:
 * add, get, remove , size
 *
 * @param <E>
 */
public class MyPriorityQueue<E> implements Methods<E> {
    private Node<E> node;
    private int size = 0;


    /**
     * The method in which the elements are added to the queue,
     * using the implementation and methods for certain types
     *
     * @param e - element
     * @return - e
     */
    @Override
    public E add(E e) {
        if (size == 0)
            return addIfQueueEmpty(e);
        try {
            if (e instanceof Integer) {
                size++;
                return addIntValues(e);
            } else if (e instanceof Double) {
                size++;
                return addDoubleValues(e);
            } else if (e instanceof Character) {
                size++;
                return addCharacterValues(e);
            } else if (e instanceof String) {
                size++;
                return addStringValues(e);
            } else {
                size++;
                return addObjects(e);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }


    /**
     * The method in which it goes through adding elements
     * of type string, where they are compared in length
     *
     * @param e - element
     * @return - e
     */
    private E addStringValues(E e) {
        Node<E> saveNode = (Node<E>) node.clone();
        if (e.toString().length() < node.getCurrentElement().toString().length()) {
            node.setCurrentElement(e);
            node.setNextElement(saveNode);
            return e;
        }
        while (saveNode.getNextElement() != null) {
            if (e.toString().length() < saveNode.getNextElement().
                    getCurrentElement().toString().length()) break;
            saveNode = saveNode.getNextElement();
        }
        Node<E> lastNode = saveNode.getNextElement();
        saveNode.setNextElement(new Node<>(e, lastNode));
        node.setNextElement(saveNode);

        return e;
    }

    /**
     * A method in which character elements are added,
     * where they are compared by number in the ascii table
     *
     * @param e element
     * @return e
     */
    private E addCharacterValues(E e) {
        Node<E> saveNode = (Node<E>) node.clone();
        if ((Character) e < (Character) node.getCurrentElement()) {
            node.setCurrentElement(e);
            node.setNextElement(saveNode);
            return e;
        }
        while (saveNode.getNextElement() != null) {
            if ((Character) e < (Character) saveNode.getNextElement().getCurrentElement()
            ) break;
            saveNode = saveNode.getNextElement();
        }
        Node<E> lastNode = saveNode.getNextElement();
        saveNode.setNextElement(new Node<>(e, lastNode));
        node.setNextElement(saveNode);

        return e;
    }

    /**
     * The method in which the addition of elements of the integer
     * type passes, where they are compared by value
     *
     * @param e - element
     * @return - e
     */
    private E addIntValues(E e) {
        Node<E> saveNode = (Node<E>) node.clone();
        if ((Integer) e < (Integer) node.getCurrentElement()) {
            node.setCurrentElement(e);
            node.setNextElement(saveNode);
            return e;
        }
        while (saveNode.getNextElement() != null) {
            if ((Integer) e < (Integer) saveNode.getNextElement().getCurrentElement()
            ) break;
            saveNode = saveNode.getNextElement();
        }
        Node<E> lastNode = saveNode.getNextElement();
        saveNode.setNextElement(new Node<>(e, lastNode));
        node.setNextElement(saveNode);

        return e;

    }

    /**
     * The method in which the addition of elements
     * of the double type passes, where they are compared by value
     *
     * @param e- element
     * @return e
     */
    private E addDoubleValues(E e) {
        Node<E> saveNode = (Node<E>) node.clone();
        if ((Double) e < (Double) node.getCurrentElement()) {
            node.setCurrentElement(e);
            node.setNextElement(saveNode);
            return e;
        }
        while (saveNode.getNextElement() != null) {
            if ((Double) e < (Double) saveNode.getNextElement().getCurrentElement()
            ) break;
            saveNode = saveNode.getNextElement();
        }
        Node<E> lastNode = saveNode.getNextElement();
        saveNode.setNextElement(new Node<>(e, lastNode));
        node.setNextElement(saveNode);

        return e;
    }

    /**
     * A method in which elements of any type are added,
     * where they are compared by the hashcode
     *
     * @param e added element
     * @return e
     */
    private E addObjects(E e) {
        Node<E> saveNode = (Node<E>) node.clone();
        if (e.hashCode() < node.getCurrentElement().hashCode()) {
            node.setCurrentElement(e);
            node.setNextElement(saveNode);
            return e;
        }
        while (saveNode.getNextElement() != null) {
            if (e.hashCode() < saveNode.getNextElement().getCurrentElement().hashCode()
            ) break;
            saveNode = saveNode.getNextElement();
        }
        Node<E> lastNode = saveNode.getNextElement();
        saveNode.setNextElement(new Node<>(e, lastNode));
        node.setNextElement(saveNode);

        return e;
    }

    /**
     * The method in which the first element is added
     *
     * @param e added element
     * @return e
     */
    private E addIfQueueEmpty(E e) {
        node = new Node<>(null, null);
        node.setCurrentElement(e);
        size++;
        return e;
    }

    /**
     * Method that returns the bottom value
     *
     * @return - value
     */
    @Override
    public E get() {
        return node.getCurrentElement();
    }

    /**
     * Method in which the first element
     * is removed and links are replaced
     *
     * @return deleted element
     */
    @Override
    public E delete() {
        if (size > 0) {
            Node<E> deleteNode = node;
            node = node.getNextElement();

            size--;
            return deleteNode.getCurrentElement();
        }
        throw new EmptyStackException();
    }

    /**
     * @return size
     */
    @Override
    public int size() {
        return size;
    }


}
