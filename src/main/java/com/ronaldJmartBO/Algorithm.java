package com.ronaldJmartBO;

import java.lang.Iterable;
import java.util.Iterator;
import java.util.*;

public class Algorithm {
    private Algorithm() {
    }

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

    public static List<Product> paginate(List<Product> list, int page, int pageSize, Predicate<Product> pred) {
        List<Product> pagination = new ArrayList<>();

        for(Product lists : list) {
            if(pred.predicate(lists)) {
                pagination.add(lists);
            }
        }

        if(pageSize < 0 || page < 0) {
            throw new IllegalArgumentException("Invalid Page Size: " + pageSize);
        }

        int fromIndex = page * pageSize;
        if(pagination == null || pagination.size() <= fromIndex){
            return Collections.emptyList();
        }

        return pagination.subList(fromIndex, Math.min(fromIndex + pageSize, pagination.size()));
    }

    /* collect method */
//    public static <T> List<T> collect(T[] array, T value) {
//        List<T> list = Arrays.asList(array);
//        list.add(value);
//        return list;
//    }

    public static <T> List<T> collect (T[] array, T value) {
        Predicate<T> predicate = val -> val.equals(value);
        List<T> list = new ArrayList<>();
        for(T single : array) {
            if(predicate.predicate(single))
                list.add(single);
        }
        return list;
    }

//    public static <T> List<T> collect(Iterable<T> iterable, T value) {
//        List<T> list = new ArrayList<T>();
//        for (T item : iterable) {
//            list.add(item);
//        }
//
//        list.add(value);
//
//        return list;
//    }

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

//    public static <T> List<T> collect(Iterator<T> iterator, T value) {
//        Iterator<T> source = iterator;
//        List<T> target = new ArrayList<>();
//        source.forEachRemaining(target::add);
//        target.add(value);
//
//        return target;
//    }

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

//    public static <T> List<T> collect(T[] array, Predicate<T> pred) {
//        List<T> list = Arrays.asList(array);
//
//        return list;
//    }

    public static <T> List<T> collect(T[] array, Predicate<T> pred) {
        List<T> list = new ArrayList<>();
        for(T single : array) {
            if(pred.predicate(single))
                list.add(single);
        }

        return list;
    }

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

    public static <T> List<T> collect(Iterator<T> iterator, Predicate<T> pred) {
        List<T> list = new ArrayList<>();

        while(iterator.hasNext()) {
            T single = iterator.next();
            if(pred.predicate(single))
                list.add(single);
        }

        return list;
    }

    /* count method */
//    public static <T> int count(T[] array, T value) {
//        final Iterator<T> iter = Arrays.stream(array).iterator();
//        return count(iter, value);
//    }

    public static <T> int count(T[] array, T value) {
        int count = 0;
        Predicate<T> x = val1 -> (val1 == value);
        for(T t : array) {
            if(x.predicate(t))
                count++;
        }

        return count;
    }

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

    public static <T> int count(T[] array, Predicate<T> pred) {
        int count = 0;
        for(T t : array) {
            if(pred.predicate(t))
                count++;
        }
        return count;
    }

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

    public static <T> int count(Iterator<T> iterator, Predicate<T> pred) {
        int count = 0;
        while(iterator.hasNext()) {
            T single = iterator.next();
            if(pred.predicate(single))
                count++;
        }
        return count;
    }

    /* exists method */
    public static <T> boolean exists(T[] array, T value) {
        Predicate<T> x = val1 -> (val1 == value);
        for(T t : array) {
            if(x.predicate(t))
                return true;
        }
        return false;
    }

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

    public static <T> boolean exists(Iterator<T> iterator, T value) {
        Predicate<T> x = val1 -> (val1 == value);
        while(iterator.hasNext()) {
            T single = iterator.next();
            if (x.predicate(single))
                return true;
        }
        return false;
    }

    public static <T> boolean exists(T[] array, Predicate<T> pred) {
        for(T t : array) {
            if(pred.predicate(t))
                return true;
        }
        return false;
    }

    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred) {
        Iterator<T> iterator = iterable.iterator();
        while(iterator.hasNext()) {
            T single = iterator.next();
            if(pred.predicate(single))
                return true;
        }
        return false;
    }

    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred) {
        while(iterator.hasNext()) {
            T single = iterator.next();
            if(pred.predicate(single))
                return true;
        }
        return false;
    }

    /* find method */
    public static <T> T find(T[] array, T value) {
        Predicate<T> x = val1 -> (val1 == value);
        for(T t : array) {
            if(x.predicate(t))
                return t;
        }
        return null;
    }

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

    public static <T> T find(Iterator<T> iterator, T value) {
        Predicate<T> x = val1 -> (val1 == value);
        while(iterator.hasNext()) {
            T single = iterator.next();
            if(x.predicate(single))
                return single;
        }
        return null;
    }

    public static <T> T find(T[] array, Predicate<T> pred) {
        for(T t : array) {
            if(pred.predicate(t))
                return t;
        }
        return null;
    }

    public static <T> T find(Iterable<T> iterable, Predicate<T> pred) {
        Iterator<T> iterator = iterable.iterator();
        while(iterator.hasNext()) {
            T single = iterator.next();
            if(pred.predicate(single))
                return single;
        }
        return null;
    }

    public static <T> T find(Iterator<T> iterator, Predicate<T> pred) {
        while(iterator.hasNext()) {
            T single = iterator.next();
            if(pred.predicate(single))
                return single;
        }
        return null;
    }

    /* max method */
    public static <T extends Comparable<? super T>> T max(T first, T second) {
        if(first.compareTo(second) > 0)
            return first;
        else
            return second;
    }

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

    public static <T extends Comparable<? super T>> T max(T first, T second, Comparator<? super T> comparator) {
        int Comp = comparator.compare(first, second);
        if(Comp > 0)
            return first;
        else
            return second;
    }

    public static <T extends Comparable<? super T>> T max(T[] array, Comparator<? super T> comparator) {
        T temp = array[0];
        for(int i = 0; i < array.length; i++) {
            int Comp = comparator.compare(array[i], temp);
            if(Comp > 0)
                temp = array[i];
        }
        return temp;
    }

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

    /* min method */
    public static <T extends Comparable<? super T>> T min(T first, T second) {
        if(first.compareTo(second) < 0)
            return first;
        else
            return second;
    }

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

    public static <T extends Comparable<? super T>> T min(T first, T second, Comparator<? super T> comparator) {
        int Comp = comparator.compare(first, second);
        if(Comp < 0)
            return first;
        else
            return second;
    }

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

//    public static <T extends Comparable<? super T>> T max(T first, T second) {
//        if(first.compareTo(second) > 0)
//            return first;
//        else
//            return second;
//    }

//    public static <T extends Comparable<? super T>> T min(T first, T second) {
//        if(first.compareTo(second) < 0)
//            return first;
//        else
//            return second;
//    }
}