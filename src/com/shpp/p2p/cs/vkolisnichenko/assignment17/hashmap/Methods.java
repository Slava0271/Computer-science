package com.shpp.p2p.cs.vkolisnichenko.assignment17.hashmap;

/**
 * Interface with methods for implementing hashmap
 *
 * @param <K> - generic
 * @param <V> - generic
 */
public interface Methods<K, V> {
    V put(K key, V value);

    V get(K key);

    V remove(K key);

    int size();
}
