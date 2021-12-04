package com.ronaldJmartBO;

import java.lang.Iterable;
import java.util.Iterator;
import java.util.*;


/**
 * Represent Algorithm Used in jMart
 *
 * @author Ronald Grant
 * @version 2.0
 * @since 24 September 2021
 */
public class Algorithm {
    private Algorithm() {
    }

    /**
     * Paginate list.
     *
     * @param <T>      the type parameter
     * @param iterable the iterable
     * @param page     the page
     * @param pageSize the page size
     * @param pred     the pred
     * @return the list
     */
    public static <T> List<T> paginate(Iterable<T> iterable, int page, int pageSize, Predicate<T> pred) {
        List<T> pagination = new ArrayList<>();
        Iterator<T> iterator = iterable.iterator();

        if(pageSize < 0 || page < 0) {
            throw new IllegalArgumentException("Invalid Page Size: " + pageSize);
        }

        int startPage = page * pageSize;
        int size = ((Collection<?>) iterator).size();

        if(iterator == null || size <= startPage)
            return Collections.emptyList();

        while(iterator.hasNext()) {
            if(pred.predicate(iterator.next()))
                pagination.add(iterator.next());
        }

        return pagination.subList(startPage, Math.min(startPage + pageSize, pagination.size()));
    }

    /**
     * Paginate list.
     *
     * @param <T>      the type parameter
     * @param array    the array
     * @param page     the page
     * @param pageSize the page size
     * @param pred     the pred
     * @return the list
     */
    public static <T> List<T> paginate(T[] array, int page, int pageSize, Predicate<T> pred) {
        List<T> pagination = new ArrayList<>();

        if(pageSize < 0 || page < 0) {
            throw new IllegalArgumentException("Invalid Page Size: " + pageSize);
        }

        int startPage = page * pageSize;

        if(array == null || array.length <= startPage)
            return Collections.emptyList();

        for(T value : array) {
            if(pred.predicate(value))
                pagination.add(value);
        }

        return pagination.subList(startPage, Math.min(startPage + pageSize, pagination.size()));
    }

    /**
     * Paginate list.
     *
     * @param <T>      the type parameter
     * @param iterator the iterator
     * @param page     the page
     * @param pageSize the page size
     * @param pred     the pred
     * @return the list
     */
    public static <T> List<T> paginate(Iterator<T> iterator, int page, int pageSize, Predicate<T> pred) {
        List<T> pagination = new ArrayList<>();

        if(pageSize < 0 || page < 0) {
            throw new IllegalArgumentException("Invalid Page Size: " + pageSize);
        }

        int startPage = page * pageSize;
        int size = ((Collection<?>) iterator).size();

        if(iterator == null || size <= startPage)
            return Collections.emptyList();

        while(iterator.hasNext()) {
            if(pred.predicate(iterator.next()))
                pagination.add(iterator.next());
        }

        return pagination.subList(startPage, Math.min(startPage + pageSize, pagination.size()));
    }

    /**
     * Paginate list.
     *
     * @param <T>      the type parameter
     * @param list     the list
     * @param page     the page
     * @param pageSize the page size
     * @param pred     the pred
     * @return the list
     */
    public static<T> List<T> paginate(List<T> list, int page, int pageSize, Predicate<T> pred){
        List<T> newPage = new ArrayList<T>();
        
        for(T element: list) {
            if(pred.predicate(element))
                newPage.add(element);
        }
        
        if((pageSize < 0) || (page < 0 || page > newPage.size()/pageSize)) {
            throw new IllegalArgumentException();
        }
        
        int startIndex = page * pageSize;
        if(newPage == null || newPage.size() <= startIndex)
            return Collections.emptyList();
        
        return newPage.subList(startIndex, Math.min(startIndex + pageSize, newPage.size()));
    }

    /**
     * Collect list.
     *
     * @param <T>   the type parameter
     * @param array the array
     * @param value the value
     * @return the list
     */
    public static <T> List<T> collect (T[] array, T value) {
        Predicate<T> predicate = val -> val.equals(value);
        List<T> list = new ArrayList<>();
        for(T single : array) {
            if(predicate.predicate(single))
                list.add(single);
        }
        return list;
    }

