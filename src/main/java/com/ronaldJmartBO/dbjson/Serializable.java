package com.ronaldJmartBO.dbjson;

import java.util.HashMap;

/**
 * Represents Serializable
 *
 * @author Ronald Grant
 * @version 1.0
 * @since 25 September 2021
 */
public class Serializable implements Comparable<Serializable>
{
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<>();
    /**
     * The Id.
     */
    public final int id;

    /**
     * Instantiates a new Serializable.
     */
    protected Serializable()
    {
        Integer counter = mapCounter.get(getClass());
        counter = counter == null ? 0 : counter + 1;
        mapCounter.put(getClass(), counter);
        this.id = counter;
    }

    /**
     * Sets closing id.
     *
     * @param <T>   the type parameter
     * @param clazz the clazz
     * @param id    the id
     * @return the closing id
     */
    public static <T extends Serializable> Integer setClosingId(Class<T> clazz, int id)
    {
        return mapCounter.put(clazz, id);
    }

    /**
     * Gets closing id.
     *
     * @param <T>   the type parameter
     * @param clazz the clazz
     * @return the closing id
     */
    public static <T extends Serializable> Integer getClosingId(Class<T> clazz)
    {
        return mapCounter.get(clazz);
    }
    public boolean equals(Object other)
    {
        return other instanceof Serializable && ((Serializable) other).id == id;
    }

    /**
     * Equals boolean.
     *
     * @param other the other
     * @return the boolean
     */
    public boolean equals(Serializable other)
    {
        return other.id == id;
    }

    @Override
    public int compareTo(Serializable other)
    {
        return Integer.compare(this.id, other.id);
    }
}