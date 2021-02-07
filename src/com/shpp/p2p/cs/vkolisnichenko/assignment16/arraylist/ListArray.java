package com.shpp.p2p.cs.vkolisnichenko.assignment16.arraylist;

import com.shpp.p2p.cs.vkolisnichenko.assignment16.interfaces.MyList;

import java.util.Iterator;

/**
 * A class that implements its own version of the ArrayList
 * with the implementation of the main methods and an iterator
 *
 * @param <T> - generic T
 */
public class ListArray<T> implements MyList<T>, Iterable<T> {
    //begin array
    private T[] array;

    public ListArray() {
        array = (T[]) new Object[0];
    }

    /**
     * Method that checks if the list is empty
     *
     * @return - true or false
     */
    @Override
    public boolean isEmpty() {
        return array.length == 0;
    }

    /**
     * The method in which an object comes to the parameters
     * that we check for the presence of the same in the list
     *
     * @param e - input object
     * @return - true or false
     */
    @Override
    public boolean contains(T e) {
        for (int i = 0; i < array.length; i++) {
            if (get(i).equals(e))
                return true;
        }
        return false;
    }

    /**
     * Method in which the size of the array is
     * increased by 1 and a new element is added
     *
     * @param t - added element
     */
    @Override
    public void add(T t) {
        T[] arr = array;
        array = (T[]) new Object[arr.length + 1];
        System.arraycopy(arr, 0, array, 0, arr.length);
        array[array.length - 1] = t;
    }

    /**
     * A method that adds an element to an array at the desired
     * index, and then shifts the remaining elements by 1 to the right
     *
     * @param index - Place to add
     * @param t     - element
     */
    public void add(int index, T t) {
        T[] arr = array;
        array = (T[]) new Object[arr.length + 1];
        //Copying the array to the index
        System.arraycopy(arr, 0, array, 0, index);
        //add element
        array[index] = t;
        //Copy the remaining array
        System.arraycopy(arr, index, array, index + 1, array.length - index - 1);

    }

    /**
     * list cleaning
     */
    @Override
    public void clear() {
        array = (T[]) new Object[0];
    }

    /**
     * The method in which the element is deleted
     * by index by copying the array in parts
     *
     * @param index - element index
     * @return - remove element
     */
    @Override
    public T remove(int index) {
        if (array.length > 0) {
            T[] mass = array;
            array = (T[]) new Object[mass.length - 1];
            int removeIndex = mass.length - index - 1;
            System.arraycopy(mass, 0, array, 0, index);
            System.arraycopy(mass, index + 1, array, index, removeIndex);
            return mass[index];
        }
        throw new NegativeArraySizeException("The list is empty, deletion is impossible");
    }


    /**
     * Getting an item by index
     *
     * @param index - needed index
     * @return - get value
     */
    @Override
    public T get(int index) {
        return array[index];
    }

    /**
     * The method in which the element in the array
     * is replaced by index with the one that
     * comes as the second parameter
     *
     * @param index - index for replace
     * @param t     - element
     */
    @Override
    public void set(int index, T t) {
        array[index] = t;
    }

    /**
     * Method that returns the size of the list
     *
     * @return size of the list
     */
    @Override
    public int size() {
        return array.length;
    }

    /**
     * The method in which the iterator is implemented
     * by the anonymous class, for looping through the array
     *
     * @return - iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                if (index < array.length)
                    return true;
                return false;
            }

            @Override
            public T next() {
                return array[index++];
            }
        };
    }


}