    /**
     * Collect list.
     *
     * @param <T>      the type parameter
     * @param iterable the iterable
     * @param value    the value
     * @return the list
     */
    public static <T> List<T> collect(Iterable<T> iterable, T value) {
        Predicate<T> predicate = val -> value.equals(value);
        List<T> list = new ArrayList<>();
        Iterator<T> iterator = iterable.iterator();

        while(iterator.hasNext()) {
            T single = iterator.next();
            if(predicate.predicate(single))
                list.add(single);
        }
        return list;
    }

    /**
     * Collect list.
     *
     * @param <T>      the type parameter
     * @param iterator the iterator
     * @param value    the value
     * @return the list
     */
    public static <T> List<T> collect(Iterator<T> iterator, T value) {
        Predicate<T> predicate = val -> value.equals(value);
        List<T> list = new ArrayList<>();

        while(iterator.hasNext()) {
            T single = iterator.next();
            if(predicate.predicate(single))
                list.add(single);
        }
        return list;
    }

    /**
     * Collect list.
     *
     * @param <T>   the type parameter
     * @param array the array
     * @param pred  the pred
     * @return the list
     */
    public static <T> List<T> collect(T[] array, Predicate<T> pred) {
        List<T> list = new ArrayList<>();
        for(T single : array) {
            if(pred.predicate(single))
                list.add(single);
        }

        return list;
    }

    /**
     * Collect list.
     *
     * @param <T>      the type parameter
     * @param iterable the iterable
     * @param pred     the pred
     * @return the list
     */
    public static <T> List<T> collect(Iterable<T> iterable, Predicate<T> pred) {
        List<T> list = new ArrayList<T>();
        Iterator<T> iterator = iterable.iterator();

        while(iterator.hasNext()) {
            T single = iterator.next();
            if(pred.predicate(single))
                list.add(single);
        }

        return list;
    }

    /**
     * Collect list.
     *
     * @param <T>      the type parameter
     * @param iterator the iterator
     * @param pred     the pred
     * @return the list
     */
    public static <T> List<T> collect(Iterator<T> iterator, Predicate<T> pred) {
        List<T> list = new ArrayList<>();

        while(iterator.hasNext()) {
            T single = iterator.next();
            if(pred.predicate(single))
                list.add(single);
        }

        return list;
    }

    /**
     * Count int.
     *
     * @param <T>   the type parameter
     * @param array the array
     * @param value the value
     * @return the int
     */
    /* count method */
    public static <T> int count(T[] array, T value) {
        int count = 0;
        Predicate<T> x = val1 -> (val1 == value);
        for(T t : array) {
            if(x.predicate(t))
                count++;
        }

        return count;
    }

    /**
     * Count int.
     *
     * @param <T>      the type parameter
     * @param iterable the iterable
     * @param value    the value
     * @return the int
     */
    public static <T> int count(Iterable<T> iterable, T value) {
        int count = 0;
        Predicate<T> x = val1 -> (val1 == value);
        Iterator<T> iterator = iterable.iterator();

        while(iterator.hasNext()) {
            T single = iterator.next();
            if(x.predicate(single))
                count++;
        }

        return count;
    }

    /**
     * Count int.
     *
     * @param <T>      the type parameter
     * @param iterator the iterator
     * @param value    the value
     * @return the int
     */
    public static <T> int count(Iterator<T> iterator, T value) {
        int count = 0;
        Predicate<T> x = val1 -> (val1 == value);

        while(iterator.hasNext()) {
            T single = iterator.next();
            if(x.predicate(single))
                count++;
        }

        return count;
    }

    /**
     * Count int.
     *
     * @param <T>   the type parameter
     * @param array the array
     * @param pred  the pred
     * @return the int
     */
    public static <T> int count(T[] array, Predicate<T> pred) {
        int count = 0;
        for(T t : array) {
            if(pred.predicate(t))
                count++;
        }
        return count;
    }

