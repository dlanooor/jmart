package com.ronaldJmartBO;

/**
 * Predicate Interface
 *
 * @param <T> the type parameter
 * @author Ronald Grant
 * @version 1.0
 * @since 3 November 2021
 */
public interface Predicate<T> {
    /**
     * Predicate boolean.
     *
     * @param arg the arg
     * @return the boolean
     */
    public abstract boolean predicate(T arg);
}
