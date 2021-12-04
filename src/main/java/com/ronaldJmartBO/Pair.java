package com.ronaldJmartBO;

/**
 * Pair Model
 *
 * @param <T> the type parameter
 * @param <U> the type parameter
 * @author Ronald Grant
 * @version 1.0
 * @since 3 September 2021
 */
public class Pair<T, U> {
    /**
     * The First.
     */
    public T first;
    /**
     * The Second.
     */
    public U second;

    /**
     * Instantiates a new Pair.
     */
    public Pair() {
    }

    /**
     * Instantiates a new Pair.
     *
     * @param first  the first
     * @param second the second
     */
    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
}