    /**
     * Count int.
     *
     * @param <T>      the type parameter
     * @param iterable the iterable
     * @param pred     the pred
     * @return the int
     */
    public static <T> int count(Iterable<T> iterable, Predicate<T> pred) {
        int count = 0;
        Iterator<T> iterator = iterable.iterator();
        while(iterator.hasNext()) {
            T single = iterator.next();
            if(pred.predicate(single))
                count++;
        }
        return count;
    }

    /**
     * Count int.
     *
     * @param <T>      the type parameter
     * @param iterator the iterator
     * @param pred     the pred
     * @return the int
     */
    public static <T> int count(Iterator<T> iterator, Predicate<T> pred) {
        int count = 0;
        while(iterator.hasNext()) {
            T single = iterator.next();
            if(pred.predicate(single))
                count++;
        }
        return count;
    }

    /**
     * Exists boolean.
     *
     * @param <T>   the type parameter
     * @param array the array
     * @param value the value
     * @return the boolean
     */
    /* exists method */
    public static <T> boolean exists(T[] array, T value) {
        Predicate<T> x = val1 -> (val1 == value);
        for(T t : array) {
            if(x.predicate(t))
                return true;
        }
        return false;
    }

    /**
     * Exists boolean.
     *
     * @param <T>      the type parameter
     * @param iterable the iterable
     * @param value    the value
     * @return the boolean
     */
    public static <T> boolean exists(Iterable<T> iterable, T value) {
        Predicate<T> x = val1 -> (val1 == value);
        Iterator<T> iterator = iterable.iterator();
        while(iterator.hasNext()) {
            T single = iterator.next();
            if (x.predicate(single))
                return true;
        }
        return false;
    }

    /**
     * Exists boolean.
     *
     * @param <T>      the type parameter
     * @param iterator the iterator
     * @param value    the value
     * @return the boolean
     */
    public static <T> boolean exists(Iterator<T> iterator, T value) {
        Predicate<T> x = val1 -> (val1 == value);
        while(iterator.hasNext()) {
            T single = iterator.next();
            if (x.predicate(single))
                return true;
        }
        return false;
    }

    /**
     * Exists boolean.
     *
     * @param <T>   the type parameter
     * @param array the array
     * @param pred  the pred
     * @return the boolean
     */
    public static <T> boolean exists(T[] array, Predicate<T> pred) {
        for(T t : array) {
            if(pred.predicate(t))
                return true;
        }
        return false;
    }

    /**
     * Exists boolean.
     *
     * @param <T>      the type parameter
     * @param iterable the iterable
     * @param pred     the pred
     * @return the boolean
     */
    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred) {
        Iterator<T> iterator = iterable.iterator();
        while(iterator.hasNext()) {
            T single = iterator.next();
            if(pred.predicate(single))
                return true;
        }
        return false;
    }

    /**
     * Exists boolean.
     *
     * @param <T>      the type parameter
     * @param iterator the iterator
     * @param pred     the pred
     * @return the boolean
     */
    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred) {
        while(iterator.hasNext()) {
            T single = iterator.next();
            if(pred.predicate(single))
                return true;
        }
        return false;
    }

    /**
     * Find t.
     *
     * @param <T>   the type parameter
     * @param array the array
     * @param value the value
     * @return the t
     */
    /* find method */
    public static <T> T find(T[] array, T value) {
        Predicate<T> x = val1 -> (val1 == value);
        for(T t : array) {
            if(x.predicate(t))
                return t;
        }
        return null;
    }

    /**
     * Find t.
     *
     * @param <T>      the type parameter
     * @param iterable the iterable
     * @param value    the value
     * @return the t
     */
    public static <T> T find(Iterable<T> iterable, T value) {
        Predicate<T> x = val1 -> (val1 == value);
        Iterator<T> iterator = iterable.iterator();
        while(iterator.hasNext()) {
            T single = iterator.next();
            if(x.predicate(single))
                return single;
        }
        return null;
    }

    /**
     * Find t.
     *
     * @param <T>      the type parameter
     * @param iterator the iterator
     * @param value    the value
     * @return the t
     */
    public static <T> T find(Iterator<T> iterator, T value) {
        Predicate<T> x = val1 -> (val1 == value);
        while(iterator.hasNext()) {
            T single = iterator.next();
            if(x.predicate(single))
                return single;
        }
        return null;
    }

    /**
     * Find t.
     *
     * @param <T>   the type parameter
     * @param array the array
     * @param pred  the pred
     * @return the t
     */
    public static <T> T find(T[] array, Predicate<T> pred) {
        for(T t : array) {
            if(pred.predicate(t))
                return t;
        }
        return null;
    }

    /**
     * Find t.
     *
     * @param <T>      the type parameter
     * @param iterable the iterable
     * @param pred     the pred
     * @return the t
     */
    public static <T> T find(Iterable<T> iterable, Predicate<T> pred) {
        Iterator<T> iterator = iterable.iterator();
        while(iterator.hasNext()) {
            T single = iterator.next();
            if(pred.predicate(single))
                return single;
        }
        return null;
    }

    /**
     * Find t.
     *
     * @param <T>      the type parameter
     * @param iterator the iterator
     * @param pred     the pred
     * @return the t
     */
    public static <T> T find(Iterator<T> iterator, Predicate<T> pred) {
        while(iterator.hasNext()) {
            T single = iterator.next();
            if(pred.predicate(single))
                return single;
        }
        return null;
    }

    /**
     * Max t.
     *
     * @param <T>    the type parameter
     * @param first  the first
     * @param second the second
     * @return the t
     */
    /* max method */
    public static <T extends Comparable<? super T>> T max(T first, T second) {
        if(first.compareTo(second) > 0)
            return first;
        else
            return second;
    }

    /**
     * Max t.
     *
     * @param <T>   the type parameter
     * @param array the array
     * @return the t
     */
    public static <T extends Comparable<? super T>> T max(T[] array) {
        T temp = null;

        for(T t : array) {
            if (temp == null)
                temp = t;
            else if (t.compareTo(temp) > 0)
                temp = t;
        }

        return temp;
    }

    /**
     * Max t.
     *
     * @param <T>      the type parameter
     * @param iterable the iterable
     * @return the t
     */
    public static <T extends Comparable<? super T>> T max(Iterable<T> iterable) {
        T temp = null;
        for(T single : iterable) {
            if(temp == null)
                temp = single;
            else if(single.compareTo(temp) > 0)
                temp = single;
        }

        return temp;
    }

    /**
     * Max t.
     *
     * @param <T>      the type parameter
     * @param iterator the iterator
     * @return the t
     */
    public static <T extends Comparable<? super T>> T max(Iterator<T> iterator) {
        T temp = null;
        while(iterator.hasNext()) {
            T single = iterator.next();
            if(temp == null)
                temp = single;
            else if(single.compareTo(temp) > 0)
                temp = single;
        }

        return temp;
    }

    /**
     * Max t.
     *
     * @param <T>        the type parameter
     * @param first      the first
     * @param second     the second
     * @param comparator the comparator
     * @return the t
     */
    public static <T extends Comparable<? super T>> T max(T first, T second, Comparator<? super T> comparator) {
        int Comp = comparator.compare(first, second);
        if(Comp > 0)
            return first;
        else
            return second;
    }

    /**
     * Max t.
     *
     * @param <T>        the type parameter
     * @param array      the array
     * @param comparator the comparator
     * @return the t
     */
    public static <T extends Comparable<? super T>> T max(T[] array, Comparator<? super T> comparator) {
        T temp = array[0];
        for(int i = 0; i < array.length; i++) {
            int Comp = comparator.compare(array[i], temp);
            if(Comp > 0)
                temp = array[i];
        }
        return temp;
    }

    /**
     * Max t.
     *
     * @param <T>        the type parameter
     * @param iterable   the iterable
     * @param comparator the comparator
     * @return the t
     */
    public static <T extends Comparable<? super T>> T max(Iterable<T> iterable, Comparator<? super T> comparator) {
        Iterator<T> iterator = iterable.iterator();
        T temp = iterator.next();
        while(iterator.hasNext()) {
            T single = iterator.next();
            int Comp = comparator.compare(single, temp);
            if(Comp > 0)
                temp = single;
        }
        return temp;
    }

    /**
     * Max t.
     *
     * @param <T>        the type parameter
     * @param iterator   the iterator
     * @param comparator the comparator
     * @return the t
     */
    public static <T extends Comparable<? super T>> T max(Iterator<T> iterator, Comparator<? super T> comparator) {
        T temp = iterator.next();
        while(iterator.hasNext()) {
            T single = iterator.next();
            int Comp = comparator.compare(single, temp);
            if(Comp > 0)
                temp = single;
        }
        return temp;
    }

    /**
     * Min t.
     *
     * @param <T>    the type parameter
     * @param first  the first
     * @param second the second
     * @return the t
     */
    /* min method */
    public static <T extends Comparable<? super T>> T min(T first, T second) {
        if(first.compareTo(second) < 0)
            return first;
        else
            return second;
    }

    /**
     * Min t.
     *
     * @param <T>   the type parameter
     * @param array the array
     * @return the t
     */
    public static <T extends Comparable<? super T>> T min(T[] array) {
        T temp = null;

        for(T single : array) {
            if(temp == null)
                temp = single;
            else if(single.compareTo(temp) < 0)
                temp = single;
        }
        return temp;
    }

    /**
     * Min t.
     *
     * @param <T>      the type parameter
     * @param iterable the iterable
     * @return the t
     */
    public static <T extends Comparable<? super T>> T min(Iterable<T> iterable) {
        T temp = null;
        Iterator<T> iterator = iterable.iterator();
        while(iterator.hasNext()) {
            T single = iterator.next();
            if(temp == null)
                temp = single;
            else if(single.compareTo(temp) < 0)
                temp = single;
        }
        return temp;
    }

    /**
     * Min t.
     *
     * @param <T>      the type parameter
     * @param iterator the iterator
     * @return the t
     */
    public static <T extends Comparable<? super T>> T min(Iterator<T> iterator) {
        T temp = null;
        while(iterator.hasNext()) {
            T single = iterator.next();
            if(single == null)
                temp = single;
            else if(single.compareTo(temp) < 0)
                temp = single;
        }
        return temp;
    }

    /**
     * Min t.
     *
     * @param <T>        the type parameter
     * @param first      the first
     * @param second     the second
     * @param comparator the comparator
     * @return the t
     */
    public static <T extends Comparable<? super T>> T min(T first, T second, Comparator<? super T> comparator) {
        int Comp = comparator.compare(first, second);
        if(Comp < 0)
            return first;
        else
            return second;
    }

    /**
     * Min t.
     *
     * @param <T>        the type parameter
     * @param array      the array
     * @param comparator the comparator
     * @return the t
     */
    public static <T extends Comparable<? super T>> T min(T[] array, Comparator<? super T> comparator) {
        T temp = null;
        for(T single : array) {
            if(temp == null)
                temp = single;
            else {
                int Comp = comparator.compare(single, temp);
                if(Comp < 0)
                    temp = single;
            }
        }
        return temp;
    }

    /**
     * Min t.
     *
     * @param <T>        the type parameter
     * @param iterable   the iterable
     * @param comparator the comparator
     * @return the t
     */
    public static <T extends Comparable<? super T>> T min(Iterable<T> iterable, Comparator<? super T> comparator) {
        T temp = null;
        Iterator<T> iterator = iterable.iterator();
        while(iterator.hasNext()) {
            T single = iterator.next();
            if(temp == null)
                temp = single;
            else {
                int Comp = comparator.compare(single, temp);
                if (Comp < 0)
                    temp = single;
            }
        }
        return temp;
    }

    /**
     * Min t.
     *
     * @param <T>        the type parameter
     * @param iterator   the iterator
     * @param comparator the comparator
     * @return the t
     */
    public static <T extends Comparable<? super T>> T min(Iterator<T> iterator, Comparator<? super T> comparator) {
        T temp = null;
        while(iterator.hasNext()) {
            T single = iterator.next();
            if(temp == null)
                temp = single;
            else {
                int Comp = comparator.compare(single, temp);
                if(Comp < 0)
                    temp = single;
            }
        }
        return temp;
    }
}